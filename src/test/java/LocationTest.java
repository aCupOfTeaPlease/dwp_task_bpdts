import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTest {

    private static final double LONDON_LATITUDE = 51.5073423d;
    private static final double LONDON_LONGITUDE = -0.1277515d;

    @Test
    void distanceFromLondonTest_1() {
        double distance = Location.distanceFromLondon(LONDON_LATITUDE, LONDON_LONGITUDE);
        assertEquals("0.000", String.format("%.3f", distance));
    }

    @Test
    void distanceFromLondonTest_2() {
        double distance = Location.distanceFromLondon(-0.1277515d, -0.1277515d);
        assertEquals("3567.640", String.format("%.3f", distance));
    }

    @Test
    void distanceFromLondonTest_3() {
        double distance = Location.distanceFromLondon(12.1215544d, 52.1144515d);
        assertEquals("3974.384", String.format("%.3f", distance));
    }

    @Test
    void checkDistanceTest_1() {
        boolean result = Location.checkDistance(String.valueOf(LONDON_LATITUDE), String.valueOf(LONDON_LONGITUDE));
        assertEquals(true, result);
    }

    @Test
    void checkDistanceTest_2() {
        boolean result = Location.checkDistance(String.valueOf(0.000), String.valueOf(0.000));
        assertEquals(false, result);
    }

    @Test
    void checkDistanceTest_3() {
        boolean result = Location.checkDistance(String.valueOf(12.1215544d), String.valueOf(52.1144515d));
        assertEquals(false, result);
    }

    @Test
    void checkDistanceTest_4() {
        boolean result = Location.checkDistance(String.valueOf(34.003135d), String.valueOf(-117.7228641d));
        assertEquals(false, result);
    }

}