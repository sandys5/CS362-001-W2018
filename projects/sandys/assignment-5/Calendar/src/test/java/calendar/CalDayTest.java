package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 GregorianCalendar day = new GregorianCalendar(1995, 02, 02);
		 CalDay calday = new CalDay(day);
		 assertEquals(1995, calday.getYear());
		 assertEquals(2, calday.getMonth());
		 assertEquals(2, calday.getDay());
		 assertEquals(0, calday.getSizeAppts());
	 }

	 @Test
	  public void test02()  throws Throwable  {
	 	GregorianCalendar day = new GregorianCalendar(1995, 2, 2);
	 	CalDay calday = new CalDay(day);
	 	Appt myAppt = new Appt(3, 6, 2, 2, 1995, "Party", "partay");

	 	assertEquals(3, myAppt.getStartHour());
	 	assertEquals(6, myAppt.getStartMinute());
	 	assertEquals(2, myAppt.getStartDay());
	 	assertEquals(2, myAppt.getStartMonth());
	 	assertEquals(1995, myAppt.getStartYear());
	 	assertEquals("Party", myAppt.getTitle());
	 	assertEquals("partay", myAppt.getDescription());
	 	assertEquals(myAppt.getStartDay(), calday.getDay());
	 	assertEquals(myAppt.getStartMonth(), calday.getMonth());
	 	assertEquals(myAppt.getStartYear(), calday.getYear());
	 }
//add more unit tests as you needed	
}
