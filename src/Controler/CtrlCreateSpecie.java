package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Main;
import Model.SpecieCategory;
import View.MainFrame;

public class CtrlCreateSpecie implements MouseListener {

	private Main main;
	private MainFrame mainFrame;
	private SpecieCategory selectedCategory;

	
	public CtrlCreateSpecie(Main pmain, MainFrame pmainFrame, SpecieCategory pSelectedCategory) {
		main = pmain;
		mainFrame = pmainFrame;
		selectedCategory = pSelectedCategory;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		main.createSpecie(mainFrame.getTextFieldSpecieName().getText(), selectedCategory);
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
