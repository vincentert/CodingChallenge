package com.takima.adsample.ressource;

import java.util.Arrays;
import java.util.List;

import com.takima.adsample.persistance.Rules;

public class Result {
	
	private String reference;
	private boolean scam;
	private List<Rules> rules;
	public Result(String reference, boolean scam, List<Rules> rules) {
		super();
		this.reference = reference;
		this.scam = scam;
		this.rules = rules;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public boolean isScam() {
		return scam;
	}
	public void setScam(boolean scam) {
		this.scam = scam;
	}
	public List<Rules> getRules() {
		return rules;
	}
	public void setRules(List<Rules> rules) {
		this.rules = rules;
	}
	@Override
	public String toString() {
		return "{reference=" + reference + ", scam=" + scam + ", rules=" + rules + "}";
	}



}
