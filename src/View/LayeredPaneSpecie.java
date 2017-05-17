package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import Controler.CtrlCreateCategory;
import Controler.CtrlCreateSpecie;
import Main.Main;
import Model.SpecieCategory;

public class LayeredPaneSpecie extends JLayeredPane {

	private Main main;
	
	private Color darkBlack = new Color(51,51,51);
	private Font fontLabel = new Font("Tahoma", Font.PLAIN, 16);
	private Color blueBootstrap =  new Color(66,139,202);
	

	private JTextField textFieldSpecieName;
	private Object selectedCategory;

	private ModelListCategory modelListCategory;

	public LayeredPaneSpecie(Main pmain) {
		
		main = pmain;
		
		this.setForeground(new Color(51, 51, 51));
		this.setBorder(null);
		this.setBackground(Color.WHITE);
		
		modelListCategory = new ModelListCategory(main);
		JComboBox listSpecieCategory = new JComboBox(modelListCategory);
		
	    selectedCategory =    listSpecieCategory.getSelectedItem(); 
		listSpecieCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listSpecieCategory.setBounds(198, 93, 407, 39);
		this.add(listSpecieCategory);
		
		textFieldSpecieName = new JTextField();
		textFieldSpecieName.setBounds(198, 143, 407, 39);
		this.add(textFieldSpecieName);
		textFieldSpecieName.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategory.setForeground(new Color(51, 51, 51));
		lblCategory.setFont(fontLabel);
		lblCategory.setBounds(10, 96, 151, 39);
		this.add(lblCategory);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(new Color(51, 51, 51));
		lblName.setFont(fontLabel);
		lblName.setBounds(10, 141, 151, 39);
		this.add(lblName);
		
		JButton btnCreateSpecie = new JButton("Add specie");
	    btnCreateSpecie.addMouseListener(new CtrlCreateSpecie(main, this)); 
		btnCreateSpecie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		btnCreateSpecie.setBorderPainted(false);
		btnCreateSpecie.setForeground(Color.WHITE);
		btnCreateSpecie.setFont(fontLabel);
		btnCreateSpecie.setBackground(blueBootstrap);
		btnCreateSpecie.setBounds(198, 343, 248, 39);
		this.add(btnCreateSpecie);
	}

	public void refresh(){
		modelListCategory.refresh();

	}

	public Object getSelectedCategory() {
		// TODO Auto-generated method stub
		return selectedCategory;
	}

	public String getTextFieldSpecieName() {
		// TODO Auto-generated method stub
		return textFieldSpecieName.getText();
	}
}
