package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Main.Main;
import Model.Specie;
import Model.SpecieCategory;
import View.LayeredPaneScrapieTest;
import View.MainFrame;

public class CtrlCreateScrapieTest implements MouseListener {
	
	private Main main;
	private LayeredPaneScrapieTest mainFrame;
	
	public CtrlCreateScrapieTest(Main pmain, LayeredPaneScrapieTest layeredPaneScrapieTest) {
		main = pmain;
		mainFrame = layeredPaneScrapieTest;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Specie selectedSpecie = null; 
		//on recuprere l'object associé a la string (
		for (SpecieCategory sc : main.getTheCategories()){
			for(Specie s : sc.getSpecies()) {
				if(s.getName().equals(mainFrame.getSelectedSpecie())) {
					selectedSpecie = s;
				}
			}
		}
		
		try {
			main.createScrapieText(selectedSpecie, Integer.parseInt(mainFrame.getTextFieldPosition().getText()), Integer.parseInt(mainFrame.getTextFieldValue().getText()));
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "The input is not a number !", "Value error", JOptionPane.ERROR_MESSAGE);
		}
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
