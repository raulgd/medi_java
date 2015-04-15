package mx.jimi.medi.views;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import mx.jimi.medi.controllers.UsageBean;
import mx.jimi.medi.models.Usage;

/**
 * The Usages REST Web Service
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
@Path("/usages")
public class UsagesResource
{

	@EJB
	private UsageBean usageBean;

	/**
	 * Creates a new instance of UsagesResource
	 */
	public UsagesResource()
	{
	}

	/**
	 * Gets a list of all usages
	 *
	 * @return a list of Usage entities
	 */
	@GET
	@Consumes(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	@Produces(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	public List<Usage> getAll()
	{
		return usageBean.getAll();
	}

}
