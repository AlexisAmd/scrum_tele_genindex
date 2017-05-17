package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Main.Main;
import View.MainFrame;

public class CtrlCreateScapieTest implements MouseListener {
	
	private Main main;
	private MainFrame mainFrame;
	
	public CtrlCreateScapieTest(Main pmain, MainFrame pmainFrame) {
		main = pmain;
		mainFrame = pmainFrame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			// main.createScrapieText(pspecie, mainFrame.getTextFieldPeakPosition().getText(), mainFrame.getTextFieldPeakValue().getText());
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "The input is not a number !");
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
