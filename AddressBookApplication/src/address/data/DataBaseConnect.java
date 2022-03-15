package address.data;/*

 * This sample shows how to list all entries from the table dogs in the database

 *

 * It uses the JDBC OCI8 driver.

 */



// You need to import the java.sql package to use JDBC

import java.sql.*;

public class DataBaseConnect {




    /**
     * @param args
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        // Load the Oracle JDBC driver
        Class.forName ("oracle.jdbc.OracleDriver"); //name of driver may change w/ versions

        //check Oracle documentation online
        // Or could do DriverManager.registerDriver (new oracle.jdbc.OracleDriver());



        // Connect to the database
        // generic host url = jdbc:oracle:thin:login/password@host:port/SID for Oracle SEE Account INFO you
        // were given by our CS tech in an email ---THIS WILL BE DIFFERENT
        //jdbc:oracle:thin:@//adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:mcs1011/y_WrlhyT@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

        // Create a Statement
        Statement stmt = conn.createStatement ();



        // Select the all (*) from the table JAVATEST

        ResultSet rset = stmt.executeQuery("SELECT * FROM ADDRESSENTRYTABLE");

        System.out.println(rset);





        // Iterate through the result and print the employee names

        while (rset.next ()) //get next row of table returned

        {         for(int i=1; i<=rset.getMetaData().getColumnCount(); i++) //visit each column

            System.out.print(rset.getString(i) + " | ");

            System.out.println(" ");

            System.out.println("========================================");

        }



        //Close access to everything...will otherwise happen when disconnect

        // from database.

        rset.close();

        stmt.close();

        conn.close();

    }

}