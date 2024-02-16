package com.railway.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TicketDetails extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TicketDetails frame = new TicketDetails();
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
    public TicketDetails() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 915, 544);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTicketDetails = new JLabel("TICKET");
        lblTicketDetails.setBounds(302, 10, 132, 20);
        lblTicketDetails.setForeground(new Color(255, 128, 0));
        lblTicketDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblTicketDetails);
        
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(38, 68, 46, 14);
        contentPane.add(lblName);
        
        JLabel lblDeparture = new JLabel("Departure:");
        lblDeparture.setBounds(38, 104, 73, 14);
        contentPane.add(lblDeparture);
        
        JLabel lblArrival = new JLabel("Arrival:");
        lblArrival.setBounds(38, 142, 46, 14);
        contentPane.add(lblArrival);
        
        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(38, 180, 46, 14);
        contentPane.add(lblDate);
        
        JButton btnPrint = new JButton("Print");
        btnPrint.setBounds(313, 384, 105, 36);
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform printing action here
                System.out.println("Printing ticket...");
            }
        });
        contentPane.add(btnPrint);
        
        JPanel panel = new JPanel();
        panel.setBounds(476, -3, 425, 510);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("New label");
        panel.add(lblNewLabel);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\othma\\git\\ONCF-clone\\code\\icon\\icon2.jpg"));
        
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(38, 228, 26, 13);
        contentPane.add(lblPrice);
        
        JButton btnBack = new JButton("back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Accueil frame = new Accueil();
                frame.setVisible(true);
        	}
        });
        btnBack.setBounds(70, 384, 105, 36);
        contentPane.add(btnBack);
    }
}
