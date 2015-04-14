package mx.jimi.medi.views.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author jz2n4h
 */
@Provider
public class ResourceNotFoundException implements ExceptionMapper<NotFoundException>
{

	@Override
	public Response toResponse(NotFoundException e)
	{
		return Response.status(Response.Status.NOT_FOUND).entity("{\"error\":\"404 Resource not found\"}")
						.type(MediaType.APPLICATION_JSON).build();
	}
}
