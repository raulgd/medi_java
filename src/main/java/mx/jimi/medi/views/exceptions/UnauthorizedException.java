package mx.jimi.medi.views.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author jz2n4h Raul Guerrero Deschamps
 */
public class UnauthorizedException extends WebApplicationException
{

	private static final long serialVersionUID = 1L;

	public UnauthorizedException()
	{
		super(Response.status(Status.UNAUTHORIZED).entity("{\"error\":\"Unauthorized Access, User Session Has Expired\"}")
						.type(MediaType.APPLICATION_JSON).build());
	}

	public UnauthorizedException(String message)
	{
		super(Response.status(Status.UNAUTHORIZED).entity("{\"error\":\"" + message + "\"}")
						.type(MediaType.APPLICATION_JSON).build());
	}
}
