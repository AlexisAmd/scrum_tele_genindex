package View;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataListener;

import Main.Main;
import Model.Customer;
import Model.SpecieCategory;

public class ModelListCustomer extends DefaultComboBoxModel {

	private Main main;
	
	public ModelListCustomer(Main pmain) {
		main = pmain;
		for(Customer c : main.getTheCustomers()) {
			this.addElement(c.getName());
		}
	}

}
