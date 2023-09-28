/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package progassignfinalparttwo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 *
 * @author lab_services_student
 */

/*
****Please note:
There are 2 test files created
1 test file tests methods in the parent class - Patients
1 test file tests methods in the child class - Appointments
*/

public class PatientsTest {
    
    //appoint of Patients class declared
    private Patients appoint;

    @Before
    // setUp() method runs before each test method which reduces for repetition in initialising appoints in each test method
    public void setUp() {
        appoint = new Patients();
    }

    @Test
    //Test method checks that only "M" or "F" can be chosen for male or female respectively
    public void testChooseSexValidOption() {
        //Upper casing used
        String gender1 = "M";
        String gender2 = "F";
        //Lower casing used to ensure method accepts either "M" or "F" irrespective of their casing
        String gender3 = "m";
        String gender4 = "f";
        assertTrue(appoint.chooseSex(gender1));
        assertTrue(appoint.chooseSex(gender2));
        assertTrue(appoint.chooseSex(gender3));
        assertTrue(appoint.chooseSex(gender4));
    }

    @Test
    //Test method ensures that the method deals correctly with an invalid gender option by returning false value
    public void testChooseSexInvalidOption() {
        String invalidGender1 = "X"; //random input for gender that is not male or female
        String invalidGender2 = "Y";
        assertFalse(appoint.chooseSex(invalidGender1));
        assertFalse(appoint.chooseSex(invalidGender2));
    }


    @Test
    //Test method checks whether CapsName() method capitalises names accordingly
    public void testCapsName() {
        String originalName1 = "levi ackerman";
        String expectedName1 = "Levi Ackerman";
        String originalName2 = "abdul basit deshmukh";
        String expectedName2 = "Abdul Basit Deshmukh";
        assertEquals(expectedName1, appoint.CapsName(originalName1));
        assertEquals(expectedName2, appoint.CapsName(originalName2));
    }

    @Test
    //Test method checks that the patient's details are saved using the savePatientDetails() method
    public void testSavePatientDetails() {
        appoint.savePatientDetails("Moe Khan", "Male", 30, "0875478623"); //patient's details are saved
        assertNotNull(appoint.getPatientNames()); //checks that the patientNames ArrayList is not Empty
        
        //checks that details are saved accordingly and matches expected details
        assertEquals("Moe Khan", appoint.getPatientNames().get(0));
        assertEquals("Male", appoint.getPatientSex().get(0));
        assertSame(30,appoint.getPatientAges().get(0));
        assertEquals("0875478623", appoint.getContactDetails().get(0));
    }

}