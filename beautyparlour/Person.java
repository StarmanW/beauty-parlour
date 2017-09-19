/**
 * @(#)Person.java
 *
 * The superclass for both Customer and Beautician class.
 * It is also the aggregating class for the Address class and has-a 
 * composition relationship with the Name class.
 *
 * @version 1.00 2017/7/25
 * @version 2.00 2017/9/19
 * 
 */

public class Person {

    //Data fields
    protected Name name;
    protected Address address;
    protected String contactNum;

    //No-args constructor
    public Person() {
    }

    //Parameterised constructor
    public Person(Name name, Address address, String contactNum) {
        this.name = name;
        this.address = address;
        this.contactNum = contactNum;
    }

    //toString methods
    //e.g. - "Name \t Contact Number \t Address"
    public String toString() {
        return String.format("%-20s \t %-10s \t %-80s", name.getFullName(), contactNum, address.getFullAddress());
    }
}