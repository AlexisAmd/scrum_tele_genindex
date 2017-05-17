package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Main; 
import Model.SpecieCategory;
import View.LayeredPaneSpecie;
import View.MainFrame; 
 
public class CtrlCreateSpecie implements MouseListener { 
 
  private Main main; 
  private LayeredPaneSpecie mainFrame; 
  private SpecieCategory selectedCategory; 
 
   
  public CtrlCreateSpecie(Main pmain, LayeredPaneSpecie layeredPaneSpecie) { 
    main = pmain; 
    mainFrame = layeredPaneSpecie; 
    
  }

	@Override
	public void mouseClicked(MouseEvent e) {
		SpecieCategory selectedCategory = null; 
		
		//on recuprere l'object associé a la string (
		for (SpecieCategory sc : main.getTheCategories()){
			if(sc.getName().equals(mainFrame.getSelectedCategory())){
				selectedCategory =   sc;
			};
		}
		
		//on demande a une methode du main d'ajouter la specie
	    main.createSpecie(mainFrame.getTextFieldSpecieName(), selectedCategory); 	
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} 

}