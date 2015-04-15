package mx.jimi.medi.views;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import mx.jimi.medi.controllers.UserBean;
import mx.jimi.medi.models.User;

/**
 * The User REST Web Service
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
@Path("/user")
public class UserResource
{

	@EJB
	private UserBean userBean;

	/**
	 * Creates a new instance of UsersResource
	 */
	public UserResource()
	{
	}

	/**
	 * Get the authenticated user information
	 *
	 * @return a User entity
	 */
	@GET
	@Consumes(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	@Produces(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	public User getUser(@Context HttpServletRequest request)
	{
		return (User) request.getAttribute("user");
	}
}
