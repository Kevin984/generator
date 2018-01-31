package nl.hu.v1sad.rulegenerator.services;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;

public class AttributeOtherRule extends BusinessRuleType {
	private String targetTableName;
	private String customCode;
	
	public AttributeOtherRule(String targetTableName, String customCode) {
		super("AttributeOtherRule", "AOTH", "Attribute Other Rule Description.", null);
		this.targetTableName = targetTableName;
		this.customCode = customCode;
	}
	
	public AttributeOtherRule() {
		this(null, null);
	}
	
	public String getCustomCode() {
		return customCode;
	}

	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}
	
	@Override
	public String fillTemplate(String template, BusinessRule br) {
		template = template.replaceAll("<code>", br.getRuleType().getCode());
		template = template.replaceAll("<target_table>", targetTableName);
		template = template.replaceAll("<customCode>", customCode);
		return template;
	}


}
