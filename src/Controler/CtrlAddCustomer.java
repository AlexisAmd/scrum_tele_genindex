package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Main;
import View.LayeredPaneCustomer;
import View.MainFrame;

public class CtrlAddCustomer implements MouseListener {

	private Main main;
	private LayeredPaneCustomer mainFrame;
	
	public CtrlAddCustomer(Main pmain, LayeredPaneCustomer layeredPaneCustomer) {
		main = pmain;
		mainFrame = layeredPaneCustomer;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		main.createCustomer(mainFrame.getTextFieldCompany().getText(), mainFrame.getTextFieldTown().getText());
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
