package gui.builder.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class JTextFieldJTextArea {

	private JFrame frmMyChat;
	private JTextField tfInput;
	private JTextArea ta;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextFieldJTextArea window = new JTextFieldJTextArea();
					window.frmMyChat.setLocationRelativeTo(null);
					window.frmMyChat.setVisible(true);
					window.tfInput.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JTextFieldJTextArea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyChat = new JFrame();
		frmMyChat.setBounds(100, 100, 450, 300);
		frmMyChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyChat.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 412, 206);
		frmMyChat.getContentPane().add(scrollPane);
		
		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		
		tfInput = new JTextField();
		tfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = tfInput.getText();
				ta.append(msg + "\n");
				tfInput.setText("");
				tfInput.requestFocus();
			}
		});
		tfInput.setBounds(22, 226, 298, 29);
		frmMyChat.getContentPane().add(tfInput);
		tfInput.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = tfInput.getText();
				ta.append(msg + "\n");
				tfInput.setText("");
				tfInput.requestFocus();
			}
		});
		btnSend.setBounds(333, 226, 91, 23);
		frmMyChat.getContentPane().add(btnSend);
		
		
	}
}
