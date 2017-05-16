package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Main;

public class CtrlLogin implements MouseListener {

    private Main main;
    private String id;
    private String password;
    
	public CtrlLogin(Main pmain, String pid, String ppassword) {
		main = pmain;
		id = pid;
		password = ppassword;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		main.loginUser(id, password);
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
