package nl.hu.v1sad.rulegenerator.services;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;

public class AttributeRangeRule extends BusinessRuleType {
	private String targetTableName;
	private String targetColumnName;
	private String firstValue;
	private String secondValue;
	
	public AttributeRangeRule(String targetTableName, String targetColumnName, String firstValue, String secondValue) {
		super("AttributeRangeRule", "ARNG", "The attribute value has to be either 'between' or 'not between' the minimum and maximum of a range.", null);
		this.targetTableName = targetTableName;
		this.targetColumnName = targetColumnName;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}
	
	public AttributeRangeRule() {
		this(null, null, null, null);
	}
	
	public String getTargetTableName() {
		return targetTableName;
	}
	
	public void setTargetTableName(String targetTableName) {
		this.targetTableName = targetTableName;
	}
	
	public String getTargetColumnName() {
		return targetColumnName;
	}
	
	public void setTargetColumnName(String targetColumnName) {
		this.targetColumnName = targetColumnName;
	}
	
	public String getFirstValue() {
		return firstValue;
	}
	
	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}
	
	public String getSecondValue() {
		return secondValue;
	}
	
	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}
	
	@Override
	public String fillTemplate(String template, BusinessRule br) {
		template = template.replaceAll("<range_min>", firstValue);
		template = template.replaceAll("<range_max>", secondValue);
		template = template.replaceAll("<operator>", br.getOperator().getSign());
		template = template.replaceAll("<targetcolumn>", targetColumnName);
		template = template.replaceAll("<targettable>", targetTableName);
		template = template.replaceAll("<error>", br.getErrorMessage());
		template = template.replaceAll("<code>", br.getRuleType().getCode());
		return template;
	}
}
