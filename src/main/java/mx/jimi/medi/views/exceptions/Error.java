package mx.jimi.medi.views.exceptions;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The error Model
 *
 * @author Raul Guerrero Deschamps
 */
@XmlRootElement
public class Error implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String error;

	public Error()
	{

	}

	public Error(String error)
	{
		this.error = error;
	}

	public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		if (!(object instanceof Error))
		{
			return false;
		}
		Error other = (Error) object;
		if ((this.error == null && other.error != null) || (this.error != null && !this.error.equals(other.error)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return error;
	}

}
