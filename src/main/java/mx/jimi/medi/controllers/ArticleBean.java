package mx.jimi.medi.controllers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.jimi.medi.models.Article;

/**
 * The Article Session Bean Controller
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
public class ArticleBean
{

	//get the JPA entity Manager
	@PersistenceContext(unitName = "MediPU")
	EntityManager em;

	/**
	 * Search for articles
	 *
	 * @param search the search filter
	 *
	 * @return a list of articles
	 */
	public List<Article> search(final String search)
	{
		Query q = em.createNamedQuery("Article.findBySearch");
		q.setParameter("name", "%" + search + "%");
		q.setParameter("formula", "%" + search + "%");
		q.setParameter("volume", "%" + search + "%");
		q.setParameter("brand", "%" + search + "%");
		q.setParameter("usage", "%" + search + "%");
		return q.getResultList();
	}

	/**
	 * Get an article using its ID
	 *
	 * @param articleId the article entity's ID
	 * @return an Article entity
	 */
	public Article get(final long articleId)
	{
		try
		{
			Query q = em.createNamedQuery("Article.findByArticleId");
			q.setParameter("articleId", articleId);
			return (Article) q.getSingleResult();
		}
		catch (NoResultException ex)
		{
			return null;
		}
	}

	/**
	 * Creates an entity in the database
	 *
	 * @param article the Article entity to save in the database
	 * @return the saved entity
	 */
	public Article create(final Article article)
	{
		article.setAmount(0);
		em.persist(article);
		em.flush();
		return article;
	}

	/**
	 * Updates an entity in the database
	 *
	 * @param article the Article entity to update
	 * @return the updated entity
	 */
	public Article update(final Article article)
	{
		Article a = get(article.getArticleId());
		article.setAmount(a.getAmount());

		em.merge(article);
		em.flush();
		return article;
	}
}
