import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         * My solution finds 9 users and creates Java objects based on the JSON data, from;
         * https://bpdts-test-app.herokuapp.com/
         */

        long start = System.currentTimeMillis();
        List<User> results = new ArrayList<>();
        results.addAll(Application.users("London"));
        results.addAll(Application.users());

        System.out.printf("Total users found: %s\nTime taken %s(ms)\n\n", results.size(), System.currentTimeMillis() - start);

        for (User user : results) {
            System.out.println(user);
        }

    }
}
