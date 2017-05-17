package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Main;
import View.LayeredPaneSpecie;
import View.MainFrame;

public class CtrlCreateCategory implements MouseListener {

	private Main main;
	private MainFrame mainFrame;
	
	public CtrlCreateCategory(Main pmain, MainFrame mainFrame2) {
		main = pmain;
		mainFrame = mainFrame2;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		main.createCategory(mainFrame.getTextFieldCategoryName().getText());
		
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
