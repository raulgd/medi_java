package mx.jimi.medi.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.jimi.medi.controllers.UserBean;
import mx.jimi.medi.models.User;

/**
 * This is the authentication servlet, it implements the login form logic and authorization and redirects the user to the
 * main logged in page.
 *
 * @author Raul Guerrero Deschamps
 */
@WebServlet(name = "LoginServlet", urlPatterns =
		{
			"/login"
})
public class LoginServlet extends HttpServlet
{

	@EJB
	private UserBean userBean;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if (email == null || password == null)
			{
				response.sendRedirect(getServletContext().getContextPath() + "/index.jsp?error=1");
			}

			User u = userBean.check(email, password);

			//wrong user ID or password error
			if (u == null)
			{
				response.sendRedirect(getServletContext().getContextPath() + "/index.jsp?error=1");
			}
			else
			{
				//create a session and add the user object to the session
				HttpSession session = request.getSession(true);
				session.setAttribute("user", u);

				//dispatch the response to the main page
				response.sendRedirect(getServletContext().getContextPath() + "/main.jsp");
			}
		}
		catch (IOException ex)
		{
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
