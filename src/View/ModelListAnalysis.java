package View;

import javax.swing.DefaultComboBoxModel;

import Main.Main;
import Model.Analysis;
import Model.SpecieCategory;

public class ModelListAnalysis extends DefaultComboBoxModel {

	private Main main;
	
	public ModelListAnalysis(Main pmain) {
		main = pmain;
		refresh();
	}

	protected void refresh() {
		this.addElement("Sexing test");
		this.addElement("Scrapie test");
	}
	
}
