package nl.hu.v1sad.rulegenerator.domain;

import java.util.ArrayList;

abstract public class BusinessRuleType {
	protected String name;
	protected String code;
	protected String description;
	protected ArrayList<Operator> availableOperators;
	
	public BusinessRuleType(String name, String code, String description, ArrayList<Operator> availableOperators) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.availableOperators = availableOperators;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<Operator> getAvailableOperators() {
		return availableOperators;
	}
	
	public void setAvailableOperators(ArrayList<Operator> availableOperators) {
		this.availableOperators = availableOperators;
	}
	
	public abstract String fillTemplate(String template, BusinessRule br);
		
}
