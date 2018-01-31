package nl.hu.v1sad.rulegenerator.webservices;

public class TargetDatabaseServiceProvider {
private static TargetDatabaseService tbs = new TargetDatabaseService();
	
	public static TargetDatabaseService getTargetDatabaseService() {
		return tbs;
	}
}
