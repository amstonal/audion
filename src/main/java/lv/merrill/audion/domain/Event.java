package lv.merrill.audion.domain;

public class Event {
    public Event(String latitude, String longitude, String type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
    }

    public String latitude;
    public String longitude;
    public String type;

    public boolean nearTo(String latitude, String longitude) {
        //Je sais pas comment savoir est-ce que c'est proche, donc j'improvise.
        int latitudeLength = latitude.length();
        int longitudeLength = longitude.length();

        String truncatedLatitude = this.latitude.substring(0, latitudeLength);
        String truncatedLongitude = this.longitude.substring(0, longitudeLength);
        return latitude.equals(truncatedLatitude) && longitude.equals(truncatedLongitude);
    }

    @Override
    public String toString() {
        return "Event{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
