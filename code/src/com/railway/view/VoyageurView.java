package com.railway.view;

import javax.swing.*;

import com.railway.model.Voyageur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VoyageurView extends JFrame {
    private Voyageur voyageur;

    // Swing components
    private JTextField textFieldFullName;
    private JTextField textFieldEmail;
    private JTextField textFieldPassword;

    public VoyageurView() {
        initialize();
        voyageur = new Voyageur();
    }

    private void initialize() {
        setTitle("Railway System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel lblFullName = new JLabel("Full Name:");
        textFieldFullName = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        textFieldEmail = new JTextField();
        JLabel lblPassword = new JLabel("Password:");
        textFieldPassword = new JPasswordField();

        panel.add(lblFullName);
        panel.add(textFieldFullName);
        panel.add(lblEmail);
        panel.add(textFieldEmail);
        panel.add(lblPassword);
        panel.add(textFieldPassword);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        panel.add(btnSignUp);
        panel.add(btnLogin);

        getContentPane().add(panel);
    }

    private void signUp() {
        String fullName = textFieldFullName.getText();
        String email = textFieldEmail.getText();
        String password = textFieldPassword.getText();

        try {
            if (voyageur.signUp()) {
                JOptionPane.showMessageDialog(this, "Sign up successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Sign up failed.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while signing up.");
        }
    }

    private void login() {
        String email = textFieldEmail.getText();
        String password = textFieldPassword.getText();

        try {
            if (voyageur.login(email, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Proceed to the next screen or perform other actions
            } else {
                JOptionPane.showMessageDialog(this, "Login failed. Please check your credentials.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while logging in.");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VoyageurView frame = new VoyageurView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
