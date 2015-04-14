package mx.jimi.medi.views.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jz2n4h Raul Guerrero Deschamps
 */
public class WebException extends WebApplicationException
{

	public WebException()
	{
		super(Response.serverError().entity("{\"error\":\"There was an error\"}")
						.type(MediaType.APPLICATION_JSON).build());
	}

	public WebException(String message)
	{
		super(Response.serverError().entity("{\"error\":\"" + message + "\"}")
						.type(MediaType.APPLICATION_JSON).build());
	}
}
