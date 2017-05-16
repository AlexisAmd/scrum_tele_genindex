package Model;

/**
 * A user of the system. Has an id and a password
 * @author Laurent
 *
 */

public class User {
	
	private String id;
	private String password;
	
	public User(String pid, String ppassword) {
		id = pid;
		password = ppassword;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

}
