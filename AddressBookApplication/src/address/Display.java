package address;

import address.data.AddressBook;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Display {
    public static void main(AddressBook ab) {

        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JPanel test = new JPanel();
        JButton b = new JButton("press");
        JTextArea text = new JTextArea(20,20);
        JScrollPane scroll = new JScrollPane(text);

        text.setEditable(false);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        b.setText("Press");
        b.setSize(10,10);

        p.add(scroll);
        test.add(b);
        f.add(p);
        f.add(test);

        f.pack();
        f.setVisible(true);

    }
}