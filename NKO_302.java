import java.awt.*;
import java.swing.*;
import java.sql.*;

public class NKO_302 extends Frame {

    NKO_302() {
        // creating a button,which is present in predefined class Button
        Button B = new Button("Click");
        B.setBounds(30, 100, 100, 30);
        add(B);

        setSize(300, 300);
        // border layout is the default layout,asked in interview
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        // calling constructor by allocating dynamic memory
        new NKO_302();
    }
}