import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JComboBox;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
	
	private static JSONParser parser;
	private static FileReader reader;
	private static JSONObject obj;
	private static JSONObject key;
	private static JSONArray JSONPerson;
	
	private static List<Person>person;
	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ParseException {
		new comboTest().setVisible(true);
	
	/*String source= new File("").getAbsolutePath()+"\\src\\mock.json";
	JSONParser parser=new JSONParser();
	FileReader reader=new FileReader(source);
		JSONObject obj=(JSONObject) parser.parse(reader);
		
	
		
		String data=obj.get("data").toString();
		System.out.println(data);
		JSONArray arr=(JSONArray) obj.get("person");
		
		
		for(int i=0;i<arr.size();i++) {
			
			JSONObject person=(JSONObject) arr.get(i);
			String lname=(String)person.get("last_name");
			String fname=(String) person.get("first_name");
			nakaratay
			
			
			System.out.println("Name: "+lname + ", " + fname);
			
		}
	
	
	List<Person> p=getPeople();


	for (Person person:p) {
		System.out.println(person.getId());
	}
	}
	public static List<Person> getPeople() throws IOException, ParseException{
		person=new ArrayList<>();
		
		String source= new File("").getAbsolutePath()+"\\src\\mock.json";
		parser=new JSONParser();
		reader=new FileReader(source);
		obj=(JSONObject) parser.parse(reader);
		
		JSONPerson=(JSONArray) obj.get("person");
		
		for(int i=0;i<JSONPerson.size();i++) {
		key=(JSONObject)JSONPerson.get(i);
			
			String id=key.get("id").toString();
			String lastName=(String)key.get("last_name");
			String firstName=(String)key.get("first_name");
			String email=(String) key.get("email");
			String gender=(String) key.get("gender");
			String ipAddress=(String)key.get("ip_address");
			
			person.add(new Person(Integer.parseInt(id),firstName,lastName,email,gender,ipAddress));
		}
		return person;
		
	} 
		
		String source= new File("").getAbsolutePath()+"\\src\\resources\\address.json";
		JsonElement fileElement=JsonParser.parseReader(new FileReader(source));
		JsonObject fileObject=fileElement.getAsJsonObject();
		
		JsonArray arr=fileObject.get("province").getAsJsonArray();
		
		for(JsonElement array:arr) {
			JsonObject key=array.getAsJsonObject();
			
			String province=key.get("provDesc").getAsString();
			
			System.out.println(province);
			
		}
		*/
		
		
		
	}
	

}
