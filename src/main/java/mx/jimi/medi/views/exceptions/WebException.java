package mx.jimi.medi.views.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * It catches all JAX-RS exceptions not catched by the others
 * @author Raul Guerrero Deschamps
 */
public class WebException extends WebApplicationException
{

	public WebException()
	{
		super(Response.serverError().entity(new Error("There was an error")).build());
	}

	public WebException(Status status, String message)
	{
		super(Response.status(status).entity(new Error(message)).build());
	}
}
