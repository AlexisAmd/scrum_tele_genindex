package Model;

/**
 * Les privil�ge d'un utilisateur (secr�taire, validator ...)
 * @author Laurent
 *
 */

public class Privilege {
	
	private String name;
	
	public Privilege(String pname) {
		name = pname;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
