/**
 * @(#)BeautyParlour.java
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Main program driver which is the main class that consists of the main 
 * function to run all the classes.
 * 
 * @version 1.00 2017/7/28
 * @version 2.00 2017/9/19
 */

//Imports
import java.util.ArrayList;
import java.text.ParseException;

public final class BeautyParlour {
    public static void main(String[] args) throws ParseException {
        //Create all the necessary objects to initialise the application
        ArrayList<Beautician> beau = Utility.predefinedBeauticians();
        ArrayList<Customer> cust = Utility.predefinedCustomers();
        ArrayList<Treatment> treat = Utility.predefinedTreatment();
        ArrayList<Package> packg = Utility.predefinedPackage(treat);
        ArrayList<Service> serv = Utility.predefinedService(treat, packg, cust, beau);

        //Local variable declaration
        int loginUser = 0;
        String choice, registrationChoice, recordsChoice;
        boolean backToMainMenu = false;
        
        //Company name header
        Utility.companyLogoHeader();
        
        //Main system
        do {
            choice = Utility.systemMainScreen();
            if(choice.equals("1")) {
            	//Call the login methods
                ///loginUser = Utility.login();
                loginUser = 1;
                do {
                    //Set backToMainMenu flag to false - Reset flag everytime after each menu
                    backToMainMenu = false;
                    
                    //Display the System Main Menu
                    choice = Utility.systemMainMenu();                      

                    //Main Menu choice check
                    if(choice.equals("1")) {
                        //Make new service
                        Service.newService(serv, treat, packg, cust, beau);
                        backToMainMenu = true;
                    } else if(choice.equals("2")) {
                        //Registration
                        registrationChoice = Utility.registrationMenu();

                        //Check for sub menu choice
                        if (registrationChoice.equals("1")) {
                            //Customer registration
                            Customer.registerCustomer(cust);
                        } else if (registrationChoice.equals("2")) {
                            //Beautician registration
                            Beautician.registerBeautician(beau);        
                        } else if (registrationChoice.equals("3")) {
                            //Treatment registration
                            Treatment.registerTreatments(treat);
                        } else if (registrationChoice.equals("4")) {
                            //Package registration
                            Package.registerPackage(packg, treat); 
                        }
                        
                        //Set flag to true, return to main menu after each operation
                        backToMainMenu = true;
                    } else if(choice.equals("3")) {
                        if(loginUser == 1) {
                            //Manager records menu
                            recordsChoice = Utility.managerRecordMenu();
                            if(recordsChoice.equals("1")) {
                                //Customer Treatment Transaction
                                Utility.custTreatmentTransaction(serv, cust);
                            } else if(recordsChoice.equals("2")) {
                                //Display appointment records
                                Utility.displayAppointmentRecords(serv);
                            } else if(recordsChoice.equals("3")) {
                                //Display Bridal reports
                                Utility.bridalReport(serv);
                            } else if(recordsChoice.equals("4")) {
                                //Check beautician details
                                Utility.checkBeauticianDetails(serv, beau);
                            } else if(recordsChoice.equals("5")) {
                                //Display Trial service report
                                Utility.displayTrialService(serv);
                            } else if(recordsChoice.equals("6")) {
                                //Display Treatment list
                                Utility.displayTreatments(treat);
                            } else if(recordsChoice.equals("7")) {
                                //Display package list
                                Utility.displayPackages(packg);
                            } else if(recordsChoice.equals("8")) {
                                //Display customer member list
                                Utility.displayCustomerMember(cust);
                            } else if(recordsChoice.equals("9")) {
                                //Display beautician list with full details
                                Utility.displayBeauticianFullDetails(beau);
                            }
                        } else {
                            //Staff records menu
                            recordsChoice = Utility.staffRecordMenu();
                            if(recordsChoice.equals("1")) {
                                //Display treatments list
                                Utility.displayTreatments(treat);
                            } else if(recordsChoice.equals("2")) {
                                //Display package list
                                Utility.displayPackages(packg);
                            } else if(recordsChoice.equals("3")) {
                                //Display customer member list
                                Utility.displayCustomerMember(cust);
                            } else if(recordsChoice.equals("4")) {
                                //Display beautician list with full details
                                Utility.displayBeauticianFullDetails(beau);
                            } else if(recordsChoice.equals("5")) {
                                //Show appointment dates & details according to customer ID
                                Utility.searchAppointDateByCustID(serv, cust);
                            }
                        }
                        //Set flag to true
                        backToMainMenu = true;
                    }
                } while(backToMainMenu);
            } else {
                System.exit(0);
            }
            //Print newline - Alignment for repeating the menu
            System.out.println("");
        } while(choice.equals("4"));
    }
}