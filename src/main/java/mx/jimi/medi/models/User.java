package mx.jimi.medi.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The User entity
 * 
 * @author Raul Guerrero Deschamps
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries(
{
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
	@NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
	@NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
})
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
	@Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "email", nullable = false, length = 255)
	private String email;
	@Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name", nullable = false, length = 255)
	private String name;
	@Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "password", nullable = false, length = 255)
	private String password;

	public User()
	{
	}

	public User(String email)
	{
		this.email = email;
	}

	public User(String email, String name, String password)
	{
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (email != null ? email.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof User))
		{
			return false;
		}
		User other = (User) object;
		if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "mx.jimi.medi.entities.User[ email=" + email + " ]";
	}

}
