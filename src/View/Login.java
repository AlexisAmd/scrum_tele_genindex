package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Genindex - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTitle = new JPanel();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Connection \u00E0 GenIndex");
		panelTitle.add(lblTitle);
		
		JPanel panelForm = new JPanel();
		contentPane.add(panelForm, BorderLayout.CENTER);
		panelForm.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTags = new JPanel();
		panelForm.add(panelTags, BorderLayout.WEST);
		panelTags.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblUser = new JLabel("User");
		panelTags.add(lblUser);
		
		JLabel lblPwd = new JLabel("Password");
		panelTags.add(lblPwd);
		
		JPanel panelContent = new JPanel();
		panelForm.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		panelContent.add(lblNewLabel);
	}

}
