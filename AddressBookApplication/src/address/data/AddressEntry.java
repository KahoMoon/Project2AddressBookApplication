package address.data;

/**
 * @author Student Name
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to contain and provide data necessary to represent an
 * AddressEntry
 */
public class AddressEntry implements Comparable<AddressEntry>{

    /**
     * first/last name
     */
    private Name name;
    /**
     * street/city/state/zip
     */
    private Address address;
    /**
     * phone number
     */
    private String phone;
    /**
     * email
     */
    private String email;
    /**
     * id
     */
    private Integer id;

    /**returns an AddressEntry where all fields are initialized to default values
     *
     */
    public AddressEntry() {
        name = new Name();
        name.setFirstName("");
        name.setLastName("");
        address = new Address();
        address.setStreet("");
        address.setCity("");
        address.setState("");
        address.setZip(0);
        phone = "";
        email = "";
        id = 999999999;
    }

    /**returns an address entry initialized to the data in parameters provided
     *
     * @param firstName is a firstName
     * @param lastName is a listName
     * @param street is a street
     * @param city is a city
     * @param state is a state
     * @param zip is a zip code
     * @param phone is a phone number
     * @param email is an email
     * @param id is an id
     */
    public AddressEntry(String firstName, String lastName, String street,
                        String city, String state, Integer zip, String email, String phone, Integer id)
    {
        name = new Name(firstName, lastName);
        address = new Address(street, city, state, zip);
        this.phone = phone;
        this.email = email;
        this.id = id;
    }

    /**
     * returns an address entry initialized to the data in parameters provided
     * @param name is an instance of Name
     * @param address is an instance of Address
     * @param email is an email
     * @param phone is a phone number
     * @param id is an id
     */
    public AddressEntry(Name name, Address address, String email, String phone, Integer id){

        this.name = new Name(name.getFirstName(), name.getLastName());
        this.address = new Address(address.getStreet(), address.getCity(), address.getState(), address.getZip());
        this.email = email;
        this.phone = phone;
        this.id = id;

    }

    @Override
    public String toString() {
        return name.getFirstName() + " " + name.getLastName() + "\n   " +
                address.getStreet() + "\n   " + address.getCity() + ", " + address.getState() + " " + address.getZip() +
                "\n   " + email + "\n   " + phone  + "\n   " + id;
    }

    @Override
    public int compareTo(AddressEntry other) {
        if(this.name.getLastName().compareTo(other.name.getLastName()) != 0)
            return this.name.getLastName().compareTo(other.name.getLastName());
        else if(this.name.getFirstName().compareTo(other.name.getFirstName()) == 0 &&
                this.address.getCity().compareTo(other.address.getCity()) == 0 &&
                this.phone.compareTo(other.phone) == 0 &&
                this.address.getState().compareTo(other.address.getState()) == 0 &&
                this.address.getStreet().compareTo(other.address.getStreet()) == 0 &&
                this.email.compareTo(other.email) == 0 &&
                this.address.getZip().compareTo(other.address.getZip()) == 0){
            return 0;
        }
        else
            return 1;
    }

    /** method to set the first name of the address entry
     *
     * @param firstName is a firstname
     */
    public void setFirstName(String firstName) { this.name.setFirstName(firstName); }

    /** method to set the last name of the address entry
     *
     * @param lastName is a lastName
     */
    public void setLastName(String lastName) { this.name.setLastName(lastName); }

    /** method to set the street name of an address entry
     *
     * @param street is a street
     */
    public void setStreet(String street) { this.address.setStreet(street); }

    /** method to set the city name of the address entry
     *
     * @param city is a city
     */
    public void setCity(String city) { this.address.setCity(city); }

    /** method to set the state name of the address entry
     *
     * @param state is a state
     */
    public void setState(String state) { this.address.setState(state); }

    /** method to set the zip code of the address entry
     *
     * @param zip is a zip code
     */
    public void setZip(int zip) { this.address.setZip(zip); }

    /** method to set the phone of the address entry
     *
     * @param phone is a phone number
     */
    public void setPhone(String phone) { this.phone = phone; }

    /** method to set the email address of the address entry
     *
     * @param email is an email address
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * method to set the id of the address entry
     * @param id is an id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** method to return the first name of the address entry
     *
     * @return a String which represents first name
     */
    public String getFirstName() { return name.getFirstName(); }

    /** method to return the last name of the address entry
     *
     * @return a String which represents last name
     */
    public String getLastName() { return name.getLastName(); }

    /** method to return the street name of the address entry
     *
     * @return a String which represents street
     */
    public String getStreet() { return address.getStreet(); }

    /** method to return the city name of the address entry
     *
     * @return a String which represents city
     */
    public String getCity() { return address.getCity(); }

    /** method to return the state name of the address entry
     *
     * @return a String which represents state
     */
    public String getState() { return address.getState(); }

    /** method to return the zip code of the address entry
     *
     * @return an int which represents zip code
     */
    public int getZip() { return address.getZip(); }

    /** method to return the phone number of the address entry
     *
     * @return a String which represents phone number
     */
    public String getPhone() { return phone; }

    /** method to return the email address of the address entry
     *
     * @return a String which represents email
     */
    public String getEmail() { return email; }

    /**
     * method to return the id of the address entry
     * @return an Integer which represents the id
     */
    public Integer getId() {
        return id;
    }
}
