package View;

import javax.swing.JFrame;


import Main.Main;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.ComponentOrientation;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Controler.CtrlAddCustomer;
import Controler.CtrlCreateCategory;
import Controler.CtrlCreateOrder;
import Controler.CtrlCreateSpecie;
import Controler.CtrlLogin;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frmGenindex;
	private Main main;
	private JTextField textFieldNumberOfSamples;
	private JComboBox listCustomer;
	private JComboBox listCategory;
	private JComboBox listSpecie;
	private JComboBox listAnalysis;
	private JTextField textFieldSpecieName;
	private JTextField textFieldCategoryName;
	private JTable tableOrders;
	private JLabel lblPercentageAnalysedSamples;
	private JLabel lblPercentageNotAnalysedSamples;
	private JLabel lblTotalOfSamples;
	private JLayeredPane layeredPaneOrder;
	
	// Les panes
	
	private JLayeredPane layeredPaneCustomer, layeredPaneSpecie, layeredPaneCategory, scrapiePane;
	
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
		
		layeredPaneOrder = new JLayeredPane();
		layeredPaneOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		layeredPaneOrder.setForeground(new Color(51, 51, 51));
		layeredPaneOrder.setBorder(null);
		layeredPaneOrder.setBackground(Color.WHITE);
		tabbedPane.addTab("Create Order", null, layeredPaneOrder, "Create a new order");
		
		JLabel labelCustomer = new JLabel("Customer");
		labelCustomer.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCustomer.setForeground(new Color(51, 51, 51));
		labelCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCustomer.setBounds(10, 42, 151, 39);
		layeredPaneOrder.add(labelCustomer);
		
		listCustomer = new JComboBox(new ModelListCustomer(main));
		listCustomer.setBackground(Color.WHITE);
		listCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCustomer.setBounds(198, 44, 407, 39);
		layeredPaneOrder.add(listCustomer);
		
		listCategory = new JComboBox(new ModelListCategory(main));
		listCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCategory.setBackground(Color.WHITE);
		listCategory.setBounds(198, 94, 407, 39);
		layeredPaneOrder.add(listCategory);
		
		listSpecie = new JComboBox(new ModelListSpecie(main));
		listSpecie.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listSpecie.setBackground(Color.WHITE);
		listSpecie.setBounds(198, 146, 407, 39);
		layeredPaneOrder.add(listSpecie);
		
		listAnalysis = new JComboBox(new ModelListAnalysis(main));
		listAnalysis.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listAnalysis.setBackground(Color.WHITE);
		listAnalysis.setBounds(198, 198, 407, 39);
		layeredPaneOrder.add(listAnalysis);
		
		textFieldNumberOfSamples = new JTextField();
		textFieldNumberOfSamples.setBounds(198, 248, 63, 39);
		layeredPaneOrder.add(textFieldNumberOfSamples);
		textFieldNumberOfSamples.setColumns(10);
		
		JButton btnCreateOrder = new JButton("Create order");
		btnCreateOrder.addMouseListener(new CtrlCreateOrder(main, this));
		btnCreateOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		btnCreateOrder.setBorderPainted(false);
		btnCreateOrder.setForeground(Color.WHITE);
		btnCreateOrder.setFont(fontLabel);
		btnCreateOrder.setBackground(blueBootstrap);
		btnCreateOrder.setBounds(198, 343, 248, 39);
		layeredPaneOrder.add(btnCreateOrder);
		
		JLabel labelCategory = new JLabel("Category");
		labelCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCategory.setForeground(new Color(51, 51, 51));
		labelCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCategory.setBounds(10, 92, 151, 39);
		layeredPaneOrder.add(labelCategory);
		
		JLabel labelSpecie = new JLabel("Specie");
		labelSpecie.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSpecie.setForeground(new Color(51, 51, 51));
		labelSpecie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelSpecie.setBounds(10, 146, 151, 39);
		layeredPaneOrder.add(labelSpecie);
		
		JLabel labelAnalysis = new JLabel("Analysis");
		labelAnalysis.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAnalysis.setForeground(new Color(51, 51, 51));
		labelAnalysis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAnalysis.setBounds(10, 198, 151, 39);
		layeredPaneOrder.add(labelAnalysis);
		
		JLabel labelNumberOfSamples = new JLabel("Number of Sample");
		labelNumberOfSamples.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNumberOfSamples.setForeground(new Color(51, 51, 51));
		labelNumberOfSamples.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNumberOfSamples.setBounds(10, 248, 151, 39);
		layeredPaneOrder.add(labelNumberOfSamples);
		
		// Ajout pane espèce
		
		layeredPaneSpecie = new LayeredPaneSpecie(main);
		tabbedPane.addTab("Add specie", null, layeredPaneSpecie, "Click here to add a new specie");

		// Ajout pane categorie
		
		layeredPaneCategory = new LayeredPaneCategory(main);
		tabbedPane.addTab("Add category", null, layeredPaneCategory, null);
		
		// Ajout pane explore
		
		JLayeredPane layeredPaneExplore = new JLayeredPane();
		layeredPaneExplore.setForeground(new Color(51, 51, 51));
		layeredPaneExplore.setBorder(null);
		layeredPaneExplore.setBackground(Color.WHITE);
		tabbedPane.addTab("Explore", null, layeredPaneExplore, null);
		
		JComboBox listCustomers = new JComboBox(new ModelListCustomer(main));
		listCustomers.setForeground(darkBlack);
		listCustomers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listCustomers.setBackground(Color.WHITE);
		listCustomers.setModel(new DefaultComboBoxModel(new String[] {"Item1", "Item2", "Item3"}));

	
		listCustomers.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCustomers.setBounds(197, 42, 405, 40);
		layeredPaneExplore.add(listCustomers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setForeground(new Color(51, 51, 51));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(41, 116, 345, 255);
		layeredPaneExplore.add(scrollPane);
		
		tableOrders = new JTable();
		tableOrders.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//TODO generer la classe qui se charge de creer des model
		tableOrders.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Order", "Status", "Object"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableOrders.getColumnModel().getColumn(0).setPreferredWidth(43);
		tableOrders.getColumnModel().getColumn(1).setPreferredWidth(96);
		tableOrders.getColumnModel().getColumn(2).setPreferredWidth(76);
		tableOrders.getColumnModel().getColumn(3).setResizable(false);
		tableOrders.getColumnModel().getColumn(3).setPreferredWidth(1);
		tableOrders.getColumnModel().getColumn(3).setMinWidth(0);
		tableOrders.getColumnModel().getColumn(3).setMaxWidth(1);
		tableOrders.setSelectionBackground(new Color(204, 204, 255));
		tableOrders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableOrders.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		//TODO FIN TABLE A EXPORTER DANS UN EAUTRE VUE
		scrollPane.setViewportView(tableOrders);
		
		JLabel lblChooseACustomer = new JLabel("Choose a customer");
		lblChooseACustomer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChooseACustomer.setForeground(new Color(51, 51, 51));
		lblChooseACustomer.setFont(fontLabel );
		lblChooseACustomer.setBounds(41, 42, 140, 39);
		layeredPaneExplore.add(lblChooseACustomer);
		
		JPanel panelStatistics = new JPanel();
		panelStatistics.setBorder(new TitledBorder(null, "Statistics", TitledBorder.LEADING, TitledBorder.TOP, null, darkBlack ));
		panelStatistics.setBackground(new Color(255, 255, 255));
		panelStatistics.setForeground(darkBlack);
		panelStatistics.setBounds(396, 116, 206, 255);
		layeredPaneExplore.add(panelStatistics);
		panelStatistics.setLayout(null);
		
		JLabel lblAnalysedSamples = new JLabel("Analysed Samples");
		lblAnalysedSamples.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnalysedSamples.setForeground(darkBlack);
		lblAnalysedSamples.setBounds(10, 38, 159, 34);
		panelStatistics.add(lblAnalysedSamples);
		
		lblPercentageAnalysedSamples = new JLabel("NA");
		lblPercentageAnalysedSamples.setBounds(164, 38, 32, 34);
		lblPercentageAnalysedSamples.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentageAnalysedSamples.setForeground(blueBootstrap);
		panelStatistics.add(lblPercentageAnalysedSamples);
		
		JLabel lblNonAnalysedSamples = new JLabel("Not Analysed Samples");
		lblNonAnalysedSamples.setBounds(10, 110, 159, 34);
		lblNonAnalysedSamples.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNonAnalysedSamples.setForeground(darkBlack);
		panelStatistics.add(lblNonAnalysedSamples);
		
		JLabel lblTotalSamples = new JLabel("Total");
		lblTotalSamples.setBounds(10, 182, 159, 34);
		lblTotalSamples.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalSamples.setForeground(darkBlack);
		panelStatistics.add(lblTotalSamples);
		
		lblPercentageNotAnalysedSamples = new JLabel("NA");
		lblPercentageNotAnalysedSamples.setBounds(164, 182, 32, 34);
		lblPercentageNotAnalysedSamples.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentageNotAnalysedSamples.setForeground(blueBootstrap);
		panelStatistics.add(lblPercentageNotAnalysedSamples);
		
		lblTotalOfSamples = new JLabel("NA");
		lblTotalOfSamples.setForeground(blueBootstrap);
		lblTotalOfSamples.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalOfSamples.setBounds(164, 110, 32, 34);
		panelStatistics.add(lblTotalOfSamples);
		
		// Ajout du menu scrapie
		
		scrapiePane = new LayeredPaneScrapieTest(main);
		tabbedPane.addTab("Create Scrapie Test", null, scrapiePane, null);

		frmGenindex.setVisible(true);
	}




	private ComboBoxModel ModelListAnalysis(Main main2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param lblPercentageAnalysedSamples the lblPercentageAnalysedSamples to set
	 */
	private void setLblPercentageAnalysedSamples(JLabel lblPercentageAnalysedSamples) {
		this.lblPercentageAnalysedSamples = lblPercentageAnalysedSamples;
	}

	/**
	 * @param lblPercentageNotAnalysedSamples the lblPercentageNotAnalysedSamples to set
	 */
	private void setLblPercentageNotAnalysedSamples(JLabel lblPercentageNotAnalysedSamples) {
		this.lblPercentageNotAnalysedSamples = lblPercentageNotAnalysedSamples;
	}

	/**
	 * @param lblTotalOfSamples the lblTotalOfSamples to set
	 */
	private void setLblTotalOfSamples(JLabel lblTotalOfSamples) {
		this.lblTotalOfSamples = lblTotalOfSamples;
	}

	public JTextField getTextFieldSpecieName() {
		return textFieldSpecieName;
	}

	public JTextField getTextFieldCategoryName() {
		return textFieldCategoryName;
	}

	public JTextField getTextFieldNumberOfSamples() {
		return textFieldNumberOfSamples;
	}

	public JFrame getFrmGenindex() {
		return frmGenindex;
	}
}
