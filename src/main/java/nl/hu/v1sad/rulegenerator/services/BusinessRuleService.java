package nl.hu.v1sad.rulegenerator.services;

import java.util.ArrayList;
import java.util.List;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.persistence.RepositoryDatabaseDAO;


public class BusinessRuleService {
private RepositoryDatabaseDAO repoDAO = new RepositoryDatabaseDAO();

public List<BusinessRule> getAllBusinessRules(String dbName){
	return repoDAO.selectBusinessRules(dbName);
}

}
