import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DatabaseNavigator extends JFrame {
    JLabel l1, l2, l3;
    JTextField tf1, tf2, tf3;
    JButton b1, b2, b3, b4;
    Connection con;
    Statement st;
    ResultSet rs;

    DatabaseNavigator() {
        setLayout(null);
   
        l1 = new JLabel("Roll Number");
        l2 = new JLabel("Name");
        l3 = new JLabel("Stipend");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
         
        b1 = new JButton("First");
        b2 = new JButton("Next");
        b3 = new JButton("Previous");
        b4 = new JButton("Last");

    
        // Row 1
        l1.setBounds(100, 100, 100, 30);
        tf1.setBounds(210, 100, 100, 30);

        // Row 2
        l2.setBounds(100, 150, 100, 30);
        tf2.setBounds(210, 150, 100, 30);

        // Row 3
        l3.setBounds(100, 200, 100, 30);
        tf3.setBounds(210, 200, 100, 30);

        // Row 4 (Buttons)
        b1.setBounds(100, 250, 100, 30);
        b2.setBounds(210, 250, 100, 30);

        // Row 5 (Buttons)
        b3.setBounds(100, 300, 100, 30);
        b4.setBounds(210, 300, 100, 30);

        add(l1); add(tf1);
        add(l2); add(tf2);
        add(l3); add(tf3);
        add(b1); add(b2);
        add(b3); add(b4);

        setSize(500, 500); // Adequate size to show all components
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        
new DatabaseNavigator();
            
        }
    
}