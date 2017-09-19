/**
 * @(#)Address.java
 *
 * Address class which stores the relevant information of address for a person.
 * Contains street, zip, city and state for the address information. 
 * This class is the Aggregated class for the Person class.
 * 
 * @version 1.00 2017/7/25
 * @version 2.00 2017/9/19
 * 
 */

public class Address {

    //Data fields
    private String street;
    private int zip;
    private String city;
    private String state;

    //No-args constructor
    public Address() {
    }

    //Parameterised constructor
    public Address(String street, int zip, String city, String state) {
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.state = state;
    }

    //Accessors - Getters
    public String getStreet() {
        return street;
    }

    public int getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    //Mutators - Setters
    public void setStreet(String street) {
        this.street = street;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }	

    public void setCity(String city) {
        this.city = city;
    }	

    public void setState(String state) {
        this.state = state;
    }
    
    //getFullAddresss to return the full address
    //e.g. - "No.82, Jalan Penampang, Dongongon, 88200, Kota Kinabalu, Sabah" 	
    public String getFullAddress() {
        return street + ", " + zip + ", " + city + ", " + state;
    }
}