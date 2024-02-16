package com.railway.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class inscreption extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscreption frame = new inscreption();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public inscreption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel right = new JPanel();
		right.setBounds(462, 0, 481, 479);
		right.setLayout(null);
		right.setBackground(Color.WHITE);
		contentPane.add(right);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(47, 309, 353, 39);
		right.add(textField);
		
		JTextArea txtrSignUp = new JTextArea();
		txtrSignUp.setText("SIGN UP");
		txtrSignUp.setForeground(new Color(255, 128, 0));
		txtrSignUp.setFont(new Font("Monospaced", Font.BOLD, 33));
		txtrSignUp.setBounds(269, 0, 154, 51);
		right.add(txtrSignUp);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("EMAIL");
		txtrEmail.setBounds(25, 138, 73, 22);
		right.add(txtrEmail);
		
		JTextArea txtrPasseword = new JTextArea();
		txtrPasseword.setText("PasseWord");
		txtrPasseword.setBounds(25, 228, 73, 22);
		right.add(txtrPasseword);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(47, 177, 359, 39);
		right.add(textField_1);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setForeground(new Color(255, 153, 153));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSignUp.setBackground(new Color(255, 128, 0));
		btnSignUp.setBounds(168, 358, 131, 39);
		right.add(btnSignUp);
		
		JTextArea txtrIHaveA = new JTextArea();
		txtrIHaveA.setText("I have a compte");
		txtrIHaveA.setBounds(52, 419, 186, 22);
		right.add(txtrIHaveA);
		
		JButton btnNewButton_1 = new JButton("Log in");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log frame = new log();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(309, 421, 85, 21);
		right.add(btnNewButton_1);
		
		JTextArea txtrFullName = new JTextArea();
		txtrFullName.setText("FULL NAME");
		txtrFullName.setBounds(25, 50, 73, 22);
		right.add(txtrFullName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(41, 89, 359, 39);
		right.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(47, 260, 353, 39);
		right.add(textField_3);
		
		JPanel left = new JPanel();
		left.setLayout(null);
		left.setBackground(new Color(255, 128, 64));
		left.setBounds(-11, 0, 462, 479);
		contentPane.add(left);
		
		JTextArea txtrLavenirSeLit = new JTextArea();
		txtrLavenirSeLit.setText("L'avenir se lit sur nos lignes");
		txtrLavenirSeLit.setForeground(Color.WHITE);
		txtrLavenirSeLit.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtrLavenirSeLit.setBackground(new Color(255, 128, 0));
		txtrLavenirSeLit.setBounds(68, 244, 321, 27);
		left.add(txtrLavenirSeLit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\othma\\Desktop\\icon1.jpg"));
		label.setBounds(35, 50, 417, 161);
		left.add(label);
	}
}
