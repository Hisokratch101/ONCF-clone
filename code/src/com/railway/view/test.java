package frontend;
import javax.swing.*;
import java.awt.*;

public class test extends JFrame {
    public test() {
        setTitle("Ticket");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        // Add your PNG image here
        JLabel imageLabel = new JLabel();
        topPanel.add(imageLabel);
        
        JPanel centerPanel = new JPanel(new GridLayout(5, 2));
        
        centerPanel.add(new JLabel("ID utilisateur"));
        centerPanel.add(new JTextField());
        
        centerPanel.add(new JLabel("Nom:"));
        centerPanel.add(new JTextField());
        
        centerPanel.add(new JLabel("Prénom:"));
        centerPanel.add(new JTextField());
        
        centerPanel.add(new JLabel("ID-Reservation:"));
        centerPanel.add(new JTextField());

		centerPanel.add(new JLabel("Départ : "));
		centerPanel.add(new JTextField());

		centerPanel.add(new JLabel("Arrivée : "));
		centerPanel.add(new JTextField());

		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	        new test().setVisible(true);
	    });
    }
}

