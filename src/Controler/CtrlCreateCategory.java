package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Main;
import View.MainFrame;

public class CtrlCreateCategory implements MouseListener {

	private Main main;
	private MainFrame mainFrame;
	
	public CtrlCreateCategory(Main pmain, MainFrame pmainFrame) {
		main = pmain;
		mainFrame = pmainFrame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		main.createCategory(mainFrame.getTextFieldCategoryName().getText());
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
