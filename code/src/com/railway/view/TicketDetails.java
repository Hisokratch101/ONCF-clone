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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class TicketDetails extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldID;
    private JTextField textFieldType;
    private JTextField textFieldReduction;
    private JLabel lblPriceValue;

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
        lblPrice.setBounds(38, 262, 46, 13);
        contentPane.add(lblPrice);
        
        lblPriceValue = new JLabel("$100"); // Initial price value
        lblPriceValue.setBounds(85, 262, 100, 13);
        contentPane.add(lblPriceValue);
        
        JButton btnBack = new JButton("back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AccueilUser frame = new AccueilUser();
                frame.setVisible(true);
            }
        });
        btnBack.setBounds(70, 384, 105, 36);
        contentPane.add(btnBack);
        
        JLabel lblClasse = new JLabel("Classe:");
        lblClasse.setBounds(38, 221, 46, 13);
        contentPane.add(lblClasse);
        
        JButton btnReduction = new JButton("reduction");
        btnReduction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showReductionDialog();
            }
        });
        btnReduction.setBounds(185, 384, 105, 36);
        contentPane.add(btnReduction);
    }
    
    private void showReductionDialog() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 10, 46, 14);
        panel.add(lblId);
        
        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(10, 40, 46, 14);
        panel.add(lblType);
        
        JLabel lblReduction = new JLabel("Reduction:");
        lblReduction.setBounds(10, 70, 68, 14);
        panel.add(lblReduction);
        
        textFieldID = new JTextField();
        textFieldID.setBounds(88, 7, 86, 20);
        panel.add(textFieldID);
        textFieldID.setColumns(10);
        
        textFieldType = new JTextField();
        textFieldType.setBounds(88, 37, 86, 20);
        panel.add(textFieldType);
        textFieldType.setColumns(10);
        
        textFieldReduction = new JTextField();
        textFieldReduction.setBounds(88, 67, 86, 20);
        panel.add(textFieldReduction);
        textFieldReduction.setColumns(10);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Reduction Information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String id = textFieldID.getText();
                String type = textFieldType.getText();
                double reduction = Double.parseDouble(textFieldReduction.getText());
                
                // Update the price based on reduction
                // For demonstration, let's say the initial price is $100
                double price = 100 - reduction; // Adjust the price based on the reduction
                
                // Update the price label with the new value
                lblPriceValue.setText("$" + String.format("%.2f", price));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid reduction value", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}