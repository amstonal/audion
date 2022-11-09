package lv.merrill.audion.domain;

public class Location {

    public Location(String name, String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public String latitude;
    public String longitude;

    public final String name;

    @Override
    public String toString() {
        return "Location{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
