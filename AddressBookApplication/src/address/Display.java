package address;

import address.data.AddressBook;

import javax.swing.*;
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
    }

    public JPanel getJPanel(){

        return panelMain;

    }
}
