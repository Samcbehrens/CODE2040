
import java.util.*;

public class NeedleInHay {

	
public static void main(String args[]){
	String needle="else";
	String[] haystack={"and","or","else","if"};
	
	int indexOfstring = 0;
	for(int i=0;i<haystack.length;i++){
		if(haystack[i].compareTo(needle)==0){
			indexOfstring=i;
		}
	}
	System.out.println("Final output");
	System.out.println(indexOfstring);
}
}
