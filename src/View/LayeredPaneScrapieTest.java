package View;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import Main.Main;

public class LayeredPaneScrapieTest extends JLayeredPane {

	private Main main;
	private JTextField textFieldPosition;
	private JTextField textFieldValue;
	

	private ModelListSpecie modelListSpecie;

	
	public LayeredPaneScrapieTest(Main pmain) {
		main = pmain;
		
		this.setForeground(new Color(51, 51, 51));
		this.setBorder(null);
		this.setBackground(Color.WHITE);
		
		textFieldPosition = new JTextField();
		textFieldPosition.setBounds(348, 182, 86, 20);
		this.add(textFieldPosition);
		textFieldPosition.setColumns(10);
		
		textFieldValue = new JTextField();
		textFieldValue.setBounds(335, 248, 86, 20);
		this.add(textFieldValue);
		textFieldValue.setColumns(10);
		
		modelListSpecie = new ModelListSpecie(main);
		JComboBox listSpecie1 = new JComboBox(modelListSpecie);
		listSpecie1.setBounds(327, 73, 148, 38);
		
		this.add(listSpecie1);
		
		JButton btnCreateScrapieTest = new JButton("Create Scrapie Test");
		btnCreateScrapieTest.setBounds(112, 312, 233, 38);
		this.add(btnCreateScrapieTest);
		
	}
	
	/**
	 * @return the textFieldPosition
	 */
	public JTextField getTextFieldPosition() {
		return textFieldPosition;
	}

	/**
	 * @return the textFieldValue
	 */
	public JTextField getTextFieldValue() {
		return textFieldValue;
	}
	
	public void refresh(){

		modelListSpecie.refresh();

	}
	
}
