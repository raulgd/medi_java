package mx.jimi.medi.views.exceptions;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author jz2n4h
 */
@Provider
public class BadRequestResourceException implements ExceptionMapper<BadRequestException>
{

	@Override
	public Response toResponse(BadRequestException e)
	{
		String json = new StringBuilder("{\"error\":\"400 Bad Request Exception\",\"message\":\"")
						.append(e.getMessage()).append("\"}").toString();
		return Response.status(Response.Status.BAD_REQUEST).entity(json).type(MediaType.APPLICATION_JSON).build();
	}

}
