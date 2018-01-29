package nl.hu.v1sad.rulegenerator.webservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import nl.hu.v1sad.rulegenerator.domain.BusinessRule;

@Path("/businessrules")
public class BusinessRuleResource {
	BusinessRuleService brService = BusinessRuleProvider.getBusinessRuleService();

	@GET
	@Path("{DatabaseName}")
	@Produces("application/json")
	public String getBusinessRules(@PathParam("DatabaseName") String dbName) {
		BusinessRuleService service = BusinessRuleProvider.getBusinessRuleService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(BusinessRule br : service.getAllBusinessRules(dbName)) { 
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
