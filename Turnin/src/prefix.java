import java.util.Vector;


public class prefix {

public static void main(String args[]){
	String givenArray[]={"forbade","forsee","ant","chicken","artichoke"};
	Vector<String> vectorToarray=new Vector<String>();
	String prefix="for";
	
	for(int i=0; i<givenArray.length;i++){
		if(givenArray[i].startsWith(prefix)==false){
			vectorToarray.add(givenArray[i]);
		}
	}
	String finalStringArray[]=vectorToarray.toArray(new String[vectorToarray.size()]);
	
	for(int j=0; j<finalStringArray.length;j++){
		System.out.println(finalStringArray[j]);
	}
}

}
