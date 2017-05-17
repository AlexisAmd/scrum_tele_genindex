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
	
	
	//CSS
	private Color darkBlack = new Color(51,51,51);
	private Font fontLabel = new Font("Tahoma", Font.PLAIN, 16);

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
		
		frame = new JFrame();
		frame.setTitle("Genindex");
		frame.setResizable(false);
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
		tabbedPane.setForeground(darkBlack);
		frame.getContentPane().add(tabbedPane);
		
		JLayeredPane layeredPaneCustomer = new JLayeredPane();
		layeredPaneCustomer.setForeground(new Color(51, 51, 51));
		layeredPaneCustomer.setBorder(null);
		layeredPaneCustomer.setBackground(Color.WHITE);
		tabbedPane.addTab("Add customer", null, layeredPaneCustomer, null);
		
		textFieldCompany = new JTextField();
		textFieldCompany.setBounds(198, 115, 407, 39);
		layeredPaneCustomer.add(textFieldCompany);
		textFieldCompany.setSelectionColor(new Color(66,139,202));
		textFieldCompany.setForeground(darkBlack);
		textFieldCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCompany.setColumns(10);
		
		textFieldTown = new JTextField();
		textFieldTown.setBounds(198, 165, 407, 39);
		layeredPaneCustomer.add(textFieldTown);
		textFieldTown.setSelectionColor(new Color(66, 139, 202));
		textFieldTown.setForeground(new Color(51, 51, 51));
		textFieldTown.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTown.setColumns(10);
		
		JButton btnAddCustomer = new JButton("Add customer");
		btnAddCustomer.setBackground(new Color(66,139,202));
		btnAddCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddCustomer.setForeground(Color.WHITE);
		btnAddCustomer.setFont(fontLabel);
		
		btnAddCustomer.setBounds(198, 343, 248, 39);
		btnAddCustomer.addMouseListener(new CtrlAddCustomer(main, this));
		layeredPaneCustomer.add(btnAddCustomer);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompany.setForeground(new Color(51, 51, 51));
		lblCompany.setFont(fontLabel);
		lblCompany.setBounds(10, 116, 151, 39);
		layeredPaneCustomer.add(lblCompany);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTown.setForeground(new Color(51, 51, 51));
		lblTown.setFont(fontLabel);
		lblTown.setBounds(10, 164, 151, 39);
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
		listCustomer.setBounds(198, 44, 407, 39);
		layeredPaneOrder.add(listCustomer);
		
		listCategory = new JList();
		listCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCategory.setBackground(Color.WHITE);
		listCategory.setBounds(198, 94, 407, 39);
		layeredPaneOrder.add(listCategory);
		
		listSpecie = new JList();
		listSpecie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSpecie.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listSpecie.setBackground(Color.WHITE);
		listSpecie.setBounds(198, 146, 407, 39);
		layeredPaneOrder.add(listSpecie);
		
		listAnalysis = new JList();
		listAnalysis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		btnCreateOrder.setBackground(new Color(66,139,202));
		btnCreateOrder.setBounds(198, 343, 248, 39);
		layeredPaneOrder.add(btnCreateOrder);
		
		JLayeredPane layeredPaneSpecie = new JLayeredPane();
		layeredPaneSpecie.setForeground(new Color(51, 51, 51));
		layeredPaneSpecie.setBorder(null);
		layeredPaneSpecie.setBackground(Color.WHITE);
		tabbedPane.addTab("Add specie", null, layeredPaneSpecie, "Click here to add a new specie");
		
		listSpecieCategory = new JList();
		listSpecieCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listSpecieCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSpecieCategory.setBounds(198, 93, 407, 39);
		layeredPaneSpecie.add(listSpecieCategory);
		
		textFieldSpecieName = new JTextField();
		textFieldSpecieName.setBounds(198, 143, 407, 39);
		layeredPaneSpecie.add(textFieldSpecieName);
		textFieldSpecieName.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategory.setForeground(new Color(51, 51, 51));
		lblCategory.setFont(fontLabel);
		lblCategory.setBounds(10, 96, 151, 39);
		layeredPaneSpecie.add(lblCategory);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(new Color(51, 51, 51));
		lblName.setFont(fontLabel);
		lblName.setBounds(10, 141, 151, 39);
		layeredPaneSpecie.add(lblName);
		
		JButton btnCreateSpecie = new JButton("Add specie");
		btnCreateSpecie.addMouseListener(new CtrlCreateSpecie(main, this));
		btnCreateSpecie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		btnCreateSpecie.setBorderPainted(false);
		btnCreateSpecie.setForeground(Color.WHITE);
		btnCreateSpecie.setFont(fontLabel);
		btnCreateSpecie.setBackground(new Color(66,139,202));
		btnCreateSpecie.setBounds(198, 343, 248, 39);
		layeredPaneSpecie.add(btnCreateSpecie);
		
		JLayeredPane layeredPaneCategory = new JLayeredPane();
		layeredPaneCategory.setForeground(new Color(51, 51, 51));
		layeredPaneCategory.setBorder(null);
		layeredPaneCategory.setBackground(Color.WHITE);
		tabbedPane.addTab("Add category", null, layeredPaneCategory, null);
		
		textFieldCategoryName = new JTextField();
		textFieldCategoryName.setBounds(198, 142, 407, 39);
		layeredPaneCategory.add(textFieldCategoryName);
		textFieldCategoryName.setColumns(10);
		
		JButton btnCreateCategory = new JButton("Add category");
		btnCreateCategory.addMouseListener(new CtrlCreateCategory(main, this));
		btnCreateCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		btnCreateCategory.setBorderPainted(false);
		btnCreateCategory.setForeground(Color.WHITE);
		btnCreateCategory.setFont(fontLabel);
		btnCreateCategory.setBackground(new Color(66,139,202));
		btnCreateCategory.setBounds(198, 343, 248, 39);
		layeredPaneCategory.add(btnCreateCategory);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoryName.setForeground(new Color(51, 51, 51));
		lblCategoryName.setFont(fontLabel);
		lblCategoryName.setBounds(10, 140, 151, 39);
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
		scrollPane.setOpaque(false);
		scrollPane.setForeground(new Color(51, 51, 51));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(41, 116, 345, 255);
		layeredPaneExplore.add(scrollPane);
		
		tableOrders = new JTable();
		tableOrders.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		tableOrders.setSelectionBackground(new Color(66, 139, 202));
		tableOrders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableOrders);
		tableOrders.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
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
		
		JLabel lblAnalysedSamples = new JLabel("AnalysedSamples");
		lblAnalysedSamples.setBounds(10, 31, 159, 34);
		panelStatistics.add(lblAnalysedSamples);
		
		lblPercentageAnalysedSamples = new JLabel("NA");
		lblPercentageAnalysedSamples.setBounds(164, 31, 32, 34);
		panelStatistics.add(lblPercentageAnalysedSamples);
		
		JLabel lblNonAnalysedSamples = new JLabel("Not Analysed Samples");
		lblNonAnalysedSamples.setBounds(10, 79, 159, 34);
		panelStatistics.add(lblNonAnalysedSamples);
		
		JLabel lblTotalSamples = new JLabel("Total");
		lblTotalSamples.setBounds(10, 123, 159, 34);
		panelStatistics.add(lblTotalSamples);
		
		lblPercentageNotAnalysedSamples = new JLabel("NA");
		lblPercentageNotAnalysedSamples.setBounds(164, 79, 32, 34);
		panelStatistics.add(lblPercentageNotAnalysedSamples);
		
		lblTotalOfSamples = new JLabel("NA");
		lblTotalOfSamples.setBounds(164, 124, 32, 34);
		panelStatistics.add(lblTotalOfSamples);
		
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
