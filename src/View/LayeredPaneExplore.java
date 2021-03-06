package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import Model.*;

import Main.Main;
import Controler.*;

public class LayeredPaneExplore extends JLayeredPane {

	private Main main;
	
	private Color darkBlack = new Color(51,51,51);
	private Font fontLabel = new Font("Tahoma", Font.PLAIN, 16);
	private Color blueBootstrap =  new Color(66,139,202);
	
	private JTable tableOrders;
	private JLabel lblPercentageAnalysedSamples;
	private JLabel lblPercentageNotAnalysedSamples;
	private JLabel lblTotalOfSamples;

	private ModelListCustomer modelCustomer;
	private ModelJTableOrders modelJtable;
	
	private String intermediateCustomer;
	private Customer selectedCustomer;
	
	public LayeredPaneExplore(Main pmain) {
		main = pmain;
		
		this.setForeground(new Color(51, 51, 51));
		this.setBorder(null);
		this.setBackground(Color.WHITE);
		
		

	    
		modelCustomer = new ModelListCustomer(main);
		JComboBox listCustomers = new JComboBox(modelCustomer);
		listCustomers.setSelectedItem("azert");
		listCustomers.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	intermediateCustomer =    (String) listCustomers.getSelectedItem(); 
			    for(Customer cus : main.getTheCustomers()) {
					if (cus.getName().equals(selectedCustomer)){
						selectedCustomer = cus;
					}
				}
			    modelJtable = new ModelJTableOrders(main,selectedCustomer);
		    }
		});
		
		//selectedCustomer =    (String) modelCustomer.getSelectedItem();
		
		//listCustomers.addActionListener(new CtrlDisplayOrders(model,listCustomers,main));
		listCustomers.setForeground(darkBlack);
		listCustomers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listCustomers.setBackground(Color.WHITE);
		listCustomers.setModel(new ModelListCustomer(main));

	
		listCustomers.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCustomers.setBounds(197, 42, 405, 40);
		this.add(listCustomers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setForeground(new Color(51, 51, 51));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(41, 116, 345, 255);
		this.add(scrollPane);
		
		tableOrders = new JTable(modelJtable);
		tableOrders.setFont(new Font("Tahoma", Font.PLAIN, 14));

		tableOrders.getColumnModel().getColumn(0).setPreferredWidth(43);
		tableOrders.getColumnModel().getColumn(1).setPreferredWidth(96);
		tableOrders.getColumnModel().getColumn(2).setPreferredWidth(76);
		/*tableOrders.getColumnModel().getColumn(3).setResizable(false);
		tableOrders.getColumnModel().getColumn(3).setPreferredWidth(1);
		tableOrders.getColumnModel().getColumn(3).setMinWidth(0);
		tableOrders.getColumnModel().getColumn(3).setMaxWidth(1);*/
		tableOrders.setSelectionBackground(new Color(204, 204, 255));
		tableOrders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableOrders.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		//TODO FIN TABLE A EXPORTER DANS UN EAUTRE VUE
		scrollPane.setViewportView(tableOrders);
		
		JLabel lblChooseACustomer = new JLabel("Choose a customer");
		lblChooseACustomer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChooseACustomer.setForeground(new Color(51, 51, 51));
		lblChooseACustomer.setFont(fontLabel );
		lblChooseACustomer.setBounds(41, 42, 140, 39);
		this.add(lblChooseACustomer);
		
		JPanel panelStatistics = new JPanel();
		panelStatistics.setBorder(new TitledBorder(null, "Statistics", TitledBorder.LEADING, TitledBorder.TOP, null, darkBlack ));
		panelStatistics.setBackground(new Color(255, 255, 255));
		panelStatistics.setForeground(darkBlack);
		panelStatistics.setBounds(396, 116, 206, 255);
		this.add(panelStatistics);
		panelStatistics.setLayout(null);
		
		JLabel lblAnalysedSamples = new JLabel("Analysed Samples");
		lblAnalysedSamples.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnalysedSamples.setForeground(darkBlack);
		lblAnalysedSamples.setBounds(10, 38, 159, 34);
		panelStatistics.add(lblAnalysedSamples);
		
		lblPercentageAnalysedSamples = new JLabel("NA");
		lblPercentageAnalysedSamples.setBounds(164, 38, 32, 34);
		lblPercentageAnalysedSamples.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentageAnalysedSamples.setForeground(blueBootstrap);
		panelStatistics.add(lblPercentageAnalysedSamples);
		
		JLabel lblNonAnalysedSamples = new JLabel("Not Analysed Samples");
		lblNonAnalysedSamples.setBounds(10, 110, 159, 34);
		lblNonAnalysedSamples.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNonAnalysedSamples.setForeground(darkBlack);
		panelStatistics.add(lblNonAnalysedSamples);
		
		JLabel lblTotalSamples = new JLabel("Total");
		lblTotalSamples.setBounds(10, 182, 159, 34);
		lblTotalSamples.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalSamples.setForeground(darkBlack);
		panelStatistics.add(lblTotalSamples);
		
		lblPercentageNotAnalysedSamples = new JLabel("NA");
		lblPercentageNotAnalysedSamples.setBounds(164, 182, 32, 34);
		lblPercentageNotAnalysedSamples.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentageNotAnalysedSamples.setForeground(blueBootstrap);
		panelStatistics.add(lblPercentageNotAnalysedSamples);
		
		lblTotalOfSamples = new JLabel("NA");
		lblTotalOfSamples.setForeground(blueBootstrap);
		lblTotalOfSamples.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalOfSamples.setBounds(164, 110, 32, 34);
		panelStatistics.add(lblTotalOfSamples);
		
	}

	public void refresh(){
		modelCustomer.refresh();
		modelJtable.refresh(selectedCustomer);
	}
}
