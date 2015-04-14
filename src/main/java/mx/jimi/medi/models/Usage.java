package mx.jimi.medi.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The Usage entity
 *
 * @author Raul Guerrero Deschamps
 */
@Entity
@Table(name = "usages")
@XmlRootElement
@NamedQueries(
{
	@NamedQuery(name = "Usage.findAll", query = "SELECT u FROM Usage u"),
	@NamedQuery(name = "Usage.findByUsageId", query = "SELECT u FROM Usage u WHERE u.usageId = :usageId"),
	@NamedQuery(name = "Usage.findByName", query = "SELECT u FROM Usage u WHERE u.name = :name")
})
public class Usage implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "usage_id", nullable = false)
	private Long usageId;
	@Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "name", nullable = false, length = 50)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usageId")
	private List<Article> articleList;

	public Usage()
	{
	}

	public Usage(Long usageId)
	{
		this.usageId = usageId;
	}

	public Usage(Long usageId, String name)
	{
		this.usageId = usageId;
		this.name = name;
	}

	public Long getUsageId()
	{
		return usageId;
	}

	public void setUsageId(Long usageId)
	{
		this.usageId = usageId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@XmlTransient
	public List<Article> getArticleList()
	{
		return articleList;
	}

	public void setArticleList(List<Article> articleList)
	{
		this.articleList = articleList;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (usageId != null ? usageId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Usage))
		{
			return false;
		}
		Usage other = (Usage) object;
		if ((this.usageId == null && other.usageId != null) || (this.usageId != null && !this.usageId.equals(other.usageId)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "mx.jimi.medi.entities.Usage[ usageId=" + usageId + " ]";
	}

}
