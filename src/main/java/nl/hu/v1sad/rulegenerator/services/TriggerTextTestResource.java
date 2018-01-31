package nl.hu.v1sad.rulegenerator.services;

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
	public String getTrigger(@PathParam("DatabaseName") String dbName ){
		TriggerTextTestService service = TriggerTextTestServiceProvider.getTriggerTextTestService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for(String s : service.generateTrigger(dbName)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("trigger", s);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}