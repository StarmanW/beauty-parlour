/**
 * @(#)Package.java
 *
 * Class that defines the package offered. For this business, each of the 
 * package is a combination of two treatments.
 * Contains information such as package ID, package name, package price,
 * treatment 1 and treatment 2.
 * 
 * @version 1.00 2017/7/31
 * @version 2.00 2017/9/19
 */

//Imports
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Package {
    
    //Data fields declaration
    private String packageID;
    private String packageName;
    private double packagePrice;
    private Treatment treat1;
    private Treatment treat2;
    private static int packageCount;

    //No-args constructor
    public Package() {
    }
    
    //Parameterised constructor
    public Package(String packageID, String packageName, double packagePrice, Treatment treat1, Treatment treat2){
        this.packageID = packageID;
        this.packageName = packageName;
        this.packagePrice = packagePrice;
        this.treat1 = treat1;
        this.treat2 = treat2;
    	packageCount++;
    }

    //Accessors - Getters
    public String getPackageID(){
    	return packageID;
    }
    
    public String getPackageName(){
    	return packageName;
    }

    public double getPackagePrice(){
    	return packagePrice;
    }
   
    public Treatment getTreatment1() {
        return treat1;
    }
   
    public Treatment getTreatment2() {
        return treat2;
    }

    public static int getPackageCount() {
        return packageCount;
    }

    //Mutators - Setters
    public void setPackageID(String packageID){
    	this.packageID = packageID;
    }
    
    public void setPackageName(String packageName){
    	this.packageName = packageName;
    }

    public void setPackagePrice(double packagePrice){
    	this.packagePrice = packagePrice;
    }
   
    public void setTreatment1(Treatment treat1){
    	this.treat1 = treat1;
    }
   
    public void setTreatment2(Treatment treat2){
    	this.treat2 = treat2;
    }
  
    //Registration for Packages
    public static void registerPackage(ArrayList<Package> pack, ArrayList<Treatment> treat) {
        Scanner sc = new Scanner(System.in);
        
        //Local variable declaration
        boolean validPackageNum = false, validPriceInput = false, treat1Found = true, treat2Found = true;
        int numOfPackg = 0, i = 0, treat1Index = 0, treat2Index = 0, newPack = 0;
        double packPrice = 0.0;
        String packName, displayMenu, treatID1, treatID2;
        
        //Prompt for number of treatments to be added
        while(!validPackageNum) {
            try {
                System.out.print("Enter number of package to add: ");
                numOfPackg = sc.nextInt();
                validPackageNum = true;			
            } catch (InputMismatchException e) {
                System.out.println("Invalid input data type, please input only number.\n");			
                sc.nextLine();
            }
        }       

        //Move to newline
        sc.nextLine();
   
        for(i =0; i < numOfPackg; i++) {
            System.out.println("\nPackage No. " + (i+1));
            System.out.println("---------------------");
            
            //New package name
            System.out.print("Enter new package name       : ");
            packName = sc.nextLine();

            //New package price
            while(!validPriceInput) {
               try {
                    System.out.print("Enter new package price      : RM ");
                    packPrice = sc.nextDouble(); 
                    validPriceInput = true;			
               } catch (InputMismatchException e) {
                    System.out.println("Invalid input data type, please input only number. (RM 50.00)\n");			
                    sc.nextLine();
               }
            }

            //Prompt user to display the treatments menu
            System.out.print("Display treatments menu? (Y/N) : ");
            displayMenu = sc.next();
            sc.nextLine();

            //Input validation
            while(!displayMenu.matches("^(Y|N|y|n)$")) {
                System.out.println("Invalid input, please try again with Y or N only.\n");            
                System.out.print("Display treatments menu? (Y/N) : ");
                displayMenu = sc.next();
                sc.nextLine();
            }
            
            //Display the treatments Menu if user's choice is "Y" 
            if(displayMenu.equals("Y") || displayMenu.equals("y")) {
                Utility.displayTreatments(treat);
            }
            
            //Prompt for treatment 1 to be included in the package
            do {
                //Treatment 1
                System.out.print("Enter treatment 1 ID : ");
                treatID1 = sc.next();
                sc.nextLine();

                //Treatment ID format check
                while(!treatID1.matches("^\\w{2}\\d{3}$")) {
                    System.out.println("Invalid treatment ID, please try again with proper ID (e.g. HC001).\n");
                    System.out.print("Enter treatment 1 ID : ");
                    treatID1 = sc.next();
                    sc.nextLine();                
                }

                //Get the index of the selected treatment
                for(int a = 0; a < treat.size(); a++) {
                    if((treat.get(a).getTreatmentCode()).equals(treatID1)) {
                        treat1Index = a;
                        treat1Found = true;
                        break;
                    } else
                        treat1Found = false;
                }
                
                if(!treat1Found)
                    System.out.println("Treatment not found in the system, please ensure the entered treat ID exists.\n");

            }while(!treat1Found);
            
            //Prompt for treatment 2 to be included in the package
            do {
                //Treatment 2
                System.out.print("Enter treatment 2 ID : ");
                treatID2 = sc.next();
                sc.nextLine();

                //Treatment ID format check
                while(!treatID1.matches("^\\w{2}\\d{3}$")) {
                    System.out.println("Invalid treatment ID, please try again with proper ID (e.g. HC001).\n");
                    System.out.print("Enter treatment 3 ID : ");
                    treatID2 = sc.next();
                    sc.nextLine();                
                }

                //Get the index of the selected treatment
                for(int b = 0; b< treat.size(); b++) {
                    if((treat.get(b).getTreatmentCode()).equals(treatID2)) {
                        treat2Index = b;
                        treat2Found = true;
                        break;
                    } else
                        treat2Found = false;
                }
                
                if(!treat2Found)
                    System.out.println("Treatment not found in the system, please ensure the entered treat ID exists.\n");                    

            } while(!treat2Found);
            
            //Resetting the flags
            validPackageNum = validPriceInput = treat1Found = treat2Found = false;
            pack.add(new Package(String.format("PK%03d", pack.size()+1), packName, packPrice, treat.get(treat1Index), treat.get(treat2Index)));
            ++newPack;      //Counter to count how many new package added
            
            //Check if the new package is an existing package
            if(pack.get(pack.size()-1).equals(pack)) {
                pack.remove(pack.size()-1);     //Remove the latest package if its an existing package
                System.out.println("\nCannot be added into the system. Same package already existed in the system.");
                --newPack;      //Decrement the counter if package existed
            }
        }
        
        //Output message
        if(newPack == 0) 
            System.out.println("No new package added into the system.\n");
        else
            System.out.println("\n" + newPack + " new package(s) has been successfully added into the system.\n");
    }
        
    
    //Method
    public String toString(){
    	return String.format("%-10s \t\t %-25s \t %-60s \t %-60s \t\t\t RM %,8.2f", packageID,packageName,treat1.getTreatmentDesc(), treat2.getTreatmentDesc(), packagePrice);
    }
    
    //Overriding equals()
    public boolean equals(ArrayList<Package> packg) {
        boolean samePakage = false;
        
        //Check for same package
        for(int i = 0; i < packg.size()-1; i++) {
            if(this.packageName.equals(packg.get(i).getPackageName()) && this.packagePrice == packg.get(i).getPackagePrice())
                samePakage = true;    //Check if the same treatment existed 
        }

        //Return true if the same package exits
        return samePakage;
    }
} 