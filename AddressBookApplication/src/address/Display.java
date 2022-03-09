package address;

import address.data.AddressBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates a window containing a button to
 */
public class Display {
    private JButton listAddresses;
    private JPanel panelMain;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    AddressBook ab;

    public Display(AddressBook addressBook) {

        ab = addressBook;
        textArea.setEditable(false);

        listAddresses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //JOptionPane.showMessageDialog(null, "Hello");
                textArea.setText(addressBook.list());
                System.out.println(addressBook.list());

            }
        });
        {   //Initializes a new text pane for a scrollable pane
            JFrame frame = new JFrame("Scrollpane");
            //Sets the layout for the frame
            frame.setLayout(new FlowLayout());
            JTextPane scrollPane = new JTextPane();
            //Adds the scrollpane
            frame.add(scrollPane);
            //Sets the dimensions for scrollpane
            frame.setSize(200,400);
            //Sets the scrollpane to always be visible
            frame.setVisible(true);
        }
    }

    public JPanel getJPanel(){

        return panelMain;

    }
}