package nl.hu.v1sad.rulegenerator.domain;

public class AttributeListRule extends BusinessRuleType {
	private String targetTableName;
	private String targetColumnName;
	private String valueList;
	
	public AttributeListRule(String targetTableName, String targetColumnName, String valueList) {
		super("AttributeListRule", "ALIS", "Attribute List Rule Description.", null);
		this.targetTableName = targetTableName;
		this.targetColumnName = targetColumnName;
		this.valueList = valueList;
	}
	
	public AttributeListRule() {
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
	
	public String getValueList() {
		return valueList;
	}
	
	public void setValueList(String valueList) {
		this.valueList = valueList;
	}

	@Override
	public String fillTemplate(String template, BusinessRule br) {
		//<<methode om list om te zetten naar sql code of apex laten doen >>
		template = template.replaceAll("<list>", valueList);
		template = template.replaceAll("<operator>", br.getOperator().getSign());
		template = template.replaceAll("<targetcolumn>", targetColumnName);
		template = template.replaceAll("<targettable>", targetTableName);
		template = template.replaceAll("<error>", br.getErrorMessage());
		template = template.replaceAll("<code>", br.getRuleType().getCode());
		return template;
	}

}
