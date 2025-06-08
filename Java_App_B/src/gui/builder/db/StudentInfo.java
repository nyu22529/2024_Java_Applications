package gui.builder.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentInfo {

	private JFrame frame;
	private JTable table;
	private JTextField tfID;
	private Connection conn;

	private final DefaultTableModel tableModel = new DefaultTableModel();
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfAge;
	private JTextField tfDept;
	private JTextField tfGrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo window = new StudentInfo();
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
	public StudentInfo() {
		conn = DB.init();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 635, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 43, 293, 316);
		frame.getContentPane().add(scrollPane);

		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();
					String id = table.getModel().getValueAt(row, 0).toString();

					String sql = "SELECT * FROM java_b.student_info where id = ?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						tfID.setText(rs.getString("id"));
						tfUsername.setText(rs.getString("name"));
						tfPassword.setText(rs.getString("password"));
						tfAge.setText(rs.getString("age"));
						tfDept.setText(rs.getString("dept"));
						tfGrade.setText(rs.getString("grade"));
					}
					
					pstmt.close();
					rs.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Load Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		btnNewButton.setBounds(510, 10, 97, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(401, 10, 97, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String sql = "INSERT INTO java_b.student_info " + "(name, password, age,dept, grade) "
							+ "VALUES(?, ?, ?, ?, ?);";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tfUsername.getText());
					pstmt.setString(2, tfPassword.getText());
					pstmt.setInt(3, Integer.parseInt(tfAge.getText()));
					pstmt.setString(4, tfDept.getText());
					pstmt.setString(5, tfGrade.getText());

					pstmt.execute();

					JOptionPane.showMessageDialog(frame, "Data Saved");

					pstmt.close();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				refreshTable();
			}
		});
		btnNewButton_2.setBounds(12, 270, 97, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBounds(12, 303, 97, 23);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.setBounds(12, 336, 97, 23);
		frame.getContentPane().add(btnNewButton_4);

		tfID = new JTextField();
		tfID.setEnabled(false);
		tfID.setBounds(186, 43, 116, 21);
		frame.getContentPane().add(tfID);
		tfID.setColumns(10);

		tfUsername = new JTextField();
		tfUsername.setBounds(186, 74, 116, 21);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);

		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(186, 105, 116, 21);
		frame.getContentPane().add(tfPassword);

		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(186, 136, 116, 21);
		frame.getContentPane().add(tfAge);

		tfDept = new JTextField();
		tfDept.setColumns(10);
		tfDept.setBounds(186, 167, 116, 21);
		frame.getContentPane().add(tfDept);

		tfGrade = new JTextField();
		tfGrade.setBounds(186, 198, 116, 21);
		frame.getContentPane().add(tfGrade);
		tfGrade.setColumns(10);

		refreshTable();
	}

	private void setTableFromDB(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();

		int cnt = metaData.getColumnCount();
		Vector<String> columnNames = new Vector<String>();

		for (int i = 1; i <= cnt; i++) {
			columnNames.add(metaData.getColumnName(i));
		}

		/*
		 * for (String column : columnNames) { System.out.println(column); }
		 */

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>();
			for (int i = 1; i <= cnt; i++) {
				row.add(rs.getObject(i));
			}
			data.add(row);
		}

		tableModel.setDataVector(data, columnNames);
	}

	private void refreshTable() {
		try {
			String sql = "SELECT * FROM student_info";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			setTableFromDB(rs);

			pstmt.close();
			rs.close();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
