/**
 * Problem 2 of CODE 2040 API Challenge: find the index of a string in a String Array
 * @author sambehrens
 */


public class NeedleInHay {
	String needle;
	String[] haystack;
	int indexOfstring;

/**
 * Takes the list of Strings and finds the index of the needle.
 * Use a for loop to compare every item in array with the needle. 
 * 
 * @param haystack	String Array
 * @param needle	String
 */
public NeedleInHay(String[] haystack, String needle) {
	this.needle=needle;
	this.haystack=haystack;
	
	this.indexOfstring = 0;
	for(int i=0;i<haystack.length;i++){
		if(haystack[i].compareTo(needle)==0){
			this.indexOfstring=i;
		}
	}
	System.out.println("Final output");
	System.out.println(indexOfstring);
}
	
	
public int getIndexofNeedle(){
	return indexOfstring;	
}

public static void main(String[] args){
	String[] sArray={"PQyUK","6l7Yn","DlRAE","btmfx","Z8SL1","rbBQs","QImn2","MBSnn","7LaXK","fW1iO","h5VCY","A0wpG","Aubcj","Ts013","3oBwF","PpA8E","URtOJ","EKhxu","m7ftV","wQyoT"};
	NeedleInHay finder=new NeedleInHay(sArray,"PQyUK");
	int index=finder.getIndexofNeedle();
	System.out.println(index);
	
}
}
