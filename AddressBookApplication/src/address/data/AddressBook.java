package address.data;

import java.sql.*;
import java.util.*;
import java.io.*;

/**
 * @author Kaho Moon
 * @version 1.0
 * @since 1.2
 *
 * The purpose of this class is to represent a generic address book
 */
public class AddressBook {

    /**
     * the data structures that will hold the data for the address book. Composed of a TreeMap
     * where the key is a String(the last name of the AddressEntry) and the value is a TreeSet
     * of the AddressEntry. This is because java does not contain a multiset in standard libraries.
     * Tree is used instead of hash because tree preserves the natural ordering of key which makes printing in
     * sorted order by last name(key) easy.
     */
    private final TreeMap<String, TreeSet<AddressEntry>> addressEntryList = new TreeMap<>();

    /** a method which prints out all fields in all entries of the address book
     *
     */
    public String list() {
        System.out.print(this.toString());
        return this.toString();
    }

    /**
     * format for PreparedStatement for DELETE
     */
    private static final String SQL_DELETE = "DELETE FROM ADDRESSENTRYTABLE WHERE FIRSTNAME=? AND LASTNAME=? AND STREET=? AND CITY=? AND STATE=? AND ZIP=? AND EMAIL=? AND PHONE=? AND ID=?";

    /**
     * a method which deletes an entry in the database matching the given parameters
     * @param firstName is the first name
     * @param lastName is the last name
     * @param street is the street
     * @param city is the city
     * @param state is the state
     * @param zip is the zip
     * @param email is the email
     * @param phone is the phone
     * @param id is the id
     * @throws SQLException SQL error
     */
    public void delete(String firstName, String lastName, String street, String city, String state, Integer zip, String email, String phone, Integer id) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:mcs1011/y_WrlhyT@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");
                PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
        ) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, street);
            statement.setString(4, city);
            statement.setString(5, state);
            statement.setInt(6, zip);
            statement.setString(7, email);
            statement.setString(8, phone);
            statement.setInt(9, id);
            statement.executeUpdate();
        }
    }

    /** a method which removes an address entry from the address book
     *
     * @param lastName is the last name(or some initial consecutive chars) of the person contained
     *                 in the AddressEntry to be removed
     *
     * First we get the prefixSet which is the set of all AddressEntry that have the first consecutive
     * of the lastName of AddressEntry match the lastName parameter passed. If the size of the set is 1 then
     * print out AddressEntry and prompt user if they wish to delete. If more than 1 element in set then print all
     * elements and ask user to select element based on index.
     */
    public void remove(String lastName) throws SQLException {

        //first obtain a set which contains all address entries in address book where
        //the first characters of their last name exactly match all of the chars in parameter lastname
        TreeSet<AddressEntry> s = this.getPrefixSet(lastName);
        Scanner keyboard = new Scanner(System.in);
        try {
            if (s.size() == 1) {
                System.out.println("The following entry was found in the address book.");
                System.out.printf("%-3s" + s.first() + "\n", " ");
                System.out.println("Hit 'y' to remove the entry or 'n' to return to main menu");
                if (keyboard.nextLine().compareTo("y") == 0)
                    //System.out.println(s.first().getId());
                    delete(s.first().getFirstName(), s.first().getLastName(), s.first().getStreet(), s.first().getCity(), s.first().getState(), s.first().getZip(), s.first().getEmail(), s.first().getPhone(), s.first().getId());
                    addressEntryList.get(s.first().getLastName()).remove(s.first());
            } else if (s.size() > 1) {
                ArrayList<AddressEntry> list = new ArrayList<>();
                int i = 1;
                System.out.println("The following entries were found in the address book," +
                        "select number of entry you wish to remove:\n");
                for (AddressEntry entry : s) {
                    list.add(entry);
                    System.out.printf("%-3s" + entry + "\n\n", i + ":");
                    i++;
                }
                int removalIndex = keyboard.nextInt() - 1;
                keyboard.nextLine();
                if(removalIndex < list.size() && removalIndex >= 0)
                    System.out.println("Hit 'y' to remove the following entry or 'n' to return to main menu:\n");
                System.out.printf("%-3s" + list.get(removalIndex) + "\n\n", "  ");
                if (keyboard.nextLine().compareTo("y") == 0) {
                    TreeSet<AddressEntry> set = addressEntryList.get(list.get(removalIndex).getLastName());
                    //System.out.println("\n ----------------" + list.get(removalIndex).getId());
                    delete(list.get(removalIndex).getFirstName(), list.get(removalIndex).getLastName(), list.get(removalIndex).getStreet(), list.get(removalIndex).getCity(), list.get(removalIndex).getState(), list.get(removalIndex).getZip(), list.get(removalIndex).getEmail(), list.get(removalIndex).getPhone(), list.get(removalIndex).getId());
                    set.remove(list.get(removalIndex));
                }
            } else
                System.out.println("No entries with last name " + lastName + " were found.");
        }
        catch(InputMismatchException e) {
            System.out.println("Error: You need to enter a valid integer. No action taken.");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid element selection. No action taken.");
        }
    }

    /**
     * format for PreparedStatement for INSERT
     */
    private static final String SQL_INSERT = "INSERT INTO ADDRESSENTRYTABLE (FIRSTNAME, LASTNAME, STREET, CITY, STATE, ZIP, EMAIL, PHONE, ID)"
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /**
     * a method which creates an entry in the database with the given parameters
     * @param firstName is the first name
     * @param lastName is the last name
     * @param street is the street
     * @param city is the city
     * @param state is the state
     * @param zip is the zip
     * @param email is the email
     * @param phone is the phone
     * @param id is the id
     * @throws SQLException SQL error
     */
    public void create(String firstName, String lastName, String street, String city, String state, Integer zip, String email, String phone, Integer id) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:mcs1011/y_WrlhyT@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
        ) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, street);
            statement.setString(4, city);
            statement.setString(5, state);
            statement.setInt(6, zip);
            statement.setString(7, email);
            statement.setString(8, phone);
            statement.setInt(9, id);
            statement.executeUpdate();
        }
    }

    /** a method which adds an address entry to the address book and database
     *
     * @param entry the instance of AddressEntry beijng added to the AddressBook and database
     *
     * If the key has never been seen before then a new TreeSet is created to contain the entry.
     * If the key has been seen before then entry is simply added to the correct set.
     */
    public void add(AddressEntry entry) throws ClassNotFoundException, SQLException {
        addressEntryList.computeIfAbsent(entry.getLastName(), k -> new TreeSet<>()).add(entry);

        Class.forName ("oracle.jdbc.OracleDriver"); //name of driver may change w/ versions

        String firstName = entry.getFirstName();
        String lastName = entry.getLastName();
        String street = entry.getStreet();
        String city = entry.getCity();
        String state = entry.getState();
        Integer zip = entry.getZip();
        String email = entry.getEmail();
        String phone = entry.getPhone();
        Integer id = entry.getId();


        create(firstName, lastName, street, city, state, zip, email, phone, id);    //create an entry in the database

    }

    /**
     * a method which adds an address entry to the address book only
     * @param entry the instance of AddressEntry being added to the AddressBook
     */
    public void addLocally(AddressEntry entry){
        addressEntryList.computeIfAbsent(entry.getLastName(), k -> new TreeSet<>()).add(entry);
    }

    /** a method which reads in address entries from a text file and adds them to the address book
     *
     * @param filename is a string which is the name of a text file that contains address Entry data in a certain format
     *
     *the format is firstName\nlastName\nAdress\ncity\nState\nzip\nemail\nphoneNumber
     */
    public void readFromFile(String filename) {
        try{
            //open file
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            //count number of entries processed
            int count =0;

            //read from filea
            while((line=br.readLine()) != null) {

                this.add(new AddressEntry(line, br.readLine(), br.readLine(), br.readLine(),
                                          br.readLine(), Integer.parseInt(br.readLine()), br.readLine(), br.readLine(), Integer.parseInt(br.readLine())));

                count++;
            }
            System.out.println("\nProcessed "+ count + " new Address Entries");
        }
        catch(FileNotFoundException e) {
            //print out message for file not found
            System.out.println(e.getMessage());
        }
        catch(IOException | SQLException ex) {
            //print out stack for other exceptions
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** a method which displays one or multiple address entries
     *
     * @param startOf_lastName is a string which contains either a full last name or the first consecutive chars
     * of a last name in an AddressEntry
     */
    public void find(String startOf_lastName) {
        SortedMap<String, TreeSet<AddressEntry>> tempMap;
        tempMap = addressEntryList.subMap(startOf_lastName, startOf_lastName + Character.MAX_VALUE);
        if(tempMap.size() > 0) {
            int i = 1;
            //this line computes total number of Address entries in tempMap
            System.out.println("The following " + tempMap.values().stream().mapToInt(TreeSet::size).sum() +
                    " entries were found in the address book" +
                    " for a last name starting with " + "\"" + startOf_lastName + "\"");
            for(Map.Entry<String, TreeSet<AddressEntry>> entry : tempMap.entrySet()) {
                for(AddressEntry item : entry.getValue()) {
                    System.out.printf("%-3s" + item + "\n\n", i + ":");
                    i++;
                }
            }
        }
        else
            System.out.println("There were no entries were found in the address book" +
                    " for a last name starting with " + "\"" + startOf_lastName + "\"");
    }

    /** a method that returns a set of address entries in which the first characters in the
     *  last name of each entry in the returned set are an exact match for the characters passed
     *  to the function
     *
     * @param startOf_lastName full last name or start of last name
     * @return A TreeSet which contains all of the AddressEntry instances whose lastName field
     * matches from the start every char provided in startOf_lastName.
     */
    private TreeSet<AddressEntry> getPrefixSet(String startOf_lastName) {
        SortedMap<String, TreeSet<AddressEntry>> tempMap;
        TreeSet<AddressEntry> tempSet = new TreeSet<>();
        tempMap = addressEntryList.subMap(startOf_lastName, startOf_lastName + Character.MAX_VALUE);

        for(Map.Entry<String, TreeSet<AddressEntry>> entry : tempMap.entrySet()) {
            tempSet.addAll(entry.getValue());
        }
        return tempSet;
    }

    /**
     * removes all AddressEntry from the AddressBook and database
     */
    public void clear() throws SQLException {
        addressEntryList.clear();
        //Class.forName ("oracle.jdbc.OracleDriver"); //name of driver may change w/ versions
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:mcs1011/y_WrlhyT@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");
        Statement stmt = conn.createStatement ();
        stmt.executeQuery("DELETE FROM ADDRESSENTRYTABLE");
        stmt.close();
        conn.close();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int i = 1;
        for(Map.Entry<String, TreeSet<AddressEntry>> entry : addressEntryList.entrySet()) {
            for(AddressEntry item : entry.getValue()) {
                if(item != null) {
                    result.append(String.format("%-3s" + item + "\n\n", i + ":"));
                    i++;
                }
            }
        }
        return result.toString();
    }
}
