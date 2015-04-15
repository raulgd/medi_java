package mx.jimi.medi.views;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import mx.jimi.medi.controllers.BrandBean;
import mx.jimi.medi.models.Brand;

/**
 * The Brands REST Web Service
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
@Path("/brands")
public class BrandsResource
{

	@EJB
	private BrandBean brandBean;

	/**
	 * Creates a new instance of BrandsResource
	 */
	public BrandsResource()
	{
	}

	/**
	 * Gets a list of all brands
	 *
	 * @return a list of Brand entities
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
	public List<Brand> getAll()
	{
		return brandBean.getAll();
	}

}
