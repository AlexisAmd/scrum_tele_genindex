package Model;

/**
 * A user of the system. Has an id and a password
 * @author Laurent
 *
 */

public class User {
	
	private String id;
	private String password;
	private Privilege privilege;
	
	public User(String pid, String ppassword, Privilege pprivilege) {
		id = pid;
		password = ppassword;
		privilege = pprivilege;
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

	/**
	 * @return the privilege
	 */
	public Privilege getPrivilege() {
		return privilege;
	}

}
