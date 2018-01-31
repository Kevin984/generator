package nl.hu.v1sad.rulegenerator.webservices;

import java.util.List;

import tempPackage.PleaseDeleteLater.GenerateBusinessRulesController;

public class TriggerTextTestService {
	private GenerateBusinessRulesController controller = new GenerateBusinessRulesController();
	
	public List<String> generateTrigger(String databaseName){
		return controller.generate(databaseName);
	}
}
