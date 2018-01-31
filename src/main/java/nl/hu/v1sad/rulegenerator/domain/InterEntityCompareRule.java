package nl.hu.v1sad.rulegenerator.domain;

public class InterEntityCompareRule extends BusinessRuleType {
	private String firstTargetColumnName;
	private String secondTargetColumnName;
	private String firstTargetTableName;
	private String secondTargetTableName;
	
	public InterEntityCompareRule(String firstTargetColumnName, String secondTargetColumnName, String firstTargetTableName, String secondTargetTableName) {
		super("InterEntityCompareRule", "ICMP", "Inter-Entity Compare Rule Description.", null);
		this.firstTargetColumnName = firstTargetColumnName;
		this.secondTargetColumnName = secondTargetColumnName;
		this.firstTargetTableName = firstTargetTableName;
		this.secondTargetTableName = secondTargetTableName;
	}
	
	public InterEntityCompareRule() {
		this(null, null, null, null);
	}
	
	public String getFirstTargetTableName() {
		return firstTargetTableName;
	}
	
	public void setFirstTargetTableName(String firstTargetTableName) {
		this.firstTargetTableName = firstTargetTableName;
	}
	
	public String getFirstTargetColumnName() {
		return firstTargetColumnName;
	}
	
	public void setFirstTargetColumnName(String firstTargetColumnName) {
		this.firstTargetColumnName = firstTargetColumnName;
	}
	
	public String getSecondTargetTableName() {
		return secondTargetTableName;
	}
	
	public void setSecondTargetTableName(String secondTargetTableName) {
		this.secondTargetTableName = secondTargetTableName;
	}
	
	public String getSecondTargetColumnName() {
		return secondTargetColumnName;
	}
	
	public void setSecondTargetColumnName(String secondTargetColumnName) {
		this.secondTargetColumnName = secondTargetColumnName;
	}
	
	@Override
    public String fillTemplate(String template, BusinessRule br) {
        template = template.replaceAll("<target_table_1>", firstTargetTableName);
        template = template.replaceAll("<target_table_2>", secondTargetTableName);
        template = template.replaceAll("<target_column_1>", firstTargetColumnName);
        template = template.replaceAll("<target_column_2>", secondTargetColumnName);
        template = template.replaceAll("<error>", br.getErrorMessage());
        template = template.replaceAll("<code>", br.getRuleType().getCode());

        return template;
    }
}
