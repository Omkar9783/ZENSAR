import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class CardLayoutExample extends JFrame implements ActionListener{

    JFrame jf;
    JPanel pp;
    CardLayout cd;

    CardLayoutExample(){
        jf = new JFrame("CardLayout Example");
        cd = new CardLayout();
        
        //Creating a main parent panel that will contain two child panel
        pp = new JPanel();

        //Creating 2 child panels
        JPanel cp1 = new JPanel();
        JPanel cp2 = new JPanel();

        //Creating 2 parent Buttons
        JButton b1= new JButton("Numbers");
        JButton b2 = new JButton("Alphabets");

        //Creating 3 child Buttons for numbers parent Button
        JButton b3 = new JButton("1");
        JButton b4 = new JButton("2");
        JButton b5 = new JButton("3");

        //Adding b3,b4 and b5 buttons to cp1

        cp1.add(b3);
        cp1.add(b4);
        cp1.add(b5);

        //Creating 3 buttons for alphabets parent Button
        JButton b6 = new JButton("A");
        JButton b7 = new JButton("B");
        JButton b8 = new JButton("C");
        JButton b9 = new JButton("D");
        
        //Adding b6,b7,b8 buttons to cp2
        cp2.add(b6);
        cp2.add(b7);
        cp2.add(b8);
        cp2.add(b9);

        //Setting the positioning of the components in pp(that contains cp2 and cp2) to cardLayout

        pp.setLayout(cd);

        //Adding cp1 and cp2 to pp
        pp.add(cp1,"Numbers");
        pp.add(cp2, "Alphabets");
        
        //Generating events
        b1.addActionListener(this);
        b2.addActionListener(this);

        //Setting container JFrame's layout to FlowLayout
        jf.setLayout(new FlowLayout());

        //Adding two buttons to JFrame,these buttons will remain commonly visible to all panels
        jf.add(b1);
        jf.add(b2);

        //Adding pp to jf
        jf.add(pp);

        jf.setSize(300, 200);
        jf.setVisible(true);

    }



    public static void main(String[] args) {
        new CardLayoutExample();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Numbers")) {
            cd.show(pp, "Numbers");
        } else {
            cd.show(pp, "Alphabets");
        }
    }
}
