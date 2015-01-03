/**
 * Problem 1 of CODE 2040 API Challenge: reverse a string
 * @author sambehrens
 *
 */
public class ReverseString{
	String givenString;
	String newString;
/**
 * 	Uses for loop starting at the end of given String to add to the beginning of new String. 
 * @param givenString	String to reverse
 */
public ReverseString(String givenString){
	
	this.givenString =givenString;
	this.newString="";
	
	for(int i=givenString.length();i>0;i=i-1){
		this.newString=newString+(givenString.charAt(i-1));
	}
	
	System.out.println(newString);
}

/**
 * returns the reversed string	
 * @return	String 
 */
public  String getReversedstring(){
	return this.newString;
}

public static void main(String[] args){

}
}
