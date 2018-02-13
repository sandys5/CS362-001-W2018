package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=28;
		 int startMonth=2;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(28, appt.getStartDay());
		 assertEquals(2, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	 public void test02() throws Throwable {
	 	int[] arr = {3, 3, 3};
	 	Appt myAppt = new Appt(1, 2, 3, 4, 2018, "Study", "sleep");
	 	myAppt.setRecurrence(arr,3, 3, 3);

	 	assertEquals(3, myAppt.getRecurNumber());
	 	assertEquals(3, myAppt.getRecurIncrement());
	 	assertEquals(3, myAppt.getRecurBy());
	 	assertEquals(true, myAppt.isRecurring());
	 	myAppt.setRecurrence(null, 3, 3, 3);
	 	assertEquals(0, myAppt.getRecurDays().length);
	 }

//add more unit tests as you needed
	
}
