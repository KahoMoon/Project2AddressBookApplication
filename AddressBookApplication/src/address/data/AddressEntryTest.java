package address.data;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kaho Moon
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to test the AddressEntry class
 */
public class AddressEntryTest {

    /**
     * Test method for {@link AddressEntry#AddressEntry()}
     */
    @Test
    public void testAddressEntry() {
        AddressEntry ae = new AddressEntry("John", "Doe", "street", "city", "state", 12345,
                "email@gmail.com", "123-456-7891", 35);
        String expected = "John Doe\n   street\n   city, state 12345\n   email@gmail.com\n   123-456-7891\n   35";
        assertEquals(expected, ae.toString());
    }

    /**
     * Test method for {@link AddressEntry#toString()}.
     */
    @Test
    public void testToString() {
        AddressEntry ae = new AddressEntry("John", "Doe", "street", "city", "state", 12345,
                                           "email@gmail.com", "123-456-7891", 100);
        String expected = "John Doe\n   street\n   city, state 12345\n   email@gmail.com\n   123-456-7891\n   100";
        assertEquals(expected, ae.toString());
    }

    /**
     * Test method for {@link AddressEntry#compareTo(AddressEntry)}.
     */
    @Test
    public void testCompareTo() {
        AddressEntry ae1 = new AddressEntry("John", "Doe", "street", "city", "state", 12345,
                "email@gmail.com", "123-456-7891", 1);

        AddressEntry ae2 = new AddressEntry("John", "Doe", "street", "city", "state", 12345,
                "email@gmail.com", "123-456-7891", 1);

        AddressEntry ae3 = new AddressEntry("John", "Dof", "street", "city", "state", 12345,
                "email@gmail.com", "123-456-7891", 3);

        AddressEntry ae4 = new AddressEntry("John", "A", "street", "city", "state", 12345,
                "email@gmail.com", "123-456-7891", 4);

        assertEquals(ae1.compareTo(ae2), 0);
        assertTrue(ae1.compareTo(ae3) < 0);
        assertTrue(ae1.compareTo(ae4) > 0);
    }

    /**
     * Test method for {@link AddressEntry#getFirstName()}
     *                 {@link AddressEntry#getLastName()}
     *                 {@link AddressEntry#getCity()}
     *                 {@link AddressEntry#getState()}
     *                 {@link AddressEntry#getZip()}
     *                 {@link AddressEntry#getStreet()}
     *                 {@link AddressEntry#getEmail()}
     *                 {@link AddressEntry#getPhone()}
     *                 {@link AddressEntry#setFirstName(java.lang.String)}
     *                 {@link AddressEntry#setLastName(java.lang.String)}
     *                 {@link AddressEntry#setCity(java.lang.String)}
     *                 {@link AddressEntry#setState(java.lang.String)}
     *                 {@link AddressEntry#setZip(int)}
     *                 {@link AddressEntry#setStreet(java.lang.String)}
     *                 {@link AddressEntry#setEmail(java.lang.String)}
     *                 {@link AddressEntry#setPhone(java.lang.String)}
     */
    @Test
    public void testGetSet() {
        AddressEntry ae = new AddressEntry();
        ae.setFirstName("John");
        ae.setLastName("Purcell");
        ae.setCity("Livermore");
        ae.setState("HI");
        ae.setZip(12345);
        ae.setStreet("Singletree");
        ae.setEmail("fake@yahoo.com");
        ae.setPhone("123-456-7891");
        ae.setId(12345);

        assertEquals("John", ae.getFirstName());
        assertEquals("Purcell", ae.getLastName());
        assertEquals("Livermore", ae.getCity());
        assertEquals("HI", ae.getState());
        assertEquals(12345, ae.getZip());
        assertEquals("Singletree", ae.getStreet());
        assertEquals("fake@yahoo.com", ae.getEmail());
        assertEquals("123-456-7891", ae.getPhone());
        assertEquals(12345, ae.getId());
    }

    @AfterAll
    static void cleanup() throws SQLException {
        AddressBook temp = new AddressBook();
        temp.clear();
    }
}