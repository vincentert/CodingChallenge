package com.takima.adsample.service;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.takima.adsample.persistance.Constante;
import com.takima.adsample.ressource.AdSample;
import com.takima.adsample.ressource.Contacts;
import com.takima.adsample.ressource.Item;
import com.takima.adsample.ressource.Phone;

public class Utils {
	
	private Utils() {
	}
	
	public static double quotationClient(Item item) {
		return Constante.QUOTATIONCLIENT;
	}
	
	public static boolean blacklistClient(String eanCode) {
		return eanCode.contentEquals(Constante.BLACKLISTEDEANCODE);
	}
	
	
	
	
	
	public static AdSample parseAd(String pathFile) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(pathFile));


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
			return adSample;
	}catch (Exception e) {
		e.printStackTrace();
		return null;
	}
		
	}
	
}
