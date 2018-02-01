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
public class TriggerResource {
	
	@GET
	@Path("{DatabaseName}")
	@Produces("application/json")
	public String getTrigger(@PathParam("DatabaseName") String dbName){
		TriggerService service = TriggerServiceProvider.getTriggerTextTestService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for(String s : service.generateTrigger(dbName)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("message", s);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}