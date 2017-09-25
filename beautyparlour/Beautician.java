/**
 * @(#)Beautician.java
 *
 * This class defines the relevant information for a beautician.
 * Contains the beautician ID, date joined and specialization.
 * This class is a subclass which inherits from a superclass (Person) class.
 * 
 * @version 1.00 2017/7/25
 * @version 2.00 2017/9/19
 */

//Imports
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Beautician extends Person {

    //Data fields declaration
    private String beauticianID;
    private Date dateJoined;
    private String specialization;
    private static int beauticianCount;

    //Creating SimpleDateFormat Object to set the date format
    SimpleDateFormat ft = new SimpleDateFormat("dd-MMM-yyyy");

    //No-args constructor		
    public Beautician() {
    }
    
    //Parameterised constructor
    public Beautician(Name name, Address address, String contactNum, String beauticianID, Date dateJoined, String specialization) {
    	super(name, address, contactNum);
    	this.beauticianID = beauticianID;
    	this.dateJoined = dateJoined;
    	this.specialization = specialization;
    	beauticianCount++;
    }
    
    //Accessors - Getters
    public String getBeauticianID() {
    	return beauticianID;
    }
    
    public Date getDateJoined() {
    	return dateJoined;
    }
    
    public String getSpecialization() {
    	return specialization;
    }
    
    public static int getBeauticianCount() {
    	return beauticianCount;
    }
    
    //Mutators - Setters
    public void setBeauticianID(String beauticianID) {
    	this.beauticianID = beauticianID;
    }
    
    public void setDateJoined(Date dateJoined) {
    	this.dateJoined = dateJoined;
    }
    
    public void setSpecialization(String specialization) {
    	this.specialization = specialization;
    }

    //Registration for Beautician
    public static void registerBeautician(ArrayList<Beautician> beau) {	
        Scanner sc = new Scanner(System.in);

        //Local variable declaration
        String fname, lname, street, city, state, contactNum, specialization;
        int zip = 0, numOfBeau = 0, i = 0, newBeau = 0;
        boolean inputValid = false, inputValid1 = false;
        
         while(!inputValid1) {
            try {
                System.out.print("Enter number of beautician to add (0 for return back to menu): ");
                numOfBeau = sc.nextInt();
                inputValid1 = true;			
            } catch (InputMismatchException e) {
                System.out.println("Invalid input data type, please input only number.\n");			
                sc.nextLine();
            }
        }
        
        if(numOfBeau == 0) {return;}
        
        for(i = 0; i < numOfBeau; ++i) {
            
            System.out.println("\nBeautician No. " + (i+1));            
            System.out.println("---------------------");
            
            //Take to newline
            sc.nextLine();
            
            //Beautician First Name
            System.out.print("Enter beautician first name: ");
            fname = sc.nextLine();

            while(!fname.matches("^([A-Za-z ]){3,}$")) {
                System.out.println("Invalid input data type, please input only alphabetic.\n");
                System.out.print("Enter beautician first name: ");
                fname = sc.nextLine();
            }

            //Beautician Last Name
            System.out.print("Enter beautician last name : ");
            lname = sc.nextLine();

            while(!lname.matches("^([A-Za-z ]){3,}$")) {
                System.out.println("Invalid input data type, please input only alphabetic.\n");
                System.out.print("Enter beautician last name : ");
                lname = sc.nextLine();
            }

            //Street Address
            System.out.print("Enter street address       : ");
            street = sc.nextLine();
            
            //Zip
            while(!inputValid) {
                try {
                    System.out.print("Enter zip                  : ");
                    zip = sc.nextInt();
                    inputValid = true;			
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input data type, please input only alphabetic.\n");			
                    sc.nextLine();
                }
            }
            
            //Take to newline
            sc.nextLine();
            
            //city
            System.out.print("Enter city                 : ");
            city = sc.nextLine();

            while(!city.matches("^([A-Za-z ]){3,}$")) {
                System.out.println("Invalid input data type, please enter only alphabetic.\n");
                System.out.print("Enter city                 : ");
                city = sc.nextLine();
            }

            //state
            System.out.print("Enter state                : ");
            state = sc.nextLine();

            while(!state.matches("^([A-Za-z ]){3,}$")) {
                System.out.println("Invalid input data type, please input only alphabetic.\n");
                System.out.print("Enter state                : ");
                state = sc.nextLine();
            }

            //Beautician contact number
            System.out.print("Enter contact number       : ");
            contactNum = sc.nextLine();

            while(!contactNum.matches("^\\d{3}\\-\\d{7,8}$")) {
                System.out.println("Invalid format or data type, please ensure to input the correct format and data type. e.g. - 016-8887469\n");
                System.out.print("Enter contact number       : ");
                contactNum = sc.nextLine();
            }
                      
            //Beautician specialization
            System.out.print("Enter specialization       : ");
            specialization = sc.nextLine();

            while(!specialization.matches("^([A-Za-z ]){3,}$")) {
                System.out.println("Invalid input data type, please input only alphabetic.\n");
                System.out.print("Enter specialization       : ");
                specialization = sc.nextLine();
            }
            
            //Reset the flag and add new beautician
            inputValid = inputValid1 = false;
            beau.add(new Beautician(new Name(fname, lname), new Address(street, zip, city, state), contactNum, String.format("BEAU%03d", beau.size()+1), new Date(), specialization));		
            ++newBeau;
            
            //Check if the new member is an existing member
            if(beau.get(beau.size()-1).equals(beau)) {
                beau.remove(beau.size()-1);     //Remove the latest customer if its an existing member
                System.out.println("\nCannot be added into the system. Same beautician already existed in the system.");
                --newBeau;
            }
        }
   
        //Output message
        if(newBeau == 0) 
            System.out.println("No new beautician added into the system.\n");
        else
            System.out.println("\n" + newBeau + " beauticians has been successfully added into the system.\n"); 
    }

    //toString method
    public String toString() {
    	return String.format("%10s \t %-15s \t %-10s \t %-25s \t %-10s \t %-60s\n", beauticianID, name.getFullName(), ft.format(dateJoined), specialization, contactNum, address.getFullAddress());
    }
    
       
    //Equals method to check the same customer existed or not
    public boolean equals(ArrayList<Beautician> beau) {
        boolean sameBeautician = false;
        
        //Check for same customer name
        for(int i = 0; i < beau.size()-1; i++) {
            if(name.getFullName().equals(beau.get(i).name.getFullName()) && (address.getFullAddress().equals(beau.get(i).address.getFullAddress())) && (contactNum.equals(beau.get(i).contactNum))) {
                sameBeautician = true;    //Check if the same customer existed 
            }
        }

        //Return true if the same customer name exits
        return sameBeautician;
    }
}