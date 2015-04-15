package mx.jimi.medi.views.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * It catches all 403 unauthorized exceptions
 * @author Raul Guerrero Deschamps
 */
public class UnauthorizedException extends WebApplicationException
{

	private static final long serialVersionUID = 1L;

	public UnauthorizedException()
	{
		super(Response.status(Status.UNAUTHORIZED).entity(new Error("403 Unauthorized Access")).build());
	}

	public UnauthorizedException(String message)
	{
		super(Response.status(Status.UNAUTHORIZED).entity(new Error(message)).build());
	}
}
