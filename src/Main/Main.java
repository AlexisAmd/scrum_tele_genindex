package Main;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.text.WordUtils;

import Model.Analysis;
import Model.Customer;
import Model.Order;
import Model.Privilege;
import Model.RawData;
import Model.Sample;
import Model.ScrapieResult;
import Model.ScrapieTest;
import Model.SexingTest;
import Model.Specie;
import Model.SpecieCategory;
import Model.User;
import View.Login;
import View.MainFrame;

/**
 * Permet de lancer l'application
 * @author Laurent
 *
 */

public class Main {
	
	// The login page
	private Login login;
	// The frame
	private MainFrame frame;
	// The current User of the system
	private User currentUser;
	// Store the users of the system
	public ArrayList<User> theUsers;
    // With theCategories, all species are available
    public ArrayList<SpecieCategory> theCategories;
    // theAnalyses stores the available analyses
    public ArrayList<Analysis> theAnalyses;
    // theCustomers gives access to all samples and results
    public ArrayList<Customer> theCustomers;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    /**
     * Initialise des donn�es
     */
	public Main() {
		generateData();
		login = new Login(this);
	}
	
	/**
	 * Si les param�tres sont corrects, g�n�re la vue suivante
	 * @param pid
	 * @param ppassword
	 */

	public boolean loginUser(String pid, String ppassword) {
		for(User u : theUsers) {
			if(u.getId().equals(pid) && u.getPassword().equals(ppassword)) { // On a trouv� un utilisateur
				this.currentUser = u;
				login.setVisible(false); // You can't see me!
				login.dispose(); // Destroy the JFrame object
				frame = new MainFrame(this);
				return true;
			}
		}
		// On a pas trouv� d'utilisateur, le couple id/pwd est incorrect
		login.showErrorBox();
		return false;
	}
	
	/**
	 * Permet de cr�er un customer. Check au pr�alable si le nouveau customer n'existe pas d�j�
	 */
	public void createCustomer(String pname, String ptown) {
		
		pname = WordUtils.capitalizeFully(pname);
		ptown = WordUtils.capitalizeFully(ptown);
		
		boolean exist = false;
		for(Customer c : theCustomers) {
			if(( c.getName().toUpperCase().equals(pname.toUpperCase()) )   && 	( c.getTown().toUpperCase().equals(ptown.toUpperCase()) )) {
				exist = true;
			}
		}
		
		if(exist) { // Il existe d�j� un client avec le m�me nom dans le logiciel
			JOptionPane.showMessageDialog(new JFrame(), "Ce client existe d�j�.");
		} else { // On peut cr�er le client
			Customer nCustomer = new Customer(pname, ptown);
			theCustomers.add(nCustomer);
			JOptionPane.showMessageDialog(new JFrame(), "Le client a bien �t� ajout�.");
		}
		
	}
	
	/**
	 * Permet d'ajouter une categorie qui n'existe pas encore
	 * @param pname le nom de la cat�gorie
	 */
	public void createCategory(String pname) {
		
		pname = WordUtils.capitalizeFully(pname);

		boolean exist = false;
		for(SpecieCategory sC : theCategories) {
			if(sC.getName().toUpperCase().equals(pname.toUpperCase())) {
				exist = true;
			}
		}
		
		if(exist) { // La cat�gorie existe d�j�
			JOptionPane.showMessageDialog(new JFrame(), "Cette cat�gorie existe d�j�.");
		} else { // On peut cr�er la cat�gorie
			SpecieCategory nCategory = new SpecieCategory(pname);
			theCategories.add(nCategory);
			JOptionPane.showMessageDialog(new JFrame(), "La cat�gorie a bien �t� cr��e.");
		}
	}
	
	/**
	 * Cr�e une esp�ce et lui donne une cat�gorie. L'esp�ce ne doit appartenir qu'� une seule cat�gorie
	 * @param pname le nom de l'esp�ce
	 * @param pcategory la cat�gorie � laquelle l'esp�ce appartient
	 */
	public void createSpecie(String pname, SpecieCategory pcategory) {
		
		pname = WordUtils.capitalizeFully(pname);

		boolean exist = false;
		for(SpecieCategory sC : theCategories) { // Pour chaque cat�gorie
			for(Specie s : sC.getSpecies()) { // Pour chaque esp�ce de la cat�gorie
				if(s.getName().toUpperCase().equals(pname.toUpperCase())) {
					exist = true;
				}
			}
		}
		
		if(exist) { // Il existe d�j� une esp�ce similaire dans une cat�gorie
			JOptionPane.showMessageDialog(new JFrame(), "Cette esp�ce existe d�j�.");
		} else { // On peut cre�r l'esp�ce et la range dans la cat�gorie demand�e
			Specie nSpecie = new Specie(pname);
			pcategory.addSpecie(nSpecie);
			JOptionPane.showMessageDialog(new JFrame(), "L'esp�ce a bien �t� ajout�e.");
		}
		
	}
	
	/**
	 * G�n�re des donn�es au pr�alable
	 */
	public void generateData() {
		
		// Init all lists;
		theUsers = new ArrayList<User>();
        theCategories = new ArrayList<SpecieCategory>();
        theAnalyses = new ArrayList<Analysis>();
        theCustomers = new ArrayList<Customer>();

        Privilege secretary = new Privilege("Secretary");
        Privilege validator = new Privilege("Validator");

        // User
        User magalie = new User("Magalie", "123", secretary);
        theUsers.add(magalie);
        
        // Customer "Mrs Rosemary Plumket", in Poitiers
        Customer rose = new Customer("Mrs Rosemary Plumket", "Poitiers");
        theCustomers.add(rose);
        // Customer "La Palmyre Zoo" in Royan
        Customer zoo = new Customer("La Palmyre Zoo", "Royan");
        theCustomers.add(zoo);
        // Customer "M. Tom Brown", in Montmorillon
        Customer tom = new Customer("M. Tom Brown", "Montmorillon");
        theCustomers.add(tom);
        // Customer "M. Paul Cameron", in Parthenay
        Customer paul = new Customer("M. Paul Cameron", "Parthenay");
        theCustomers.add(paul);

        // ScrapieTest management
        SpecieCategory sc = new SpecieCategory("Mammals");
        theCategories.add(sc);
        Specie s = new Specie("Sheep");
        sc.addSpecie(s);
        ScrapieTest sct = new ScrapieTest(s,354,224);
        theAnalyses.add(sct);
        // Order for Tom Brown - 24 sheeps, status toAnalyse
        Order o = new Order(tom);
        tom.addOrder(o);
        ArrayList<Sample> ls = new ArrayList<Sample>();
        Sample sam;
        for (int i=0;i<24;i++) ls.add(new Sample(sct,s,o));
        o.setSamples(ls);
        
        // RawData results
        RawData scrapieOk = new RawData (354, 224);
        RawData scrapieDoubt = new RawData (354, 221);
        RawData scrapieNotOk = new RawData (354, 155);
        RawData scrapieNotReadable = new RawData (354, 0);        
        
        // Several scrapie results :
        ScrapieResult scrFirstReadOkSensible = new ScrapieResult();
            scrFirstReadOkSensible.setScrapieValue(scrapieOk);
            scrFirstReadOkSensible.firstRead(true, "Sensible");
        ScrapieResult scrFirstReadOkNotSensible = new ScrapieResult();
            scrFirstReadOkNotSensible.setScrapieValue(scrapieNotOk);
            scrFirstReadOkNotSensible.firstRead(true, "Not Sensible");
        ScrapieResult scrFirstReadDoubtful = new ScrapieResult();
            scrFirstReadDoubtful.setScrapieValue(scrapieDoubt);
            scrFirstReadDoubtful.firstRead(false, "Doubtful");   
        ScrapieResult scrValidatedNotSensible = new ScrapieResult();
            scrValidatedNotSensible.setScrapieValue(scrapieNotOk);
            scrValidatedNotSensible.firstRead(true, "Not Sensible");   
            scrValidatedNotSensible.validate(true);      
        
        // Order for Tom Brown - 36 sheeps, all firstRead, not sensible - order status = completed
        o = new Order(tom);
        tom.addOrder(o);
        ls = new ArrayList<Sample>();
        for (int i=0;i<36;i++) {
            sam = new Sample(sct,s,o);
            sam.addResult(scrValidatedNotSensible);
            ls.add(sam);
        }
        o.setSamples(ls);
        
        // Order for Tom Brown - 12 sheeps, ready to analyse - order status = toAnalyse
        o = new Order(tom);
        tom.addOrder(o);
        ls = new ArrayList<Sample>();
        for (int i=0;i<12;i++) {
            sam = new Sample(sct,s,o);
            sam.addResult(new ScrapieResult());
            ls.add(sam);
        }
        o.setSamples(ls);
        
        // Order for Tom Brown - 8 sheeps, different status - order status = inAnalysis
        o = new Order(tom);
        tom.addOrder(o);
        ls = new ArrayList<Sample>();
        for (int i=0;i<4;i++) {
            sam = new Sample(sct,s,o);
            sam.addResult(new ScrapieResult());
            ls.add(sam);
        }
        sam = new Sample(sct,s,o);
        sam.addResult(scrFirstReadOkSensible);
        ls.add(sam);
        sam = new Sample(sct,s,o);
        sam.addResult(scrFirstReadDoubtful);
        ls.add(sam);
        sam = new Sample(sct,s,o);
        sam.addResult(scrValidatedNotSensible);
        ls.add(sam);
        sam = new Sample(sct,s,o);
        sam.addResult(scrFirstReadOkNotSensible);
        ls.add(sam);
        o.setSamples(ls);
        
        // Order for Paul Cameron, status in progress (samples are not created yet)
        o = new Order(paul);
        paul.addOrder(o);
            
        // Sexing tests management - no order created yet
        sc = new SpecieCategory("Birds");
        theCategories.add(sc);
        s = new Specie("Parrot");
        sc.addSpecie(s);
        SexingTest sxt = new SexingTest(s,155,46,264,32);
        theAnalyses.add(sxt);
        Specie budge = new Specie("Budgerigar");
        sc.addSpecie(budge);
        sxt = new SexingTest(budge,175,35,333,18);
        theAnalyses.add(sxt);
        s = new Specie("Canary");
        sc.addSpecie(s);
        sxt = new SexingTest(s,133,35,135,67);
        theAnalyses.add(sxt);
	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * @return the theUsers
	 */
	public ArrayList<User> getTheUsers() {
		return theUsers;
	}

	/**
	 * @return the theCategories
	 */
	public ArrayList<SpecieCategory> getTheCategories() {
		return theCategories;
	}

	/**
	 * @return the theAnalyses
	 */
	public ArrayList<Analysis> getTheAnalyses() {
		return theAnalyses;
	}

	/**
	 * @return the theCustomers
	 */
	public ArrayList<Customer> getTheCustomers() {
		return theCustomers;
	}
	
}
