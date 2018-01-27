package nl.hu.v1sad.rulegenerator.services;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;

public class AttributeOtherRule extends BusinessRuleType {
	private String customCode;
	
	public AttributeOtherRule(String customCode) {
		super("AttributeOtherRule", "AOTH", "Attribute Other Rule Description.", null);
		this.customCode = customCode;
	}
	
	public AttributeOtherRule() {
		this(null);
	}
	
	public String getCustomCode() {
		return customCode;
	}

	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}
	
	@Override
	public String fillTemplate(String template, BusinessRule br) {
		return "return AOTH";
	}


}
