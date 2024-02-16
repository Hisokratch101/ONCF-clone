package com.railway.view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Accueil extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> departComboBox;
    private JComboBox<String> arriverComboBox;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Accueil frame = new Accueil();
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
    public Accueil() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 988, 680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setForeground(new Color(255, 128, 0));
        panel.setBounds(0, 616, 985, 27);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("© 2024 ONCF - Tous droits réservés");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 128, 0));
        panel_1.setBounds(0, 0, 160, 615);
        contentPane.add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(157, 27, 828, 494);
        contentPane.add(panel_2);
        panel_2.setToolTipText("Depart");
        panel_2.setLayout(null);
        
        JLabel lblDate = new JLabel("Select Date:");
        lblDate.setBounds(10, 40, 80, 21);
        panel_2.add(lblDate);
        
        JComboBox<String> dateComboBox = new JComboBox<String>();
        dateComboBox.setToolTipText("Select Date");
        dateComboBox.setBounds(82, 40, 150, 21);
        panel_2.add(dateComboBox);
        
        departComboBox = new JComboBox<String>();
        departComboBox.setToolTipText("Depart");
        departComboBox.setBounds(256, 40, 150, 21);
        panel_2.add(departComboBox);
        
        arriverComboBox = new JComboBox<String>();
        arriverComboBox.setToolTipText("Arriver");
        arriverComboBox.setBounds(416, 40, 150, 21);
        panel_2.add(arriverComboBox);
        
        Button rechercheButton = new Button("Recherche");
        rechercheButton.setBounds(570, 40, 178, 21);
        panel_2.add(rechercheButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 808, 404);
        panel_2.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        
        departComboBox.addItem("Station A");
        departComboBox.addItem("Station B");
        departComboBox.addItem("Station C");
        
        arriverComboBox.addItem("Station X");
        arriverComboBox.addItem("Station Y");
        arriverComboBox.addItem("Station Z");
        
        
        rechercheButton.addActionListener(e -> searchTickets());
        
        // Populate dates (dummy data)
        dateComboBox.addItem("2024-02-16");
        dateComboBox.addItem("2024-02-17");
        dateComboBox.addItem("2024-02-18");
    }

    // Method to search tickets (dummy data)
    private void searchTickets() {
        String depart = (String) departComboBox.getSelectedItem();
        String arriver = (String) arriverComboBox.getSelectedItem();

        DefaultTableModel model = new DefaultTableModel(new String[]{"Nom", "Depart", "Arriver", "Date", "Prix"}, 0);

        // Dummy data
        model.addRow(new Object[]{"John Doe", depart, arriver, "2024-02-18", "$50"});
        model.addRow(new Object[]{"Jane Smith", depart, arriver, "2024-02-19", "$55"});
        model.addRow(new Object[]{"Alice Johnson", depart, arriver, "2024-02-20", "$60"});

        table.setModel(model);
    }
}
