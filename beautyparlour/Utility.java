/**
 * 
 * Utility class that is used for the main class.
 * This class contains all the methods that used by the
 * main class for all the operations on each of the classes.
 * The main purpose of this class is to group the related
 * utility methods to provide efficiencies and easy maintenance
 * of each operation/methods.
 * 
 * All methods are made to default static final to limit the accessibility to
 * only classes that are in the same package/folder, each of the methods are 
 * final as to protect any inheritance or direct modification of the data. 
 * This is to provide a better security of the software.
 * 
 * 
 * @version 1.00 2017/7/25
 * @version 2.00 2017/9/19
 */

//Imports
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

//Declaring final for security reason - No other class can inherit from this class, should only be used for main class (Utility purpose)
public final class Utility {
    
    //Global Objects for all the methods
    //Global Scanner object for each of the methods
    //Global SimpleDateFormat for different methods that requires parsing of date format.
    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat ft = new SimpleDateFormat("dd-MMM-yyyy");

    /******************* Predefined Objects section ******************/
    //Predefined Beautician Objects - HardCoded, contains 10 beauticians
    static final ArrayList predefinedBeauticians() throws ParseException {
        //ArrayList creation
        ArrayList<Beautician> beau = new ArrayList<>();
        
        //Add beautician to ArrayList
        beau.add(new Beautician(new Name("Natalie", "Wong"), new Address("No.42, Taman Bersatu, Putatan", 88200, "Kota Kinabalu", "Sabah"), "014-6558315", "BEAU001", ft.parse("01-JAN-2017"), "Hair Care"));
        beau.add(new Beautician(new Name("Cherry", "Yee"), new Address("No.55, Taman Walnutwood, Penampang", 88400, "Kota Kinabalu", "Sabah"), "012-6554892", "BEAU002", ft.parse("24-JAN-2017"), "Hair Care"));
        beau.add(new Beautician(new Name("Michelle", "Yeo"), new Address("No.02, Taman Perkasa, Penampang", 87600, "Kota Kinabalu", "Sabah"), "011-2334587", "BEAU003", ft.parse("15-FEB-2017"), "Skin Care"));
        beau.add(new Beautician(new Name("Mary", "Ann"), new Address("No.57, Taman Johor, Kepayan", 88200, "Kota Kinabalu", "Sabah"), "010-4557895", "BEAU004", ft.parse("18-FEB-2017"), "Skin Care"));
        beau.add(new Beautician(new Name("Sophia", "Bella"), new Address("No.20, Taman Johor, Kepayan", 88100, "Kota Kinabalu", "Sabah"), "016-5668794", "BEAU005", ft.parse("20-FEB-2017"), "Skin Care"));
        beau.add(new Beautician(new Name("Isabella", "Skylar"), new Address("No.38, Taman New Lintas, Lintas", 88450, "Kota Kinabalu", "Sabah"), "016-4668921", "BEAU006", ft.parse("20-FEB-2017"), "Body Care"));
        beau.add(new Beautician(new Name("Grace", "Ella"), new Address("No.17, Taman Jones, Kelombong", 88450, "Kota Kinabalu", "Sabah"), "012-5679826", "BEAU007", ft.parse("22-FEB-2017"), "Body Care"));
        beau.add(new Beautician(new Name("Emily", "Liang"), new Address("No.34, Taman Margarets, Kelombong", 89250, "Kota Kinabalu", "Sabah"), "012-5685465", "BEAU008", ft.parse("25-FEB-2017"), "Bridal makeup specialist"));
        beau.add(new Beautician(new Name("Elsa", "Anna"), new Address("No.25, Taman Kurnia Jata, Likas ", 89850, "Kota Kinabalu", "Sabah"), "014-6897453", "BEAU009", ft.parse("05-MAR-2017"), "Bridal makeup specialist"));
        beau.add(new Beautician(new Name("Charlotte", "Esther"), new Address("No.75, Taman Marlborough, Kingfisher", 88554, "Kota Kinabalu", "Sabah"), "016-6897456", "BEAU010", ft.parse("08-MAR-2017"), "Bridal makeup specialist"));

        //Return the array to main
        return beau;
    }
    
    //Predefined Customer Objects - HardCoded, contains 10 customers
    static final ArrayList predefinedCustomers() throws ParseException {
        //ArrayList creation
        ArrayList<Customer> cust = new ArrayList<>();
        
        //Add customer to ArrayList
        cust.add(new Customer("CUST0001", new Name("Sammy", "Wong"), ft.parse("02-JAN-2017"), "014-6557896", new Address("No.11, Taman Nanas, Putatan", 88200, "Kota Kinabalu", "Sabah")));
        cust.add(new Customer("CUST0002", new Name("Jessy", "Smith"), ft.parse("02-JAN-2017"), "012-8778865", new Address("No.35, Taman Bunga, Penampang", 88300, "Kota Kinabalu", "Sabah")));
        cust.add(new Customer("CUST0003", new Name("Lilly", "Mayson"), ft.parse("05-JAN-2017"), "011-5658974", new Address("No.64, Taman Iramanis, Kelombong", 88220, "Kota Kinabalu", "Sabah")));
        cust.add(new Customer("CUST0004", new Name("Kelly", "Benderson"), ft.parse("12-JAN-2017"), "012-6523496", new Address("No.23, Taman Kepayan, Penampang", 88500, "Kota Kinabalu", "Sabah")));
        cust.add(new Customer("CUST0005", new Name("Sonia", "Junior"), ft.parse("22-FEB-2017"), "016-6234896", new Address("No.34, Taman Chofu, Jalan Lintas", 88230, "Kota Kinabalu", "Sabah")));
        cust.add(new Customer("CUST0006", new Name("Shelly", "Wong"), ft.parse("15-FEB-2017"), "014-0556482", new Address("No.12, Taman Bunga Raja, Putatan", 86130, "Kota Kinabalu", "Sabah")));
        cust.add(new Customer("CUST0007", new Name("Jessie", "Chen"), ft.parse("22-FEB-2017"), "016-2347896", new Address("No.56, Taman Epal, Putatan", 88240, "Kota Kinabalu", "Sabah")));
        cust.add(new Customer("CUST0008", new Name("Bell", "Ng"), ft.parse("02-MAR-2017"), "016-2223568", new Address("No.90, Taman Air, Penampang", 88300, "Kota Kinabalu", "Sabah")));
        cust.add(new Customer("CUST0009", new Name("Lela", "Tan"), ft.parse("12-MAY-2017"), "012-2657896", new Address("No.56, Taman Choi Sin, Kelombong", 88300, "Kota Kinabalu", "Sabah")));
        cust.add(new Customer("CUST0010", new Name("Fiona", "Chen"), ft.parse("13-APR-2017"), "014-2465879", new Address("No.54, Taman Nanas, Putatan", 87400, "Kota Kinabalu", "Sabah")));
        
        //Return the array to main
        return cust;
    }
    
    //Predefined Treatment Objects - Hardcoded, contains 14 treatments
    static final ArrayList predefinedTreatment() {
        //ArrayList Creation
        ArrayList<Treatment> treat = new ArrayList<>();
        
        //Add treatments to the ArrayList
        treat.add(new Treatment("HC001", "Hair Blow Dry (45 mins)", 50.00, true));
        treat.add(new Treatment("HC002", "Hair Straightening (60 mins)", 80.00, true));
        treat.add(new Treatment("HC003", "Loreal Nourishing Hair Spa - Up to Waist (60 Mins)", 120.00, false));
        treat.add(new Treatment("HC004", "Loreal Nourishing Hair Spa - Below Waist (75 Mins)", 140.00, false));
        treat.add(new Treatment("SC005", "Express Fruit Clean-Up (45 Mins)", 150.00, false));
        treat.add(new Treatment("SC006", "Advance (Acne) (60mins)", 100.00, false));
        treat.add(new Treatment("SC007", "Instant Radiance Facial (60 Mins)", 200.00, false));
        treat.add(new Treatment("SC008", "Natural De-Tan Face (30 Mins)", 100.00, false));
        treat.add(new Treatment("BC009", "Full Body Massage (Deep Tissue) - (60 mins)", 180.00, false));
        treat.add(new Treatment("BC010", "Head, Neck & Shoulder Massage (30 mins)", 60.00, true));
        treat.add(new Treatment("BC011", "Aroma Manicure (45 mins)", 50.00, true));
        treat.add(new Treatment("BC012", "Aroma Pedicure (45 mins)", 50.00, true));
        treat.add(new Treatment("BS013", "Bridal - Hair Upstyle & Make-up (Wedding day & Dinner night)", 2000.00, false));
        treat.add(new Treatment("BS014", "Flower Girl - Hair Upstyle & Make-up (Wedding day only)", 1500.00, false));
        
        //Return the array
        return treat;
    }
    
    //Predefined Package Objects - Hardcoded, contains 4 packages
    static final ArrayList predefinedPackage(ArrayList<Treatment> treat) {
        //ArrayList Creation
        ArrayList<Package> packg = new ArrayList<>();
        
        //Creating package objects
        packg.add(new Package("PK001", "Skin Luxury", 250.00, treat.get(5), treat.get(6)));
        packg.add(new Package("PK002", "Relaxation Indulgence", 200.00, treat.get(8), treat.get(10)));
        packg.add(new Package("PK003", "Hair Essentials (Women)", 80.00, treat.get(0), treat.get(1)));
        packg.add(new Package("PK004", "Woman's Big Day", 3200.00, treat.get(12), treat.get(13)));

        //Return
        return packg;
    }
  
    //Predefined Service Objects - Hardcoded, contains 12 services
    static final ArrayList predefinedService(ArrayList<Treatment> treat, ArrayList<Package> pack, ArrayList<Customer> cust, ArrayList<Beautician> beau) throws ParseException {
        //ArrayList Creation
        ArrayList<Service> service = new ArrayList<>();
        
        //Adding the predefined service objects
        service.add(new Service("APT00001", ft.parse("05-JAN-2017"), 1500.00, cust.get(0), beau.get(9), treat.get(13), false));
        service.add(new Service("APT00002", ft.parse("08-JAN-2017"), 80.00, cust.get(5), beau.get(1), pack.get(2), false));
        service.add(new Service("APT00003", ft.parse("10-FEB-2017"), 100.00, cust.get(1), beau.get(4), treat.get(5), false));
        service.add(new Service("APT00004", ft.parse("20-FEB-2017"), 250.00, cust.get(1), beau.get(4), pack.get(1), false));
        service.add(new Service("APT00005", ft.parse("13-MAR-2017"), 140.00, cust.get(0), beau.get(1), treat.get(3), false));
        service.add(new Service("APT00006", ft.parse("15-APR-2017"), 250.00, cust.get(0), beau.get(3), pack.get(0), false));
        service.add(new Service("APT00007", ft.parse("20-JUN-2017"), 120.00, cust.get(2), beau.get(0), treat.get(2), false));
        service.add(new Service("APT00008", ft.parse("25-JUN-2017"), 0.0, cust.get(5), beau.get(0), treat.get(0), true));
        service.add(new Service("APT00009", ft.parse("25-JUN-2017"), 0.0, cust.get(3), beau.get(1), treat.get(1), true));
        service.add(new Service("APT00010", ft.parse("25-JUN-2017"), 0.0, cust.get(4), beau.get(6), treat.get(9), true));
        service.add(new Service("APT00011", ft.parse("22-JUL-2017"), 100.00, cust.get(4), beau.get(4), treat.get(7), false));
        service.add(new Service("APT00012", ft.parse("22-JUL-2017"), 3200.00, cust.get(3), beau.get(9), pack.get(3), false));

        //Return the latest service array
        return service;
    }
    
    /******************* Screen menu section ******************/
    //Company Name Header
    static final void companyLogoHeader() {
        System.out.println("========================================================");
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("|         Everlove Home Service Beauty Parlour         |");
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("========================================================\n");
    }
    
    //Main System screen
    static final String systemMainScreen() {
        //Variable declaration
        String choice = null;
        
        //MAIN SYSTEM MENU
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "======= Main Screen Menu =======\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + 
                         "1. Login\n" + 
                         "2. Exit program\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "Enter choice: ");
        choice = sc.next();
        sc.nextLine();
        
         //Data type and format check, only numbers range from 1 to 5
        while(!choice.matches("^[1-2]{1}$")) {
            System.out.println("Invalid input, please enter only numbers ranging from 1 to 2.\n");
            System.out.print("Enter choice: ");
            choice = sc.next();
            sc.nextLine();
        }

        //Return the choice
        return choice;
    }
    
    //Login module
    static final int login() {
        
        //Local variable declaration
        String loginID = null, password = null;
        boolean loginPass = false;
        
        //Login menu
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "========== LOGIN ==========\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        do {
            //LoginID
            System.out.print("Login ID: ");
            loginID = sc.next();
            sc.nextLine();

            //Password
            System.out.print("Password: ");
            password = sc.next();
            sc.nextLine();

            //Login validation
            if ((!loginID.equals("manager123") || !password.equals("manager123456789")) && (!loginID.equals("staff123") || !password.equals("staff123456789"))) {
                System.out.println("Invalid login ID or password, please try again or contact the system support staff.\n");
                loginPass = false;      //Set flag to false if login ID and password is not valid
            } else {
                loginPass = true;       //Set flag to true if login ID and password is valid
            }

            //Newline for the next menu
        } while(!loginPass);
        
        //If the user login is manager, return 1 to indicate it is manager, else 0 for staff
        if(loginID.equals("manager123") && password.equals("manager123456789"))
            return 1;
        else
            return 0;
    }

    //System Main Menu
    static final String systemMainMenu() {
        
        //Local variable declaration
        String choice;
        
        //Beautician staff menu
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "========== Main Menu ==========\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "1. New Service\n" +
                         "2. Registration\n" +
                         "3. Display Records\n" + 
                         "4. Log out\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "Enter choice: ");
        choice = sc.next();
        sc.nextLine();
        
        //Data type and format check, only numbers range from 1 to 4
        while(!choice.matches("^[1-4]{1}$")) {
            System.out.println("Invalid input, please enter only numbers ranging from 1 to 4.\n");
            System.out.print("Enter choice: ");
            choice = sc.next();
            sc.nextLine();
        }

        //Return the choice
        return choice;
    }
    
    //Registration Menu (Option 2)
    static final String registrationMenu() {
        
        //Local variable declaration
        String choice;
        
        //Beautician staff menu
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "========== Registration Menu ==========\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "1. Register new Customer\n" +
                         "2. Register new Beautician\n" +
                         "3. Register new Treatment\n" +
                         "4. Register new Package\n" +
                         "5. Return to main menu\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "Enter choice: ");
        choice = sc.next();
        sc.nextLine();
        
        //Data type and format check, only numbers range from 1 to 5
        while(!choice.matches("^[1-5]{1}$")) {
            System.out.println("Invalid input, please enter only numbers ranging from 1 to 5.\n");
            System.out.print("Enter choice: ");
            choice = sc.next();
            sc.nextLine();
        }

        //Return the choice
        return choice;
    }

    //Records menu for staff
    static final String staffRecordMenu() {
        //Local variable declaration
        String choice;
        
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "========= Records Menu (Staff) =========\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "1. Display treatment list\n" +
                         "2. Display package list\n" +
                         "3. Display customer member list\n" +
                         "4. Display beautician list\n" +
                         "5. Check appointment dates\n" +
                         "6. Return to main menu\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "Enter choice: ");
        choice = sc.next();
        sc.nextLine();
        
        while(!choice.matches("^[1-6]{1}$")) {
            System.out.println("Invalid input, please try again with only 1 to 6 as input.\n");
            System.out.print("Enter choice: ");
            choice = sc.next();
            sc.nextLine();
        }
        
        //Return the choice
        return choice;
    }
    
    //Records/Reports menu for manager
    static final String managerRecordMenu() {
        //Local variable declaration
        String choice;
        
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "========= Records Menu (Manager) =========\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "1. Show customer treatment transactions\n" +
                         "2. Show appointments records\n" +
                         "3. Bridal service report\n" +
                         "4. Check beautician's treatment records\n" +
                         "5. Display trial service records\n" +
                         "6. Display treatment list\n" +
                         "7. Display package list\n" + 
                         "8. Display customer member list\n" +
                         "9. Display beautician list\n" +
                         "10. Return to main menu\n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                         "Enter choice: ");
        choice = sc.next();
        sc.nextLine();
        
        while(!choice.matches("^([1-9]|[1][0])$")) {
            System.out.println("Invalid input, please try again with only 1 to 10 as input.\n");
            System.out.print("Enter choice: ");
            choice = sc.next();
            sc.nextLine();
        }
        
        //Return the choice
        return choice;  
    }
    
    /******************* Output/Report section ******************/
    //Display the notes before making any service
    static final void newServiceNotes() {
        System.out.println("\n\n============================ NOTES =============================\n" +
                           "1. If a customer bring along extra member and registers for any\n" +
                           "services enjoys additional discount as shown in the table below\n\n" +
                           "The FIRST customer to register for a service must be the referer\n" +
                           "(The customer that brought extra members)\n\n" +
                           "--------------------------------------------\n" +
                           "|      No. of members      | Discount Rate |\n" +
                           "|--------------------------|---------------|\n" +
                           "| More than or equals 5    |      15%      |\n" +
                           "| More than or equals to 10|      30%      |\n" +
                           "| More than  10            |      50%      |\n" +
                           "--------------------------------------------\n\n" +
                           "2. Free trials are only available during the Chinese New Year,\n" +
                           "Deepavali, Christmas and Hari Raya dates. Thus, the treatment\n" +
                           "date should match the specified holidays\n" +
                           "=================================================================\n\n");
    }
    
    //Header/Footer for displaying the Treatments based on suitable style
    static final void treatmentHeaderFooter(String headerFooter) {
        //Display the header if input string is "header"
        //Otherwise, display the footer
        switch (headerFooter) {
            case "header":
            	System.out.println("------------------------------------------------------------------------------------------------------------------------");
            	System.out.println("\t\t\t\t\t\t\tTREATMENT LIST");
            	System.out.println("------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-20s \t %-55s \t %-8s     %-10s\n", "--------------------", "-------------------------------------------------------------", "---------------", "-----------");
                System.out.printf("%-20s \t\t\t     %-35s \t %-10s     %-20s", "Treatment Code", "Treatment Description", "Treatment Price", "Free trials");
                System.out.printf("\n%-20s \t %-55s \t %-10s     %-10s\n", "--------------------", "-------------------------------------------------------------", "---------------", "-----------");
                break;
            case "footer":
                System.out.printf("%-20s \t %-55s \t %-10s     %-10s\n", "--------------------", "-------------------------------------------------------------", "---------------", "-----------");
                break;
            case "header1":
                System.out.printf("\n%-20s \t %-55s \t %-8s\n", "--------------------", "-------------------------------------------------------------", "---------------");
                System.out.printf("%-20s \t\t\t     %-35s \t %-10s", "Treatment Code", "Treatment Description", "Treatment Price");             
                System.out.printf("\n%-20s \t %-55s \t %-10s\n", "--------------------", "-------------------------------------------------------------", "---------------");
                break;
            case "footer1":
                System.out.printf("%-20s \t %-55s \t %-10s\n", "--------------------", "-------------------------------------------------------------", "---------------");
                break;
        }
    }

    //Header/Footer for displaying the Package
    static final void packageHeaderFooter(String headerFooter) {
        //Display the header if input string is "header"
        //Otherwise, display the footer
        if(headerFooter.equals("header")) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");   
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tPACKAGE LIST");   
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");   
        	
            System.out.printf("%-20s \t %-15s \t %-10s \t %10s \t %-10s\n", "--------------------", "-------------------------", "------------------------------------------------------------", "-------------------------------------------------------", "----------------------------");   
            System.out.printf("%-20s \t\t%-10s \t\t\t\t\t %-30s \t\t\t\t %-30s \t\t %10s", "Service/Treatment ID", "Package Name", "Treatment 1", "Treatment 2", "Package Price");   
            System.out.printf("\n%-20s \t %-15s \t %-10s \t %10s \t %-10s\n", "--------------------", "-------------------------", "------------------------------------------------------------", "-------------------------------------------------------", "----------------------------");   
        } else if (headerFooter.equals("footer"))
            System.out.printf("%-20s \t %-15s \t %-10s \t %10s \t %-10s\n", "--------------------", "-------------------------", "------------------------------------------------------------", "-------------------------------------------------------", "----------------------------");
    }
    
    //Header/Footer for displaying the Service
    static final void serviceHeaderFooter(String headerFooter) {
        //Display the header if input string is "header"
        //Otherwise, display the footer
        //Different header/footer are designed for different reports
        switch (headerFooter) {
            case "beauticianDetailsHead":
                System.out.println(String.format("%s \t %-10s \t %7s \t %-10s \t %-15s \t %-15s \t%-5s \t %-55s \t%-5s",
                       "--------------", "------------------", "-----------", "-----------", "---------------------",
                       "---------------------", "----------------------", "----------------------------------------------------------", "-----------"));
                System.out.println(String.format("%s \t %-12s \t %7s \t %-10s \t %-15s \t %-15s \t%-5s \t\t\t       %-35s \t%-5s",
                       "Appointment ID", "Appointment Date", "Total Price", "Customer ID", "Customer Name", "Beautician Name", "Treatment/Package Code", "Treatment/Package", "Free Trials"));
                System.out.println(String.format("%s \t %-10s \t %7s \t %-10s \t %-15s \t %-15s \t%-5s \t %-55s \t%-5s",
                       "--------------", "------------------", "-----------", "-----------", "---------------------",
                       "---------------------", "----------------------", "----------------------------------------------------------", "-----------"));
                break;
            case "beauticianDetailsFoot":
                System.out.println(String.format("%s \t %-10s \t %7s \t %-10s \t %-15s \t %-15s \t%-5s \t %-55s \t%-5s",
                       "--------------", "------------------", "-----------", "-----------", "---------------------",
                       "---------------------", "----------------------", "----------------------------------------------------------", "-----------"));
                break;
            case "bridalService":
            	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            	System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\tBridal Service Report");
            	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");        		
                break;
            case "appointmentRecords":
            	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            	System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\tAppointment Records");
            	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");        		
                break;	
            case "header":
                System.out.println(String.format("%s \t %-10s \t %7s \t %-10s \t %-15s \t %-10s \t %-15s \t%-5s \t %-55s \t%-5s",
                        "--------------", "------------------", "-----------", "-----------", "---------------------",
                        "-------------", "---------------------", "----------------------", "----------------------------------------------------------", "-----------"));
                System.out.println(String.format("%s \t %-12s \t %7s \t %-10s \t %-15s \t %-10s \t %-15s \t%-5s \t\t\t       %-35s \t%-5s",
                        "Appointment ID", "Appointment Date", "Total Price", "Customer ID", "Customer Name", "Beautician ID", "Beautician Name", "Treatment/Package Code", "Treatment/Package", "Free Trials"));
                System.out.println(String.format("%s \t %-10s \t %7s \t %-10s \t %-15s \t %-10s \t %-15s \t%-5s \t %-55s \t%-5s",
                        "--------------", "------------------", "-----------", "-----------", "---------------------",
                        "-------------", "---------------------", "----------------------", "----------------------------------------------------------", "-----------"));
                break;
            case "footer":
                System.out.println(String.format("%s \t %-10s \t %7s \t %-10s \t %-15s \t %-10s \t %-15s \t%-5s \t %-55s \t%-5s",
                        "--------------", "------------------", "-----------", "-----------", "---------------------",
                        "-------------", "---------------------", "----------------------", "----------------------------------------------------------", "-----------"));
                break; 
            case "header1":
                System.out.println(String.format("%s \t %-10s \t %-25s \t %-10s \t %-50s \t %-15s",
                        "--------------", "------------------", "--------------------------", "----------------------",
                        "---------------------------------------------------------", "-----------"));
                System.out.println(String.format("%s \t %-12s \t %-25s \t %-10s \t\t\t\t\t%-35s \t %-10s", 
                        "Appointment ID", "Appointment Date", "Customer Name", "Treatment Code", "Treatment", "Total Price"));
                System.out.println(String.format("%s \t %-10s \t %-25s \t %-10s \t %-50s \t %-15s",
                        "--------------", "------------------", "--------------------------", "----------------------", 
                        "---------------------------------------------------------", "-----------"));
                break;
            case "footer1":
                System.out.println(String.format("%s \t %-10s \t %-25s \t %-10s \t %-50s \t %-15s", 
                        "--------------", "------------------", "--------------------------", "----------------------",
                        "---------------------------------------------------------", "-----------"));
                break;
            case "header2":
            	System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            	System.out.println("\t\t\t\t\t\t\t\t\t\tTrial Service Records");
            	System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(String.format("%s \t %-10s \t %-25s \t %-10s \t %-8s \t %-15s", 
                        "--------------", "------------------", "--------------------------", "----------------------",
                        "----------------------", "---------------------------------------------------------"));
                System.out.println(String.format("%s \t %-12s \t %-25s \t %-25s \t %-30s \t\t    %-10s", 
                        "Appointment ID", "Appointment Date", "Customer Name", "Beautician Name", "Treatment/Package Code", "Treatment/Package"));
                System.out.println(String.format("%s \t %-10s \t %-25s \t %-10s \t %-8s \t %-15s",
                        "--------------", "------------------", "--------------------------", "----------------------", 
                        "----------------------", "---------------------------------------------------------"));
                break;
            case "footer2":
                System.out.println(String.format("%s \t %-10s \t %-25s \t %-10s \t %-8s \t %-15s", 
                        "--------------", "------------------", "--------------------------", "----------------------",
                        "----------------------", "---------------------------------------------------------"));
                break;
        }
    }
    
    //Display the treatments
    static final void displayTreatments(ArrayList<Treatment> treat) {
        //Display the list of treatments
        treatmentHeaderFooter("header");
        for(int i = 0; i < treat.size(); i++) {
            System.out.println(treat.get(i).toString());
        }
        treatmentHeaderFooter("footer");
        
        //Display the counter
        System.out.println("\n" + treat.size() + " treatment(s) are shown\n");
    }

    //Display the list of treatments according to a specific choice -- Used by newService(params) methods in Service.java (Service class)
    static final String displaySpecificTreatments(String treatmentChoice, ArrayList<Treatment> treat, ArrayList<Package> packg) {
        String treatPackgCodePrefix;
        
        //Display the list of treatments based on the choice
        switch (treatmentChoice) {
            case "1":
                treatmentHeaderFooter("header");
                for(int a = 0; a < treat.size(); a++) {
                    if(treat.get(a).getTreatmentCode().matches("^HC\\d{3}$")) {
                        System.out.println(treat.get(a).toString());    //Display Hair Care treatment list
                    }
                }   treatmentHeaderFooter("footer");
                ;
                treatPackgCodePrefix = "HC";        //Set the prefix code to "HC"
                break;
            case "2":
                treatmentHeaderFooter("header");
                for(int a = 0; a < treat.size(); a++) {
                    if(treat.get(a).getTreatmentCode().matches("^SC\\d{3}$")) {
                        System.out.println(treat.get(a).toString());    //Display Skin Care treatment list
                    }
                }   treatmentHeaderFooter("footer");
                ;
                treatPackgCodePrefix = "SC";        //Set the prefix code to "SC"
                break;
            case "3":
                treatmentHeaderFooter("header");
                for(int a = 0; a < treat.size(); a++) {
                    if(treat.get(a).getTreatmentCode().matches("^BC\\d{3}$")) {
                        System.out.println(treat.get(a).toString());    //Display Body Care treatment list
                    }
                }   treatmentHeaderFooter("footer");
                ;
                treatPackgCodePrefix = "BC";        //Set the prefix code to "BC"
                break;
            case "4":
                treatmentHeaderFooter("header");
                for(int a = 0; a < treat.size(); a++) {
                    if(treat.get(a).getTreatmentCode().matches("^BS\\d{3}$")) {
                        System.out.println(treat.get(a).toString());    //Display Bridal Service list
                    }
                }   treatmentHeaderFooter("footer");
                ;
                treatPackgCodePrefix = "BS";        //Set the prefix code to "BS"
                break;
            default:
                displayPackages(packg);              //Display package list
                treatPackgCodePrefix = "PK";        //Set the prefix code to "PK"
                break;
        }
        
        //Return the prefix
        return treatPackgCodePrefix;
    }

    //Display the list of free trials treatments
    static final void displayFreeTrials(ArrayList<Treatment> treat) {
        treatmentHeaderFooter("header1"); 
        for(int a = 0; a < treat.size(); a++) {
            if(treat.get(a).getFreeTrials().equals("Yes")) {  //Check if the free trials flag is true or not
                System.out.println(String.format("%-15s \t %-55s \t RM %,10.2f", treat.get(a).getTreatmentCode(), treat.get(a).getTreatmentDesc(), treat.get(a).getTreatmentPrice()));    //Display treatments that are free tirals
            }
        }
        treatmentHeaderFooter("footer1");   
    }
    
    //Display the package 
    static final void displayPackages(ArrayList<Package> pack) {
        //Display the list of package
        packageHeaderFooter("header");
        for(int i = 0; i < pack.size(); i++) {
            System.out.println(pack.get(i).toString());
        }
        packageHeaderFooter("footer");
        System.out.println("\n" + pack.size() + " package are shown\n");
    }

    //Display the list of beautician - Used in newService() method in Service class 
    static final void displayBeauticianList(ArrayList<Beautician> beau) {
        //Beautician table list header
        System.out.printf("\n%-7s \t %-20s \t %-11s \t %-30s\n", "-------------", "---------------------", "------------", "------------------------");
        System.out.printf("%-7s \t %-20s \t %-11s \t %-30s\n", "Beautician ID", "Beautician Name", "Contact No.", "Specialization");
        System.out.printf("%-7s \t %-20s \t %-11s \t %-30s\n", "-------------", "---------------------", "------------", "------------------------");
        for(int i = 0; i < beau.size(); i++) {
            //Display the list of beautician
            System.out.printf("%-7s \t %-20s \t %-11s \t %-30s\n", beau.get(i).getBeauticianID(), beau.get(i).name.getFullName(), beau.get(i).contactNum, beau.get(i).getSpecialization());
        }
        System.out.printf("%-7s \t %-20s \t %-11s \t %-30s\n", "-------------", "---------------------", "------------", "------------------------");
        
        //Display the counter
        System.out.println("\n" + beau.size() + " beautician(s) are shown.\n");
    }

    //Check beauticians record
    static final void checkBeauticianDetails(ArrayList<Service> serv, ArrayList<Beautician> beau) {
        String beauID;
        boolean beauFound = false;
        int beauCount = 0;
        
        //Do-while loop to prompt beautician ID and find the existing beautician member
        do {
            System.out.print("Enter beautician ID to show details: BEAU");
            beauID = sc.next();
            sc.nextLine();

            while(!beauID.matches("^\\d{3}$")) {
                System.out.println("Invalid beautician ID, please try again and ensure the correct beautician ID.\n");
                System.out.print("Enter beautician ID to show details: BEAU");
                beauID = sc.next();
                sc.nextLine(); 
            }

            //Loop throught array to get the object of the entered beautician ID
            for(int a = 0; a < beau.size(); a++) {
                if((beau.get(a).getBeauticianID()).equals("BEAU"+beauID)) {
                    beauFound = true;
                    break;
                } else 
                    beauFound = false;
            }

            //If beautician is not found in the system, display error message
            if(!beauFound)
                System.out.println("Beautician not found in the system, please try again and ensure the beautician ID exist.\n");
        } while(!beauFound);

        //Display the service list
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tBeautician Appointment Details for BEAU" + beauID);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");        		
        serviceHeaderFooter("beauticianDetailsHead");
        for(int i = 0; i < serv.size(); i++) {
            if(("BEAU"+beauID).equals(serv.get(i).getBeautician().getBeauticianID())) {
                if(serv.get(i).getTreatOrPackage() instanceof Treatment) {
                    System.out.println(String.format("%s \t %-20s \t RM %,8.2f \t %-10s \t %-15s \t %-15s \t\t%-10s \t %-60s \t %6s", 
                            serv.get(i).getServiceID(), ft.format(serv.get(i).getServiceDate()), 
                            serv.get(i).getTotalPrice(), serv.get(i).getCustomer().getMemberID(), 
                            serv.get(i).getCustomer().name.getFullName(), serv.get(i).getBeautician().name.getFullName(), 
                            ((Treatment)serv.get(i).getTreatOrPackage()).getTreatmentCode(), ((Treatment)serv.get(i).getTreatOrPackage()).getTreatmentDesc(), serv.get(i).getFreeTrials()));
                } else {
                    System.out.println(String.format("%s \t %-20s \t RM %,8.2f \t %-10s \t %-15s \t %-15s \t\t%-10s \t %-60s \t %6s", 
                            serv.get(i).getServiceID(), ft.format(serv.get(i).getServiceDate()), 
                            serv.get(i).getTotalPrice(), serv.get(i).getCustomer().getMemberID(), 
                            serv.get(i).getCustomer().name.getFullName(), serv.get(i).getBeautician().name.getFullName(), 
                            ((Package)serv.get(i).getTreatOrPackage()).getPackageID(), ((Package)serv.get(i).getTreatOrPackage()).getPackageName(), serv.get(i).getFreeTrials()));                    
                }
                beauCount++;
            }
        }
        serviceHeaderFooter("beauticianDetailsFoot");
        System.out.println("\n" + beauCount + " record(s) are shown.");
    }

    //Show full beautician list with complete details 
    static final void displayBeauticianFullDetails(ArrayList<Beautician> beau) {
        //Beautician table list header
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\tBEAUTICIAN LISTS");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-7s \t %-20s \t %-11s \t %-25s \t %-13s \t %s\n", "-------------", "---------------------", "-----------", "------------------------", "------------", "-----------------------------------------------------------------------");
        System.out.printf("%-7s \t %-20s \t %-11s \t %-25s \t %-40s \t %s\n", "Beautician ID", "Beautician Name", "Date Joined", "Specialization", "Contact No.", "Home Address");
        System.out.printf("%-7s \t %-20s \t %-11s \t %-25s \t %-13s \t %s\n", "-------------", "---------------------", "-----------", "------------------------", "------------", "-----------------------------------------------------------------------");
        for(int i = 0; i < beau.size(); i++) {
            System.out.printf(beau.get(i).toString());
        }
        System.out.printf("%-7s \t %-20s \t %-11s \t %-25s \t %-13s \t %s\n", "-------------", "---------------------", "-----------", "------------------------", "------------", "-----------------------------------------------------------------------");
        System.out.println("\n" + beau.size() + " beautician(s) are shown\n");
    }

    //Show appointment records
    static final void displayAppointmentRecords(ArrayList<Service> serv) {
        //Display the service list
        serviceHeaderFooter("appointmentRecords");
        serviceHeaderFooter("header");
        for(int i = 0; i < serv.size(); i++) {
            System.out.println(serv.get(i).toString());
        }
        serviceHeaderFooter("footer");
        System.out.println("\n" + serv.size() + " record(s) are shown.\n");
    }
    
    //Display free trial service records
    static final void displayTrialService(ArrayList<Service> serv) {
        //Local variables declaration
        int serviceCount = 0;
        
        //Display the service list
        serviceHeaderFooter("header2");
        for(int i = 0; i < serv.size(); i++) {
            if(serv.get(i).getFreeTrials().equals("Yes")) { 
                    System.out.println(String.format("%-10s \t %-15s \t %-25s \t %-25s \t %-15s \t\t %-60s", 
                            serv.get(i).getServiceID(), ft.format(serv.get(i).getServiceDate()),
                            serv.get(i).getCustomer().name.getFullName(), serv.get(i).getBeautician().name.getFullName(), ((Treatment)serv.get(i).getTreatOrPackage()).getTreatmentCode(),
                            ((Treatment)serv.get(i).getTreatOrPackage()).getTreatmentDesc()));
                serviceCount++;
            }
        }
        serviceHeaderFooter("footer2");
        System.out.println("\n" + serviceCount + " record(s) are shown.\n");
    }

    //Bridal service report
    static final void bridalReport(ArrayList<Service> serv) {
        //Local variables declaration
        int bridalCount = 0;
        
        //Display the service list
        serviceHeaderFooter("bridalService");
        serviceHeaderFooter("header");
        for(int i = 0; i < serv.size(); i++) {
            if(serv.get(i).getTotalPrice() > 1000) { 
                System.out.println(serv.get(i).toString());
                bridalCount++;
            }
        }
        serviceHeaderFooter("footer");
        System.out.println("\n" + bridalCount + " record(s) are shown.\n");
    }
    
    //Show full customer member list with complete details
    static final void displayCustomerMember(ArrayList<Customer> cust) {
        //Customer table list header
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\tCUSTOMER MEMBER LISTS");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-7s \t %-20s \t %-11s \t %-13s \t %s\n", "-------------", "---------------------", "------------", "----------------------------------------------------------------------------", "-----------------");
        System.out.printf("%-7s \t %-20s \t %-11s \t\t\t\t\t %-40s \t %s\n", "Customer ID", "Customer Name", "Contact No.", "Home Address", "Member since");
        System.out.printf("%-7s \t %-20s \t %-11s \t %-13s \t %s\n", "-------------", "---------------------", "------------", "----------------------------------------------------------------------------", "-----------------");
        for(int i = 0; i < cust.size(); i++) {
            System.out.printf(cust.get(i).toString());
        }
        System.out.printf("%-7s \t %-20s \t %-11s \t %-13s \t %s\n", "-------------", "---------------------", "------------", "----------------------------------------------------------------------------", "-----------------");
        System.out.println("\n" + cust.size() + " customer member(s) are shown\n");
    }
    
    //Check the appointment dates by customer ID
    static final void custTreatmentTransaction(ArrayList<Service> serv, ArrayList<Customer> cust) {
        //Local variables declaration
        String custID;
        boolean custFound = false;
        int treatCount = 0;
        
        //Do-while loop to prompt customer ID and find the existing customer member
        do {
        
            System.out.print("Enter customer ID to show appointment list: CUST");
            custID = sc.next();
            sc.nextLine();

            while(!custID.matches("^\\d{4}$")) {
                System.out.println("Invalid customer ID, please try again and ensure the correct customer ID.\n");
                System.out.print("Enter customer ID to search appointment: CUST");
                custID = sc.next();
                sc.nextLine(); 
            }

            //Loop through array to get the object of the entered customer ID
            for(int a = 0; a < cust.size(); a++) {
                if((cust.get(a).getMemberID()).equals("CUST"+custID)) {
                    custFound = true;
                    break;
                } else 
                    custFound = false;
            }

            //If customer is not found in the system, display error message
            if(!custFound)
                System.out.println("Customer not found in the system, please try again and ensure the customer member ID is an existing member.\n");
        } while(!custFound);

        //Display the service list
        //Header
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\tCustomer Treatment Transaction for CUST" + custID);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        //For loop to match the customer ID and display the transaction details
        for(int i = 0; i < serv.size(); i++) {
            if(("CUST"+custID).equals(serv.get(i).getCustomer().getMemberID())) {
                if(serv.get(i).getTreatOrPackage() instanceof Treatment && serv.get(i).getFreeTrials().equals("Yes")) {
                    System.out.println(String.format("%-10s \t %-15s \t %-25s \t %-15s \t\t %-60s \t RM %,8.2f", 
                            serv.get(i).getServiceID(), ft.format(serv.get(i).getServiceDate()), serv.get(i).getCustomer().name.getFullName(), 
                            ((Treatment)serv.get(i).getTreatOrPackage()).getTreatmentCode(), ((Treatment)serv.get(i).getTreatOrPackage()).getTreatmentDesc(), 
                            serv.get(i).getTotalPrice()));
                    treatCount++;
                }
            }
        }
        serviceHeaderFooter("footer1");
        System.out.println("\n" + (treatCount) + " record(s) are shown.\n");
     }
 
    //Check the appointment dates by customer ID
    static final void searchAppointDateByCustID(ArrayList<Service> serv, ArrayList<Customer> cust) {
        String custID;
        boolean custFound = false;
        int custCount = 0;
        
        //Do-while loop to prompt customer ID and find the existing customer member
        do {
        
            System.out.print("Enter customer ID to show appointment list: CUST");
            custID = sc.next();
            sc.nextLine();

            while(!custID.matches("^\\d{4}$")) {
                System.out.println("Invalid customer ID, please try again and ensure the correct customer ID.\n");
                System.out.print("Enter customer ID to search appointment: CUST");
                custID = sc.next();
                sc.nextLine(); 
            }

            //Loop through array to get the object of the entered customer ID
            for(int a = 0; a < cust.size(); a++) {
                if((cust.get(a).getMemberID()).equals("CUST"+custID)) {
                    custFound = true;
                    break;
                } else 
                    custFound = false;
            }

            //If customer is not found in the system, display error message
            if(!custFound)
                System.out.println("Customer not found in the system, please try again and ensure the customer member ID is an existing member.\n");
        } while(!custFound);

        //Display the service list
        serviceHeaderFooter("header");
        for(int i = 0; i < serv.size(); i++) {
            if(("CUST"+custID).equals(serv.get(i).getCustomer().getMemberID())) {
                System.out.println(serv.get(i).toString());
                custCount++;
            }
        }
        serviceHeaderFooter("footer");
        System.out.println("\n" + custCount + " record(s) are shown.\n");
    }
}
