/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package progassignfinalparttwo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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

public class AppointmentsTest {
    
    //instance of Appointments class created and named as "appoint"
    private Appointments appoint;
    
    @Before
    public void setUp() {
        appoint = new Appointments();
    }
    

    @Test
    //Tests that the default Booking times are filled and available for the user
    public void testDefaultDailyTimes() {
        appoint.defaultDailyTimes();//
        assertFalse(appoint.getBookingTimes().isEmpty());
    }

    @Test
    //Tests that the user is displayed with the correct booking times as saved
    public void testBookingTimesAvailableWithAvailableTimes() {
        appoint.defaultDailyTimes(); //saves the default times for available bookings
        String expectedMessage = "These are the available times:\n"
                + "\n1) 8:00 - 9:00"
                + "\n2) 9:00 - 10:00"
                + "\n3) 10:00 - 11:00"
                + "\n4) 11:00 - 12:00"
                + "\n5) 12:00 - 13:00";
        String actualMessage = appoint.bookingTimesAvailable();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    //Tests that no bookings available
    public void testBookingTimesAvailableWithNoAvailableTimes() {
        appoint.defaultDailyTimes(); //default Times are added
        
        //All available times are booked below
        appoint.bookedTime(5);
        appoint.bookedTime(4);
        appoint.bookedTime(3);
        appoint.bookedTime(2);
        appoint.bookedTime(1);
        
        //checks no booking times available
        String expectedMessage = "No available times for booking";
        String actualMessage = appoint.bookingTimesAvailable();
        assertEquals(expectedMessage,actualMessage);
    }

    
}
