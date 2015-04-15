package mx.jimi.medi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Article entity model
 *
 * @author Raul Guerrero Deschamps
 */
@Entity
@Table(name = "articles")
@XmlRootElement
@NamedQueries(
				{
					//The preconfigured usual queries
					@NamedQuery(name = "Article.findByArticleId", query = "SELECT a FROM Article a WHERE a.articleId = :articleId"),
					@NamedQuery(name = "Article.findBySearch", query = "SELECT a FROM Article a JOIN a.brandId b, a.usageId u "
											+ "WHERE a.name LIKE :name OR a.formula LIKE :formula OR a.volume LIKE :volume OR b.name LIKE :brand OR u.name LIKE :usage")
				})
public class Article implements Serializable
{

	private static final long serialVersionUID = 1L;

	//The database mapping fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "article_id", nullable = false)
	private Long articleId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "amount", nullable = false)
	private int amount;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "formula", nullable = false, length = 255)
	private String formula;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "volume", nullable = false, length = 50)
	private String volume;
	@Lob
	@Size(max = 65535)
	@Column(name = "comments", length = 65535)
	private String comments;
	@JoinColumn(name = "brand_id", referencedColumnName = "brand_id", nullable = false)
	@ManyToOne(optional = false)
	private Brand brandId;
	@JoinColumn(name = "usage_id", referencedColumnName = "usage_id", nullable = false)
	@ManyToOne(optional = false)
	private Usage usageId;

	public Article()
	{
	}

	public Article(Long articleId)
	{
		this.articleId = articleId;
	}

	public Article(Long articleId, int amount, String name, String formula, String volume)
	{
		this.articleId = articleId;
		this.amount = amount;
		this.name = name;
		this.formula = formula;
		this.volume = volume;
	}

	@JsonProperty("article_id")
	public Long getArticleId()
	{
		return articleId;
	}

	@JsonProperty("article_id")
	public void setArticleId(Long articleId)
	{
		this.articleId = articleId;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFormula()
	{
		return formula;
	}

	public void setFormula(String formula)
	{
		this.formula = formula;
	}

	public String getVolume()
	{
		return volume;
	}

	public void setVolume(String volume)
	{
		this.volume = volume;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	@JsonProperty("brand_id")
	public Brand getBrandId()
	{
		return brandId;
	}

	@JsonProperty("brand_id")
	public void setBrandId(Brand brandId)
	{
		this.brandId = brandId;
	}

	@JsonProperty("usage_id")
	public Usage getUsageId()
	{
		return usageId;
	}

	@JsonProperty("usage_id")
	public void setUsageId(Usage usageId)
	{
		this.usageId = usageId;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (articleId != null ? articleId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		//Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Article))
		{
			return false;
		}
		Article other = (Article) object;
		if ((this.articleId == null && other.articleId != null) || (this.articleId != null && !this.articleId.equals(other.articleId)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "mx.jimi.medi.entities.Article[ articleId=" + articleId + " ]";
	}

}
