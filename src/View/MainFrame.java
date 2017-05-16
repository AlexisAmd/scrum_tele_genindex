package View;

import javax.swing.JFrame;

import Main.Main;

public class MainFrame {

	private JFrame frame;
	private Main main;

	/**
	 * Create the application.
	 */
	public MainFrame(Main pmain) {
		main = pmain;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
