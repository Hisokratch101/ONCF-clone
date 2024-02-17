package com.railway.view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame {

    public User() {
        setTitle("Welcome");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Set background image
        ImageIcon backgroundIcon = new ImageIcon("background.jpg");
        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\othma\\Desktop\\icon 4.jpg"));
        backgroundLabel.setBackground(new Color(0, 128, 192));
        backgroundLabel.setBounds(0, 0, 586, 363);
        getContentPane().add(backgroundLabel);

        // Create buttons
        JButton clientButton = new JButton("Client");
        clientButton.setBackground(new Color(255, 128, 0));
        clientButton.setBounds(200, 200, 100, 40);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LogUser frame = new LogUser();
				frame.setVisible(true);
            }
        });
        backgroundLabel.add(clientButton);

        JButton adminButton = new JButton("Admin");
        adminButton.setBackground(new Color(255, 128, 0));
        adminButton.setBounds(300, 200, 100, 40);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LogAdmin frame = new LogAdmin();
				frame.setVisible(true);
            }
        });
        backgroundLabel.add(adminButton);

        getContentPane().setLayout(null); // To set components manually
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new User();
            }
        });
    }
}

