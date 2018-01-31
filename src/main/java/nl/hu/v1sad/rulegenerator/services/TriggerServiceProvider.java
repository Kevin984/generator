package nl.hu.v1sad.rulegenerator.services;

public class TriggerServiceProvider {
	private static TriggerService ttts = new TriggerService();
	
	public static TriggerService getTriggerTextTestService() {
		return ttts;
	}
}
