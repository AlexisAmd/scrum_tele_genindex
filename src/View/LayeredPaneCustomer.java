package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controler.CtrlAddCustomer;
import Main.Main;

public class LayeredPaneCustomer extends JLayeredPane {

	private JTextField textFieldCompany;
	private JTextField textFieldTown;
	private Main main;
	
	private Color darkBlack = new Color(51,51,51);
	private Font fontLabel = new Font("Tahoma", Font.PLAIN, 16);
	private Color blueBootstrap =  new Color(66,139,202);
	
	public LayeredPaneCustomer(Main pmain) {
		
		main = pmain;
		
		this.setForeground(new Color(51, 51, 51));
		this.setBorder(null);
		this.setBackground(Color.WHITE);
		

		textFieldCompany = new JTextField();
		textFieldCompany.setBounds(198, 115, 407, 39);
		this.add(textFieldCompany);
		textFieldCompany.setSelectionColor(blueBootstrap);
		textFieldCompany.setForeground(darkBlack);
		textFieldCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCompany.setColumns(10);
		
		textFieldTown = new JTextField();
		textFieldTown.setBounds(198, 165, 407, 39);
		this.add(textFieldTown);
		textFieldTown.setSelectionColor(new Color(66, 139, 202));
		textFieldTown.setForeground(new Color(51, 51, 51));
		textFieldTown.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTown.setColumns(10);
		
		JButton btnAddCustomer = new JButton("Add customer");
		btnAddCustomer.setBackground(blueBootstrap);
		btnAddCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddCustomer.setForeground(Color.WHITE);
		btnAddCustomer.setFont(fontLabel);
		
		btnAddCustomer.setBounds(198, 343, 248, 39);
		btnAddCustomer.addMouseListener(new CtrlAddCustomer(main, this));
		this.add(btnAddCustomer);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompany.setForeground(new Color(51, 51, 51));
		lblCompany.setFont(fontLabel);
		lblCompany.setBounds(10, 116, 151, 39);
		this.add(lblCompany);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTown.setForeground(new Color(51, 51, 51));
		lblTown.setFont(fontLabel);
		lblTown.setBounds(10, 164, 151, 39);
		this.add(lblTown);
		
	}

	/**
	 * @return the textFieldCompany
	 */
	public JTextField getTextFieldCompany() {
		return textFieldCompany;
	}

	/**
	 * @return the textFieldTown
	 */
	public JTextField getTextFieldTown() {
		return textFieldTown;
	}
	
	public void refresh(){
		
	}
}
