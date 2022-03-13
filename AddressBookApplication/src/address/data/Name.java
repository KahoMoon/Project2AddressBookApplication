package address.data;

/**
 * @author Student Name
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

    /**returns an Name initialized to the data in parameters provided
     *
     * @param firstName is a firstname
     * @param lastName is a listname
     */

    public Name(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
