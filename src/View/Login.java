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
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUser;
	private JTextField textFieldPwd;

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
		panelTitle.setBackground(Color.WHITE);
		contentPane.add(panelTitle);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel(" Connect to your account");
		lblTitle.setForeground(new Color(51, 51, 51));
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelTitle.add(lblTitle, BorderLayout.CENTER);
		
		JPanel panelForm = new JPanel();
		panelForm.setBounds(36, 53, 284, 109);
		panelForm.setBackground(Color.WHITE);
		contentPane.add(panelForm);
		panelForm.setLayout(new BorderLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(Color.WHITE);
		panelForm.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(null);
		
		textFieldUser = new JTextField();
		textFieldUser.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldUser.setToolTipText("Type your username here");
		textFieldUser.setText("User");
		textFieldUser.setBackground(SystemColor.inactiveCaptionBorder);
		textFieldUser.setBounds(0, 11, 283, 41);
		panelContent.add(textFieldUser);
		
		textFieldPwd = new JTextField();
		textFieldPwd.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldPwd.setToolTipText("Type your password here");
		textFieldPwd.setText("Password");
		textFieldPwd.setBackground(SystemColor.inactiveCaptionBorder);
		textFieldPwd.setBounds(0, 52, 283, 41);
		panelContent.add(textFieldPwd);
		
		JPanel panelSubmit = new JPanel();
		panelSubmit.setBounds(36, 162, 284, 47);
		panelSubmit.setBackground(new Color(255, 255, 255));
		contentPane.add(panelSubmit);
		panelSubmit.setLayout(new BorderLayout(0, 0));
		
		JButton btnSubmit =  new JButton();
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSubmit.setBackground(new Color(66,139,202));
		btnSubmit.setText("Submit");
		btnSubmit.addMouseListener(new CtrlLogin(main, this));
		panelSubmit.add(btnSubmit, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}

	/**
	 * @return the textFieldUser
	 */
	public JTextField getTextFieldUser() {
		return textFieldUser;
	}

	/**
	 * @return the textFieldPwd
	 */
	public JTextField getTextFieldPwd() {
		return textFieldPwd;
	}
	public void showErrorBox() {
		JOptionPane.showMessageDialog(new JFrame(), "Mauvais couple ID / Mot de passe.");
	}
}
