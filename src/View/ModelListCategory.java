package View;

import javax.swing.DefaultComboBoxModel;

import Main.Main;
import Model.SpecieCategory;

public class ModelListCategory extends DefaultComboBoxModel {

	private Main main;
	
	public ModelListCategory(Main pmain) {
		main = pmain;
		for(SpecieCategory sC : main.getTheCategories()) {
			this.addElement(sC);
		}
	}
	
}
