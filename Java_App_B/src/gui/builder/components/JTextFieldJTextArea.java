package gui.builder.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;

public class JTextFieldJTextArea {

	private JFrame frmMyChat;
	private JTextField tfInput;
	private JTextArea ta;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

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
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 10, 412, 122);
		frmMyChat.getContentPane().add(scrollPane);
		
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setLineWrap(true);
		scrollPane.setViewportView(ta);
		
		tfInput = new JTextField();
		tfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		tfInput.setBounds(15, 143, 298, 29);
		frmMyChat.getContentPane().add(tfInput);
		tfInput.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		btnSend.setBounds(328, 143, 91, 23);
		frmMyChat.getContentPane().add(btnSend);
		
		rdbtnNewRadioButton = new JRadioButton("영희");
		rdbtnNewRadioButton.setBounds(111, 187, 55, 23);
		frmMyChat.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("철수");
		rdbtnNewRadioButton_1.setBounds(269, 187, 55, 23);
		frmMyChat.getContentPane().add(rdbtnNewRadioButton_1);
	}
	private void sendMsg() {
		String msg = tfInput.getText();
		ta.append("[클라이언트] : " + msg + "\n");
		tfInput.setText("");
		tfInput.requestFocus();
	}
}
