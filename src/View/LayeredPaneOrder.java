package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import Controler.CtrlCreateOrder;
import Main.Main;
import Model.SpecieCategory;

public class LayeredPaneOrder extends JLayeredPane {

	private Main main;
	

	private JTextField textFieldNumberOfSamples;
	private Object selectedCategory, selectedCustomer, selectedSpecie, selectedAnalysis;

	private Font fontLabel = new Font("Tahoma", Font.PLAIN, 16);
	private Color blueBootstrap =  new Color(66,139,202);


	private ModelListCategory modelListCategory;
	private ModelListSpecie modelListSpecie;
	private ModelListAnalysis modelListAnalysis;
	private ModelListCustomer modelListCustomer;
	
	public LayeredPaneOrder(Main pmain) {
		main = pmain;
	
		this.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setForeground(new Color(51, 51, 51));
		this.setBorder(null);
		this.setBackground(Color.WHITE);
		
		JLabel labelCustomer = new JLabel("Customer");
		labelCustomer.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCustomer.setForeground(new Color(51, 51, 51));
		labelCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCustomer.setBounds(10, 42, 151, 39);
		this.add(labelCustomer);
		

		modelListCustomer = new ModelListCustomer(main);
		JComboBox listCustomer = new JComboBox(modelListCustomer);
		listCustomer.setBackground(Color.WHITE);
		listCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCustomer.setBounds(198, 44, 407, 39);
		this.add(listCustomer);
		selectedCustomer =   listCustomer.getSelectedItem(); 
		

		modelListCategory = new ModelListCategory(main);
		JComboBox listCategory = new JComboBox(modelListCategory);
		listCategory.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
			    selectedCategory =    listCategory.getSelectedItem(); 
			    modelListSpecie.setsC((String) selectedCategory);
				modelListSpecie.refresh();
		    }
		});
	    selectedCategory =    listCategory.getSelectedItem(); 

		listCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCategory.setBackground(Color.WHITE);
		listCategory.setBounds(198, 94, 407, 39);
		this.add(listCategory);
		

		modelListSpecie = new ModelListSpecie(main, (String) selectedCategory);
		JComboBox listSpecie = new JComboBox(modelListSpecie);
	    selectedSpecie =    listSpecie.getSelectedItem(); 
	    listSpecie.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
			    selectedSpecie =    listSpecie.getSelectedItem(); 
			    modelListAnalysis.setS((String) selectedSpecie);
				modelListAnalysis.refresh();
		    }
		});
		listSpecie.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listSpecie.setBackground(Color.WHITE);
		listSpecie.setBounds(198, 146, 407, 39);
		this.add(listSpecie);
		

		modelListAnalysis =new ModelListAnalysis(main, (String) selectedSpecie);
		JComboBox listAnalysis = new JComboBox(modelListAnalysis);

	    selectedAnalysis =    listAnalysis.getSelectedItem(); 

		listAnalysis.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listAnalysis.setBackground(Color.WHITE);
		listAnalysis.setBounds(198, 198, 407, 39);
		this.add(listAnalysis);
		
		textFieldNumberOfSamples = new JTextField();
		textFieldNumberOfSamples.setBounds(198, 248, 63, 39);
		this.add(textFieldNumberOfSamples);
		textFieldNumberOfSamples.setColumns(10);
		
		JButton btnCreateOrder = new JButton("Create order");
		btnCreateOrder.addMouseListener(new CtrlCreateOrder(main, this));
		btnCreateOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		btnCreateOrder.setBorderPainted(false);
		btnCreateOrder.setForeground(Color.WHITE);
		btnCreateOrder.setFont(fontLabel);
		btnCreateOrder.setBackground(blueBootstrap);
		btnCreateOrder.setBounds(198, 343, 248, 39);
		this.add(btnCreateOrder);
		
		JLabel labelCategory = new JLabel("Category");
		labelCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCategory.setForeground(new Color(51, 51, 51));
		labelCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCategory.setBounds(10, 92, 151, 39);
		this.add(labelCategory);
		
		JLabel labelSpecie = new JLabel("Specie");
		labelSpecie.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSpecie.setForeground(new Color(51, 51, 51));
		labelSpecie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelSpecie.setBounds(10, 146, 151, 39);
		this.add(labelSpecie);
		
		JLabel labelAnalysis = new JLabel("Analysis");
		labelAnalysis.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAnalysis.setForeground(new Color(51, 51, 51));
		labelAnalysis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAnalysis.setBounds(10, 198, 151, 39);
		this.add(labelAnalysis);
		
		JLabel labelNumberOfSamples = new JLabel("Number of Sample");
		labelNumberOfSamples.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNumberOfSamples.setForeground(new Color(51, 51, 51));
		labelNumberOfSamples.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNumberOfSamples.setBounds(10, 248, 151, 39);
		this.add(labelNumberOfSamples);
	
	}

	public void refresh(){
		modelListCategory.refresh();
		modelListSpecie.refresh();
		modelListAnalysis.refresh();
		modelListCustomer.refresh();
		System.out.println("le refresh est ok");
	}

	/**
	 * @return the textFieldNumberOfSamples
	 */
	public JTextField getTextFieldNumberOfSamples() {
		return textFieldNumberOfSamples;
	}

	/**
	 * @return the selectedCategory
	 */
	public Object getSelectedCategory() {
		return selectedCategory;
	}

	/**
	 * @return the selectedCustomer
	 */
	public Object getSelectedCustomer() {
		return selectedCustomer;
	}

	/**
	 * @return the selectedSpecie
	 */
	public Object getSelectedSpecie() {
		return selectedSpecie;
	}

	/**
	 * @return the selectedAnalysis
	 */
	public Object getSelectedAnalysis() {
		return selectedAnalysis;
	}
}
