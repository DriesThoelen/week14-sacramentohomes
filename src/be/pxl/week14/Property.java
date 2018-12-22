package be.pxl.week14;

import java.time.ZonedDateTime;

public class Property implements Comparable<Property> {
    private String street;
    private String city;
    private String zip;
    private String state;
    private int beds;
    private int baths;
    private int sq_ft;
    private String type;
    private ZonedDateTime saleDate;
    private Double price;
    private Double latitude;
    private Double longitude;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getSq_ft() {
        return sq_ft;
    }

    public void setSq_ft(int sq_ft) {
        this.sq_ft = sq_ft;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ZonedDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(ZonedDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return
                "Street: " + street + "\n"
                + "City: " + city + "\n"
                + "Zip: " + zip + "\n"
                + "State: " + state + "\n"
                + "Beds: " + beds + "\n"
                + "Baths: " + baths + "\n"
                + "Sq ft: " + sq_ft + "\n"
                + "Type: " + type + "\n"
                + "Sale Date: " + saleDate.format(Properties.FORMAT) + "\n"
                + "Price: " + price + "\n"
                + "Latitude: " + latitude + "\n"
                + "Longitude: " + longitude + "\n";
    }

    @Override
    public int compareTo(Property p) {
        return p.getSaleDate().compareTo(getSaleDate());
    }
}
