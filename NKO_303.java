import java.awt.*;
import java.awt.event.*;

public class NKO_303 extends Frame {
    Label L;

    NKO_303() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }

        );

        L = new Label("Window Closing Example");
        this.add(L);

        setTitle("NKOCET");
        setSize(300, 300);
        setVisible(true);

    }

    public static void main(String[] args) {
        new NKO_303();
    }
}