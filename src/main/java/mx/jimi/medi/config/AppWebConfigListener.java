package mx.jimi.medi.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Raul Guerrero Deschamps
 */
@WebListener()
public class AppWebConfigListener implements ServletContextListener
{

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		//Set the JSP root path variable
		sce.getServletContext().setAttribute("appRoot", sce.getServletContext().getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
	}
}
