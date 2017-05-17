package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Main.Main;
import Model.Analysis;
import Model.Customer;
import Model.Specie;
import Model.SpecieCategory;
import View.LayeredPaneOrder;
import View.MainFrame;

public class CtrlCreateOrder implements MouseListener {

	private Main main;
	private LayeredPaneOrder mainFrame;
	
	public CtrlCreateOrder(Main pmain, LayeredPaneOrder layeredPaneOrder) {
		mainFrame = layeredPaneOrder;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		Customer selectedCustomer = null; 
		for (Customer c : main.getTheCustomers()){
			if(c.getName().equals(mainFrame.getSelectedCustomer())){
				selectedCustomer =   c;
			}
		}
		
		Specie selectedSpecie = null; 
		for (SpecieCategory sc : main.getTheCategories()){
			for(Specie s : sc.getSpecies()) {
				if(s.getName().equals(mainFrame.getSelectedSpecie())){
					selectedSpecie =   s;
				}
			}
		}
		
		Analysis selectedAnalysis = null; 
		for (Analysis a : main.getTheAnalyses()){
			if(a.getName().equals(mainFrame.getSelectedAnalysis())){
				selectedAnalysis =   a;
			}
		}
		
		int numberOfSamples = Integer.parseInt(mainFrame.getTextFieldNumberOfSamples().getText());
		
		main.createOrder(selectedCustomer, selectedSpecie, selectedAnalysis, numberOfSamples);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
