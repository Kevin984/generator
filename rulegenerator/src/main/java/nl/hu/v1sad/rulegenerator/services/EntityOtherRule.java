package nl.hu.v1sad.rulegenerator.services;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;

public class EntityOtherRule extends BusinessRuleType {
	private String targetTableName;
	private String customCode;
	
	public EntityOtherRule(String targetTableName, String customCode) {
		super("EntityOtherRule", "EOTH", "Entity Other Rule Description.", null);
		this.targetTableName = targetTableName;
		this.customCode = customCode;
	}
	
	public EntityOtherRule() {
		this(null, null);
	}

	public String getTargetTableName() {
		return targetTableName;
	}

	public void setTargetTableName(String targetTableName) {
		this.targetTableName = targetTableName;
	}
	
	public String getCustomCode() {
		return customCode;
	}

	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}
	
	@Override
	public String fillTemplate(String template, BusinessRule br) {
		return "return EOTH";
	}


}
