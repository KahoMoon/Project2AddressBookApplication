package address.data;

/**
 * @author Student Name
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to contain and provide data necessary to represent an
 * Address
 */
public class Address{

    /**
     * street
     */
    private String street;
    /**
     * city
     */
    private String city;
    /**
     * state
     */
    private String state;
    /**
     * zip code
     */
    private Integer zip;

    /**returns an Address where all fields are initialized to default values
     *
     */
    public Address() {
        street = "";
        city = "";
        state = "";
        zip = 0;
    }

    /**returns an Address initialized to the data in parameters provided
     *
     * @param street is a street
     * @param city is a city
     * @param state is a state
     * @param zip is a zip code
     */
    public Address(String street, String city, String state, int zip)
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * returns an Address initialized to the data the same data in the given Address instance
     * @param address is an instance of Address
     */
    public Address(Address address){

        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();

    }

    @Override
    public String toString() {
        return street + "\n   " + city + ", " + state + " " + zip;
    }

    /** method to set the street name of an address entry
     *
     * @param street is a street
     */
    public void setStreet(String street) { this.street = street; }

    /** method to set the city name of the address entry
     *
     * @param city is a city
     */
    public void setCity(String city) { this.city = city; }

    /** method to set the state name of the address entry
     *
     * @param state is a state
     */
    public void setState(String state) { this.state = state; }

    /** method to set the zip code of the address entry
     *
     * @param zip is a zip code
     */
    public void setZip(int zip) { this.zip = zip; }

    /** method to return the street name of the address entry
     *
     * @return a String which represents street
     */
    public String getStreet() { return street; }

    /** method to return the city name of the address entry
     *
     * @return a String which represents city
     */
    public String getCity() { return city; }

    /** method to return the state name of the address entry
     *
     * @return a String which represents state
     */
    public String getState() { return state; }

    /** method to return the zip code of the address entry
     *
     * @return an int which represents zip code
     */
    public Integer getZip() { return zip; }

}
