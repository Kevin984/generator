package nl.hu.v1sad.rulegenerator.services;

import java.util.List;

public class TriggerService {
	private GenerateBusinessRulesController controller = new GenerateBusinessRulesController();
	
	public List<String> generateTrigger(String databaseName, String triggerName){
		return controller.generate(databaseName, triggerName);
	}
}
