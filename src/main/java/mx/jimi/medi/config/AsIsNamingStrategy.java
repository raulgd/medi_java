package mx.jimi.medi.config;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

/**
 * This leaves alone all case conversion for the JSON name properties, this class is used by the JacksonConfig provider
 *
 * @author Raul Guerrero Deschamps
 */
public class AsIsNamingStrategy extends PropertyNamingStrategy
{

	@Override
	public String nameForField(MapperConfig config, AnnotatedField field, String defaultName)
	{
		return defaultName;
	}

	@Override
	public String nameForGetterMethod(MapperConfig config, AnnotatedMethod method, String defaultName)
	{
		return defaultName;
	}

	@Override
	public String nameForSetterMethod(MapperConfig config, AnnotatedMethod method, String defaultName)
	{
		return defaultName;
	}

}
