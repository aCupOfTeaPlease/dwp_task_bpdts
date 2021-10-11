import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    /**
     * Kindly note at this stage I am unsure how to properly
     * write a test that will deal with throw exceptions in the method being tested.
     * I am aware that tests should use edge cases and erroneous cases as well as valid data.
     * This is an area of JUnit I intend to research. It is on my to do list! :)
     * get all users within 50 miles of London
     */

    @Test
    void usersTest_1() {
        List<User> users = Application.users();
        assertEquals(3, users.size());
    }

    /**
     * get all users by city name
     */

    @Test
    void userTest_1() {
        List<User> users = Application.users("London");
        assertEquals(6, users.size());

    }

    @Test
    void userTest_2() {
        List<User> users = Application.users("Rochester");
        assertEquals(1, users.size());
    }

    @Test
    void userTest_3() {
        List<User> users = Application.users("FakeCity");
        assertEquals(0, users.size());
    }

    /**
     * getUserCityById Test
     */

    @Test
    void getUserCityByIdTest_1() {
        String testCity = Application.getUserCityById(20);
        assertEquals("Cinagrog Girang", testCity);
    }

    @Test
    void getUserCityByIdTest_2() {
        String testCity = Application.getUserCityById(1);
        assertEquals("Kax", testCity);
    }

    @Test
    void getUserCityByIdTest_3() {
        String testCity = Application.getUserCityById(1000);
        assertEquals("Dhangarhi", testCity);
    }

}