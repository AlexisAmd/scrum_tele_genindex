package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controler.CtrlLogin;
import Main.Main;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param main 
	 */
	public Login(Main main) {
		setTitle("Genindex - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 272);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 354, 38);
		panelTitle.setBackground(new Color(144, 238, 144));
		contentPane.add(panelTitle);
		panelTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTitle = new JLabel("  LOGIN");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBackground(new Color(144, 238, 144));
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 17));
		panelTitle.add(lblTitle);
		
		JPanel panelForm = new JPanel();
		panelForm.setBounds(8, 45, 338, 117);
		panelForm.setBackground(Color.WHITE);
		contentPane.add(panelForm);
		panelForm.setLayout(new BorderLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(Color.WHITE);
		panelForm.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(null);
		
		JTextField textFieldUser = new JTextField();
		textFieldUser.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldUser.setToolTipText("Type your username here");
		textFieldUser.setText("User");
		textFieldUser.setBackground(SystemColor.inactiveCaptionBorder);
		textFieldUser.setBounds(0, 11, 338, 41);
		panelContent.add(textFieldUser);
		
		JTextField textFieldPwd = new JTextField();
		textFieldPwd.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldPwd.setToolTipText("Type your password here");
		textFieldPwd.setText("Password");
		textFieldPwd.setBackground(SystemColor.inactiveCaptionBorder);
		textFieldPwd.setBounds(0, 63, 338, 41);
		panelContent.add(textFieldPwd);
		
		JPanel panelSubmit = new JPanel();
		panelSubmit.setBounds(8, 169, 338, 57);
		panelSubmit.setBackground(new Color(255, 255, 255));
		contentPane.add(panelSubmit);
		panelSubmit.setLayout(new BorderLayout(0, 0));
		
		JButton btnSubmit =  new JButton();
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 24));
		btnSubmit.setBackground(new Color(144, 238, 144));
		btnSubmit.setText("Submit");
		btnSubmit.addMouseListener(new CtrlLogin(main, "Magalie", "123"));
		panelSubmit.add(btnSubmit, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}

}
