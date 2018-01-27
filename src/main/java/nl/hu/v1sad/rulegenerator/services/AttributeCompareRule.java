package nl.hu.v1sad.rulegenerator.services;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;

public class AttributeCompareRule extends BusinessRuleType {
	private String targetTableName;
	private String targetColumnName;
	private String compareValue;

	public AttributeCompareRule(String targetTableName, String targetColumnName, String compareValue) {
		super("AttributeCompareRule", "ACMP", "The attribute value has to be 'equal to', 'not equal to', 'greater than', 'less than', 'greater than or equal to' or 'less than or equal to' a given value.", null);
		this.targetTableName = targetTableName;
		this.targetColumnName = targetColumnName;
		this.compareValue = compareValue;
	}
	
	public AttributeCompareRule() {
		this(null, null, null);
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
	
	public String getCompareValue() {
		return compareValue;
	}
	
	public void setCompareValue(String compareValue) {
		this.compareValue = compareValue;
	}
	
	@Override
	public String fillTemplate(String template, BusinessRule br) {
		template = template.replaceAll("<comparevalue>", compareValue);
		template = template.replaceAll("<operator>", br.getOperator().getSign());
		template = template.replaceAll("<targetcolumn>", targetColumnName);
		template = template.replaceAll("<targettable>", targetTableName);
		template = template.replaceAll("<error>", br.getErrorMessage());
		template = template.replaceAll("<code>", br.getRuleType().getCode());
		return template;
	}

}
