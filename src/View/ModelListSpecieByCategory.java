/**
 * 
 */
package View;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataListener;

import Main.Main;
import Model.Customer;
import Model.Specie;
import Model.SpecieCategory;

public class ModelListSpecieByCategory extends DefaultComboBoxModel {

	private Main main;
	private SpecieCategory sC;

	public ModelListSpecieByCategory(Main pmain, String psC) {
		
		main = pmain;

		for (SpecieCategory sc : main.getTheCategories()){
			if(sc.getName().equals(psC)){
				sC =   sc;
			}
		}
		
		refresh();
		
	}

	protected void refresh(){
		this.removeAllElements();// peut etre inutile
		for(Specie s : sC.getSpecies()) { // Pour chaque espèce de la catégorie
			this.addElement(s.getName());
		}
	}

	/**
	 * @param sC the sC to set
	 */
	public void setsC(String psC) {
		for (SpecieCategory sc : main.getTheCategories()){
			if(sc.getName().equals(psC)){
				this.sC =   sc;
			}
		}
	}
	
}

