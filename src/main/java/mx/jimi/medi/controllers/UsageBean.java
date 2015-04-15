package mx.jimi.medi.controllers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.jimi.medi.models.Usage;

/**
 * The Usage Session Bean Controller
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
public class UsageBean
{

	//get the JPA entity Manager
	@PersistenceContext(unitName = "MediPU")
	EntityManager em;

	/**
	 * Get a usage by its ID
	 *
	 * @param usageId the ID of the usage
	 * @return a Usage entity, if not found then returns null
	 */
	public Usage get(final long usageId)
	{
		try
		{
			Query q = em.createNamedQuery("Usage.findByUsageId");
			q.setParameter("usageId", usageId);
			return (Usage) q.getSingleResult();
		}
		catch (NoResultException ex)
		{
			return null;
		}
	}

	/**
	 * Get all usages
	 *
	 * @return all Usage entities
	 */
	public List<Usage> getAll()
	{
		Query q = em.createNamedQuery("Usage.findAll");
		return (List<Usage>) q.getResultList();
	}
}
