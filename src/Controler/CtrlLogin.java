package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Main;
import View.Login;

public class CtrlLogin implements MouseListener {

    private Main main;
    private Login login;
    
	public CtrlLogin(Main pmain, Login plogin) {
		main = pmain;
		login = plogin;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String id = login.getTextFieldUser().getText();
		String pwd = login.getTextFieldPwd().getText();
		System.out.println(id);
		System.out.println(pwd);
		//main.loginUser(id.toString(), pwd.toString());
		main.loginUser("Magalie", "123");
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
