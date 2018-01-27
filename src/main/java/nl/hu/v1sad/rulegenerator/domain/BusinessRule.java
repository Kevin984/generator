package nl.hu.v1sad.rulegenerator.domain;

public class BusinessRule {
	private String name;
	private String databaseType;
	private BusinessRuleType ruleType;
	private Operator operator;
	private String errorMessage;
	
	public BusinessRule(String name, BusinessRuleType ruleType, Operator operator, String databaseType, String errorMessage) {
		this.name = name;
		this.ruleType = ruleType;
		this.operator = operator;
		this.databaseType = databaseType;
		this.errorMessage =errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BusinessRuleType getRuleType() {
		return ruleType;
	}
	
	public void setRuleType(BusinessRuleType ruleType) {
		this.ruleType = ruleType;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public String getDatabaseType() {
		return databaseType;
	}
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
}
