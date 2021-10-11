public class Location {

    private static final double LONDON_LATITUDE = 51.5073423d;
    private static final double LONDON_LONGITUDE = -0.1277515d;
    private static final double DISTANCE_TO_LONDON = 50.0000000d;
    private static final double LONDON_LATITUDE_RAD = Math.toRadians(LONDON_LATITUDE);
    private static final double LONDON_LATITUDE_RAD_COS = Math.cos(LONDON_LATITUDE_RAD);
    private static final double EARTH_RADIUS_MILES = 6371 * 0.6213712;

    public static double distanceFromLondon(double targetLatitude, double targetLongitude) {
        double diffLat = Math.toRadians(targetLatitude - LONDON_LATITUDE);
        double diffLong = Math.toRadians(targetLongitude - LONDON_LONGITUDE);
        double targetLatRad = Math.toRadians(targetLatitude);
        double a = Math.pow(Math.sin(diffLat / 2), 2) + Math.pow(Math.sin(diffLong / 2), 2) * LONDON_LATITUDE_RAD_COS * Math.cos(targetLatRad);
        double c = 2 * Math.asin(Math.sqrt(a));
        c *= EARTH_RADIUS_MILES;

        return c;
    }

    public static boolean checkDistance(String targetLatitude, String targetLongitude) {
        double lat = Double.parseDouble(targetLatitude.replace("\"", ""));
        double lon = Double.parseDouble(targetLongitude.replace("\"", ""));
        double distance = distanceFromLondon(lat, lon);

        return distance <= DISTANCE_TO_LONDON;
    }

}
