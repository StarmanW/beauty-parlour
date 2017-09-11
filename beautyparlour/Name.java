/**
 * @(#)Person.java
 *
 * This class defines the name information for the Person class.
 * It is a composition relationship with the Person class. (Exclusive has-a)
 * Each person only has a unique name.
 *
 *
 * @version 1.00 2017/7/25
 */

public class Name {

    //Data fields
    private String firstName;
    private String lastName;

    //No-args constructor
    public Name() {
    }

    //Parameterised constructor
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Accessors - Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //Mutators - Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }	

    //e.g "Samuel Wong"	
    public String getFullName() {
        return firstName + " " + lastName;
    }
}