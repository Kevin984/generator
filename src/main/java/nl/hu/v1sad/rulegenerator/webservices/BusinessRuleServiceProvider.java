package nl.hu.v1sad.rulegenerator.webservices;

public class BusinessRuleServiceProvider {
	private static BusinessRuleService brs = new BusinessRuleService();
	
	public static BusinessRuleService getBusinessRuleService() {
		return brs;
	}

}
