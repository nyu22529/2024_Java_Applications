package gui.builder.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseKeyEvent {

	private JFrame frame;
	private JLabel lblName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouseKeyEvent window = new MouseKeyEvent();
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
	public MouseKeyEvent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				//System.out.println(x + ", " + y);
				lblName.setLocation(x, y);
			}
		});
		frame.setTitle("마우스 키보드 이벤트");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblName = new JLabel("홍길동");
		lblName.setFont(new Font("굴림", Font.BOLD, 20));
		lblName.setBounds(80, 60, 65, 30);
		/*
		 * lblName.setLocation(80, 60); lblName.setSize(65, 30);
		 */
		frame.getContentPane().add(lblName);
	}
}
