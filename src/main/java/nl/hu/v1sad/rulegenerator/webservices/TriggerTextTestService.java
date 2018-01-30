package nl.hu.v1sad.rulegenerator.webservices;

import java.util.List;
import nl.hu.v1sad.rulegenerator.services.GenerateBusinessRulesController;

public class TriggerTextTestService {
	private GenerateBusinessRulesController controller = new GenerateBusinessRulesController();
	
	public List<String> generateTrigger(String databaseName){
		return controller.generate(databaseName);
	}
}
