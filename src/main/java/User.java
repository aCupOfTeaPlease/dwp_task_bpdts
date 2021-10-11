import javax.json.JsonObject;

public class User {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String ip_address;
    private double latitude;
    private double longitude;
    private String city;

    public User() {
    }

    public User(JsonObject user) {
        this.id = user.getInt("id");
        this.first_name = user.getString("first_name").replace("\"", "");
        this.last_name = user.getString("last_name").replace("\"", "");
        this.email = user.getString("email").replace("\"", "");
        this.ip_address = user.getString("ip_address").replace("\"", "");

        String latNumber = user.get("latitude").toString().replace("\"", "");
        String lonNumber = user.get("longitude").toString().replace("\"", "");

        this.latitude = Double.parseDouble(latNumber);
        this.longitude = Double.parseDouble(lonNumber);

        if (user.get("city") == null) {
            this.city = Application.getUserCityById(id);
        } else {
            this.city = user.getString("city").replace("\"", "");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    protected String cityLookUp(int id) {
        return Application.getUserCityById(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", ip_address='" + ip_address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", city='" + city + '\'' +
                '}';
    }
}
