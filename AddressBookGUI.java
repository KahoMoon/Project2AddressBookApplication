package address.gui;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import address.data.AddressBook;

/**
 * Java Program to create a GUI for diaplsying the
 * address book entries using java swing components
 * @author
 */
public class AddressBookGUI extends JFrame {

    private AddressBook addressBook;
    private JLabel headerLabel;
    private JButton displayButton;
    private JButton addButton;
    private JLabel optionLabel;

    public AddressBookGUI() {
        addressBook = new AddressBook();
        addressBook.readFromFile("entries.txt");
        initComponents();
    }

    private void initComponents() {
        headerLabel = new JLabel();
        displayButton = new JButton();
        optionLabel = new JLabel();
        addButton = new JButton();

        setMinimumSize(new Dimension(440,300));
        setPreferredSize(new Dimension(440,300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        headerLabel.setFont(new Font("Liberation Sans", 1, 18));
        headerLabel.setForeground(new Color(0, 0, 204));
        headerLabel.setText("  Welcome to AddressBook Management System");
        getContentPane().add(headerLabel);
        headerLabel.setBounds(0, 0, 440, 80);

        displayButton.setFont(new Font("Liberation Sans", 1, 14));
        displayButton.setForeground(new Color(0, 0, 204));
        displayButton.setText("Display AddressBook");
        getContentPane().add(displayButton);
        displayButton.setBounds(120, 130, 190, 23);

        optionLabel.setFont(new Font("Liberation Sans", 3, 15));
        optionLabel.setForeground(new Color(255, 0, 0));
        optionLabel.setText("Please select your option");
        getContentPane().add(optionLabel);
        optionLabel.setBounds(130, 90, 180, 18);

        addButton.setFont(new Font("Liberation Sans", 1, 14));
        addButton.setForeground(new Color(0,0,204));
        addButton.setText("Add New Address Entry");
        getContentPane().add(addButton);
        addButton.setBounds(100, 180, 230, 23);

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        pack();
    }

    protected void addButtonActionPerformed(ActionEvent evt) {
        AddressBookForm form = new AddressBookForm(addressBook);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        form.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                form.writeToFile();
                AddressBookGUI addressBookGUI =  new AddressBookGUI();
                addressBookGUI.setLocationRelativeTo(null);
                addressBookGUI.setVisible(true);
                dispose();
            }
        });
        dispose();
    }

    protected void displayButtonActionPerformed(ActionEvent evt) {
        AddressBookTable addressBookTable = new AddressBookTable(addressBook);
        addressBookTable.setLocationRelativeTo(null);
        addressBookTable.setVisible(true);
        addressBookTable.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                addressBookTable.writeToFile();
                AddressBookGUI addressBookGUI =  new AddressBookGUI();
                addressBookGUI.setLocationRelativeTo(null);
                addressBookGUI.setVisible(true);
                dispose();
            }
        });
        dispose();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo i : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(i.getName())) {
                    UIManager.setLookAndFeel(i.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddressBookGUI addressBookGUI =  new AddressBookGUI();
                addressBookGUI.setLocationRelativeTo(null);
                addressBookGUI.setVisible(true);
            }
        });
    }
}


