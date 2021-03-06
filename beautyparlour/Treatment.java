/**
 * @(#)Treatment.java
 *
 * Contains all the relevant information about the treatments such as
 * treatment code, treatment description, treatment price and free trials flag
 * to indicate whether the treatments is available for free trials or not.
 *
 * @version 1.00 2017/7/31
 * @version 2.00 2017/9/19
 */

//Imports
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Treatment {
    
    //Data fields declaration
    private String treatmentCode;
    private String treatmentDesc;
    private double treatmentPrice;
    private boolean freeTrials;
    private static int treatmentCount;

    //No-args constructor
    public Treatment() {
    }
    
    //Parameterised constructor
    public Treatment(String treatmentCode,String treatmentDesc, double treatmentPrice, boolean freeTrials){
        this.treatmentCode = treatmentCode;
    	this.treatmentDesc = treatmentDesc;
    	this.treatmentPrice = treatmentPrice;
        this.freeTrials = freeTrials;
    	treatmentCount++;
    }

    //Accessors - Getters
    public String getTreatmentCode(){
    	return treatmentCode;
    }

    public String getTreatmentDesc(){
    	return treatmentDesc;
    }
    
    public double getTreatmentPrice(){
    	return treatmentPrice;
    }
    
    public String getFreeTrials() {
        if(freeTrials)
            return "Yes";
        else
            return "No";
    }
    
    public static int getTreatmentCount() {
        return treatmentCount;
    }

    //Mutators - Setters
    public void setTreatmentCode(String treatmentCode){
    	this.treatmentCode = treatmentCode;
    }
    
    public void setTreatmentDesc(String treatmentDesc){
    	this.treatmentDesc = treatmentDesc;
    }
    
    public void setTreatmentPrice(double treatmentPrice){
    	this.treatmentPrice = treatmentPrice;
    }
    
    public void setFreeTrials(boolean freeTrials) {
        this.freeTrials = freeTrials;
    }
    
    //Registration for Treatments
    public static void registerTreatments(ArrayList<Treatment> treat) {
        Scanner sc = new Scanner(System.in);
        
        //Local variable declaration
        boolean inputValid = false, invalidPrice = false, freeTrials = false;
        int numOfTreat = 0, i = 0, newTreat = 0;
        String serviceChoice, treatCode, treatName, treatDesc, servName, allowTrials;
        double treatPrice = 0.0;
        
        //Prompt for number of treatments to be added
        while(!inputValid) {
            try {
                System.out.print("Enter number of treatments to add (0 for return back to menu): ");
                numOfTreat = sc.nextInt();
                inputValid = true;			
            } catch (InputMismatchException e) {
                System.out.println("Invalid input data type, please input only number.\n");			
                sc.nextLine();
            }
        }       
        
        if(numOfTreat == 0) {return;}
        //Move to nextline
        sc.nextLine();

        //Loop to continue adding
        for(i = 0; i < numOfTreat; i++) {
            
            System.out.println("\nTreatment No. " + (i+1));
            System.out.println("---------------------");
            
            //Prompt for the new treatments
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                             "Choose the service for the treatment\n" + 
                             "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                             "1. Hair Care\n" +
                             "2. Skin Care\n" +
                             "3. Body Care\n" +
                             "4. Bridal Service\n" +
                             "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                             "Enter service choice: ");
            serviceChoice = sc.next();
            sc.nextLine();

            while(!serviceChoice.matches("^[1-4]{1}$")) {
                System.out.println("Invalid input choice, please try again with 1 to 4 as option.\n");
                System.out.print("Enter service choice: ");
                serviceChoice = sc.next();
                sc.nextLine();
            }
            
            //Check service type based on choice
            if(serviceChoice.equals("1")) {
                treatCode = "HC";
                servName = "Hair Care";
            } else if(serviceChoice.equals("2")) {
                treatCode = "SC";
                servName = "Skin Care";
            } else if(serviceChoice.equals("3")) {
                treatCode = "BC";            
                servName = "Body Care";
            } else {
                treatCode = "BS";
                servName = "Bridal Service";
            }
            
            //Treatment Description
            System.out.print("Enter new treatment description: ");
            treatDesc = sc.nextLine();
            
            //Treatment Price
            while(!invalidPrice) {
               try {
                    System.out.print("Enter new treatment price      : RM ");
                    treatPrice = sc.nextDouble();
                    invalidPrice = true;			
               } catch (InputMismatchException e) {
                    System.out.println("Invalid input data type, please input only number. (RM 50.00)\n");			
                    sc.nextLine();
               }
            }
            
            System.out.print("Does free trials of this new treatment available during the holidays? (Y/N): ");
            allowTrials = sc.next();
            sc.nextLine();

            while(!allowTrials.matches("^(Y|N|y|n)$")) {
                System.out.println("Invalid input, please try again only with \"Y\" or \"N\" as input.\n\n");            
                System.out.print("Does free trials of this new treatment available during the holidays? (Y/N): ");
                allowTrials = sc.next();
                sc.nextLine();
            }
                    
            //Assign the flag to freeTrials
            if(allowTrials.matches("^(Y|y)$")) {
                freeTrials = true;
            } else 
                freeTrials = false;
            
            //Reset the flag and add new customer
            inputValid = invalidPrice = false;
            treat.add(new Treatment(String.format(treatCode + "%03d", treat.size()+1), treatDesc, treatPrice, freeTrials));		
            ++newTreat;      //Counter to count how many new treatment added
            
            //Check if the new treatment is an existing treatment
            if(treat.get(treat.size()-1).equals(treat)) {
                treat.remove(treat.size()-1);     //Remove the latest treatment if its an existing treatment
                System.out.println("\nCannot be added into the system. Same treatment already existed in the system.");
                --newTreat;      //Decrement the counter if treatment existed
            }
        }
        
        //Output message
        if(newTreat == 0) 
            System.out.println("No new treatment added into the system.\n");
        else
            System.out.println("\n" + newTreat + " new treatment(s) has been successfully added into the system.\n");
    }
    
    //toString() Method
    public String toString(){
    	return String.format("%-15s \t %-55s \t RM %,10.2f \t\t %-6s", treatmentCode, treatmentDesc, treatmentPrice, this.getFreeTrials());
    }
    
    //Overriding equals
    public boolean equals(ArrayList<Treatment> treat) {
        boolean sameTreatment = false;
        
        //Check for same treatment
        for(int i = 0; i < treat.size()-1; i++) {
            if(this.treatmentDesc.equals(treat.get(i).getTreatmentDesc()) && this.treatmentPrice == treat.get(i).getTreatmentPrice() && this.getFreeTrials().equals(treat.get(i).getFreeTrials())) 
                sameTreatment = true;    //Check if the same treatment existed 
        }

        //Return true if the same treatment exits
        return sameTreatment;
    }
}