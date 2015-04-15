package mx.jimi.medi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
 * The Brand entity
 *
 * @author Raul Guerrero Deschamps
 */
@Entity
@Table(name = "brands")
@XmlRootElement
@NamedQueries(
{
	//The preconfigured usual queries
	@NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
	@NamedQuery(name = "Brand.findByBrandId", query = "SELECT b FROM Brand b WHERE b.brandId = :brandId"),
})
public class Brand implements Serializable
{
	private static final long serialVersionUID = 1L;

	//the database mapping fields
	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "brand_id", nullable = false)
	private Long brandId;
	@Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "name", nullable = false, length = 50)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "brandId")
	private List<Article> articleList;

	public Brand()
	{
	}

	public Brand(Long brandId)
	{
		this.brandId = brandId;
	}

	public Brand(Long brandId, String name)
	{
		this.brandId = brandId;
		this.name = name;
	}

	@JsonProperty("brand_id")
	public Long getBrandId()
	{
		return brandId;
	}

	@JsonProperty("brand_id")
	public void setBrandId(Long brandId)
	{
		this.brandId = brandId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@JsonIgnore
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
		hash += (brandId != null ? brandId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Brand))
		{
			return false;
		}
		Brand other = (Brand) object;
		if ((this.brandId == null && other.brandId != null) || (this.brandId != null && !this.brandId.equals(other.brandId)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "mx.jimi.medi.entities.Brand[ brandId=" + brandId + " ]";
	}

}
