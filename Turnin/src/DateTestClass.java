
public class DateTestClass {

	public static void main(String[] args){
	datatime tester= new datatime();
	String testString="0000-01-01T00:00:00.000Z";
	System.out.println(testString+"initstring");
	tester.parser(testString);
	tester.converstion(5184000);
	tester.FindMonth();
	tester.adder();
	String output=tester.formatOutputString(testString, false);
	System.out.println(output);
}
}