package business;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimeManagementTest {
	private short year;
	private byte month;
	private static TimeManagement timeManagement;

	@BeforeClass
	public static void setUpTestObjects() {
		timeManagement = new TimeManagement();
	}

	@Before
	public void setUpTestDatas() {
		year = 2000;
		month = 2;
	}

	@Test
	public void testGetDaysInMonth_MonthIsJanMarMayJulAugOctDec_Return31() {
		// setup
		byte[] months = { 1, 3, 5, 7, 8, 10, 12 };
		int random = new Random().nextInt(months.length);
		byte month = months[random];

		// execute
		byte actual = timeManagement.getDaysInMonth(year, month);

		// assert
		byte expected = 31;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDaysInMonth_MonthIsAprJunSepNov_Return30() {
		// setup
		byte[] months = { 4, 6, 9, 11 };
		int random = new Random().nextInt(months.length);
		byte month = months[random];

		// execute
		byte actual = timeManagement.getDaysInMonth(year, month);

		// assert
		byte expected = 30;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDaysInMonth_MonthIsFebruaryAndYearDivisibleBy400_Return29() {
		// execute
		byte actual = timeManagement.getDaysInMonth(year, month);

		// assert
		byte expected = 29;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDaysInMonth_MonthIsFebruaryAndYearDivisibleBy100ButNot400_Return28() {
		// setup
		year = 1900;

		// execute
		byte actual = timeManagement.getDaysInMonth(year, month);

		// assert
		byte expected = 28;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDaysInMonth_MonthIsFebruaryAndYearDivisibleBy4ButNot400And100_Return29() {
		// setup
		year = 2004;

		// execute
		byte actual = timeManagement.getDaysInMonth(year, month);

		// assert
		byte expected = 29;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDaysInMonth_MonthIsFebruaryAndYearNotDivisibleBy4_Return28() {
		// setup
		year = 2005;

		// execute
		byte actual = timeManagement.getDaysInMonth(year, month);

		// assert
		byte expected = 28;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDaysInMonth_InValidMonth_Return0() {
		// setup
		month = 13;

		// execute
		byte actual = timeManagement.getDaysInMonth(year, month);

		// assert
		byte expected = 0;
		assertEquals(expected, actual);
	}
}
