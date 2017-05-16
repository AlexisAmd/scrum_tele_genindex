package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Main;
import View.MainFrame;

public class CtrlAddCustomer implements MouseListener {

	private Main main;
	private MainFrame mainFrame;
	
	public CtrlAddCustomer(Main pmain, MainFrame pmainFrame) {
		main = pmain;
		mainFrame = pmainFrame;
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
