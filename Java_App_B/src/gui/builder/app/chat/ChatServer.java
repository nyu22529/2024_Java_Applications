package gui.builder.app.chat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class ChatServer {

	private JFrame frmChatServer;
	private JTextField tfInput;
	private JTextArea taChat;
	private String inMsg;
	private BufferedWriter out;
	
	public JFrame getFrame() {
		return frmChatServer;
	}
	
	public JTextField getTfInput() {
		return tfInput;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatServer chatServer = new ChatServer();
					chatServer.frmChatServer.setVisible(true);
					new Thread(() -> chatServer.runServer()).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param title 
	 * @param myEditor 
	 */
	public ChatServer() {		
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChatServer = new JFrame();
		frmChatServer.setTitle("Chat Server");
		frmChatServer.setBounds(100, 100, 450, 507);
		frmChatServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		frmChatServer.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Chat Server");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 255));
		frmChatServer.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tfInput = new JTextField();
		tfInput.setFont(new Font("굴림", Font.PLAIN, 14));
		tfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeMsg();
			}

			
		});
		panel_1.add(tfInput);
		tfInput.setColumns(25);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeMsg();			
			}
		});
		
		
		panel_1.add(btnSend);
		
		taChat = new JTextArea();
		taChat.setFont(new Font("Monospaced", Font.PLAIN, 16));
		taChat.setEditable(false);
		taChat.setLineWrap(true);
		
		JScrollPane sp = new JScrollPane(taChat);
		
		frmChatServer.getContentPane().add(sp, BorderLayout.CENTER);
	}
	
	public void runServer() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9999);
			taChat.append("서버가 시작되었습니다.\n");
			
			Socket socket = server.accept();
			taChat.append("클라이언트가 접속했습니다.\n");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String isMsg = null;
			while(true) {
				inMsg = in.readLine();
				taChat.append("[클라이언트] : " + inMsg + "\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void typeMsg() {
		try {
			String outMsg = tfInput.getText();
			out.write(outMsg + "\n");
			out.flush();
			taChat.append("[서버] : " + outMsg + "\n");
			tfInput.setText("");
			tfInput.requestFocus();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}