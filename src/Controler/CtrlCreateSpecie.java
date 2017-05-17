package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Main;
import View.MainFrame;

public class CtrlCreateSpecie implements MouseListener {

	private Main main;
	private MainFrame mainFrame;
	
	public CtrlCreateSpecie(Main pmain, MainFrame pmainFrame) {
		main = pmain;
		mainFrame = pmainFrame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// main.createSpecie(mainFrame.getTextFieldSpecieName().getText(), "A COMPLETER");
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
