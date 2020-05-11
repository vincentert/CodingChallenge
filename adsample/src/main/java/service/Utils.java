package service;

import java.util.ArrayList;
import java.util.List;

import persistance.Constante;
import persistance.Rules;
import ressource.AdSample;
import ressource.Item;

public class Utils {
	
	private Utils() {
	}
	
	public static double quotationClient(Item item) {
		return Constante.QUOTATIONCLIENT;
	}
	
	public static boolean blacklistClient(String eanCode) {
		return eanCode.contentEquals(Constante.BLACKLISTEDEANCODE);
	}
	
	public static String[] rulesnotRespected(AdSample adSample) {
		List<String> rulesnotRespectedList = new ArrayList<String>();
		
		if(adSample.getContacts().getFirstName().length()<=2) rulesnotRespectedList.add(Rules.RULE_FIRST_NAME_LENGTH.toString());
		if(adSample.getContacts().getLastName().length()<=2) rulesnotRespectedList.add(Rules.RULE_LAST_NAME_LENGTH.toString());
		if(!isEmailAlphaRateCorrect(adSample.getContacts().getEmail())) rulesnotRespectedList.add(Rules.RULE_EMAIL_ALPHA_RATE.toString());
		if(!isEmailNumberRateCorrect(adSample.getContacts().getEmail())) rulesnotRespectedList.add(Rules.RULE_EMAIL_NUM_RATE.toString());
		if(!isPriceQuotationRateCorrect(adSample)) rulesnotRespectedList.add(Rules.RULE_PRICE_QUOTATION_RATE.toString());
		if(blacklistClient(adSample.getItem().getEanCode())) rulesnotRespectedList.add(Rules.RULE_REGISTER_NUMBER_BLACKLIST.toString());
		
		return rulesnotRespectedList.toArray(new String[rulesnotRespectedList.size()]);
	}
	
	/**le prix de l'annonce doit être dans une fourchette de 20% autour de la
	 * côte calculée
	 * 
	 * @return
	 */
	public static boolean isPriceQuotationRateCorrect(AdSample adSample){
		double price = adSample.getPrice();
		float quotationClient = (float)quotationClient(adSample.getItem());
		float diff = (float)Math.abs(price-quotationClient);
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
		if(!email.contains("@")) {
			return false;
		}
		float countAlpha = 0f;
		float countTotal = 0f;
		String emailCut = email.substring(0, email.indexOf('@'));
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
		if(!email.contains("@")) {
			return false;
		}
		float countNumber = 0f;
		float countTotal = 0f;
		String emailCut = email.substring(0, email.indexOf('@'));
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
