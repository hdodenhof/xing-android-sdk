package de.hdodenhof.xingapi.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alfdev on 12/08/15.
 */
public class Location {
    @SerializedName(value = "geo_code")
    private GeoCode geoCode;
    private String city;
    private String country;
    private String street;
    private String zip_code;
    private String region;

    public GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
