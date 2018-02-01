package nl.hu.v1sad.rulegenerator.services;

import java.util.ArrayList;
import java.util.List;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.persistence.RepositoryDatabaseDAO;
import nl.hu.v1sad.rulegenerator.persistence.TargetDatabaseDAO;


public class GenerateBusinessRulesController {
	private RepositoryDatabaseDAO repoDAO = new RepositoryDatabaseDAO();
	private TargetDatabaseDAO targetDAO = new TargetDatabaseDAO();
	private ArrayList<BusinessRule> rules = new ArrayList<BusinessRule>();
	private TemplateBuilder templateBuilder = new TemplateBuilder();
	private ArrayList<String> triggers = new ArrayList<String>();
	ArrayList<String> message = new ArrayList<String>();
	private String entireTrigger = "";
	
	public GenerateBusinessRulesController() {
	}
	
	public List<String> generate(String databaseName) {
		rules.clear();
		message.clear();
		rules = repoDAO.selectBusinessRules(databaseName);
		
		triggers.clear();
		for (int i = 0; i < rules.size(); i++) {
			String template = templateBuilder.getFilledTemplate(rules.get(i));
			triggers.add(template);
			entireTrigger.concat("\n\n");
			entireTrigger.concat(template);
		}
		
		message.add(targetDAO.executeTrigger(databaseName, triggers, rules));
		return message;
	}
}
