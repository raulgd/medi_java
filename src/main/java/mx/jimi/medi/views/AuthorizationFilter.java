package mx.jimi.medi.views;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;
import mx.jimi.medi.controllers.UserBean;
import mx.jimi.medi.models.User;
import mx.jimi.medi.views.exceptions.UnauthorizedException;
import org.glassfish.jersey.server.internal.routing.UriRoutingContext;
import org.glassfish.jersey.server.model.ResourceMethodInvoker;

/**
 * Checks for user authorization, it's ignored for REST methods annotated with AuthorizationNotRequired
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
@Provider
public class AuthorizationFilter implements ContainerRequestFilter
{

	@EJB
	private UserBean userBean;

	@Context
	private HttpServletRequest servletRequest;

	public static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final String ACCESS_DENIED = "Access denied";

	@Override
	public void filter(ContainerRequestContext request) throws IOException, UnauthorizedException
	{
		//get the method that's being requested
		UriRoutingContext routingContext = (UriRoutingContext) request.getUriInfo();
		ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) routingContext.getInflector();
		Method method = methodInvoker.getResourceMethod();

		//if the method is not annotated with AuthorizationNotRequired, then check if it has permissions to run
		if (!method.isAnnotationPresent(AuthorizationNotRequired.class))
		{
			//get request headers
			MultivaluedMap<String, String> headers = request.getHeaders();

			//Fetch authorization header
			String authorization = null;
			if (headers.get(AUTHORIZATION_PROPERTY) != null)
			{
				if (!headers.get(AUTHORIZATION_PROPERTY).isEmpty())
				{
					authorization = headers.get(AUTHORIZATION_PROPERTY).get(0);
				}
			}
			//the user object that, if authenticated, will be added to the request as a property so any REST Resource can obtain it
			User u = authorize(authorization, servletRequest);

			//add the user to the request so it can be pulled by the REST method
			if (u == null)
			{
				throw new UnauthorizedException(ACCESS_DENIED);
			}
			else
			{
				request.setProperty("user", u);
			}
		}
	}

	/**
	 * Checks if the user is authorized to access a service
	 *
	 * @param authorization the authorization headers, if there aren't it can be null
	 * @param request the servlet request
	 *
	 * @return the user that is authorized to do it, returns null if it is not authorized
	 */
	private User authorize(String authorization, HttpServletRequest request) throws UnauthorizedException
	{
		User u = null;

		//use this method for applications like browsers that support cookies and use sessions
		if (authorization == null)
		{
			//check if there's a user session, if not throw an unauthorized exception
			HttpSession session = request.getSession(false);
			if (session == null)
			{
				throw new UnauthorizedException(ACCESS_DENIED);
			}
			else
			{
				u = (User) session.getAttribute("user");
				if (u == null)
				{
					throw new UnauthorizedException(ACCESS_DENIED);
				}
			}
		}
		//use this method for applications that send credentials for each request through HTTP headers
		else
		{
			//Get encoded username and password
			String encodedUserPassword = authorization.replaceFirst(AUTHENTICATION_SCHEME + " ", "");

			//Decode username and password
			String usernameAndPassword = new String(DatatypeConverter.parseBase64Binary(encodedUserPassword));

			//Split username and password tokens
			StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();

			//check the user and password
			u = userBean.check(username, password);
			if (u == null)
			{
				throw new UnauthorizedException(ACCESS_DENIED);
			}
		}
		return u;
	}
}
