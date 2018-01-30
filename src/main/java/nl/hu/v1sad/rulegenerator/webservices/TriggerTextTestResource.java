package nl.hu.v1sad.rulegenerator.webservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/generatetrigger")
public class TriggerTextTestResource {
	
	@GET
	@Path("{DatabaseName}")
	@Produces("application/json")
	public String getTableNames(@PathParam("DatabaseName") String dbName ){
		TriggerTextTestService service = TriggerTextTestProvider.getTriggerTextTestService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for(String s : service.generateTrigger(dbName)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("tablename", s);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}