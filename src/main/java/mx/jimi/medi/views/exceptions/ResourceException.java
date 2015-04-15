package mx.jimi.medi.views.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * It catches all other exceptions
 * @author Raul Guerrero Deschamps
 */
@Provider
public class ResourceException implements ExceptionMapper<Exception>
{

	@Override
	public Response toResponse(Exception e)
	{
		Error err = new Error("500 Server Exception: " + e.getMessage());
		return Response.serverError().entity(err).build();
	}

}
