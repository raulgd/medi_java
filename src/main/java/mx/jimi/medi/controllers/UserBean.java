package mx.jimi.medi.controllers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;
import mx.jimi.medi.models.User;

/**
 * The User Controller
 *
 * @author Raul Guerrero Deschamps
 */
@Stateless
public class UserBean
{

	public User getMyUser()
	{
		return null;
	}

	/**
	 * Hash the password using the SHA-512 algorithm
	 * 
	 * @param passwd the password to hash
	 * @return the hashed string representation of the password
	 *
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String hashPassword(String passwd) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		//get the algorithm and calculate the digest
		MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
		sha512.reset();
		byte[] hashBytes = sha512.digest(passwd.getBytes("UTF-8"));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hashBytes.length; i++)
		{
			sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
