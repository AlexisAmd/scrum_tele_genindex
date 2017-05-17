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
	for(SpecieCategory sC : main.getTheCategories()) { // Pour chaque cat�gorie
		for(Specie s : sC.getSpecies()) { // Pour chaque esp�ce de la cat�gorie
			this.addElement(s.getName());
		}
	}
}
}
