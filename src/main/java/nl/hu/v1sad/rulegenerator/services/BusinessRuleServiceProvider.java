package nl.hu.v1sad.rulegenerator.services;

public class BusinessRuleServiceProvider {
	private static BusinessRuleService brs = new BusinessRuleService();
	
	public static BusinessRuleService getBusinessRuleService() {
		return brs;
	}

}
