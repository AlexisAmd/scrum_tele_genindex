package Main;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

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
import View.ModelListCategory;

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
     * Initialise des données
     */
	public Main() {
		generateData();
		login = new Login(this);
	}
	
	/**
	 * Si les paramètres sont corrects, génère la vue suivante
	 * @param pid
	 * @param ppassword
	 */

	public boolean loginUser(String pid, String ppassword) {
		for(User u : theUsers) {
			if(u.getId().equals(pid) && u.getPassword().equals(ppassword)) { // On a trouvé un utilisateur
				this.currentUser = u;
				login.setVisible(false); // You can't see me!
				login.dispose(); // Destroy the JFrame object
				frame = new MainFrame(this);
				return true;
			}
		}
		// On a pas trouvé d'utilisateur, le couple id/pwd est incorrect
		JOptionPane.showMessageDialog(new JFrame(), "Wrong ID / Password.");
		return false;
	}
	
	/**
	 * Permet de créer un customer. Check au préalable si le nouveau customer n'existe pas déjà
	 */
	public void createCustomer(String pname, String ptown) {
		
		if(pname.length() < 3 || pname.length() > 15 || ptown.length() < 3 || ptown.length() > 15) {
			JOptionPane.showMessageDialog(new JFrame(), "Please complete the fields (between 3 and 15 caracters).");
		} else {
			pname = WordUtils.capitalizeFully(pname);
			ptown = WordUtils.capitalizeFully(ptown);
			
			boolean exist = false;
			for(Customer c : theCustomers) {
				if(( c.getName().toUpperCase().equals(pname.toUpperCase()) )   && 	( c.getTown().toUpperCase().equals(ptown.toUpperCase()) )) {
					exist = true;
				}
			}
			
			if(exist) { // Il existe déjà un client avec le même nom dans le logiciel
				JOptionPane.showMessageDialog(new JFrame(), "This customer already exist.");
			} else { // On peut créer le client
				Customer nCustomer = new Customer(pname, ptown);
				theCustomers.add(nCustomer);
				JOptionPane.showMessageDialog(new JFrame(), "The customer has been well created.");
			}
		}
		
	}
	
	
	/**
	 * Permet d'ajouter une categorie qui n'existe pas encore
	 * @param pname le nom de la catégorie
	 */
	public void createCategory(String pname) {
		if(pname.length() < 3 || pname.length() > 15) {
			JOptionPane.showMessageDialog(new JFrame(), "Please complete the fields (between 3 and 15 caracters).");
		} else {
			pname = WordUtils.capitalizeFully(pname);
	
			boolean exist = false;
			for(SpecieCategory sC : theCategories) {
				if(sC.getName().toUpperCase().equals(pname.toUpperCase())) {
					exist = true;
				}
			}
			
			if(exist) { // La catégorie existe déjà
				JOptionPane.showMessageDialog(new JFrame(), "This category already exist.");
			} else { // On peut créer la catégorie
				SpecieCategory nCategory = new SpecieCategory(pname);
				theCategories.add(nCategory);
				JOptionPane.showMessageDialog(new JFrame(), "The category has been well created.");
			}
		}
		
	}

	/**
	 * Crée une espèce et lui donne une catégorie. L'espèce ne doit appartenir qu'à une seule catégorie
	 * @param pname le nom de l'espèce
	 * @param pcategory la catégorie à laquelle l'espèce appartient
	 */
	public void createSpecie(String pname, SpecieCategory pcategory) {
		
		if(pname.length() < 3 || pname.length() > 15) {
			JOptionPane.showMessageDialog(new JFrame(), "Please complete the fields (between 3 and 15 caracters).");
		} else {
			pname = WordUtils.capitalizeFully(pname);
	
			boolean exist = false;
			SpecieCategory catExist = null;
			for(SpecieCategory sC : theCategories) { // Pour chaque catégorie
				for(Specie s : sC.getSpecies()) { // Pour chaque espèce de la catégorie
					if(s.getName().toUpperCase().equals(pname.toUpperCase())) {
						exist = true;
						catExist = sC;
					}
				}
			}
			
			if(exist) { // Il existe déjà une espèce similaire dans une catégorie
				JOptionPane.showMessageDialog(new JFrame(), "This specie already exist in the category " + catExist.getName());
			} else { // On peut creér l'espèce et la range dans la catégorie demandée
				Specie nSpecie = new Specie(pname);
				pcategory.addSpecie(nSpecie);
				
				//affichage de toutes les especes en cosole
				for(SpecieCategory sC : theCategories) { // Pour chaque catégorie
					for(Specie s : sC.getSpecies()) { // Pour chaque espèce de la catégorie
						System.out.println(s);
					}}
				
					}
				
				JOptionPane.showMessageDialog(new JFrame(), "The specie has been added successfully.");
			}
		}
		
	
	
	/**
	 * Ajoute un scrapie test (vérifie que les valeurs ne sont pas inférieures à 0)
	 * @param pspecie l'espèce
	 * @param ppos la position
	 * @param pval la valeur
	 */
	public void createScrapieText(Specie pspecie, int ppos, int pval) {
		
		if(ppos < 0 || pval < 0) {
			JOptionPane.showMessageDialog(new JFrame(), "Please enter positive values.");
		} else {
			ScrapieTest nScrapieTest = new ScrapieTest(pspecie, ppos, pval);
			theAnalyses.add(nScrapieTest);
			JOptionPane.showMessageDialog(new JFrame(), "The scrapie test has been well created.");
		}
		
	}
	
	/**
	 * Génère des données au préalable
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
