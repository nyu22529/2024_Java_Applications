package gui.basic;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("나의 첫번째 프레임");
		this.setSize(300, 300);
//		this.setLocation(300, 300);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JButton btn = new JButton("버튼");
		add(btn);
		
		setVisible(true);
	}
}
