package com.takima.adsample.application;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.takima.adsample.persistance.Rules;
import com.takima.adsample.ressource.AdSample;
import com.takima.adsample.ressource.Result;
import com.takima.adsample.service.Utils;

public class Main {

	private final static Logger LOG = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {



		AdSample adSample = Utils.parseAd("./src/main/resources/ad-sample.json");

		List<Rules> rulesnotRespectedArr = adSample.rulesnotRespected();

		Result result = new Result(adSample.getReference(), rulesnotRespectedArr.size()>0, rulesnotRespectedArr);
		LOG.log(Level.INFO,result.toString());
	}
}
