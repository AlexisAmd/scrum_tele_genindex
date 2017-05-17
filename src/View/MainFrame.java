package View;

import javax.swing.JFrame;

import Main.Main;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.ComponentOrientation;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame {

	private JFrame frmGenindex;
	private Main main;
	
	// Les panes
	
	private JLayeredPane layeredPaneCustomer, layeredPaneOrder, layeredPaneSpecie, layeredPaneCategory, layeredPaneExplore, scrapiePane;
	
	//CSS
	private Color darkBlack = new Color(51,51,51);
	private Font fontLabel = new Font("Tahoma", Font.PLAIN, 16);
	private Color blueBootstrap =  new Color(66,139,202);

	/**
	 * Create the application.
	 */
	public MainFrame(Main pmain) {
		main = pmain;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frmGenindex = new JFrame();
		//frmGenindex.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Users\\pc\\Documents\\GitHub\\scrum_tele_genindex\\img\\parrot.PNG"));
		frmGenindex.getContentPane().setBackground(Color.WHITE);
		frmGenindex.setTitle("GENINDEX");
		frmGenindex.setResizable(false);
		frmGenindex.getContentPane().setForeground(Color.RED);
		frmGenindex.setBounds(100, 100, 664, 476);
		frmGenindex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGenindex.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFocusTraversalPolicyProvider(true);
		tabbedPane.setFocusCycleRoot(true);
		tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane.setAutoscrolls(true);
		tabbedPane.setBackground(blueBootstrap);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setOpaque(true);
		tabbedPane.setForeground(darkBlack);
		frmGenindex.getContentPane().add(tabbedPane);
		
		// Ajout du pane Customer
		
		layeredPaneCustomer = new LayeredPaneCustomer(main);
		tabbedPane.addTab("Add customer", null, layeredPaneCustomer, null);		
		
		// Ajout du pane Ordre
		
		layeredPaneOrder = new LayeredPaneOrder(main);
		tabbedPane.addTab("Create Order", null, layeredPaneOrder, "Create a new order");
		
		// Ajout pane espèce
		
		layeredPaneSpecie = new LayeredPaneSpecie(main);
		tabbedPane.addTab("Add specie", null, layeredPaneSpecie, "Click here to add a new specie");

		// Ajout pane categorie
		
		layeredPaneCategory = new LayeredPaneCategory(main);
		tabbedPane.addTab("Add category", null, layeredPaneCategory, null);
		
		// Ajout pane explore
		
		layeredPaneExplore = new JLayeredPane();
		tabbedPane.addTab("Explore", null, layeredPaneExplore, null);

		// Ajout du menu scrapie
		
		scrapiePane = new LayeredPaneScrapieTest(main);
		tabbedPane.addTab("Create Scrapie Test", null, scrapiePane, null);

		frmGenindex.setVisible(true);
		
	}

}
