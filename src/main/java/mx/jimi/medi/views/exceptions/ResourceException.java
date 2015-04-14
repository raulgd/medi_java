package mx.jimi.medi.views.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author jz2n4h
 */
@Provider
public class ResourceException implements ExceptionMapper<Exception>
{

	@Override
	public Response toResponse(Exception e)
	{
		String json = new StringBuilder("{\"error\":\"500 Application Exception\",\"message\":\"")
						.append(e.getMessage()).append("\"}").toString();
		return Response.serverError().entity(json).type(MediaType.APPLICATION_JSON).build();
	}

}
