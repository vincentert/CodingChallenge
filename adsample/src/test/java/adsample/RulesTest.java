package adsample;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.takima.adsample.persistance.Rules;
import com.takima.adsample.ressource.AdSample;
import com.takima.adsample.service.Utils;



public class RulesTest {
	
	@Test
	public final void ruleEmailNumRateNotRespectedTest() {
		AdSample adSample = Utils.parseAd("./src/test/resources/ad-sampleRulesEmailTest.json");
		List<Rules> rulesArray = adSample.rulesnotRespected();		
		assertTrue(rulesArray.contains(Rules.RULE_EMAIL_NUM_RATE));
	}
	
	@Test
	public final void ruleFirstNameNotRespectedTest() {
		AdSample adSample = Utils.parseAd("./src/test/resources/ad-sampleRulesFirstNameTest.json");
		List<Rules> rulesArray = adSample.rulesnotRespected();		
		assertTrue(rulesArray.contains(Rules.RULE_FIRST_NAME_LENGTH));
	}
	
	@Test
	public final void ruleLastNameNotRespectedTest() {
		AdSample adSample = Utils.parseAd("./src/test/resources/ad-sampleRulesLastNameTest.json");
		List<Rules> rulesArray = adSample.rulesnotRespected();		
		assertTrue(rulesArray.contains(Rules.RULE_LAST_NAME_LENGTH));
	}
	
	@Test
	public final void rulePriceQuotationRateNotRespectedTest() {
		AdSample adSample = Utils.parseAd("./src/test/resources/ad-sampleRulesPriceQuotationRateTest.json");
		List<Rules> rulesArray = adSample.rulesnotRespected();		
		assertTrue(rulesArray.contains(Rules.RULE_PRICE_QUOTATION_RATE));
	}
	
	@Test
	public final void ruleRegisterNumberBlackListNotRespectedTest() {
		AdSample adSample = Utils.parseAd("./src/test/resources/ad-sampleRulesRegisterNumberBlackListTest.json");
		List<Rules> rulesArray = adSample.rulesnotRespected();		
		assertTrue(rulesArray.contains(Rules.RULE_REGISTER_NUMBER_BLACKLIST));
	}
	
	@Test
	public final void ruleEmailAlphaRateNotRespectedTest() {
		AdSample adSample = Utils.parseAd("./src/test/resources/ad-sampleRulesEmailAlphaRateTest.json");
		List<Rules> rulesArray = adSample.rulesnotRespected();		
		assertTrue(rulesArray.contains(Rules.RULE_EMAIL_ALPHA_RATE));
	}

}
