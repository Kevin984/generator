package nl.hu.v1sad.rulegenerator.webservices;

import java.util.List;

import nl.hu.v1sad.rulegenerator.persistence.TargetDatabaseDAO;


public class TargetDatabaseService {
	private TargetDatabaseDAO brDAO = new TargetDatabaseDAO();

	public List<String> getTablesFromDatabase(String databaseName){
		return brDAO.getAllTablesOfDatabase(databaseName);
	}
	
	public List<String> getColumnsFromTable(String databaseName, String tableName){
        return 	brDAO.getAllColumnsOfTable(databaseName, tableName);
	}
	

}
