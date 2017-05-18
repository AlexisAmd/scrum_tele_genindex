package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import Model.*;
import Main.*;

public class CtrlDisplayOrders implements ActionListener {
	private DefaultTableModel model;
	private JComboBox combo;
	private Main main;
	
	public CtrlDisplayOrders(DefaultTableModel newModel,JComboBox newCombo,Main newMain){
		model = newModel;
		combo = newCombo;
		main = newMain;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Customer c = null;
		int i = 0;
		
		// Get the right customer
		for(Customer cus : main.getTheCustomers()) {
			if (cus.getName() == combo.getSelectedItem()){
				c = cus;
			}
		}
		//reset JTable
		for (int j = 0;j<model.getRowCount();j++){
			model.setValueAt(null, j, 0);
			model.setValueAt(null, j, 1);
			model.setValueAt(null, j, 2);
		};
		
		// updating JTable
		if (!c.getOrders().isEmpty()){
			for (Order o : c.getOrders()){
				model.insertRow(i, new Object[]{i+1,o.getSamples().size(),o.getStatus()});
				i++;
			}
		}
	}
}


