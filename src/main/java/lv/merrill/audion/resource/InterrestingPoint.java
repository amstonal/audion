package lv.merrill.audion.resource;

import lv.merrill.audion.domain.Location;

public class InterrestingPoint {
    public String name;
    public String latitude;
    public String longitude;

    public Location asLocation() {
        return new Location(name, latitude, longitude);
    }
}
