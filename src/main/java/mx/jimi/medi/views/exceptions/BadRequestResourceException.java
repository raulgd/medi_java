package mx.jimi.medi.views.exceptions;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Catches all 400 exceptions
 * @author Raul Guerrero Deschamps
 */
@Provider
public class BadRequestResourceException implements ExceptionMapper<BadRequestException>
{

	@Override
	public Response toResponse(BadRequestException e)
	{
		Error err = new Error("400 Bad Request Exception: " + e.getMessage());
		return Response.status(Response.Status.BAD_REQUEST).entity(err).build();
	}

}
