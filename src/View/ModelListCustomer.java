package View;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import Main.Main;

public class ModelListCustomer implements ComboBoxModel {

	private Main main;
	
	public ModelListCustomer(Main pmain) {
		main = pmain;
		for(Customer c : main.getTheCustomers()) {
			this.addElement(c);
		}
	}

	public ModelListCustomer(Main main) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub

	}

}
