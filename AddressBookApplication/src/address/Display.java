package address;

import address.data.AddressBook;

import javax.swing.*;
import java.awt.*;
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
    AddressBook ab; //instance of address book


    /**
     * creates GUI
     * @param addressBook is the addressBook that GUI will attach to
     */
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
        /*
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
         */
    }

    /**
     * returns the main panel
     * @return the main panel
     */
    public JPanel getJPanel(){

        return panelMain;

    }
}