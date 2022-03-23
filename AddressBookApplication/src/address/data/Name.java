package address.data;

/**
 * @author Kaho Moon
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to contain and provide data necessary to represent a Name
 */
public class Name {

    /**
     * first name
     */
    private String firstName;
    /**
     * last name
     */
    private String lastName;

    /**returns an Name where all fields are initialized to default values
     *
     */
    public Name() {
        firstName = "";
        lastName = "";
    }

    /**returns a Name initialized to the data in parameters provided
     *
     * @param firstName is a firstname
     * @param lastName is a listname
     */

    public Name(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * returns a Name initialized to the same data in the given Name instance
     * @param name is an instance of Name
     */
    public Name(Name name){

        this.firstName = name.getFirstName();
        this.lastName = name.getLastName();

    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * method to get the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * method to get the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * method to set the first name
     * @param firstName is the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * method to set the last name
     * @param lastName is the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
