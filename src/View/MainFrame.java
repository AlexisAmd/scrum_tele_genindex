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
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Controler.CtrlAddCustomer;
import Controler.CtrlCreateCategory;
import Controler.CtrlCreateOrder;
import Controler.CtrlCreateSpecie;
import Controler.CtrlLogin;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MainFrame {

	private JFrame frame;
	private Main main;
	private JTextField textFieldCompany;
	private JTextField textFieldTown;
	private JTextField textFieldNumberOfSamples;
	private JList listCustomer;
	private JList listCategory;
	private JList listSpecie;
	private JList listAnalysis;
	private JTextField textFieldSpecieName;
	private JTextField textFieldCategoryName;
	private JList listSpecieCategory;
	private JTable tableOrders;
	private JLabel lblPercentageAnalysedSamples;
	private JLabel lblPercentageNotAnalysedSamples;
	private JLabel lblTotalOfSamples;

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
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(66,139,202));
		frame.setBounds(100, 100, 664, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFocusTraversalPolicyProvider(true);
		tabbedPane.setFocusCycleRoot(true);
		tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane.setAutoscrolls(true);
		tabbedPane.setBackground(new Color(66,139,202));
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setOpaque(true);
		tabbedPane.setForeground(new Color(51,51,51));
		frame.getContentPane().add(tabbedPane);
		
		JLayeredPane layeredPaneCustomer = new JLayeredPane();
		layeredPaneCustomer.setForeground(new Color(51, 51, 51));
		layeredPaneCustomer.setBorder(null);
		layeredPaneCustomer.setBackground(Color.WHITE);
		tabbedPane.addTab("Add customer", null, layeredPaneCustomer, null);
		
		textFieldCompany = new JTextField();
		textFieldCompany.setBounds(258, 115, 207, 39);
		layeredPaneCustomer.add(textFieldCompany);
		textFieldCompany.setSelectionColor(new Color(66,139,202));
		textFieldCompany.setForeground(new Color(51,51,51));
		textFieldCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCompany.setColumns(10);
		
		textFieldTown = new JTextField();
		textFieldTown.setBounds(247, 195, 207, 39);
		layeredPaneCustomer.add(textFieldTown);
		textFieldTown.setSelectionColor(new Color(66, 139, 202));
		textFieldTown.setForeground(new Color(51, 51, 51));
		textFieldTown.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTown.setColumns(10);
		
		JButton btnAddCustomer = new JButton("Add customer");
		btnAddCustomer.setBounds(201, 298, 264, 68);
		btnAddCustomer.addMouseListener(new CtrlAddCustomer(main, this));
		layeredPaneCustomer.add(btnAddCustomer);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setBounds(84, 115, 46, 14);
		layeredPaneCustomer.add(lblCompany);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setBounds(63, 208, 46, 14);
		layeredPaneCustomer.add(lblTown);
		
		
		JLayeredPane layeredPaneOrder = new JLayeredPane();
		layeredPaneOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		layeredPaneOrder.setForeground(new Color(51, 51, 51));
		layeredPaneOrder.setBorder(null);
		layeredPaneOrder.setBackground(Color.WHITE);
		tabbedPane.addTab("Create Order", null, layeredPaneOrder, "Create a new order");
		
		listCustomer = new JList();
		listCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCustomer.setBackground(Color.WHITE);
		listCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCustomer.setBounds(299, 36, 246, 41);
		layeredPaneOrder.add(listCustomer);
		
		listCategory = new JList();
		listCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCategory.setBackground(Color.WHITE);
		listCategory.setBounds(299, 100, 246, 41);
		layeredPaneOrder.add(listCategory);
		
		listSpecie = new JList();
		listSpecie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSpecie.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listSpecie.setBackground(Color.WHITE);
		listSpecie.setBounds(299, 159, 246, 41);
		layeredPaneOrder.add(listSpecie);
		
		listAnalysis = new JList();
		listAnalysis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAnalysis.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listAnalysis.setBackground(Color.WHITE);
		listAnalysis.setBounds(299, 229, 246, 41);
		layeredPaneOrder.add(listAnalysis);
		
		textFieldNumberOfSamples = new JTextField();
		textFieldNumberOfSamples.setBounds(299, 283, 46, 29);
		layeredPaneOrder.add(textFieldNumberOfSamples);
		textFieldNumberOfSamples.setColumns(10);
		
		JButton btnCreateOrder = new JButton("Create order");
		btnCreateOrder.addMouseListener(new CtrlCreateOrder(main, this));
		btnCreateOrder.setBounds(199, 352, 246, 41);
		layeredPaneOrder.add(btnCreateOrder);
		
		JLayeredPane layeredPaneSpecie = new JLayeredPane();
		layeredPaneSpecie.setForeground(new Color(51, 51, 51));
		layeredPaneSpecie.setBorder(null);
		layeredPaneSpecie.setBackground(Color.WHITE);
		tabbedPane.addTab("Add specie", null, layeredPaneSpecie, "Click here to add a new specie");
		
		listSpecieCategory = new JList();
		listSpecieCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listSpecieCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSpecieCategory.setBounds(370, 93, 209, 41);
		layeredPaneSpecie.add(listSpecieCategory);
		
		textFieldSpecieName = new JTextField();
		textFieldSpecieName.setBounds(370, 182, 209, 41);
		layeredPaneSpecie.add(textFieldSpecieName);
		textFieldSpecieName.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(142, 96, 46, 14);
		layeredPaneSpecie.add(lblCategory);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(142, 195, 46, 14);
		layeredPaneSpecie.add(lblName);
		
		JButton btnCreateSpecie = new JButton("Add specie");
		btnCreateSpecie.addMouseListener(new CtrlCreateSpecie(main, this));
		btnCreateSpecie.setBounds(234, 296, 255, 50);
		
		layeredPaneSpecie.add(btnCreateSpecie);
		
		JLayeredPane layeredPaneCategory = new JLayeredPane();
		layeredPaneCategory.setForeground(new Color(51, 51, 51));
		layeredPaneCategory.setBorder(null);
		layeredPaneCategory.setBackground(Color.WHITE);
		tabbedPane.addTab("Add category", null, layeredPaneCategory, null);
		
		textFieldCategoryName = new JTextField();
		textFieldCategoryName.setBounds(323, 151, 86, 20);
		layeredPaneCategory.add(textFieldCategoryName);
		textFieldCategoryName.setColumns(10);
		
		JButton btnCreateCategory = new JButton("Add category");
		btnCreateCategory.addMouseListener(new CtrlCreateCategory(main, this));
		btnCreateCategory.setBounds(184, 256, 242, 88);
		layeredPaneCategory.add(btnCreateCategory);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setBounds(65, 154, 165, 14);
		layeredPaneCategory.add(lblCategoryName);
		
		JLayeredPane layeredPaneExplore = new JLayeredPane();
		layeredPaneExplore.setForeground(new Color(51, 51, 51));
		layeredPaneExplore.setBorder(null);
		layeredPaneExplore.setBackground(Color.WHITE);
		tabbedPane.addTab("Explore", null, layeredPaneExplore, null);
		
		JList listCustomers = new JList();
		listCustomers.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCustomers.setBounds(197, 42, 405, 40);
		layeredPaneExplore.add(listCustomers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 116, 355, 255);
		layeredPaneExplore.add(scrollPane);
		
		tableOrders = new JTable();
		scrollPane.setViewportView(tableOrders);
		tableOrders.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblChooseACustomer = new JLabel("Choose a customer");
		lblChooseACustomer.setBounds(31, 45, 156, 37);
		layeredPaneExplore.add(lblChooseACustomer);
		
		JPanel panel = new JPanel();
		panel.setBounds(396, 203, 206, 168);
		layeredPaneExplore.add(panel);
		panel.setLayout(null);
		
		JLabel lblAnalysedSamples = new JLabel("AnalysedSamples");
		lblAnalysedSamples.setBounds(10, 31, 159, 34);
		panel.add(lblAnalysedSamples);
		
		lblPercentageAnalysedSamples = new JLabel("NA");
		lblPercentageAnalysedSamples.setBounds(164, 31, 32, 34);
		panel.add(lblPercentageAnalysedSamples);
		
		JLabel lblNonAnalysedSamples = new JLabel("Not Analysed Samples");
		lblNonAnalysedSamples.setBounds(10, 79, 159, 34);
		panel.add(lblNonAnalysedSamples);
		
		JLabel lblTotalSamples = new JLabel("Total");
		lblTotalSamples.setBounds(10, 123, 159, 34);
		panel.add(lblTotalSamples);
		
		lblPercentageNotAnalysedSamples = new JLabel("NA");
		lblPercentageNotAnalysedSamples.setBounds(164, 79, 32, 34);
		panel.add(lblPercentageNotAnalysedSamples);
		
		lblTotalOfSamples = new JLabel("NA");
		lblTotalOfSamples.setBounds(164, 124, 32, 34);
		panel.add(lblTotalOfSamples);
		
		JLayeredPane layeredPaneCreateScrapieTest = new JLayeredPane();
		layeredPaneCreateScrapieTest.setForeground(new Color(51, 51, 51));
		layeredPaneCreateScrapieTest.setBorder(null);
		layeredPaneCreateScrapieTest.setBackground(Color.WHITE);
		tabbedPane.addTab("Create Scrapie Test", null, layeredPaneCreateScrapieTest, null);
		frame.setVisible(true);
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

	public JTextField getTextFieldCompany() {
		return textFieldCompany;
	}

	public JTextField getTextFieldTown() {
		return textFieldTown;
	}

	public JTextField getTextFieldNumberOfSamples() {
		return textFieldNumberOfSamples;
	}
}
