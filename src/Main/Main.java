package Main;

import java.awt.EventQueue;
import java.util.List;
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
	public static  void main(String[] args) {
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
		JOptionPane.showMessageDialog(new JFrame(), "Wrong ID / Password.", "Login error", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	/**
	 * Permet de cr�er un customer. Check au pr�alable si le nouveau customer n'existe pas d�j�
	 */
	public void createCustomer(String pname, String ptown) {
		
		if(pname.length() < 3 || pname.length() > 15 || ptown.length() < 3 || ptown.length() > 15) {
			JOptionPane.showMessageDialog(new JFrame(), "Please complete the fields (between 3 and 15 caracters).", "Completion error", JOptionPane.ERROR_MESSAGE);
		} else {
			pname = WordUtils.capitalizeFully(pname);
			ptown = WordUtils.capitalizeFully(ptown);
			
			boolean exist = false;
			for(Customer c : theCustomers) {
				if(( c.getName().toUpperCase().equals(pname.toUpperCase()) )   && 	( c.getTown().toUpperCase().equals(ptown.toUpperCase()) )) {
					exist = true;
				}
			}
			
			if(exist) { // Il existe d�j� un client avec le m�me nom dans le logiciel
				JOptionPane.showMessageDialog(new JFrame(), "This customer already exist.", "Already exist", JOptionPane.ERROR_MESSAGE);
			} else { // On peut cr�er le client
				Customer nCustomer = new Customer(pname, ptown);
				theCustomers.add(nCustomer);
				JOptionPane.showMessageDialog(new JFrame(), "The customer has been well created.");
			}
		}
		refresh();
	}
	
	
	/**
	 * Permet d'ajouter une categorie qui n'existe pas encore
	 * @param pname le nom de la cat�gorie
	 */
	public void createCategory(String pname) {
		if(pname.length() < 3 || pname.length() > 15) {
			JOptionPane.showMessageDialog(new JFrame(), "Please complete the fields (between 3 and 15 caracters).", "Completion error", JOptionPane.ERROR_MESSAGE);
		} else {
			pname = WordUtils.capitalizeFully(pname);
	
			boolean exist = false;
			for(SpecieCategory sC : theCategories) {
				if(sC.getName().toUpperCase().equals(pname.toUpperCase())) {
					exist = true;
				}
			}
			
			if(exist) { // La cat�gorie existe d�j�
				JOptionPane.showMessageDialog(new JFrame(), "This category already exist.", "Already exist", JOptionPane.ERROR_MESSAGE);
			} else { // On peut cr�er la cat�gorie
				SpecieCategory nCategory = new SpecieCategory(pname);
				theCategories.add(nCategory);
				JOptionPane.showMessageDialog(new JFrame(), "The category has been well created.");
			}
		}
		refresh();
	}

	/**
	 * Cr�e une esp�ce et lui donne une cat�gorie. L'esp�ce ne doit appartenir qu'� une seule cat�gorie
	 * @param pname le nom de l'esp�ce
	 * @param pcategory la cat�gorie � laquelle l'esp�ce appartient
	 */
	public void createSpecie(String pname, SpecieCategory pcategory) {
		
		if(pname.length() < 3 || pname.length() > 15) {
			JOptionPane.showMessageDialog(new JFrame(), "Please complete the fields (between 3 and 15 caracters).", "Completion error", JOptionPane.ERROR_MESSAGE);
		} else {
			pname = WordUtils.capitalizeFully(pname);
	
			boolean exist = false;
			SpecieCategory catExist = null;
			for(SpecieCategory sC : theCategories) { // Pour chaque cat�gorie
				for(Specie s : sC.getSpecies()) { // Pour chaque esp�ce de la cat�gorie
					if(s.getName().toUpperCase().equals(pname.toUpperCase())) {
						exist = true;
						catExist = sC;
					}
				}
			}
			
			if(exist) { // Il existe d�j� une esp�ce similaire dans une cat�gorie
				JOptionPane.showMessageDialog(new JFrame(), "This specie already exist in the category " + catExist.getName(), "Already exist", JOptionPane.ERROR_MESSAGE);
			} else { // On peut cre�r l'esp�ce et la range dans la cat�gorie demand�e
				Specie nSpecie = new Specie(pname);
				pcategory.addSpecie(nSpecie);
				JOptionPane.showMessageDialog(new JFrame(), "The specie has been added successfully.");
			}
				
		}
		refresh();
	}
	
	/**
	 * Cr�e une commande avec des samples dedans.
	 * @param selectedCustomer
	 * @param selectedSpecie
	 * @param selectedAnalysis
	 * @param numberOfSamples
	 */
	public void createOrder(Customer selectedCustomer, Specie selectedSpecie, Analysis selectedAnalysis,
			int numberOfSamples) {
		
		// Cr�er la commande
		Order nOrder = new Order(selectedCustomer);
		
		// G�n�re les samples � faire
		List<Sample> nList = new ArrayList<Sample>();
		for(int i = 1; i <= numberOfSamples; i++) {
			Sample nSample = new Sample(selectedAnalysis, selectedSpecie, nOrder);
			nList.add(nSample);
		}
		
		// Ajoute la liste de sample � la commande
		nOrder.setSamples(nList);
		
		// Ajoute la commande � la liste des commandes du client
		selectedCustomer.addOrder(nOrder);
		
		JOptionPane.showMessageDialog(new JFrame(), "The order has been created.");

	}
		
	/**
	 * Ajoute un scrapie test (v�rifie que les valeurs ne sont pas inf�rieures � 0)
	 * @param pspecie l'esp�ce
	 * @param ppos la position
	 * @param pval la valeur
	 */
	public void createScrapieText(Specie pspecie, int ppos, int pval) {
		
		if(ppos <= 0 || pval <= 0) {
			JOptionPane.showMessageDialog(new JFrame(), "Please enter positive values.", "Not a proper value", JOptionPane.ERROR_MESSAGE);
		} else {
			ScrapieTest nScrapieTest = new ScrapieTest(pspecie, ppos, pval);
			theAnalyses.add(nScrapieTest);
			JOptionPane.showMessageDialog(new JFrame(), "The scrapie test has been well created.");
		}
		refresh();
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
        Privilege customer = new Privilege("Customer");
        Privilege technician = new Privilege("Technician");
        Privilege admin = new Privilege("Admin");
        
        // User
        User magalie = new User("Magalie", "123", secretary);
        theUsers.add(magalie);
        
        User clotaire = new User("Clotaire", "123", validator);
        theUsers.add(clotaire);
        
        User marcel = new User("Marcel", "123", technician);
        theUsers.add(marcel);
        
        User vincent  = new User("Vincent", "123", customer);
        theUsers.add(vincent);        
        
        User uadmin = new User("Admin", "123", admin);
        theUsers.add(uadmin);
        
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
        /*o = new Order(paul);
        paul.addOrder(o);*/
            
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

	public ArrayList<SpecieCategory> getTheCategories() {
		return theCategories;
	}
	
	public void refresh(){
		MainFrame.refresh();
	}

	public ArrayList<Customer>  getTheCustomers() {
		// TODO Auto-generated method stub
		return  theCustomers;
	}

	public ArrayList<Analysis> getTheAnalyses() {
		// TODO Auto-generated method stub
		return theAnalyses;
	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}


}
