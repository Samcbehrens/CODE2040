
import java.util.Vector;

/**
 * 
 * @author Sambehrens
 * Problem 3 of the CODE 2040 API Challenge: find all strings that do not contain the given prefix
 *
 */
public class prefix {
	String[] givenArray;
	String prefix;
	String finalStringArray[];

/**
 * Takes an array  of strings scans the array for prefix and if it does not start with the prefix ass to the vector array. 
 * It then converts the vector array into a string array and using a for loop prints the array. 
 * 
 * @param givenArray	Array of Strings 
 * @param prefix		String of prefix to find 
 */
public prefix (String[] givenArray, String prefix){
	this.givenArray=givenArray;
	Vector<String> vectorToarray=new Vector<String>();
	
	this.prefix=prefix;
	
	for(int i=0; i<givenArray.length;i++){
		if(givenArray[i].startsWith(prefix)==false){
			vectorToarray.add(givenArray[i]);
		}
	}
	String finalArray[]=vectorToarray.toArray(new String[vectorToarray.size()]);
	
	this.finalStringArray=finalArray;
	
	for(int j=0; j<finalStringArray.length;j++){
		System.out.println(finalStringArray[j]);
	}
}

public String[] getFinalarray(){
	return finalStringArray;
}

public static void main(String[] args){
	String[] sarray={"477x4Ux3","477uINI0","1737jsVQ","477bKLi3","477431za","279cpAmc"};
	String prefix="477";
	prefix solver=new prefix(sarray,prefix);
	
	
}

}
