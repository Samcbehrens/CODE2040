

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.entity.ContentType;
import org.apache.http.HttpResponse;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


import java.text.StringCharacterIterator;
//import org.json.JSONArray;
import java.util.Map;
 
/**
 * Used this code to turn in all problems for the CODE 2040 API Challenge
 *This code was modified from 
 *http://www.gnovus.com/blog/programming/making-http-post-request-json-using-apaches-httpclient
 * @author joe666, SamBehrens
 */
public class SimpleHTTPPOSTRequester {
 
    private String token;
    private String apiURL;
    private String time;
 
    public SimpleHTTPPOSTRequester(String token, String time, String apiURL) {        
        this.apiURL = apiURL;
        this.token = token;
        this.time=time;
      
        
    }
 
    public void makeHTTPPOSTRequest() {
    	
        try {
            HttpClient c = new DefaultHttpClient();        
            HttpPost p = new HttpPost(this.apiURL);        
//Should look like 
            
            
            p.setEntity(new StringEntity("{\"token\":\"" + this.token + "\",\"time\":\"" + this.time + "\"}",                    ContentType.create("application/json")));
            
            HttpResponse r = c.execute(p);
            	
            BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
               //Parse our JSON response               
               JSONParser j = new JSONParser();
               JSONObject o = (JSONObject)j.parse(line);
               Map response = (Map)o.get("response");
 
               System.out.println(o);
            }
        }
        catch(ParseException e) {
            System.out.println(e);
        }
        catch(IOException e) {
            System.out.println(e);
        }                        
    }  
    
    
    public static String forJSON(String aText){
	    final StringBuilder result = new StringBuilder();
	    StringCharacterIterator iterator = new StringCharacterIterator(aText);
	    char character = iterator.current();
	    while (character != StringCharacterIterator.DONE){
	      if( character == '\"' ){
	        result.append("\\\"");
	      }
	      else if(character == '\\'){
	        result.append("\\\\");
	      }
	      else if(character == '/'){
	        result.append("\\/");
	      }
	      else if(character == '\b'){
	        result.append("\\b");
	      }
	      else if(character == '\f'){
	        result.append("\\f");
	      }
	      else if(character == '\n'){
	        result.append("\\n");
	      }
	      else if(character == '\r'){
	        result.append("\\r");
	      }
	      else if(character == '\t'){
	        result.append("\\t");
	      }
	      else {
	        //the char is not a special one
	        //add it to the result as is
	        result.append(character);
	      }
	      character = iterator.next();
	    }
	    return result.toString();    
	  }
    
    public static void main(String[] args){
    	//String[] array={"1737jsVQ","279cpAmc"};
    	//  JsonArray jarray=new JsonArray
    	//jarray.put(array[0]);
    	//jarray.put(array[1]);
    	//System.out.println(jarray.toString());\
    	String[] array = "{/ "1737jsVQ", "279cpAmc" /}";
		String jsonString=forJSON(array);
    	SimpleHTTPPOSTRequester requester=new SimpleHTTPPOSTRequester("zsb97KMvgO",jsonString,,"http://challenge.code2040.org/api/validateprefix");
    	requester.makeHTTPPOSTRequest();
    }
}