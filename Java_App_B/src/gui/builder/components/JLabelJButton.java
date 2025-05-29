package gui.builder.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JLabelJButton {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLabelJButton window = new JLabelJButton();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JLabelJButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("레이블, 버튼 그리고 이미지");
		frame.setBounds(100, 100, 420, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Java 프로그램 응용");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 380, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(JLabelJButton.class.getResource("/gui/builder/images/beauty.jpg")));
		lblNewLabel_1.setBounds(15, 50, 400, 400);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnCall = new JButton("Call Me");
		btnCall.setIcon(new ImageIcon(JLabelJButton.class.getResource("/gui/builder/images/normalIcon.gif")));
		btnCall.setPressedIcon(new ImageIcon(JLabelJButton.class.getResource("/gui/builder/images/pressedIcon.gif")));
		btnCall.setRolloverIcon(new ImageIcon(JLabelJButton.class.getResource("/gui/builder/images/rolloverIcon.gif")));
		btnCall.setBounds(80, 450, 250, 80);
		frame.getContentPane().add(btnCall);
	}
}
