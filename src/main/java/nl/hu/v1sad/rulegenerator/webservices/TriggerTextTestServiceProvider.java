package nl.hu.v1sad.rulegenerator.webservices;

public class TriggerTextTestServiceProvider {
	private static TriggerTextTestService ttts = new TriggerTextTestService();
	
	public static TriggerTextTestService getTriggerTextTestService() {
		return ttts;
	}
}
