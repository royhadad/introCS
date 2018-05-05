 

public class DateTesterGadi {
	public static void main(String[] args) {
		extremeCases();
		positive31DaysMonths();
		negative31DaysMonths32();
		positive30DaysMonths();
		negative30DaysMonths31();
		febTests();
	}

	private static void febTests() {
		dateTest(29, 2, 2000, true);
		dateTest(29, 2, 1999, false);
		dateTest(28, 2, 2000, true);
		dateTest(28, 2, 1999, true);		
	}

	private static void extremeCases() {
		dateTest(-1, 1, 1900, false);
		dateTest(1, -1, 1900, false);
		dateTest(1, 1, -1900, false);
		dateTest(1, 1, 999, false);
		dateTest(1, 1, 11900, false);
		dateTest(1, 1, 1900, true);		
	}

	private static void negative30DaysMonths31() {
		dateTest(31, 4, 1900, false);
		dateTest(31, 6, 1900, false);
		dateTest(31, 9, 1900, false);
		dateTest(31, 11, 1900, false);
	}

	private static void positive30DaysMonths() {
		dateTest(30, 4, 1900, true);
		dateTest(30, 6, 1900, true);
		dateTest(30, 9, 1900, true);
		dateTest(30, 11, 1900, true);
	}

	private static void negative31DaysMonths32() {
		dateTest(32, 1, 1900, false);
		dateTest(32, 3, 1900, false);
		dateTest(32, 5, 1900, false);
		dateTest(32, 7, 1900, false);
		dateTest(32, 8, 1900, false);
		dateTest(32, 10, 1900, false);
		dateTest(32, 12, 1900, false);
	}

	private static void positive31DaysMonths() {
		dateTest(31, 1, 1900, true);
		dateTest(31, 3, 1900, true);
		dateTest(31, 5, 1900, true);
		dateTest(31, 7, 1900, true);
		dateTest(31, 8, 1900, true);
		dateTest(31, 10, 1900, true);
		dateTest(31, 12, 1900, true);
	}

	private static void dateTest(int day, int month, int year, boolean expectedResult) {
		Date date = new Date(day, month, year);
		boolean result = false;
		if ((isDefault(date) && expectedResult == false) || (!isDefault(date) && expectedResult == true && date.getDay() == day && date.getMonth() == month && date.getYear() == year))
			result = true;
		System.out.println("day = " + day + ", month = " + month + ", year = " + year + " - " + result);
	}

	private static boolean isDefault(Date date) {
		return date.getDay() == 1 && date.getMonth() == 1 && date.getYear() == 2000;
	}
}
