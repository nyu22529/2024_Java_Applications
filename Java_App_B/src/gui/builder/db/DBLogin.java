package gui.builder.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.builder.app.SimpleCalc;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DBLogin {

	private JFrame frame;
	private JTextField tfID;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JPasswordField pw;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBLogin window = new DBLogin();
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
	public DBLogin() {
		initialize();
		conn = DB.init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(201, 84, 57, 15);
		frame.getContentPane().add(lblNewLabel);

		tfID = new JTextField();
		tfID.setBounds(272, 81, 116, 21);
		frame.getContentPane().add(tfID);
		tfID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("pw");
		lblNewLabel_1.setBounds(201, 112, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);

		btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * String sql = "SELECT * FROM student_info WHERE name='" + id +
				 * "' AND password = '1234'";
				 */
				 try {
					 String sql = "SELECT * FROM student_info WHERE name=? AND password =?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tfID.getText());
					pstmt.setString(2, pw.getText());
					
					ResultSet rs = pstmt.executeQuery();
					
					if(rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString("name");
						
						System.out.println(id + " - " + name);
						JOptionPane.showMessageDialog(frame, "아이디와 패스워드가 일치합니다.");
						
						SimpleCalc calc = new SimpleCalc();
						calc.getFrame().setLocationRelativeTo(null);
						calc.getFrame().setVisible(true);
						
						frame.setVisible(false);
						
					} else {
						JOptionPane.showMessageDialog(frame, "아이디와 패스워드가 일치하지 않습니다.");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				 
				
			}
		});
		btnNewButton.setBounds(272, 140, 97, 23);
		frame.getContentPane().add(btnNewButton);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DBLogin.class.getResource("/gui/builder/images/logo.png")));
		lblNewLabel_2.setBounds(51, 81, 90, 90);
		frame.getContentPane().add(lblNewLabel_2);

		pw = new JPasswordField();
		pw.setBounds(272, 112, 116, 21);
		frame.getContentPane().add(pw);
	}
}
