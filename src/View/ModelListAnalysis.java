package View;

import javax.swing.DefaultComboBoxModel;

import Main.Main;
import Model.Analysis;
import Model.ScrapieTest;
import Model.SexingTest;
import Model.Specie;
import Model.SpecieCategory;

public class ModelListAnalysis extends DefaultComboBoxModel {

	private Main main;
	private Specie sP;
	
	public ModelListAnalysis(Main pmain, String pS) {
		main = pmain;
		for (SpecieCategory sc : main.getTheCategories()){
			for(Specie s : sc.getSpecies()) {
				if(s.getName().equals(pS)){
					sP = s;
				}
			}
		}
		refresh();
	}

	protected void refresh() {
		this.removeAllElements();
		for(Analysis a : main.getTheAnalyses()) {
			if(a instanceof SexingTest && a.getSpecie().equals(sP)) {
				this.addElement(a.getName() + " | Male value : " + ((SexingTest) a).getMaleValue().getValue() + " - Female value : " + ((SexingTest) a).getFemaleValue().getValue());
				
			} else if(a instanceof ScrapieTest && a.getSpecie().equals(sP)){
				this.addElement(a.getName() + " | Peak position : " + ((ScrapieTest) a).getScrapieSensibility().getPosition() + " - Peak value : " + ((ScrapieTest) a).getScrapieSensibility().getValue() );
			}
		}
		
	}

	public void setS(String pS) {
		for (SpecieCategory sc : main.getTheCategories()){
			for(Specie s : sc.getSpecies()) {
				if(s.getName().equals(pS)){
					sP = s;
				}
			}
		}
	}
	
}
