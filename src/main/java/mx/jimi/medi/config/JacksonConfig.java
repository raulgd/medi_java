package mx.jimi.medi.config;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Configures the JSON property names to be left as is, by default it converts all of them to lower case
 *
 * @author Raul Guerrero Deschamps
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<ObjectMapper>
{

	private final ObjectMapper objectMapper;

	public JacksonConfig()
	{
		//leave JSON property names with its original case instead of forcing camel case
		objectMapper = new ObjectMapper();
		objectMapper.setPropertyNamingStrategy(new AsIsNamingStrategy());
	}

	@Override
	public ObjectMapper getContext(Class<?> type)
	{
		return objectMapper;
	}
}
