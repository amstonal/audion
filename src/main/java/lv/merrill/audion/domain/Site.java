package lv.merrill.audion.domain;

import java.util.Objects;

public class Site {

    private String latitude;
    private String longitude;
    private String name;
    private int impressions;
    private int clicks;

    public Site(String name, String latitude, String longitude, int impressions, int clicks) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.impressions = impressions;
        this.clicks = clicks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Site site = (Site) o;
        return impressions == site.impressions && clicks == site.clicks && Objects.equals(latitude, site.latitude) && Objects.equals(longitude, site.longitude) && Objects.equals(name, site.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, name, impressions, clicks);
    }

    @Override
    public String toString() {
        return "Site{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", name='" + name + '\'' +
                ", impressions=" + impressions +
                ", clicks=" + clicks +
                '}';
    }
}
