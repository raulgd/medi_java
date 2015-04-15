package mx.jimi.medi.views;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.jimi.medi.controllers.ArticleBean;
import mx.jimi.medi.models.Article;

/**
 * The Articles REST Web Service
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
@Path("/articles")
public class ArticlesResource
{

	@EJB
	private ArticleBean articleBean;

	/**
	 * Creates a new instance of ArticlesResource
	 */
	public ArticlesResource()
	{
	}

	/**
	 * Search for articles
	 *
	 * @param search the search filter
	 *
	 * @return a list of articles
	 */
	@GET
	@Path("/search={search:.*}")
	@Consumes(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	@Produces(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	public List<Article> search(@PathParam("search") final String search)
	{
		return articleBean.search(search);
	}

	/**
	 * Get an article using its ID
	 *
	 * @param articleId the article entity's ID
	 * @return an Article entity
	 */
	@GET
	@Path("/{id}")
	@Consumes(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	@Produces(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	public Article get(@PathParam("id") final long articleId)
	{
		return articleBean.get(articleId);
	}

	/**
	 * Creates an entity in the database
	 *
	 * @param article the Article entity to save in the database
	 * @return the saved entity
	 */
	@POST
	@Consumes(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	@Produces(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	public Article create(final Article article)
	{
		return articleBean.create(article);
	}

	/**
	 * Updates an entity in the database
	 *
	 * @param articleId the article ID number
	 * @param article the Article entity to update
	 * @return the updated entity
	 */
	@PUT
	@Path("/{id}")
	@Consumes(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	@Produces(
					{
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML
					})
	public Article update(@PathParam("id") final long articleId, final Article article)
	{
		Article a = article;
		a.setArticleId(articleId);
		return articleBean.update(a);
	}
}
