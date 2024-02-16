package com.railway.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Panel;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class log extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField textField;
	private JPanel left;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log frame = new log();
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
	public log() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		left = new JPanel();
		left.setBackground(new Color(255, 128, 64));
		left.setBounds(0, 0, 434, 456);
		contentPane.add(left);
		left.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\othma\\Desktop\\icon1.jpg"));
		lblNewLabel.setBounds(10, 80, 404, 143);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		left.add(lblNewLabel);
		
		JTextArea txtrLavenirSeLit = new JTextArea();
		txtrLavenirSeLit.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtrLavenirSeLit.setForeground(new Color(255, 255, 255));
		txtrLavenirSeLit.setBackground(new Color(255, 128, 0));
		txtrLavenirSeLit.setText("L'avenir se lit sur nos lignes");
		txtrLavenirSeLit.setBounds(68, 244, 321, 27);
		left.add(txtrLavenirSeLit);
		
		JPanel right = new JPanel();
		right.setBackground(new Color(255, 255, 255));
		right.setBounds(433, 0, 447, 456);
		contentPane.add(right);
		right.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setBounds(41, 262, 353, 39);
		right.add(txtEmail);
		txtEmail.setColumns(10);
		
		JTextArea txtrLogIn = new JTextArea();
		txtrLogIn.setForeground(new Color(255, 128, 0));
		txtrLogIn.setFont(new Font("Monospaced", Font.BOLD, 33));
		txtrLogIn.setText("LOG IN");
		txtrLogIn.setBounds(155, 49, 137, 51);
		right.add(txtrLogIn);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("EMAIL");
		txtrEmail.setBounds(25, 138, 73, 22);
		right.add(txtrEmail);
		
		JTextArea txtrPasseword = new JTextArea();
		txtrPasseword.setText("PasseWord");
		txtrPasseword.setBounds(25, 230, 73, 22);
		right.add(txtrPasseword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(41, 170, 359, 39);
		right.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Accueil frame = new Accueil();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(255, 153, 153));
		btnNewButton.setBounds(168, 333, 131, 39);
		right.add(btnNewButton);
		
		JTextArea txtrCreerUnCompte = new JTextArea();
		txtrCreerUnCompte.setText("creer un compte");
		txtrCreerUnCompte.setBounds(82, 395, 186, 22);
		right.add(txtrCreerUnCompte);
		
		JButton btnNewButton_1 = new JButton("inscreption");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				inscreption frame = new inscreption();
                frame.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(279, 397, 104, 21);
		right.add(btnNewButton_1);
	}
}
