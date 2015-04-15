package mx.jimi.medi.views;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import mx.jimi.medi.controllers.InventoryBean;
import mx.jimi.medi.models.Article;

/**
 * The Inventory REST Web Service
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
@Path("/inventory")
public class InventoryResource
{

	@EJB
	private InventoryBean inventoryBean;

	@Context
	private UriInfo context;

	/**
	 * Creates a new instance of InventoryResource
	 */
	public InventoryResource()
	{
	}

	/**
	 * Add or remove the amount of articles in the inventory
	 *
	 * @param articleId the ID of the article to change the amount
	 * @param amount the amount number
	 *
	 * @return the updated article, or null if it couldn't update it
	 */
	@GET
	@Path("/{id}/amount={amount}")
	@Consumes(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	@Produces(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	public Article updateAmount(@PathParam("id") final long articleId, @PathParam("amount") final int amount)
	{
		return inventoryBean.updateAmount(articleId, amount);
	}
}
