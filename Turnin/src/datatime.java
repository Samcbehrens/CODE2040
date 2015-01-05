import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Problem 4 of the CODE 2040 API Challenge: Add seconds to ISO datestamp format
 * 
 * @author sambehrens
 *
 */

public class datatime {

	Stack<Float> Times;

	int calcMonth;
	int calcDay;

	int finalYear;
	int finalMonth;
	int finalDay;
	int finalHour;
	int finalMinute;
	int finalSecond;
	int finalMillis;
	int timeZonehours;
	int timeZoneminutes;

	int addYear;
	int addMonth;
	int addDay;
	int addHour;
	int addMinute;
	int addSecond;

	int parsedYear;
	int parsedMonth;
	int parsedDay;
	int parsedHour;
	int parsedMinute;
	int parsedSecond;
	int parsedMillis;

	/***
	 * conversion of total seconds into years, months, days, hours, minutes, and
	 * remaining seconds. Returns a stack with the values
	 * 
	 * @param seconds
	 *            integer seconds passed in
	 * @return Integer stack with conversion
	 */
	public void converstion(int seconds) {

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

		this.addSecond = seconds % 60;
		int totalMinutes = (int) Math.floor(seconds / 60);
		int minutestoAdd = totalMinutes % 60;
		this.addMinute = minutestoAdd;

		float totalHours = (float) Math.floor(totalMinutes / 60);
		float hourstoAdd = totalHours % 24;
		this.addHour = (int) hourstoAdd;

		float totalDays = (float) Math.floor(totalHours / 24);// minutes,hours,days
		this.addDay = (int) totalDays;

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
	public void parser(String initStringtime) {
		Vector<Integer> dateTimestack = new Vector<Integer>();
		StringTokenizer findNum = new StringTokenizer(initStringtime, "T-:+Z .");

		while (findNum.hasMoreTokens()) {
			String token = findNum.nextToken();
			dateTimestack.add(Integer.parseInt(token));
		}

		int count = 0;

		if (count <= dateTimestack.size() - 1) {
			this.parsedYear = dateTimestack.get(count);
			// System.out.println(intYear + "year");
			count++;
		}

		if (count <= dateTimestack.size() - 1) {
			this.parsedMonth = dateTimestack.get(count);
			// System.out.println(intMonth + "Month");
			count++;
		}

		if (count <= dateTimestack.size() - 1) {
			this.parsedDay = dateTimestack.get(count);
			// System.out.println(intDay + "Day");
			count++;
		}
		if (count <= dateTimestack.size() - 1) {
			this.parsedHour = dateTimestack.get(count);
			// System.out.println(intHour + "Hour");
			count++;
		}

		if (count <= dateTimestack.size() - 1) {
			this.parsedMinute = dateTimestack.get(count);
			// System.out.println(intMinute + "minute");
			count++;
		}

		if (count <= dateTimestack.size() - 1) {
			this.parsedSecond = dateTimestack.get(count);
			// System.out.println(intSecond + "second");
			count++;
		}

		if (count <= dateTimestack.size() - 1) {
			this.parsedMillis = dateTimestack.get(count);
			// System.out.println(intMillis+"millis");
			count++;
		}
		setMillis(parsedMillis);

		if (count <= dateTimestack.size() - 1) {
			timeZonehours = dateTimestack.get(count);
			count++;
		}

		if (count <= dateTimestack.size() - 1) {
			timeZoneminutes = dateTimestack.get(count);
			count++;
		}

	}

	/**
	 * Considering that each month has a different number of days, this
	 * calculates the resulting month by subtracting the total days depending on
	 * the month
	 * 
	 * @param addDay
	 *            total days calculated from seconds
	 * @param parsedMonth
	 *            month parsed from original ISO datestamp
	 */
	public void FindMonth() {
		
		
		this.calcDay = addDay+parsedDay;
		this.calcMonth = parsedMonth;
		
		finalHour = parsedHour + addHour;
		
		if (finalHour >= 24) {
			calcDay = calcDay + 1;
		
		}
		while (calcDay > 28) {

			if (calcMonth == 13) {
				calcMonth = 1;
			}
			if (calcMonth == 9 || calcMonth == 4 || calcMonth == 6
					|| calcMonth == 11 && calcDay >= 31) {
				calcDay = calcDay - 30;
				calcMonth = calcMonth + 1;
				

			} else if ((calcMonth == 2 && calcDay >= 31)) {
				calcDay = calcDay - 28;
				calcMonth = calcMonth + 1;
			

			} else if (calcDay >= 31) {
				calcDay = calcDay - 31;
				calcMonth = calcMonth + 1;
				
			}else{
				break;
			}
			
		}
		
		addMonth = calcMonth;
	}

	public String formatOutputString(String initStringtime,
			Boolean isTimezonePos) {
		String finalOutput = "" + this.finalYear + "-";

		if (this.finalMonth < 10) {
			finalOutput = finalOutput + 0;

		}

		finalOutput = finalOutput + this.finalMonth + "-";

		if (this.finalDay < 10) {
			finalOutput = finalOutput + 0;
		}
		finalOutput = finalOutput + this.finalDay + "T";

		if (this.finalHour < 10) {
			finalOutput = finalOutput + 0;
		}
		finalOutput = finalOutput + this.finalHour + ":";

		if (this.finalMinute < 10) {
			finalOutput = finalOutput + 0;
		}
		finalOutput = finalOutput + this.finalMinute + ":";

		if (this.finalSecond < 10) {
			finalOutput = finalOutput + 0;
		}
		finalOutput = finalOutput + this.finalSecond;

		if (this.finalMillis >= 0) {
			String[] getRideofmill = initStringtime.split("\\.");
			String[] millis = getRideofmill[getRideofmill.length - 1]
					.split("\\s");
			finalOutput = finalOutput + "." + millis[millis.length - 1];

		}

		return finalOutput;

	}

	public void adder() {

		// /DOESNT DEAL WITH LEEP YEARS :S
		addYear = (int) Math.floor((this.addDay / 365));

		finalYear = parsedYear + addYear;

		// if months are greater than a year
		
		finalMonth = this.calcMonth;
		
		this.finalDay = parsedDay + calcDay;
		if(finalDay>28){
			if (finalMonth == 9 || finalMonth == 4 || finalMonth == 6
					|| finalMonth == 11 && finalDay>=31) {
				finalDay=finalDay-30;
				finalMonth++;
			}
			else if (finalMonth == 2 && finalDay>=29){
				finalDay=finalDay-28;
				finalMonth++;
			}
			else if(finalMonth != 2||finalMonth != 9 || finalMonth != 4 || finalMonth != 6
					|| finalMonth != 11 && finalDay>32){
				finalDay=finalDay-31;
				finalMonth++;
			}

		}
		

		finalHour = parsedHour + addHour;
		
		if (finalHour >= 24) {
			finalDay = finalDay + 1;
			finalHour = finalHour % 24;
		}

		finalMinute = parsedMinute + addMinute;
		if (this.parsedMinute >= 60) {
			finalHour = finalHour + 1;
			finalMinute = finalMinute % 60;
		}

		finalSecond = parsedSecond + addSecond;
		if (finalSecond >= 60) {
			finalMinute = finalMinute + 1;
			finalSecond = finalSecond % 60;
		}

	}

	public boolean isTimezonePos(String givenString) {
		int doesPosexist = givenString.indexOf("+", givenString.length() - 4);
		if (doesPosexist >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setMillis(int millis) {
		this.finalMillis = millis;
	}

	public static void main(String args[]) {

		// put interval time here
		int interval = 292781130;

		datatime dataTimeobject = new datatime();

		// put initial time here
		String initStringtime = "2026-03-22T22:17:00.000Z";
		//String initStringtime ="0000-00-00T00:00:00.000Z";

		dataTimeobject.parser(initStringtime);
		dataTimeobject.converstion(interval);
		dataTimeobject.FindMonth();
		dataTimeobject.adder();
		Boolean isPos = dataTimeobject.isTimezonePos(initStringtime);
		String finalOutput = dataTimeobject.formatOutputString(initStringtime,
				isPos);

		System.out.println(finalOutput);
		System.out.println(initStringtime + "original number");
	}
}
