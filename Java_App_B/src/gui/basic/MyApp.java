package gui.basic;

import javax.swing.JFrame;

public class MyApp {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("AAA");
		frame.setSize(300, 300);
//		frame.setLocation(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}