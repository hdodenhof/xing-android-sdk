package de.hdodenhof.xingapi.models;

/**
 * Created by alfdev on 12/08/15.
 */
public class GeoCode {
    private int accuracy;
    private double latitude;
    private double longitude;

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
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
}
