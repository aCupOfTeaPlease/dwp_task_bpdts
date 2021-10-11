import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    /**
     * Kindly note at this stage I am unsure how to properly
     * write a test that will deal with throw exceptions in the method being tested.
     * I am aware that tests should use edge cases and erroneous cases as well as valid data.
     * This is an area of JUnit I intend to research. It is on my to do list! :)
     */

    @Test
    void cityLookUpTest_1() {
        String testCity = new User().cityLookUp(20);
        assertEquals("Cinagrog Girang", testCity);
    }

    @Test
    void cityLookUpTest_2() {
        String testCity = new User().cityLookUp(1);
        assertEquals("Kax", testCity);
    }

    @Test
    void cityLookUpTest_3() {
        String testCity = new User().cityLookUp(1000);
        assertEquals("Dhangarhi", testCity);
    }

}