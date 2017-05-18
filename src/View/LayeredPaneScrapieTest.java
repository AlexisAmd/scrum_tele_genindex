package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import Controler.CtrlCreateScrapieTest;
import Controler.CtrlCreateSpecie;
import Main.Main;

public class LayeredPaneScrapieTest extends JLayeredPane {

	private Main main;
	private JTextField textFieldPosition;
	private JTextField textFieldValue;
	
	private Color darkBlack = new Color(51,51,51);
	private Font fontLabel = new Font("Tahoma", Font.PLAIN, 16);
	private Color blueBootstrap =  new Color(66,139,202);

	private Object selectedSpecie;

	private ModelListSpecie modelListSpecie;

	
	public LayeredPaneScrapieTest(Main pmain) {
		main = pmain;
		
		this.setForeground(new Color(51, 51, 51));
		this.setBorder(null);
		this.setBackground(Color.WHITE);
		
		textFieldPosition = new JTextField();
		textFieldPosition.setBounds(198, 138, 407, 39);
		this.add(textFieldPosition);
		textFieldPosition.setColumns(10);
		
		JLabel lblPeakPosition = new JLabel("Peak Position");
		lblPeakPosition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeakPosition.setForeground(new Color(51, 51, 51));
		lblPeakPosition.setFont(fontLabel);
		lblPeakPosition.setBounds(10, 141, 151, 39);
		this.add(lblPeakPosition);
		
		textFieldValue = new JTextField();
		textFieldValue.setBounds(198, 183, 407, 39);
		this.add(textFieldValue);
		textFieldValue.setColumns(10);
		
		JLabel lblPeakValue = new JLabel("Peak Value");
		lblPeakValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeakValue.setForeground(new Color(51, 51, 51));
		lblPeakValue.setFont(fontLabel);
		lblPeakValue.setBounds(10, 186, 151, 39);
		this.add(lblPeakValue);
		
		modelListSpecie = new ModelListSpecie(main);
		JComboBox listSpecie1 = new JComboBox(modelListSpecie);
	    //selectedSpecie =    listSpecie1.getSelectedItem(); 
	    	    
		listSpecie1.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
			    selectedSpecie =    listSpecie1.getSelectedItem(); 

		    }
		});
	    selectedSpecie =    modelListSpecie.getSelectedItem();
	    
		listSpecie1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listSpecie1.setBounds(198, 93, 407, 39);
		this.add(listSpecie1);

		JLabel lblListSpecie = new JLabel("Specie");
		lblListSpecie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblListSpecie.setForeground(new Color(51, 51, 51));
		lblListSpecie.setFont(fontLabel);
		lblListSpecie.setBounds(10, 96, 151, 39);
		this.add(lblListSpecie);
		
		JButton btnCreateScrapieTest = new JButton("Create Scrapie Test");
		btnCreateScrapieTest.addMouseListener(new CtrlCreateScrapieTest(main, this)); 
		btnCreateScrapieTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		btnCreateScrapieTest.setBorderPainted(false);
		btnCreateScrapieTest.setForeground(Color.WHITE);
		btnCreateScrapieTest.setFont(fontLabel);
		btnCreateScrapieTest.setBackground(blueBootstrap);
		btnCreateScrapieTest.setBounds(198, 343, 248, 39);
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
	
	/**
	 * @return the selectedSpecie
	 */
	public Object getSelectedSpecie() {
		return selectedSpecie;
	}
	
	public void refresh(){
		modelListSpecie.refresh();
	}
	
}
