/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progassignfinalparttwo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Abdul
 */

//child class - use of inheritance
public class Appointments extends Patients{
    
    //additional ArrayLists for patient's bookings
    private ArrayList<Integer> bookingTimes;
    private ArrayList<Integer> reservedTimes;

    //constructor to initialise variables
    public Appointments() {
        super();
        bookingTimes = new ArrayList<>(); //holds available booking times
        reservedTimes = new ArrayList<>(); //holds times booked by patients
    }    
    
    //default booking times for the day
    public void defaultDailyTimes(){
        bookingTimes.add(8);
        bookingTimes.add(9);
        bookingTimes.add(10);
        bookingTimes.add(11);
        bookingTimes.add(12);
    }

    //getter methods
    public ArrayList<Integer> getBookingTimes() {
        return bookingTimes;
    }

    public ArrayList<Integer> getReservedTimes() {
        return reservedTimes;
    }
    
    //Overrides the displayPatients() method from parent class to include the Time variable
    @Override
    public String displayPatients() {
         String patientReport = "";
        
        for (int i = 0; i < super.getPatientNames().size(); i++) {
            patientReport += "\nPatient " + (i+1)
                    + "\nName: " + super.getPatientNames().get(i)
                    + "\nAge: " + super.getPatientAges().get(i)
                    + "\nSex: " + super.getPatientSex().get(i)
                    + "\nContact Details: " + super.getContactDetails().get(i)
                    + "\nTime Booked: " + reservedTimes.get(i) + ":00 - " + (reservedTimes.get(i)+1) + ":00\n";
        }
        
        if (super.getPatientNames().isEmpty()) {
            return "No details to show";
        }
        
        else{
            return patientReport;
        }
    }
    
    //method displays which times are available to book for
    public String bookingTimesAvailable(){
        String availTimes;      
        if (!bookingTimes.isEmpty()) {
            availTimes = "These are the available times:\n";
            for (int i = 0; i < bookingTimes.size(); i++) {
                availTimes += "\n" + (i+1) +") " + bookingTimes.get(i) + ":00 - " + (bookingTimes.get(i)+1) + ":00";
            }
        }
        else {
            availTimes = "No available times for booking"; //Message shown when clinic is booked out
        }
        return availTimes;
    }
    
    //method updates the booking times available after patients book for their sessions
    public void bookedTime(int index){
        reservedTimes.add(bookingTimes.get(index-1));
        bookingTimes.remove(index-1); //removes the available time, taken by patient
    }

    //method deletes the booking, patient's details and updates the booking times available accordingly
    public String deleteBooking(String patientToDelete){
        boolean found = false;
        for (int i = 0; i < getPatientNames().size(); i++) {
            if (patientToDelete.equalsIgnoreCase(getPatientNames().get(i))) {
                int indexToDelete = i;
                patientNames.remove(indexToDelete);
                patientSex.remove(indexToDelete);
                patientAges.remove(indexToDelete);
                contactDetails.remove(indexToDelete);
                bookingTimes.add(reservedTimes.get(indexToDelete)); //after a patient's booking is deleted, their appointed time is available again in the system
                reservedTimes.remove(indexToDelete);
                Collections.sort(bookingTimes); //sorts the available booking times ArrayList in ascending order
                found = true;
            }   
        }
        if (found) {
            return "Patient details have been deleted";
        }
        else {
                return "Patient name was not found";
            }
    }

    
    
}
