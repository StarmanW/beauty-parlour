/**
 * @(#)Service.java
 *
 * This class defines the relevant information/state of a service.
 * 
 * Contains serviceID, serviceDate, totalPrice, customer (object),
 * beautician (object), treatment/package (Using Object as declared type,
 * because a service could be either a treatment or a package) and freeTrials
 * to determine whether a particular service is a free trials or not.
 *
 * @version 1.00 2017/7/25
 * @version 2.00 2017/9/19
 */

//Imports
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Service {
    //Data fields
    private String serviceID;
    private Date serviceDate;
    private double totalPrice;
    private Customer customer;
    private Beautician beautician;
    private Object treatOrPackage;
    private boolean freeTrials;
    private static int serviceCount;
    
    //No-args constructor		
    public Service() {
    }
    
    //Parameterised constructor
    public Service(String serviceID, Date serviceDate, double totalPrice, Customer customer, Beautician beautician, Object treatOrPackage, boolean freeTrials) {
        this.serviceID = serviceID;
        this.serviceDate = serviceDate;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.beautician = beautician;
        this.freeTrials = freeTrials;
        this.treatOrPackage = treatOrPackage;
        serviceCount++;
    }
    
    //Getters - Accessors
    public String getServiceID() {
        return serviceID;
    }
    
    public Date getServiceDate() {
        return serviceDate;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public Beautician getBeautician() {
        return beautician;
    }

    public Object getTreatOrPackage() {
        return treatOrPackage;
    }

    public String getFreeTrials() {
        if(freeTrials)
            return "Yes";
        else
            return "No";
    }
    
    //Setters - Mutators
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
    
    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void setBeautician(Beautician beautician) {
        this.beautician = beautician;
    }

    public void setTreatOrPackage(Object treatOrPackage) {
        this.treatOrPackage = treatOrPackage;
    }

    public void setFreeTrials(boolean freeTrials) {
        this.freeTrials = freeTrials;
    }

    //Make new service
    public static void newService(ArrayList<Service> serv, ArrayList<Treatment> treat, ArrayList<Package> pack, ArrayList<Customer> cust, ArrayList<Beautician> beau) throws ParseException {
        //Creating necessary Objects to perform new service
        Scanner sc = new Scanner(System.in);
        Utility util = new Utility();
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MMM-yyy");

        
        //Local variables declaration
        String custID, serviceChoice = "", treatPackID, beauID, treatDate, treatPackgCodePrefix, freeTrials = "";
        boolean inputValid = false, custFound = false, validDate = false, beauFound = false, treatFound = false, packFound = false;
        double totalPrice = 0.0, discountRate = 0.0, extraMemberDiscountRate = 0.0;
        int numOfService = 0, refererCount = 0, custIndex = 0, beauIndex = 0, treatPackIndex = 0, i = 0;
        
        //Display the notes before registering any service
        Utility.newServiceNotes();
        
        //This is for demo purpose, to illustrate when the registration date is one of the specified holidays.
        String testHolidayDate = "25-DEC-2017";
        
        //Check if the dates are holidays or not
        if(ft.format(date).equals("28-JAN-2017") || ft.format(date).equals("25-JUN-2017") || ft.format(date).equals("19-OCT-2017") || testHolidayDate.equals("25-DEC-2017"))
            discountRate = 0.90;
        
        
        //Prompt for registration for free trials
        System.out.print("Register for Free-Trials? (Y/N): ");
        freeTrials = sc.next();
        sc.nextLine();

        while(!freeTrials.matches("^(Y|N|y|n)$")) {
            System.out.println("Invalid input choice, please try again with only \"Y\" or \"N\" as input.\n");
            System.out.print("Register for Free-Trials? (Y/N): ");
            freeTrials = sc.next();
            sc.nextLine();
        }
        
        //Prompt for the amount of service(s) to make register
        while(!inputValid) {
            try {
                System.out.print("Enter the numbers of service(s) to register: ");
                numOfService = sc.nextInt();
                inputValid = true;			
            } catch (InputMismatchException e) {
                System.out.println("Invalid input data type, please input only number.\n");			
                sc.nextLine();
            }
        }
        
        //Check how many customer are registering at once and set the refererCount to 1
        //To indicate that one customer brought extra members for registration.
        if((numOfService >= 6) || (numOfService > 6 && numOfService <= 11) || (numOfService >= 11) && freeTrials.matches("^(N|n)$"))
            refererCount = 1;
                
        //Take to newline
        sc.nextLine();

        //Loop the number of service to register
        for(i = 0; i < numOfService; i++) {
            
            //Service No.
            System.out.println("\nService No. " + (i+1));
            System.out.println("------------------");
            
            //Do-while loop to prompt customer ID and find the existing customer member
            do {
                //Prompt for the customer ID
                System.out.print("Enter customer ID (e.g. CUST0001): CUST");
                custID = sc.next();
                sc.nextLine();

                while(!custID.matches("^\\d{4}$")) {
                    System.out.println("Invalid customer ID format, please try again with the proper format.\n");
                    System.out.print("Enter customer ID: CUST");
                    custID = sc.next();
                    sc.nextLine();
                }

                //Loop through array to get the object of the entered customer ID
                for(int a = 0; a < cust.size(); a++) {
                    if((cust.get(a).getMemberID()).equals("CUST"+custID)) {
                        custIndex = a;
                        custFound = true;
                        break;
                    } else 
                        custFound = false;
                }
                
                //If customer is not found in the system, display error message
                if(!custFound)
                    System.out.println("Customer not found in the system, please try again and ensure the customer member ID is an existing member.\n");
            } while(!custFound);
            
            if(freeTrials.matches("^(N|n)$")) {
                //Prompt for the treatments/packages
                System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                 "===== List of Services =====\n" +
                                 "~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                 "1. Hair Care\n" +
                                 "2. Skin Care\n" + 
                                 "3. Body Care\n" +
                                 "4. Bridal Service\n" +
                                 "5. Packages Service\n" +
                                 "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                 "Enter the required service care: ");
                serviceChoice = sc.next();
                
                while(!serviceChoice.matches("^[1-5]{1}$")) {
                    System.out.println("Invalid input choice, please try again with only 1 to 5 as input choice.\n");
                    System.out.print("Enter the required service care: ");
                    serviceChoice = sc.next();
                }

                //Display the specific treatments/packages list
                treatPackgCodePrefix = Utility.displaySpecificTreatments(serviceChoice, treat, pack);

                if(!serviceChoice.equals("5")) {
                    do {
                        //Enter the service/treatments code 
                        System.out.print("Enter service/treatment Code: ");
                        treatPackID = sc.next();
                        sc.nextLine();

                        while(!treatPackID.matches("^"+treatPackgCodePrefix+"\\d{3}$")) {
                            System.out.println("Invalid treatment code or code format, please try again with the correct format and correct treatment code. (e.g. " + treatPackgCodePrefix + "001) \n");
                            System.out.print("Enter service/treatment Code: ");
                            treatPackID = sc.next();
                            sc.nextLine();                
                        }

                        //Loop through array to get the object of the entered treatment code
                        for(int a = 0; a < treat.size(); a++) {
                            if((treat.get(a).getTreatmentCode()).equals(treatPackID)) {
                                treatPackIndex = a;
                                treatFound = true;
                                break;
                            } else
                                treatFound = false;
                        }
                    } while(!treatFound);
                } else {
                    do {
                        //Enter the package code
                        System.out.print("Enter package code: PK");
                        treatPackID = sc.next();
                        sc.nextLine();

                        while(!treatPackID.matches("^\\d{3}$")) {
                            System.out.println("Invalid package code or code format, please try again with the correct format and correct package code. (e.g. PK001) \n");
                            System.out.print("Enter package code: PK");
                            treatPackID = sc.next();
                            sc.nextLine();                
                        }

                        //Loop through array to get the object of the entered package code
                        for(int a = 0; a < pack.size(); a++) {
                            if((pack.get(a).getPackageID()).equals(treatPackID)) {
                                treatPackIndex = a;
                                packFound = true;
                                break;
                            } else
                                packFound = false;
                        }
                    } while(!packFound);
                }
            } else {
                //Display the treatment list and prompt for the preferred treatments
                System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                 "===================================== List of Free Trials Service ======================================\n" +
                                 "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                //Display the specific treatments list
                Utility.displayFreeTrials(treat);

                do {
                    //Enter the service/treatments
                    System.out.print("Enter service/treatment/ID: ");
                    treatPackID = sc.next();
                    sc.nextLine();

                    while(!treatPackID.matches("^(HC|SC|BC)\\d{3}$")) {
                        System.out.println("Invalid treatment code or code format, please try again with the correct format and correct treatment code. (e.g. HC001) \n");
                        System.out.print("Enter service/treatment/ID: ");
                        treatPackID = sc.next();
                        sc.nextLine();                
                    }

                    //Loop through array to get the object of the entered treatment code
                    for(int a = 0; a < treat.size(); a++) {
                        if((treat.get(a).getTreatmentCode()).equals(treatPackID)) {
                            treatPackIndex = a;
                            treatFound = true;
                            break;
                        } else
                            treatFound = false;
                    }
                } while(!treatFound);
            }
            
            //Display the list of beautician
            Utility.displayBeauticianList(beau);
            
            //Do-while loop to prompt preferred beautician and find the existing beautician
            do {
                //Enter preferred beauticians
                System.out.print("Enter prefererd beauticians ID: BEAU");
                beauID = sc.next();
                sc.nextLine();

                while(!beauID.matches("^\\d{3}$")) {
                    System.out.println("Invalid beautician ID format, please try again with the correct format. (e.g. BEAU001)\n");            
                    System.out.print("Enter preferred beauticians ID: BEAU");
                    beauID = sc.next();
                    sc.nextLine();
                }
                
                //Loop through array to get the object of the entered beautician ID
                for(int a = 0; a < beau.size(); a++) {
                    if((beau.get(a).getBeauticianID()).equals("BEAU"+beauID)) {
                        beauIndex = a;
                        beauFound = true;
                        break;
                    } else
                        beauFound = false;
                }
                
                //If beautician is not found
                if(!beauFound)
                    System.out.print("Beautician not found in the system, please try again and ensure the beautician ID is an existing beautician.\n");
            } while(!beauFound);
            
            do {
                //Enter treatment date
                System.out.print("Enter treatment date (e.g. 02-JAN-2017): ");
                treatDate = sc.next();
                sc.nextLine();

                while(!treatDate.matches("^(([0-9])|([0-2][0-9])|([3][0-1]))\\-(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)\\-\\d{4}$")){
                    System.out.println("Invalid date format, please ensure the correct date format is entered. (e.g. 02-JAN-2017)\n");
                    System.out.print("Enter treatment date (e.g. 02-JAN-2017): ");
                    treatDate = sc.next();
                    sc.nextLine();
                }
                
                //If it is registering for free trials, check if the date input (Treatment date) matches the date of the specified holidays
                //Set the flag to true if it is matched, otherwise set it to false
                if(freeTrials.matches("^(Y|y)$") && (!treatDate.equals("28-JAN-2017") && !treatDate.equals("25-JUN-2017") && !treatDate.equals("19-OCT-2017") && !treatDate.equals("25-DEC-2017"))) {
                    System.out.println("Invalid date input, free trials only available on specified holidays date. Please try again and ensure the correct date is entered.\n");
                    validDate = false;
                } else 
                    validDate = true;
            } while(!validDate);

            /************** Calculation and discount checking section **************/ 
            //Only applies for paid service - Not for free trials
            //Check if any extra members discount
            if(freeTrials.matches("^(N|n)$")) {
                if (numOfService >= 6 && (refererCount != 0)) {
                    extraMemberDiscountRate = 0.85;
                    refererCount = 0;
                } else if (numOfService > 6 && numOfService <= 11 && (refererCount != 0)) {
                    extraMemberDiscountRate = 0.70;
                    refererCount = 0;
                } else if (numOfService >= 11 && (refererCount != 0)) {
                    extraMemberDiscountRate = 0.50;
                    refererCount = 0;
                }

                //Output the totals
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + 
                                   "================================= Total payment =================================\n" +
                                   "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                if(!serviceChoice.equals("5")) {
                    //Calculate the final totals
                    if(discountRate != 0 && extraMemberDiscountRate != 0)
                        totalPrice = treat.get(treatPackIndex).getTreatmentPrice() * extraMemberDiscountRate * discountRate;
                    else if(discountRate != 0)
                        totalPrice = treat.get(treatPackIndex).getTreatmentPrice() * discountRate;
                    else if(extraMemberDiscountRate != 0) 
                        totalPrice = treat.get(treatPackIndex).getTreatmentPrice()* extraMemberDiscountRate;
                    else
                        totalPrice = treat.get(treatPackIndex).getTreatmentPrice();

                    System.out.println("Selected treatment           : " + treat.get(treatPackIndex).getTreatmentCode() + " - " + treat.get(treatPackIndex).getTreatmentDesc());
                    System.out.println(String.format("Treatment price              : RM %7.2f", treat.get(treatPackIndex).getTreatmentPrice()));
                    if(discountRate != 0)
                        System.out.println("Holidays dicount             : 10%");
                    if(extraMemberDiscountRate != 0)
                        System.out.println(String.format("Brought extra member discount: %2.0f%%", ((1 - extraMemberDiscountRate) * 100)));
                    System.out.println(String.format("Total price after discount   : RM %7.2f", totalPrice));
                    if(totalPrice >= 1000)
                        System.out.println(String.format("Deposit required (50%%)       : RM %7.2f", (totalPrice * 0.5)));

                    //Creating new service for treatment as the service care choice
                    serv.add(new Service(String.format("APT%05d", serv.size() + 1), ft.parse(treatDate), totalPrice, cust.get(custIndex), beau.get(beauIndex), treat.get(treatPackIndex), false));
                } else {
                    //Calculate the final totals
                    if(discountRate != 0 && extraMemberDiscountRate != 0)
                        totalPrice = pack.get(treatPackIndex).getPackagePrice() * extraMemberDiscountRate * discountRate;
                    else if(discountRate != 0)
                        totalPrice = pack.get(treatPackIndex).getPackagePrice() * discountRate;
                    else if(extraMemberDiscountRate != 0) 
                        totalPrice = pack.get(treatPackIndex).getPackagePrice() * extraMemberDiscountRate;
                    else
                        totalPrice = pack.get(treatPackIndex).getPackagePrice();    

                    System.out.println("Selected package             : " + pack.get(treatPackIndex).getPackageID() + " - " + pack.get(treatPackIndex).getPackageName());
                    System.out.println(String.format("Package price                : RM %7.2f", pack.get(treatPackIndex).getPackagePrice()));
                    if(discountRate != 0)
                        System.out.println("Holidays dicount             : 10%");
                    if(extraMemberDiscountRate != 0)
                        System.out.println(String.format("Brought extra member discount: %2.0f%%", ((1 - extraMemberDiscountRate) * 100)));
                    System.out.println(String.format("Total price after discount   : RM %7.2f", totalPrice));
                    if(totalPrice >= 1000)
                        System.out.println(String.format("Deposit required (50%%)       : RM %7.2f", (totalPrice * 0.5)));
                    
                    //Creating new service for package as the service care choice
                    serv.add(new Service(String.format("APT%05d", serv.size() + 1), ft.parse(treatDate), totalPrice, cust.get(custIndex), beau.get(beauIndex), pack.get(treatPackIndex), false));
                }

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                //Creating new service for free trials
                serv.add(new Service(String.format("APT%05d", serv.size() + 1), ft.parse(treatDate), 0.0, cust.get(custIndex), beau.get(beauIndex), treat.get(treatPackIndex), true));
            }
            
            //Reset the discount rate
            extraMemberDiscountRate = 0;
        }
        
        //Output message
        System.out.println("\n" + i + " service(s) has been successfully recorded into the system.\n");
    }
    
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat("dd-MMM-yyy");
        
        //If the chosen service care is treatment, display treatment details
        //otherwise, display the package details.
        if(treatOrPackage instanceof Treatment) {
            return String.format("%s \t %-20s \t RM %,8.2f \t %-10s \t %-15s \t %-10s \t %-15s \t\t%-10s \t %-60s \t %6s", 
                    serviceID, ft.format(serviceDate), totalPrice, customer.getMemberID(), customer.name.getFullName(),
                    beautician.getBeauticianID(), beautician.name.getFullName(), ((Treatment)treatOrPackage).getTreatmentCode(), 
                    ((Treatment)treatOrPackage).getTreatmentDesc(),this.getFreeTrials());   
        } else 
            return String.format("%s \t %-20s \t RM %,8.2f \t %-10s \t %-15s \t %-10s \t %-15s \t\t%-10s \t %-60s \t %6s", 
                    serviceID, ft.format(serviceDate), totalPrice, customer.getMemberID(), customer.name.getFullName(), 
                    beautician.getBeauticianID(), beautician.name.getFullName(), ((Package)treatOrPackage).getPackageID(), 
                    ((Package)treatOrPackage).getPackageName(),this.getFreeTrials());
    }
}
