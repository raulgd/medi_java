package mx.jimi.medi.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is the logout servlet, it implements the logout logic and destroys the user session, then redirects the user to
 * the main web page.
 *
 * @author Raul Guerrero Deschamps
 */
@WebServlet(name = "LogoutServlet", urlPatterns =
		{
			"/logout"
})
public class LogoutServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			HttpSession session = request.getSession(false);
			if (session != null)
			{
				session.invalidate();
			}
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
		}
		catch (IOException ex)
		{
			Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
