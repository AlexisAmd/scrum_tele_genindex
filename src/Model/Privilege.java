package Model;

/**
 * Les privilège d'un utilisateur (secrétaire, validator ...)
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
