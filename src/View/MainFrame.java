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
import Controler.CtrlLogin;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;

public class MainFrame {

	private JFrame frame;
	private Main main;
	private JTextField textFieldCompany;
	private JTextField textFieldTown;
	private JTextField textFieldNumberOfSamples;
	private JList listCustomer;
	private JList listCategory;
	private JList listSpecie;
	private JList listAnalisys;
	private JTextField textFieldSpecieName;
	private JTextField textFieldCategoryName;

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
		
		listAnalisys = new JList();
		listAnalisys.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAnalisys.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listAnalisys.setBackground(Color.WHITE);
		listAnalisys.setBounds(299, 229, 246, 41);
		layeredPaneOrder.add(listAnalisys);
		
		textFieldNumberOfSamples = new JTextField();
		textFieldNumberOfSamples.setBounds(299, 283, 46, 29);
		layeredPaneOrder.add(textFieldNumberOfSamples);
		textFieldNumberOfSamples.setColumns(10);
		
		JButton btnCreateOrder = new JButton("Create order");
		btnCreateOrder.setBounds(245, 341, 246, 41);
		layeredPaneOrder.add(btnCreateOrder);
		
		JLayeredPane layeredPaneSpecie = new JLayeredPane();
		layeredPaneSpecie.setForeground(new Color(51, 51, 51));
		layeredPaneSpecie.setBorder(null);
		layeredPaneSpecie.setBackground(Color.WHITE);
		tabbedPane.addTab("Add specie", null, layeredPaneSpecie, "Click here to add a new specie");
		
		JList listSpecieCategory = new JList();
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
		
		JButton btnAddSpecie = new JButton("Add specie");
		btnAddSpecie.setBounds(234, 296, 255, 50);
		layeredPaneSpecie.add(btnAddSpecie);
		
		JLayeredPane layeredPaneCategory = new JLayeredPane();
		layeredPaneCategory.setForeground(new Color(51, 51, 51));
		layeredPaneCategory.setBorder(null);
		layeredPaneCategory.setBackground(Color.WHITE);
		tabbedPane.addTab("Add category", null, layeredPaneCategory, null);
		
		textFieldCategoryName = new JTextField();
		textFieldCategoryName.setBounds(323, 151, 86, 20);
		layeredPaneCategory.add(textFieldCategoryName);
		textFieldCategoryName.setColumns(10);
		
		JButton btnAddCategory = new JButton("Add category");
		btnAddCategory.setBounds(184, 256, 242, 88);
		layeredPaneCategory.add(btnAddCategory);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setBounds(65, 154, 165, 14);
		layeredPaneCategory.add(lblCategoryName);
		
		JLayeredPane layeredPaneExplore = new JLayeredPane();
		layeredPaneExplore.setForeground(new Color(51, 51, 51));
		layeredPaneExplore.setBorder(null);
		layeredPaneExplore.setBackground(Color.WHITE);
		tabbedPane.addTab("Explore", null, layeredPaneExplore, null);
		
		JLayeredPane layeredPane_6 = new JLayeredPane();
		layeredPane_6.setForeground(new Color(51, 51, 51));
		layeredPane_6.setBorder(null);
		layeredPane_6.setBackground(Color.WHITE);
		tabbedPane.addTab("Create Scrapie Test", null, layeredPane_6, null);
		frame.setVisible(true);
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
