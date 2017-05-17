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
	private SpecieCategory sC;

	public ModelListSpecie(Main pmain) {
		main = pmain;
		refresh();
		
	}
	
	public ModelListSpecie(Main pmain, String psC) {
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
		
		if(sC == null) { // On a pas de categorie en param donc on prend toutes les espèces
			for(SpecieCategory sC : main.getTheCategories()) { // Pour chaque catégorie
				for(Specie s : sC.getSpecies()) { // Pour chaque espèce de la catégorie
					this.addElement(s.getName());
				}
			}
		} else { // On a une catégorie alors on pioche dedans
			for(Specie s : sC.getSpecies()) { // Pour chaque espèce de la catégorie
				this.addElement(s.getName());
			}
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
