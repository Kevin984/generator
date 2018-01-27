package nl.hu.v1sad.rulegenerator.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.persistence.BusinessRuleDAO;

@Path("/businessrules")
public class BusinessRuleResource {
private BusinessRuleDAO brDAO = new BusinessRuleDAO();
BusinessRuleService brService = BusinessRuleProvider.getBusinessRuleService();

@GET
@Produces
public String getBusinessRules() {
	BusinessRuleService service = BusinessRuleProvider.getBusinessRuleService();
	JsonArrayBuilder jab = Json.createArrayBuilder();
	
	for(BusinessRule br : service.getAllBusinessRules("myDatabase")) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("databasetype", br.getDatabaseType());
		job.add("name", br.getName());
		job.add("errormessage", br.getErrorMessage());
		jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
}
}