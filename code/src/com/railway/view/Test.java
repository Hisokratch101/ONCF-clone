package com.railway.view;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("ONCF Ticket Booking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create a panel for the main content
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add the ONCF logo (you can replace this with an actual image)
        ImageIcon oncfLogo = new ImageIcon("https://www.maroc.ma/sites/default/files/image_actualite/oncf_5.jpg "); 
        JLabel logoLabel = new JLabel("oncf_5.jpg");
        mainPanel.add(logoLabel, BorderLayout.NORTH);

        // Create a panel for the ticket details
        JPanel ticketPanel = new JPanel();
        ticketPanel.setLayout(new GridLayout(4, 2));

        // Add labels and text fields for ID utilisateur, Nom, Prénom, and ID-Reservation
        ticketPanel.add(new JLabel("ID utilisateur:"));
        ticketPanel.add(new JTextField(10));
        ticketPanel.add(new JLabel("Nom:"));
        ticketPanel.add(new JTextField(10));
        ticketPanel.add(new JLabel("Prénom:"));
        ticketPanel.add(new JTextField(10));
        ticketPanel.add(new JLabel("ID-Reservation:"));
        ticketPanel.add(new JTextField(10));

        mainPanel.add(ticketPanel, BorderLayout.CENTER);

        // Create a panel for departure and arrival stations
        JPanel stationsPanel = new JPanel();
        stationsPanel.setLayout(new GridLayout(2, 2));

        // Add labels and text fields for departure and arrival stations
        stationsPanel.add(new JLabel("Départ:"));
        stationsPanel.add(new JTextField(10));
        stationsPanel.add(new JLabel("Arrivé:"));
        stationsPanel.add(new JTextField(10));

        mainPanel.add(stationsPanel, BorderLayout.SOUTH);

        // Load a webpage (you can replace this URL with your desired page)
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        try {
            editorPane.setPage(new URL("http://www.yoursite.com"));
        } catch (IOException e) {
            editorPane.setContentType("text/html");
            editorPane.setText("<html>Could not load</html>");
        }

        JScrollPane scrollPane = new JScrollPane(editorPane);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}

