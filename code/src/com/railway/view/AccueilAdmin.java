package com.railway.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccueilAdmin extends JFrame {

    private JPanel contentPane;

    public AccueilAdmin() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Welcome. Admin");
        lblTitle.setBounds(280, 20, 250, 40);
        lblTitle.setBackground(new Color(255, 128, 0));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(lblTitle);

        JButton btnAddTrain = new JButton("Add Train");
        btnAddTrain.setBounds(10, 44, 200, 40);
        btnAddTrain.setBackground(new Color(64, 0, 128));
        btnAddTrain.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(btnAddTrain);

        JButton btnModifyTrajectory = new JButton("Modify Trajectory");
        btnModifyTrajectory.setBounds(10, 116, 200, 40);
        btnModifyTrajectory.setBackground(new Color(128, 0, 255));
        btnModifyTrajectory.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(btnModifyTrajectory);

        JButton btnDeleteTrajectory = new JButton("Delete Trajectory");
        btnDeleteTrajectory.setBounds(10, 180, 200, 40);
        btnDeleteTrajectory.setBackground(new Color(255, 0, 128));
        btnDeleteTrajectory.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(btnDeleteTrajectory);

        JButton btnAddDiscountCard = new JButton("Add Discount Card");
        btnAddDiscountCard.setBounds(10, 249, 200, 40);
        btnAddDiscountCard.setBackground(new Color(255, 0, 255));
        btnAddDiscountCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(btnAddDiscountCard);

        JButton btnDeleteDiscountCard = new JButton("Delete Discount Card");
        btnDeleteDiscountCard.setBounds(10, 331, 200, 40);
        btnDeleteDiscountCard.setBackground(new Color(0, 128, 255));
        btnDeleteDiscountCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(btnDeleteDiscountCard);

        JButton btnViewClientAccounts = new JButton("View Client Accounts");
        btnViewClientAccounts.setBounds(10, 403, 200, 40);
        btnViewClientAccounts.setBackground(new Color(128, 255, 255));
        btnViewClientAccounts.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(btnViewClientAccounts);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(255, 128, 0));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 537, 800, 27);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("© 2024 ONCF - Tous droits réservés");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\othma\\Desktop\\icon 4.jpg"));
        lblNewLabel_1.setBounds(300, 100, 500, 500);
        contentPane.add(lblNewLabel_1);

        // Button actions
        btnAddTrain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AccueilAdmin.this, "Functionality to add train.");
            }
        });

        btnModifyTrajectory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AccueilAdmin.this, "Functionality to modify trajectory.");
            }
        });

        btnDeleteTrajectory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AccueilAdmin.this, "Functionality to delete trajectory.");
            }
        });

        btnAddDiscountCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AccueilAdmin.this, "Functionality to add discount card.");
            }
        });

        btnDeleteDiscountCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AccueilAdmin.this, "Functionality to delete discount card.");
            }
        });

        btnViewClientAccounts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AccueilAdmin.this, "Functionality to view client accounts.");
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	AccueilAdmin frame = new AccueilAdmin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}