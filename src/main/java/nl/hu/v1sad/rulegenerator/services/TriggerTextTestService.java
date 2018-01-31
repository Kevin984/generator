package nl.hu.v1sad.rulegenerator.services;

import java.util.List;

public class TriggerTextTestService {
	private GenerateBusinessRulesController controller = new GenerateBusinessRulesController();
	
	public List<String> generateTrigger(String databaseName){
		return controller.generate(databaseName);
	}
}
