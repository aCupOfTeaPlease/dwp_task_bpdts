import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Application API to mirror the API @ https://bpdts-test-app.herokuapp.com/
 * Thus the method names match. Additional helper methods designed to help my solution.
 */

public class Application {

    private static final String ALL_USERS_ULR = "https://bpdts-test-app.herokuapp.com/users";
    private static final String CITY_USERS_URL = "https://bpdts-test-app.herokuapp.com/city/%s/users";
    private static final String ID_USER_URL = "https://bpdts-test-app.herokuapp.com/user/%s";

    /**
     * Get all users
     */
    public static List<User> users() {

        List<User> results = new ArrayList<>();

        try {
            URL url = new URL(ALL_USERS_ULR);
            try (InputStream is = url.openStream();
                 JsonReader rdr = Json.createReader(is)) {

                JsonArray users = rdr.readArray();

                for (int i = 0; i < users.size(); i++) {
                    JsonObject jsonObject = users.getJsonObject(i);
                    String latNumber = jsonObject.get("latitude").toString();
                    String lonNumber = jsonObject.get("longitude").toString();
                    if (Location.checkDistance(latNumber, lonNumber)) {
                        results.add(new User(jsonObject));
                    }
                }

                return results;

            } catch (ClassCastException | IOException classCastException) {
                classCastException.printStackTrace();
            }
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }

        return null;
    }

    /**
     * Get all users for a given city
     */
    public static List<User> users(String city) {
        List<User> results = new ArrayList<>();
        String cityURL = String.format(CITY_USERS_URL, city);

        try {
            URL url = new URL(cityURL);
            try (InputStream is = url.openStream();
                 JsonReader rdr = Json.createReader(is)) {

                JsonArray users = rdr.readArray();
                for (int i = 0; i < users.size(); i++) {
                    JsonObject jsonObject = users.getJsonObject(i);
                    results.add(new User(jsonObject));
                }

                return results;

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }

        return null;
    }

    /**
     * Get user for a given id
     */
    public static User user(int id) {
        String cityURL = String.format(ID_USER_URL, id);

        try {
            URL url = new URL(cityURL);
            try (InputStream is = url.openStream();
                 JsonReader rdr = Json.createReader(is)) {

                return new User(rdr.readObject());

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }

        return null;
    }

    /**
     * Get user city via id
     */
    static String getUserCityById(int id) {
        User temp = Application.user(id);
        if (temp != null) {
            return temp.getCity();
        } else {
            return "DEFAULT";
        }
    }

}
