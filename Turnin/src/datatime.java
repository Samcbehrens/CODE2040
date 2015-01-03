import java.util.Stack;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * Problem 4 of the CODE 2040 API Challenge: Add seconds to ISO datestamp format
 * 
 * @author sambehrens
 *
 */

public class datatime {

	Stack<Float> Times;
	int month;
	int days;

	/***
	 * conversion of total seconds into years, months, days, hours, minutes, and
	 * remaining seconds. Returns a stack with the values
	 * 
	 * @param seconds
	 *            integer seconds passed in
	 * @return Integer stack with conversion
	 */
	public Stack<Float> converstion(int seconds) {
		Times = new Stack<Float>();

		/*
		 * could also use this format for conversion int day =
		 * (int)TimeUnit.SECONDS.toDays(seconds); System.out.println(day+"day");
		 * long hours = TimeUnit.SECONDS.toHours(seconds) - (day *24);
		 * System.out.println(hours+"hours"); long minute =
		 * TimeUnit.SECONDS.toMinutes(seconds) -
		 * (TimeUnit.SECONDS.toHours(seconds)* 60);
		 * System.out.println(minute+"minute"); long second =
		 * TimeUnit.SECONDS.toSeconds(seconds) -
		 * (TimeUnit.SECONDS.toMinutes(seconds) *60);
		 * System.out.println(second+"second");
		 */

		float secondstoAdd = seconds % 60;
		Times.push(secondstoAdd);
		System.out.println(secondstoAdd + "secondstoadd");

		float totalMinutes = (float) Math.floor(seconds / 60);
		float minutestoAdd = totalMinutes % 60;
		Times.push(minutestoAdd);
		System.out.println(minutestoAdd + "minutestoadd");

		float totalHours = (float) Math.floor(totalMinutes / 60);
		float hourstoAdd = totalHours % 24;
		Times.push(hourstoAdd);
		System.out.println(hourstoAdd + "hoursToAdd");

		float totalDays = (float) Math.floor(totalHours / 24);// minutes,hours,days
		Times.push(totalDays);
		System.out.println(totalDays + "totalDays");

		
		return Times;
	}

	/***
	 * This function parses the time string into years, months, days, hours,
	 * minutes, seconds
	 * 
	 * @param initStringtime
	 *            string representation of ISO time format
	 * @return Stack Integer Stack of all parsed values without non number
	 *         characters
	 */
	public Stack<Integer> parser(String initStringtime) {
		Stack<Integer> dateTimestack = new Stack<Integer>();
		StringTokenizer findNum = new StringTokenizer(initStringtime, "T-:+Z .");

		while (findNum.hasMoreTokens()) {
			String token = findNum.nextToken();
			dateTimestack.push(Integer.parseInt(token));
		}

		return dateTimestack;

	}

	/**
	 * Considering that each month has a different number of days, this
	 * calculates the resulting month by subtracting the total days depending on
	 * the month
	 * 
	 * @param intDay
	 *            total days calculated from seconds
	 * @param intMonth
	 *            month parsed from original ISO datestamp
	 */
	public void FindMonth(float intDay, int intMonth) {


		while (intDay > 28) {

			if (intMonth == 12) {
				intMonth = 0;
			}

			if (intMonth == 9 || intMonth == 4 || intMonth == 6
					|| intMonth == 11 && intDay >= 31) {
				intDay = intDay - 30;
				intMonth = intMonth + 1;

			} else if ((intMonth == 2 && intDay >= 31)) {
				intDay = intDay - 28;
				intMonth = intMonth + 1;

			} else if (intDay >= 31) {
				intDay = intDay - 31;
				intMonth = intMonth + 1;
			}
		}
		this.month = intMonth;
		this.days = (int) intDay - 30;
	}

	/**
	 *
	 * @return month that is calculated from Find Month method
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return days that are calculated from Find Month method
	 */
	public int getDay() {
		return days;
	}

	public static void main(String args[]) {

		// put interval time here
		int interval = 292781130;// DOESNT DO YEARS ROLLOVER AND WIPE OLD MONTHS

		datatime dataTimeobject = new datatime();

		// put initial time here
		String initStringtime = "2026-03-22T22:17:00.000Z";
		String otherExample="";
		System.out.println(otherExample);
		System.out.println(initStringtime + " original number");

		Stack<Integer> ParsedNum = dataTimeobject.parser(initStringtime);
		int intMillis=0;
		int intSecond=0;
		int intMinute=0;
		int intHour=0;
		int intDay=0;
		int intMonth=0;
		int intYear=0;
		
		if (ParsedNum.peek() != null) {
			intMillis=ParsedNum.pop();
		}

		if (ParsedNum.peek() != null) {
			intSecond = ParsedNum.pop();
			System.out.println(intSecond + "second");
		}
		if (ParsedNum.peek() != null) {
			 intMinute = ParsedNum.pop();
			System.out.println(intMinute + "minute");
		}
		if (ParsedNum.peek() != null) {
			 intHour = ParsedNum.pop();
			System.out.println(intHour+"Hour");
		}
		if (ParsedNum.peek() != null) {
			 intDay = ParsedNum.pop();
			System.out.println(intDay+"Day");
		}
		if (ParsedNum.peek() != null) {
			 intMonth = ParsedNum.pop();
			System.out.println(intMonth + "Month");
		}
		if (ParsedNum.peek() != null) {
			 intYear = ParsedNum.pop();
			System.out.println(intYear+"year");
		}
		
		// convert interval into year, moth, days,hours,minutes,seconds
		Stack<Float> outputStack = dataTimeobject.converstion(interval);

		float daystoAdd = outputStack.pop();
		float hourstoAdd = outputStack.pop();
		float minutestoAdd = outputStack.pop();
		float secondstoAdd = outputStack.pop();

		dataTimeobject.FindMonth(daystoAdd, intMonth);// PASSED THIS VALUE IN
														// WRONG.
		int monthstoAdd = dataTimeobject.getMonth();
		int finalDay = dataTimeobject.getDay();

		intMonth = dataTimeobject.getMonth();

		// /DOESNT DEAL WITH LEEP YEARS :S
		int yearsToadd = (int) Math.floor((daystoAdd / 365));
		intYear = intYear + yearsToadd;

		// if months are greater than a year
		if (monthstoAdd > 12) {
			intMonth = monthstoAdd % 12;
		}

		intDay = (int) (intDay + finalDay);

		intHour = (int) (intHour + hourstoAdd);
		if (intHour >= 24) {
			intDay = intDay + 1;
			intHour = intHour % 24;
		}

		intMinute = (int) (intMinute + minutestoAdd);
		if (intMinute >= 60) {
			intHour = intHour + 1;
			intMinute = intMinute % 60;
		}

		intSecond = (int) (intSecond + secondstoAdd);
		if (intSecond >= 60) {
			intMinute = intMinute + 1;
			intSecond = intSecond % 60;
		}

		String finalOutput = "" + intYear + "-";

		if (intMonth < 10) {
			finalOutput = finalOutput + 0;

		}

		finalOutput = finalOutput + intMonth + "-";

		if (intDay < 10) {
			finalOutput = finalOutput + 0;
		}
		finalOutput = finalOutput + intDay + "T";

		if (intHour < 10) {
			finalOutput = finalOutput + 0;
		}
		finalOutput = finalOutput + intHour + ":";

		if (intMinute < 10) {
			finalOutput = finalOutput + 0;
		}
		finalOutput = finalOutput + intMinute + ":";

		if (intSecond < 10) {
			finalOutput = finalOutput + 0;
		}
		finalOutput = finalOutput + intSecond;

		if (initStringtime.contains("Z")) {
			if(initStringtime.indexOf(".")>17){
				finalOutput = finalOutput +"."+ intMillis+"00"+"Z";
			}
			
		} else {
			String[] getRideofmill = initStringtime.split("\\+");
			String[] millis = getRideofmill[getRideofmill.length - 1]
					.split("\\s");

			finalOutput = finalOutput + " + " + millis[millis.length - 1];

		}

		System.out.println(finalOutput);
		System.out.println(initStringtime+"original number");
		System.out.println("suppose to be july 1 2035");
	}
}
