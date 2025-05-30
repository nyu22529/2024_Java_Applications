package gui.builder.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleCalc {

	private JFrame frame;
	private JTextField tfX;
	private JTextField tfY;
	private JTextField tfResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc window = new SimpleCalc();
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
	public SimpleCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("간단한 계산기");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X = ");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(26, 45, 50, 15);
		frame.getContentPane().add(lblNewLabel);
		
		tfX = new JTextField();
		tfX.setFont(new Font("굴림", Font.BOLD, 20));
		tfX.setHorizontalAlignment(SwingConstants.CENTER);
		tfX.setBounds(104, 42, 96, 21);
		frame.getContentPane().add(tfX);
		tfX.setColumns(10);
		
		JLabel lblY = new JLabel("Y = ");
		lblY.setFont(new Font("굴림", Font.BOLD, 20));
		lblY.setBounds(228, 45, 50, 15);
		frame.getContentPane().add(lblY);
		
		tfY = new JTextField();
		tfY.setFont(new Font("굴림", Font.BOLD, 20));
		tfY.setHorizontalAlignment(SwingConstants.CENTER);
		tfY.setColumns(10);
		tfY.setBounds(306, 42, 96, 21);
		frame.getContentPane().add(tfY);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(tfX.getText());
				int y = Integer.parseInt(tfY.getText());
				int result = x + y;
				tfResult.setText(result + "");
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(71, 70, 50, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(tfX.getText());
				int y = Integer.parseInt(tfY.getText());
				int result = x - y;
				tfResult.setText(result + "");
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1.setBounds(192, 70, 50, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("C");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfX.setText("");
				tfY.setText("");
				tfResult.setText("");
			}
		});
		btnNewButton_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(313, 70, 50, 39);
		frame.getContentPane().add(btnNewButton_1_1);
		
		tfResult = new JTextField();
		tfResult.setFont(new Font("굴림", Font.BOLD, 20));
		tfResult.setHorizontalAlignment(SwingConstants.CENTER);
		tfResult.setColumns(10);
		tfResult.setBounds(218, 122, 96, 34);
		frame.getContentPane().add(tfResult);
		
		JLabel lblResult = new JLabel("Result =");
		lblResult.setFont(new Font("굴림", Font.BOLD, 20));
		lblResult.setBounds(109, 124, 81, 31);
		frame.getContentPane().add(lblResult);
	}
}
