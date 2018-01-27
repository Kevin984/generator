package nl.hu.v1sad.rulegenerator.webservices;

public class BusinessRuleProvider {
	private static BusinessRuleService brs = new BusinessRuleService();
	
	public static BusinessRuleService getBusinessRuleService() {
		return brs;
	}

}
