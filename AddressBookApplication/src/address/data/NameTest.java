package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kaho Moon
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to test the Name class
 */
class NameTest {

    /**
     * Test method for {@link Name#toString()}
     */
    @Test
    void testToString() {
        Name n = new Name("first", "last");
        String expected = "first last";
        assertEquals(expected, n.toString());
    }

    /**
     * Test method for {@link Name#setFirstName(String)}
     *                 {@link Name#setLastName(String)}
     *                 {@link Name#getFirstName()}
     *                 {@link Name#getLastName()}
     */
    @Test
    void testGetSet() {
        Name n = new Name();
        n.setFirstName("first");
        n.setLastName("last");

        assertEquals("first", n.getFirstName());
        assertEquals("last", n.getLastName());
    }
}