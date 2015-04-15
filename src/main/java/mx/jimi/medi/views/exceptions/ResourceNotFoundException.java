package mx.jimi.medi.views.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * It catches all 404 exceptions
 * @author Raul Guerrero Deschamps
 */
@Provider
public class ResourceNotFoundException implements ExceptionMapper<NotFoundException>
{

	@Override
	public Response toResponse(NotFoundException e)
	{
		Error err = new Error("404 Resource not found");
		return Response.status(Response.Status.NOT_FOUND).entity(err).build();
	}
}
