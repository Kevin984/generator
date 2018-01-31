package nl.hu.v1sad.rulegenerator.domain;

public class TupleOtherRule extends BusinessRuleType {
	private String targetTableName;
	private String customCode;
	
	public TupleOtherRule(String targetTableName, String customCode) {
		super("TupleOtherRule", "TOTH", "Tuple Other Rule Description.", null);
		this.targetTableName = targetTableName;
		this.customCode = customCode;
	}
	
	public TupleOtherRule() {
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
		template = template.replaceAll("<code>", br.getRuleType().getCode());
		template = template.replaceAll("<target_table>", targetTableName);
		template = template.replaceAll("<customCode>", customCode);
		template = template.replaceAll("<customCode>", br.getErrorMessage());
		return template;
	}
}
