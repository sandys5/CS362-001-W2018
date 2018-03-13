package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int[] arr = {3, 3, 3};
		 Appt myAppt = new Appt(1, 2, 35, 2, 2020, "Study", "sleep");
		 myAppt.setRecurrence(arr,3, 3, 3);

		 assertEquals(3, myAppt.getRecurNumber());
		 assertEquals(3, myAppt.getRecurIncrement());
		 assertEquals(3, myAppt.getRecurBy());
		 assertEquals(true, myAppt.isRecurring());
		 myAppt.setRecurrence(null, 3, 3, 3);
		 assertEquals(0, myAppt.getRecurDays().length);
		 assertFalse(myAppt.getValid());

	 }
	 @Test
	  public void test02()  throws Throwable  {
		 GregorianCalendar day = new GregorianCalendar(1995, 2, 2);
		 CalDay calday = new CalDay(day);
		 Appt myAppt = new Appt(50, 69, 2, 2, 1995, "Party", "partay");

		 assertEquals(2, myAppt.getStartMonth());
		 assertEquals(1995, myAppt.getStartYear());
		 assertEquals("Party", myAppt.getTitle());
		 assertEquals("partay", myAppt.getDescription());
		 assertEquals(myAppt.getStartDay(), calday.getDay());
		 assertEquals(myAppt.getStartMonth(), calday.getMonth());
		 assertEquals(myAppt.getStartYear(), calday.getYear());

		 assertFalse(myAppt.getValid());
		 
	 }
//add more unit tests as you needed
}
