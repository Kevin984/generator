package nl.hu.v1sad.rulegenerator.services;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;

public class TupleCompareRule extends BusinessRuleType {
	private String targetTableName;
	private String firstTargetColumnName;
	private String secondTargetColumnName;
	
	TupleCompareRule(String targetTableName, String firstTargetColumnName, String secondTargetColumnName) {
		super("TupleCompareRule", "TCMP", "Tuple Compare Rule Description.", null);
		this.targetTableName = targetTableName;
		this.firstTargetColumnName = firstTargetColumnName;
		this.secondTargetColumnName = secondTargetColumnName;
	}
	
	public TupleCompareRule() {
		this(null, null, null);
	}
	
	public String getTargetTableName() {
		return targetTableName;
	}
	
	public void setTargetTableName(String targetTableName) {
		this.targetTableName = targetTableName;
	}
	
	public String getFirstTargetColumnName() {
		return firstTargetColumnName;
	}
	
	public void setFirstTargetColumnName(String firstTargetColumnName) {
		this.firstTargetColumnName = firstTargetColumnName;
	}
	
	public String getSecondTargetColumnName() {
		return secondTargetColumnName;
	}
	
	public void setSecondTargetColumnName(String secondTargetColumnName) {
		this.secondTargetColumnName = secondTargetColumnName;
	}
	
	@Override
	public String fillTemplate(String template, BusinessRule br) {
		return "return TCMP";
	}
}