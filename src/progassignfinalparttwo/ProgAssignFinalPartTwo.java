/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progassignfinalparttwo;

import java.util.Scanner;

/**
 *
 * @author Abdul
 */
public class ProgAssignFinalPartTwo {

    /**
     * @param args the command line arguments
     */
    
    /*
    References
    https://www.youtube.com/watch?v=ceGnVDrMy1A
    https://www.youtube.com/watch?v=xNVlq9IEBEg
    https://www.youtube.com/watch?v=pTAda7qU4LY
    */
    
    /*
    This program helps receptionists with managing appointments for a clinic.
    Patients details are saved and they can select a time appropriate for them
    A maximum of 5 bookings can be made with each booking lasting for an hour
    Some of the additional features of this program include: 
    --> Find available times for booking
    --> Display the bookings made
    --> Delete a booking for a certain patient
    */
    
    final static String WELCOME = "Welcome to the Appointment Manager Program";
    final static String MENU = "Please select from the following options:"
            + "\n1) Book an appointpointment"
            + "\n2) Find available booking times"
            + "\n3) Show all bookings made"
            + "\n4) Delete booking"
            + "\n5) Exit appointplication"
            + "\n\n Enter the number from above menu option>>>";
    final static String CONTINUE = "Enter \"Y\" to continue or any other character to exit>>>";
    
    static Scanner kb = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        //creates object for Appoinments class
        Appointments appoint = new Appointments();
        //Creates the default available booking times for the day
        appoint.defaultDailyTimes();
        
        System.out.println(WELCOME);
        
        System.out.println(CONTINUE);
        String input = kb.nextLine();
        
        while (input.equalsIgnoreCase("y")) {
            System.out.println(MENU);
            String programChoice = kb.nextLine();
            
            switch (programChoice) {
                
                case "1" :
                    
                    if (!appoint.getBookingTimes().isEmpty()) {  //Patients details can only be added when bookings are available
                    System.out.println("Please enter your name>>>");
                    String name = kb.nextLine();
                    
                    System.out.println("Please enter your age>>>");
                    String checkAge = kb.nextLine();
                    //loop created and runs until valid numerical value entered
                    while (!appoint.isAgeNumeric(checkAge)) {
                        System.out.println(appoint.ageNumericMessage(checkAge));
                        System.out.println("Please enter age again>>>");
                        checkAge = kb.nextLine();
                    }
                    int age = Integer.parseInt(checkAge); //String age converted to integer
                    
                    System.out.println("Please enter your sex"
                            + "\n Enter \"M\" for male or \"F\" for female>>>");
                    
                    String checkSex = kb.nextLine();
                    //loop runs until patient's sex is entered and valid
                    while (!appoint.chooseSex(checkSex)) {
                        System.out.println(appoint.chooseSexMessage(checkSex));
                        System.out.println("Please enter your sex"
                            + "\n Enter \"M\" for male or \"F\" for female>>>");
                        checkSex = kb.nextLine();
                    }
                    String patientSex = "";
                        if (checkSex.equalsIgnoreCase("M")) {
                            patientSex = "Male"; 
                        }
                        
                        else if (checkSex.equalsIgnoreCase("F")) {
                            patientSex = "Female";
                        }
                    
                    System.out.println("Please enter your contact number>>>");
                    String contact = kb.nextLine();
                    
                    System.out.println("\nPlease select a time from the following"
                            + "\nEnter the number only");
                    System.out.println(appoint.bookingTimesAvailable());
                    int timeChoice = kb.nextInt();
                    //loop ensures only available times can be booked for
                    while (true) {
                        if (timeChoice > 0 && timeChoice <= appoint.getBookingTimes().size()) {
                            break;
                        }
                        else{
                            System.out.println("Enter a valid time below \n Select the number>>>"
                                    + "\n" + appoint.bookingTimesAvailable());
                            timeChoice = kb.nextInt();
                        }
                    }
                    //books time according to patient's choice
                    appoint.bookedTime(timeChoice);
                    kb.nextLine(); //Consumes newline character since to avoid unexpected behaviour from using kb.nextLine() after kb.nextInt()
                    
                    //patients details are saved
                    appoint.savePatientDetails(name, patientSex, age, contact);
                    ContinueProgram();
                    }
                    
                    else{
                        System.out.println("No bookings available today");
                        ContinueProgram();
                    }
                    
                    break;
                    
                case "2": 
                    System.out.println(appoint.bookingTimesAvailable()); //displays available booking times
                    ContinueProgram();
                    break;
                    
                case "3": 
                    System.out.println(appoint.displayPatients());   //displays all patients that booked
                    ContinueProgram();
                    break;
                    
                case "4":
                    System.out.println("Enter the name of patient whose booking will be deleted>>>");
                    String patientDelete = kb.nextLine();
                    System.out.println(appoint.deleteBooking(patientDelete)); //deletes booking for a patient
                    ContinueProgram();
                    break;
                    
                case "5":
                    System.exit(0);
                    
                default: System.out.println("Invalid option selected");    
            }//switch ends
            
        }
        
        
    }
    
    //Method that checks with user whether to continue with program or quit
    public static void ContinueProgram(){
        System.out.println("Do you wish to continue?"
                + "\nEnter \"Y\" to continue to any other key to exit>>>");
        if (!kb.nextLine().equalsIgnoreCase("Y")) {
            System.exit(0);
        }
    }
    
}
