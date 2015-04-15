package mx.jimi.medi.controllers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.jimi.medi.models.Brand;

/**
 * The Brand Session Bean Controller
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
public class BrandBean
{

	//get the JPA entity Manager
	@PersistenceContext(unitName = "MediPU")
	EntityManager em;

	/**
	 * Get a brand by its ID
	 *
	 * @param brandId the ID of the brand
	 * @return a Brand entity, if not found then returns null
	 */
	public Brand get(final long brandId)
	{
		try
		{
			Query q = em.createNamedQuery("Brand.findByBrandId");
			q.setParameter("brandId", brandId);
			return (Brand) q.getSingleResult();
		}
		catch (NoResultException ex)
		{
			return null;
		}
	}

	/**
	 * Get all brands
	 *
	 * @return all Brand entities
	 */
	public List<Brand> getAll()
	{
		Query q = em.createNamedQuery("Brand.findAll");
		return (List<Brand>) q.getResultList();
	}
}
