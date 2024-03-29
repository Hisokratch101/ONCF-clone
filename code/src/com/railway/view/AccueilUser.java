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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AccueilUser extends JFrame {

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
                    AccueilUser frame = new AccueilUser();
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
    public AccueilUser() {
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
        
        JRadioButton rdbtnClasse1 = new JRadioButton("Classe 1");
        panel_1.add(rdbtnClasse1);
        
        JRadioButton rdbtnClasse2 = new JRadioButton("Classe 2");
        rdbtnClasse2.setSelected(true); // Select Classe 2 by default
        panel_1.add(rdbtnClasse2);
        
        // Group the radio buttons so that only one can be selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnClasse1);
        buttonGroup.add(rdbtnClasse2);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(157, 62, 828, 459);
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
        departComboBox.setBounds(447, 40, 150, 21);
        panel_2.add(departComboBox);
        
        arriverComboBox = new JComboBox<String>();
        arriverComboBox.setToolTipText("Arriver");
        arriverComboBox.setBounds(278, 40, 150, 21);
        panel_2.add(arriverComboBox);
        
        Button rechercheButton = new Button("Recherche");
        rechercheButton.setBounds(570, 40, 178, 21);
        panel_2.add(rechercheButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 87, 808, 404);
        panel_2.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        JButton btnNewButton_1 = new JButton("Acheter Ticket");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TicketDetails frame = new TicketDetails();
                frame.setVisible(true);
            }
        });
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setBackground(new Color(255, 128, 0));
        btnNewButton_1.setBounds(780, 565, 100, 30);
        contentPane.add(btnNewButton_1);
        
        JTextPane txtpnWelcomeToOncf = new JTextPane();
        txtpnWelcomeToOncf.setBackground(new Color(255, 128, 0));
        txtpnWelcomeToOncf.setFont(new Font("Yu Gothic Medium", Font.BOLD, 25));
        txtpnWelcomeToOncf.setText("welcome to ONCF");
        txtpnWelcomeToOncf.setBounds(419, 0, 258, 64);
        contentPane.add(txtpnWelcomeToOncf);
        
        
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