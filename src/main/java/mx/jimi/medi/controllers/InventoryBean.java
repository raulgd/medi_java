package mx.jimi.medi.controllers;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response.Status;
import mx.jimi.medi.models.Article;
import mx.jimi.medi.views.exceptions.WebException;

/**
 * The Inventory Session Bean Controller
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
public class InventoryBean
{

	@EJB
	private ArticleBean articleBean;

	/**
	 * Add or remove the amount of articles in the inventory
	 *
	 * @param articleId the ID of the article to change the amount
	 * @param amount the amount number
	 *
	 * @return the updated article, or null if it couldn't update it
	 */
	public Article updateAmount(final long articleId, final int amount) throws WebException
	{
		Article a = articleBean.get(articleId);

		if (a != null)
		{
			int result = a.getAmount() + amount;

			if (result >= 0)
			{
				a.setAmount(result);
				articleBean.update(a);
			}
			else
			{
				throw new WebException(Status.NOT_ACCEPTABLE, "Cannot remove more articles than in existence");
			}
		}
		else
		{
			throw new WebException(Status.NOT_FOUND, "The article doesn't exist");
		}
		return a;
	}
}
