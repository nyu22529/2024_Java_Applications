package gui.basic;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener, MouseListener {
	
	private JButton btn;

	public MyFrame() {
		setTitle("나의 첫번째 프레임");
		this.setSize(300, 300);
//		this.setLocation(300, 300);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * setLayout(new FlowLayout()); JButton btn = new JButton("버튼"); add(btn);
		 * 
		 * setVisible(true);
		 */
		
		btn = new JButton("버튼");
		btn.addActionListener(this);
		btn.addMouseListener(this);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(btn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setText("!!!");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		btn.setBackground(Color.YELLOW);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
