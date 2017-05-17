package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controler.CtrlCreateCategory;
import Main.Main;

public class LayeredPaneCategory extends JLayeredPane {

	private Main main;
	private JTextField textFieldCategoryName;

	private Color darkBlack = new Color(51,51,51);
	private Font fontLabel = new Font("Tahoma", Font.PLAIN, 16);
	private Color blueBootstrap =  new Color(66,139,202);
	
	public LayeredPaneCategory(Main pmain) {
		
		main = pmain;
		
		this.setForeground(new Color(51, 51, 51));
		this.setBorder(null);
		this.setBackground(Color.WHITE);
		
		textFieldCategoryName = new JTextField();
		textFieldCategoryName.setBounds(198, 142, 407, 39);
		this.add(textFieldCategoryName);
		textFieldCategoryName.setColumns(10);
		
		JButton btnCreateCategory = new JButton("Add category");
		btnCreateCategory.addMouseListener(new CtrlCreateCategory(main, this));
		btnCreateCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		btnCreateCategory.setBorderPainted(false);
		btnCreateCategory.setForeground(Color.WHITE);
		btnCreateCategory.setFont(fontLabel);
		btnCreateCategory.setBackground(blueBootstrap);
		btnCreateCategory.setBounds(198, 343, 248, 39);
		this.add(btnCreateCategory);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoryName.setForeground(new Color(51, 51, 51));
		lblCategoryName.setFont(fontLabel);
		lblCategoryName.setBounds(10, 140, 151, 39);
		this.add(lblCategoryName);
		
	}

	/**
	 * @return the textFieldCategoryName
	 */
	public JTextField getTextFieldCategoryName() {
		return textFieldCategoryName;
	}
	
public void refresh(){
	
}
	
}
