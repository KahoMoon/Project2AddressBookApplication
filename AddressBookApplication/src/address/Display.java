package address;

import address.data.AddressBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates a window containing a button to list addresses
 */
public class Display {
    private JButton listAddresses;  //button to list addresses
    private JPanel panelMain;   //the main panel which contains both the button and text box
    private JScrollPane scrollPane; //the scrollable pane
    private JTextArea textArea; //the text box
    AddressBook ab;

    public Display(AddressBook addressBook) {

        ab = addressBook;
        textArea.setEditable(false);    //remove ability to edit text box

        listAddresses.addActionListener(new ActionListener() {
            /**
             * prints out all the addresses to the text box when an action occurs
             * @param e the action
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                //JOptionPane.showMessageDialog(null, "Hello");
                textArea.setText(addressBook.list());
                //System.out.println(addressBook.list());

            }
        });
    }

    /**
     * returns the main panel
     * @return the main panel
     */
    public JPanel getJPanel(){

        return panelMain;

    }
}
