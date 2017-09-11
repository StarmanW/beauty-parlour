/**
 * @(#)Person.java
 *
 * The superclass for both Customer and Beautician class.
 * It is also the aggregating class for the Address class and has-a 
 * composition relationship with the Name class.
 *
 * @version 1.00 2017/7/25
 */

public class Person {

    //Data fields
    private Name name;
    private Address address;
    private String contactNum;

    //No-args constructor
    public Person() {
    }

    //Parameterised constructor
    public Person(Name name, Address address, String contactNum) {
        this.name = name;
        this.address = address;
        this.contactNum = contactNum;
    }

    //Accessors - Getters
    public String getName() {
        return name.getFullName();
    }

    public String getAddress() {
        return address.getFullAddress();
    }

    public String getContactNum() {
        return contactNum;
    }

    //Mutators - Setters
    public void setName(Name name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }	

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    //toString methods
    //e.g. - "Name \t Contact Number \t Address"
    public String toString() {
        return String.format("%-20s \t %-10s \t %-80s", getName(), contactNum, getAddress());
    }
}