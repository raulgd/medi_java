package mx.jimi.medi.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * The JAX-RS application main configuration and classpath scanner
 *
 * @author Raul Guerrero Deschamps
 */
@javax.ws.rs.ApplicationPath("/rest")
public class RestConfig extends ResourceConfig
{

	public RestConfig()
	{
		//configure to use Jackson as default JSON serialization provider
		register(JacksonFeature.class);

		//scan this package and subpackages for providers and resources
		packages(true, "mx.jimi.medi");
	}
}
