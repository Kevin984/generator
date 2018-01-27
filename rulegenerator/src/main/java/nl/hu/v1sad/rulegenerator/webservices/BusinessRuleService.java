package nl.hu.v1sad.rulegenerator.webservices;

import java.util.ArrayList;
import java.util.List;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.persistence.BusinessRuleDAO;


public class BusinessRuleService {
private BusinessRuleDAO brDAO = new BusinessRuleDAO();

public List<BusinessRule> getAllBusinessRules(String dbName){
	return brDAO.selectBusinessRules(dbName);
}

}
