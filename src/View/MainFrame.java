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

import Controller.CtrlLogin;
import Controller.CtrlAddCustomer;

import javax.swing.JTextField;

public class MainFrame {

	private JFrame frame;
	private Main main;
	private JTextField textFieldCompany;
	private JTextField textFieldTown;
	private JButton btnSubmitCustomer;

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
		textFieldCompany.setSelectionColor(new Color(66,139,202));
		textFieldCompany.setForeground(new Color(51,51,51));
		textFieldCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCompany.setBounds(218, 119, 207, 39);
		layeredPaneCustomer.add(textFieldCompany);
		textFieldCompany.setColumns(10);
		
		textFieldTown = new JTextField();
		textFieldTown.setSelectionColor(new Color(66, 139, 202));
		textFieldTown.setForeground(new Color(51, 51, 51));
		textFieldTown.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTown.setColumns(10);
		textFieldTown.setBounds(228, 179, 207, 39);
		layeredPaneCustomer.add(textFieldTown);
		
		btnSubmitCustomer = new JButton();
		btnSubmitCustomer.setForeground(Color.WHITE);
		btnSubmitCustomer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSubmitCustomer.setBackground(new Color(66,139,202));
		btnSubmitCustomer.setText("Add new customer");
		btnSubmitCustomer.addMouseListener(new CtrlAddCustomer(main, this));
		layeredPaneCustomer.add(btnSubmitCustomer);
		
		
		JLayeredPane layeredPaneOrder = new JLayeredPane();
		layeredPaneOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		layeredPaneOrder.setForeground(new Color(51, 51, 51));
		layeredPaneOrder.setBorder(null);
		layeredPaneOrder.setBackground(Color.WHITE);
		tabbedPane.addTab("Create Order", null, layeredPaneOrder, "Create a new order");
		
		JLabel lblBite = new JLabel("BITE");
		lblBite.setBounds(251, 177, 46, 14);
		layeredPaneOrder.add(lblBite);
		
		JLayeredPane layeredPaneSpecie = new JLayeredPane();
		layeredPaneSpecie.setForeground(new Color(51, 51, 51));
		layeredPaneSpecie.setBorder(null);
		layeredPaneSpecie.setBackground(Color.WHITE);
		tabbedPane.addTab("Add specie", null, layeredPaneSpecie, "Click here to add a new specie");
		
		JLayeredPane layeredPaneCategory = new JLayeredPane();
		layeredPaneCategory.setForeground(new Color(51, 51, 51));
		layeredPaneCategory.setBorder(null);
		layeredPaneCategory.setBackground(Color.WHITE);
		tabbedPane.addTab("Add category", null, layeredPaneCategory, null);
		
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
}
