package mx.jimi.medi.views;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author jz2n4h
 */
@Path("/inventory")
public class InventoryResource
{

	@Context
	private UriInfo context;

	/**
	 * Creates a new instance of InventoryResource
	 */
	public InventoryResource()
	{
	}

	/**
	 * Retrieves representation of an instance of mx.jimi.medi.views.InventoryResource
	 * @return an instance of java.lang.String
	 */
	@GET
  @Produces("application/json")
	public String getJson()
	{
		//TODO return proper representation object
		throw new UnsupportedOperationException();
	}

	/**
	 * PUT method for updating or creating an instance of InventoryResource
	 * @param content representation for the resource
	 * @return an HTTP response with content of the updated or created resource.
	 */
	@PUT
  @Consumes("application/json")
	public void putJson(String content)
	{
	}
}
