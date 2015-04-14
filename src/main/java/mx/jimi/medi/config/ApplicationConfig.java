package mx.jimi.medi.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author jz2n4h
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application
{

	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources)
	{
		resources.add(mx.jimi.medi.views.ArticlesResource.class);
		resources.add(mx.jimi.medi.views.InventoryResource.class);
		resources.add(mx.jimi.medi.views.UserResource.class);
		resources.add(mx.jimi.medi.views.exceptions.BadRequestResourceException.class);
		resources.add(mx.jimi.medi.views.exceptions.ResourceException.class);
		resources.add(mx.jimi.medi.views.exceptions.ResourceNotFoundException.class);
	}

}
