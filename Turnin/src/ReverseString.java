
public class ReverseString{

public static void main (String args[]){
	String givenString="cupcakes";
	String newString="";
	
	for(int i=givenString.length();i>0;i=i-1){
		newString=newString+(givenString.charAt(i-1));
	}
	
	System.out.println(newString);
}
}