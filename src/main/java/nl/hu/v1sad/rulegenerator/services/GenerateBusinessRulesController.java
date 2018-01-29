package nl.hu.v1sad.rulegenerator.services;

import java.util.ArrayList;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.persistence.RepositoryDatabaseDAO;


public class GenerateBusinessRulesController {
	private RepositoryDatabaseDAO repoDAO = new RepositoryDatabaseDAO();
	private ArrayList<BusinessRule> rules;
	private OutputTemplate templatemaker = new OutputTemplate();
	private String entireTrigger = "";
	
	public GenerateBusinessRulesController() {
	}
	
	public void generate(String databaseName) {
		rules = repoDAO.selectBusinessRules(databaseName);
		
		
		for (int i = 0; i < rules.size(); i++) {
			String template = templatemaker.getFilledTemplate(rules.get(i));
			entireTrigger += template;
			entireTrigger += "\n\n";
		}
		
		System.out.println(entireTrigger);
		
	
		// adds all templates/triggers to one long triggercode
		// sends triggercode to dao
		// dao executes trigger on target database
		// sets business rule status to generated
		// saves triggercode to repository database
	}
}
