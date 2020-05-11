package application;

import java.io.FileReader;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ressource.AdSample;
import ressource.Contacts;
import ressource.Item;
import ressource.Phone;
import ressource.Result;
import service.Utils;

public class Main {
	
	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\vince\\OneDrive\\Documents\\Eclipse_workspace\\Coding_challenge\\adsample\\src\\main\\resources\\ad-sample.json"));
 

			JSONObject jsonObject = (JSONObject) obj;
			
			JSONObject jsonObjectContacts = (JSONObject) jsonObject.get("contacts");
			
			JSONObject jsonObjectItem = (JSONObject)jsonObject.get("item");
			
			JSONObject phoneValue = (JSONObject)jsonObjectContacts.get("phone1");
			
			Item item = new Item((String)jsonObjectItem.get("make"), (String)jsonObjectItem.get("model"), (String)jsonObjectItem.get("version"), (String)jsonObjectItem.get("category"), (String)jsonObjectItem.get("eanCode"));
			
			Phone phone = new Phone((String)phoneValue.get("value"));
			
			Contacts contacts = new Contacts((String)jsonObjectContacts.get("firstName"), (String)jsonObjectContacts.get("lastName"), (String)jsonObjectContacts.get("email"), phone);
			
			JSONArray publicationOptions = (JSONArray) jsonObject.get("publicationOptions");
			
			String[] publicationOptionsArray = (String[]) publicationOptions.toArray(new String[publicationOptions.size()]);
			
			AdSample adSample = new AdSample(contacts, item, phone, (String)jsonObject.get("creationDate"), (Long) jsonObject.get("price"), publicationOptionsArray, (String)jsonObject.get("reference"));
			
			
			String[] rulesnotRespectedArr = Utils.rulesnotRespected(adSample);
			
			Result result = new Result(adSample.getReference(), rulesnotRespectedArr.length>0, rulesnotRespectedArr);
	        System.out.println((result.toString()));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
