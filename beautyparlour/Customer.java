/**
 * @(#)Customer.java
 *
 * This class defines the relevant information for a customer.
 * Contains the member ID and date member since.
 * This class is a subclass which inherits from a superclass (Person) class.
 * 
 *
 * @version 1.00 2017/7/31
 */
//Imports
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer extends Person {
    
    //Data fields declaration
    private String memberID;
    private Date dateMemberSince;
    private static int customerCount;

    //No-args constructor
    public Customer() {
    }
    
    //Parameterised constructor
    public Customer(String memberID, Name name, Date dateMemberSince, String contactNum, Address address) {
        super(name, address, contactNum);
        this.memberID = memberID;
        this.dateMemberSince = dateMemberSince;
    	customerCount++;
    }
    
    //Accessors - Getters
    public String getMemberID(){
    	return memberID;
    }
    
    public Date getDateMemberSince(){
    	return dateMemberSince;
    }
    
    public static int getCustomerCount(){
    	return customerCount;
    }
        
    //Mutators - Setters
    public void setMemberID(String memberID){
    	this.memberID = memberID;
    }
    
    public void setDateMemberSince(Date dateMemberSince){
    	this.dateMemberSince = dateMemberSince;
    }

    //Registration for Customer
    public static ArrayList registerCustomer(ArrayList<Customer> cust) {	
        Scanner sc = new Scanner(System.in);

        //Local variable declaration
        String fname, lname, street, city, state, contactNum;
        int zip = 0, numOfCust = 0, i = 0, newCust = 0;
        boolean inputValid = false, inputValid1 = false, custExist = false;

        while(!inputValid1) {
            try {
                System.out.print("Enter number of customer to register: ");
                numOfCust = sc.nextInt();
                inputValid1 = true;			
            } catch (InputMismatchException e) {
                System.out.println("Invalid input data type, please input only number.\n");			
                sc.nextLine();
            }
        }

        //Take to newline
        sc.nextLine();

        for(i = 0; i < numOfCust; ++i) {
            System.out.println("\nCustomer No. " + (i+1));            
            System.out.println("------------------");

            //Customer First Name
            System.out.print("Enter customer first name: ");
            fname = sc.nextLine();

            while(!fname.matches("^([A-Za-z ]){3,}$")) {
                System.out.println("Invalid input data type, please input only alphabetic.\n");
                System.out.print("Enter customer first name: ");
                fname = sc.nextLine();
            }

            //Customer Last Name
            System.out.print("Enter customer last name : ");
            lname = sc.nextLine();

            while(!lname.matches("^([A-Za-z ]){3,}$")) {
                System.out.println("Invalid input data type, please input only alphabetic.\n");
                System.out.print("Enter customer last name : ");
                lname = sc.nextLine();
            }

            //Street Address
            System.out.print("Enter street address     : ");
            street = sc.nextLine();
            
            //Zip
            while(!inputValid) {
                try {
                    System.out.print("Enter zip                : ");
                    zip = sc.nextInt();
                    inputValid = true;			
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input data type, please input only numbers.\n");			
                    sc.nextLine();
                }
            }
            
            //Take to newline
            sc.nextLine();
            
            //City
            System.out.print("Enter city               : ");
            city = sc.nextLine();

            while(!city.matches("^([A-Za-z ]){3,}$")) {
                System.out.println("Invalid input data type, please enter only alphabetic.\n");
                System.out.print("Enter city               : ");
                city = sc.nextLine();
            }

            //State
            System.out.print("Enter state              : ");
            state = sc.nextLine();

            while(!state.matches("^([A-Za-z ]){3,}$")) {
                System.out.println("Invalid input data type, please input only alphabetic.\n");
                System.out.print("Enter state              : ");
                state = sc.nextLine();
            }

            //Customer contact number
            System.out.print("Enter contact number     : ");
            contactNum = sc.next();
            sc.nextLine();

            while(!contactNum.matches("^\\d{3}\\-\\d{7,8}$")) {
                System.out.println("Invalid format or data type, please ensure to input the correct format and data type. e.g. XXX-XXXXXXX\n");
                System.out.print("Enter contact number     : ");
                contactNum = sc.next();
                sc.nextLine();		
            }
            
            //Reset the flag and add new customer
            inputValid = inputValid1 = false;
            cust.add(new Customer(String.format("CUST%04d", cust.size()+1), new Name(fname, lname), new Date(), contactNum, new Address(street, zip, city, state)));		
            ++newCust;      //Counter to count how many new customer member added
            
            //Check if the new member is an existing member
            custExist = cust.get(cust.size()-1).equals(cust.get(cust.size()-1), cust);
            if(custExist) {
                cust.remove(cust.size()-1);     //Remove the latest customer if its an existing member
                System.out.println("Cannot be added into the system. Same customer already existed in the system.\n");
                --newCust;      //Decrement the counter if customer member existed
            }
        }
        
        //Output message
        if(newCust == 0) 
            System.out.println("No new customer member added into the system.\n");
        else
            System.out.println("\n" + newCust + " customer has been successfully added into the system.\n");
        
        //Return the latest array
        return cust;
    }
    
    //toString() method
    public String toString(){
        //Creating SimpleDateFormat Object to set the date format
        SimpleDateFormat ft = new SimpleDateFormat("dd-MMM-yyyy");
    	return String.format("%-10s \t %s%-10s\n", memberID, super.toString(), ft.format(dateMemberSince));
    }
  
    //Equals method to check the same customer existed or not
    public boolean equals(Object o, ArrayList<Customer> customer) {
        ArrayList<Customer> cust = customer;
        boolean sameCustomer = false;
        
        //Check for same customer name
        for(int i = 0; i < cust.size()-1; i++) {
            if((((Customer)o).getName()).equals(cust.get(i).getName()) && (((Customer)o).getAddress()).equals(cust.get(i).getAddress()) && (((Customer)o).getContactNum()).equals(cust.get(i).getContactNum()))
                sameCustomer = true;    //Check if the same customer existed 
        }

        //Return true if the same customer name exits
        if(sameCustomer) 
            return true;
        else
            return false;
    }
}