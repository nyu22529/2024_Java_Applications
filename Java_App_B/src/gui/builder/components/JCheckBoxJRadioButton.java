package gui.builder.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class JCheckBoxJRadioButton {

	private JFrame frame;
	private int sum = 0;
	private JLabel lblResult;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckBoxJRadioButton window = new JCheckBoxJRadioButton();
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
	public JCheckBoxJRadioButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("체크박스와 라디오 버튼");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("사과 100원, 배 500원, 체리 1000원");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 410, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("사과");
		chckbxNewCheckBox.setBorderPainted(true);
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				int i = e.getStateChange();
				if(i == ItemEvent.SELECTED) {
					sum += 100;
				} else {
					sum -= 100;
				}
				lblResult.setText("현재 " + sum + "원입니다.");
			}
		});
		chckbxNewCheckBox.setBounds(28, 89, 107, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("배");
		chckbxNewCheckBox_1.setBorderPainted(true);
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i = e.getStateChange();
				if(i == ItemEvent.SELECTED) {
					sum += 500;
				} else {
					sum -= 500;
				}
				lblResult.setText("현재 " + sum + "원입니다.");
			}
		});
		chckbxNewCheckBox_1.setBounds(163, 89, 107, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("체리");
		chckbxNewCheckBox_2.setBorderPainted(true);
		chckbxNewCheckBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i = e.getStateChange();
				if(i == ItemEvent.SELECTED) {
					sum += 1000;
				} else {
					sum -= 1000;
				}
				lblResult.setText("현재 " + sum + "원입니다.");
			}
		});
		chckbxNewCheckBox_2.setBounds(298, 89, 107, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		lblResult = new JLabel("현재 0원입니다.");
		lblResult.setOpaque(true);
		lblResult.setBackground(new Color(255, 255, 0));
		lblResult.setForeground(new Color(255, 0, 0));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(10, 100, 410, 30);
		frame.getContentPane().add(lblResult);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("남자");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(70, 166, 113, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("여자");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(253, 166, 113, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("사과");
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setBounds(67, 211, 56, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("배");
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(190, 211, 56, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("체리");
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(313, 211, 56, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(JCheckBoxJRadioButton.class.getResource("/gui/builder/images/apple.jpg")));
		lblNewLabel_1.setBounds(174, 240, 88, 82);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
