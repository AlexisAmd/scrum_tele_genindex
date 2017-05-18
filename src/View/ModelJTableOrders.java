package View;

import javax.swing.table.DefaultTableModel;

import Main.Main;
import Model.*;

public class ModelJTableOrders extends DefaultTableModel {

	private Main main;
	
	public ModelJTableOrders(Main pmain,Customer c) {
		main = pmain;
		this.setColumnIdentifiers(new String[] {
				"ID", "Sample Number","Status"
			});
		refresh(c);
	}

	protected void refresh(Customer c) {
		
		int i = 0;
		
		//reset JTable
		for (int j = 0;j<this.getRowCount();j++){
			this.setValueAt(null, j, 0);
			this.setValueAt(null, j, 1);
			this.setValueAt(null, j, 2);
		};
		
		// updating JTable
		if (!c.getOrders().isEmpty()){
			for (Order o : c.getOrders()){
				this.insertRow(i, new Object[]{i+1,o.getSamples().size(),o.getStatus()});
				i++;
			}
		}
		
	}
	
}
