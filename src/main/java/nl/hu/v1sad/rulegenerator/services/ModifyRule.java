package nl.hu.v1sad.rulegenerator.services;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;

public class ModifyRule extends BusinessRuleType {
	private String customCode;
	
	public ModifyRule(String customCode) {
		super("ModifyRule", "MODI", "Modify Rule Description.", null);
		this.customCode = customCode;
	}
	
	public ModifyRule() {
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
		return "return MODI";
	}


}
