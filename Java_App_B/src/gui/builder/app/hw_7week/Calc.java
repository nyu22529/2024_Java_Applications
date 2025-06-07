package gui.builder.app.hw_7week;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calc {

	private JFrame frame;
	private JTextField tfNum;
	
	private double num1 = 0;
	private double num2 = 0;
	private String op = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
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
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfNum = new JTextField();
		tfNum.setBounds(0, 0, 584, 30);
		tfNum.setFont(new Font("굴림", Font.PLAIN, 20));
		tfNum.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(tfNum);
		tfNum.setColumns(10);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "1");
			}
		});
		btnNewButton.setBounds(0, 30, 97, 180);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("=");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num2 = Double.parseDouble(tfNum.getText());
				double result = 0;
				if(op.equals("+")) {
					result = num1 + num2;
				} else if(op.equals("-")) {
					result = num1 - num2;
				} else if(op.equals("*")) {
					result = num1 * num2;
				} else if(op.equals("/")) {
					result = num1 / num2;
				} else {
					JOptionPane.showMessageDialog(frame, "잘못된 연산입니다.");
				}
				
				tfNum.setText(result + "");
				op = null;
			}
		});
		btnNewButton_1.setBounds(0, 388, 584, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(97, 30, 390, 358);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "2");
			}
		});
		btnNewButton_3.setBounds(487, 30, 97, 180);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DEL");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText("");
			}
		});
		btnNewButton_4.setBounds(0, 220, 97, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("C");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tfNum.getText();
				tfNum.setText(str.substring(0, str.length()-1));
			}
		});
		btnNewButton_5.setBounds(0, 253, 97, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("+");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(tfNum.getText());
				tfNum.setText("");
				op = "+";
			}
		});
		btnNewButton_6.setBounds(487, 220, 97, 23);
		frame.getContentPane().add(btnNewButton_6);
	}
}
