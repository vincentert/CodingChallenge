package com.takima.adsample.ressource;

import java.util.ArrayList;
import java.util.List;

import com.takima.adsample.persistance.Rules;
import com.takima.adsample.service.Utils;

public class AdSample {
	private Contacts contacts;
	private Item item;
	private Phone phone;
	private String creationDate;
	private Long price;
	private String [] publicationOptions;
	private String reference;
	
	public AdSample(Contacts contacts, Item item, Phone phone, String creationDate, Long price,
			String[] publicationOptions, String reference) {
		super();
		this.contacts = contacts;
		this.item = item;
		this.phone = phone;
		this.creationDate = creationDate;
		this.price = price;
		this.publicationOptions = publicationOptions;
		this.reference = reference;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String[] getPublicationOptions() {
		return publicationOptions;
	}

	public void setPublicationOptions(String[] publicationOptions) {
		this.publicationOptions = publicationOptions;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
	public List<Rules> rulesnotRespected() {
		List<Rules> rulesnotRespectedList = new ArrayList<Rules>();
		
		if(getContacts().getFirstName().length()<=2) rulesnotRespectedList.add(Rules.RULE_FIRST_NAME_LENGTH);
		if(getContacts().getLastName().length()<=2) rulesnotRespectedList.add(Rules.RULE_LAST_NAME_LENGTH);
		if(!isEmailAlphaRateCorrect(getContacts().getEmail())) rulesnotRespectedList.add(Rules.RULE_EMAIL_ALPHA_RATE);
		if(!isEmailNumberRateCorrect(getContacts().getEmail())) rulesnotRespectedList.add(Rules.RULE_EMAIL_NUM_RATE);
		if(!isPriceQuotationRateCorrect()) rulesnotRespectedList.add(Rules.RULE_PRICE_QUOTATION_RATE);
		if(Utils.blacklistClient(getItem().getEanCode())) rulesnotRespectedList.add(Rules.RULE_REGISTER_NUMBER_BLACKLIST);
		
		return rulesnotRespectedList;
	}
	
	/**le prix de l'annonce doit être dans une fourchette de 20% autour de la
	 * côte calculée
	 * 
	 * @return
	 */
	public boolean isPriceQuotationRateCorrect(){
		float quotationClient = (float)Utils.quotationClient(getItem());
		float diff = Math.abs(getPrice()-quotationClient);
		return diff/quotationClient<=0.2f;

	}
	
	
	/**la proportion de caractères alphanumériques (chiffres et lettres) par
	 * rapport au nombre total de caractères de la partie avant le '@' de l'email
	 * doit être strictement supérieure à 70%
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmailAlphaRateCorrect(String email) {
		
		int index = email.indexOf('@');
		if(index==-1) {
			return false;
		}
		float countAlpha = 0f;
		float countTotal = 0f;
		String emailCut = email.substring(0, index);
		for(int i = 0;i<emailCut.length();i++) {
			char letter = emailCut.charAt(i);
			
			if(Character.isDigit(letter)) {
				countAlpha++;
			}else if(Character.isLetter(letter)) {
				countAlpha++;
			}
			countTotal++;
		}
		return countTotal>0f && countAlpha/countTotal>0.7;

	
	}
	
	/**la proportion de caractères numériques par rapport au nombre total de
	 * caractères de la partie avant le '@' de l'email doit être strictement
	 * inférieure à 30%
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmailNumberRateCorrect(String email) {
		int index = email.indexOf('@');
		if(index==-1) {
			return false;
		}
		float countNumber = 0f;
		float countTotal = 0f;
		String emailCut = email.substring(0, index);
		for(int i = 0;i<emailCut.length();i++) {
			char letter = emailCut.charAt(i);
			
			if(Character.isDigit(letter)) {
				countNumber++;
			}
			countTotal++;
		}
		return countTotal>0f && countNumber/countTotal<0.3;
	}
	
}
