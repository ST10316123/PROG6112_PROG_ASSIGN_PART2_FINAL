/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progassignfinalparttwo;

import java.util.ArrayList;

/**
 *
 * @author Abdul
 */

//Parent class
public class Patients {
    
    //ArrayLists to hold patients' details
    //Advanced arrays
    //Protected ArrayLists allow for the child class to access these variables 
    protected ArrayList<String> patientNames;
    protected ArrayList<String> patientSex;
    protected ArrayList<String> contactDetails;
    protected ArrayList<Integer> patientAges;

    //constructor to initialise variables
    public Patients(){
        patientNames = new ArrayList<>();
        patientAges = new ArrayList<>();
        patientSex = new ArrayList<>();
        contactDetails = new ArrayList<>();
    }
    
    //getter methods
    public ArrayList<String> getPatientNames() {
        return patientNames;
    }

    public ArrayList<String> getPatientSex() {
        return patientSex;
    }

    public ArrayList<String> getContactDetails() {
        return contactDetails;
    }

    public ArrayList<Integer> getPatientAges() {
        return patientAges;
    }
    
    //checks that patient is either male or female
    public boolean chooseSex(String input){
        return (input.equalsIgnoreCase("m") || input.equalsIgnoreCase("f"));
    }
    
    //method returns message based on user's gender input
    public String chooseSexMessage(String input){
        if (chooseSex(input)) {
           return "Valid sex option has been selected"; 
        }
        else{
            return "Invalid sex option selected";
        }
    }
    
    //method checks that age inputted is numeric and catches any invalid character to avoid Exception errors
    public boolean isAgeNumeric(String age){
        try {
            Integer.valueOf(age);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public String ageNumericMessage(String age){
       if (isAgeNumeric(age)) {
            return "Patient's age has been saved!";
        }
        else{
            return "Invalid! Age must be numeric!";
        } 
    }
    
    //method that capitalises patient's name which improves appearance when displaying patient's report 
    // Also provides convenience to user by letting them input names in lower casing while the method changes the casing accordingly
    public String CapsName(String Name){
        String Altered="";
        Name=Character.toUpperCase(Name.charAt(0))+Name.substring(1);
        for (int i = 0; i < Name.length(); i++) {
            
            char vchar = Name.charAt(i);
            if (Character.isSpaceChar(vchar)) {
               Altered+=' '; 
                i++; //ensures that the first character after a blank space is converted to an upper case 
             vchar=Character.toUpperCase(Name.charAt(i)); 
            }
           Altered+=vchar;
            }
        return Altered;
    }
    
    //method to save all patient's details
    public void savePatientDetails(String name, String sex, int age, String contactNum){
        patientNames.add(CapsName(name));
        patientSex.add(sex);
        patientAges.add(age);
        contactDetails.add(contactNum);
    }
    
    //method displays all patients that booked
    public String displayPatients(){
        String patientReport = "";
        
        for (int i = 0; i < patientNames.size(); i++) {
            patientReport += "/nPatient " + (i+1)
                    + "\nName: " + patientNames.get(i)
                    + "\nAge: " + patientAges.get(i)
                    + "\nSex: " + patientSex.get(i)
                    + "\nContact Details: " + contactDetails.get(i);
        }
        
        if (patientNames.isEmpty()) {
            return "No details to show"; //message shown when no bookings have been made
        }
        
        else{
            return patientReport;
        }
    }
    
    
    
}
