package nl.hu.v1sad.rulegenerator.services;

import java.util.ArrayList;
import java.util.List;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.persistence.RepositoryDatabaseDAO;


public class GenerateBusinessRulesController {
	private RepositoryDatabaseDAO repoDAO = new RepositoryDatabaseDAO();
	private ArrayList<BusinessRule> rules;
	private TemplateBuilder templateBuilder = new TemplateBuilder();
	private List<String> triggers = new ArrayList<String>();
	
	public GenerateBusinessRulesController() {
	}
	
	public List<String> generate(String databaseName) {
		rules = repoDAO.selectBusinessRules(databaseName);
		triggers.clear();
		for (int i = 0; i < rules.size(); i++) {
			String template = templateBuilder.getFilledTemplate(rules.get(i));
			triggers.add(template);
		}
		
		return triggers;
	
		// adds all templates/triggers to one long triggercode
		// sends triggercode to dao
		// dao executes trigger on target database
		// sets business rule status to generated
		// saves triggercode to repository database
	}
}