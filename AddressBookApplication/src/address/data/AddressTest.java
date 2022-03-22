package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kaho Moon
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to test the Address class
 */
class AddressTest {

    /**
     * Test method for {@link Address#toString()}
     */
    @Test
    void testToString() {
        Address a = new Address("street", "city", "state", 987);
        String expected = "street\n   city, state 987";
        assertEquals(expected, a.toString());
    }

    /**
     * Test method for {@link Address#setStreet(String)}
     *                 {@link Address#setCity(String)}
     *                 {@link Address#setState(String)}
     *                 {@link Address#setZip(int)}
     *                 {@link Address#getStreet()}
     *                 {@link Address#getCity()}
     *                 {@link Address#getState()}
     *                 {@link Address#getZip()}
     */
    @Test
    void testGetSet() {
        Address a = new Address();
        a.setStreet("street");
        a.setCity("city");
        a.setState("state");
        a.setZip(987);

        assertEquals("street", a.getStreet());
        assertEquals("city", a.getCity());
        assertEquals("state", a.getState());
        assertEquals(987, a.getZip());
    }
}