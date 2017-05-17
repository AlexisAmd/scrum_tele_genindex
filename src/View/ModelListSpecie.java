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

/**
 * @author pc
 *
 */
public class ModelListSpecie extends DefaultComboBoxModel {

	private Main main;

	public ModelListSpecie(Main pmain) {
		main = pmain;
		refresh();
		
	}

protected void refresh(){
	this.removeAllElements();// peut etre inutile
	for(SpecieCategory sC : main.getTheCategories()) { // Pour chaque catégorie
		for(Specie s : sC.getSpecies()) { // Pour chaque espèce de la catégorie
			this.addElement(s.getName());
		}
	}
}
}
