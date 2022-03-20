package address;
import address.data.AddressBook;
import address.data.AddressEntry;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author Student Name
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to add data to and delete data from and query an address book
 */
public class AddressBookApplication {


    /**
     * creates an AddressBook initializes the AddressBook with some AddressEntry's and
     * then prompts the user to add, delete, list, and search for entries.
     * @param args command line arguments passed to main
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //create instance of AddressBook for application
        AddressBook ab = new AddressBook();

        //creates window with Display button
        JFrame frame = new JFrame("Display");
        frame.setContentPane(new Display(ab).getJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(400, 400));

        initAddressBook(ab);

        //Code to Loop until user chooses to Quit
        //Display Menu of options, based on user's choice
        //invoke appropriate code.
        Scanner keyboard = new Scanner(System.in);
        String answer;

        //Loop
        boolean continueLoop = true;
        while(continueLoop) {
            //display menu
            Menu.display_Menu();
            //grab users choice and based on this invoke code
            answer = keyboard.nextLine();
            //print a few line returns before processing
            System.out.println("\n\n");
            switch (answer) {
                case "a" -> { //case of read from file
                    System.out.println("Enter in FileName:");
                    ab.readFromFile(keyboard.nextLine());
                }
                case "b" -> ab.add(Menu.promptForNewAddressEntry());  //case add new address object using Menu class prompts to User
                case "c" -> { //remove an address entry
                    System.out.println("Enter in Last Name of contact to remove:");
                    ab.remove(keyboard.nextLine());
                }
                case "d" -> { //find AddressEntry based on last name or start of it
                    System.out.println("Enter in all or beginning of last name you wish to find:");
                    ab.find(keyboard.nextLine());
                }
                case "e" -> ab.list();  //list alphanumerically based on last name all the users
                case "f" -> {
                    System.out.println("Quitting.");
                    continueLoop = false;
                }
                default -> System.out.println("Error: " + answer + " is not a valid selection.");
            }
        }
    }

    /**
     * initializes 2 AddressEntry instances with hard-coded data. Then adds entries to AddressBook class passed to function.
     * @param ab is an instance of AddressBook class
     */
    public static void initAddressBook(AddressBook ab) throws SQLException, ClassNotFoundException{

        Class.forName ("oracle.jdbc.OracleDriver"); //name of driver
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:mcs1011/y_WrlhyT@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");
        Statement stmt = conn.createStatement ();
        ResultSet rset = stmt.executeQuery("SELECT * FROM ADDRESSENTRYTABLE");

        System.out.println(rset);

        while (rset.next ()){ //get next row of table returned

            ab.add(new AddressEntry(rset.getString("FirstNAME"), rset.getString("LASTNAME"), rset.getString("STREET"), rset.getString("CITY"), rset.getString("STATE"), Integer.parseInt(rset.getString("ZIP")), rset.getString("EMAIL"), rset.getString("PHONE"), Integer.parseInt(rset.getString("ID"))));

        }

        rset.close();

        stmt.close();

        conn.close();

    }




}
