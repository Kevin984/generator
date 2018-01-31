package nl.hu.v1sad.rulegenerator.webservices;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import nl.hu.v1sad.rulegenerator.persistence.TargetDatabaseDAO;

@Path("/targetdatabase")
public class TargetDatabaseResource {
	private TargetDatabaseDAO tdDAO = new TargetDatabaseDAO();
	TargetDatabaseService tdService = TargetDatabaseServiceProvider.getTargetDatabaseService();
	
	@GET
	@Path("{DatabaseName}/tables")
	@Produces("application/json")
	public String getTableNames(@PathParam("DatabaseName") String dbName ){
		TargetDatabaseService service = TargetDatabaseServiceProvider.getTargetDatabaseService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for(String s : service.getTablesFromDatabase(dbName)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("tablename", s);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("{DatabaseName}/{TableName}/columns")
	@Produces("application/json")
	public String getColumnNames(@PathParam("DatabaseName") String dbName, @PathParam("TableName") String tableName){
		TargetDatabaseService service = TargetDatabaseServiceProvider.getTargetDatabaseService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for(String s : service.getColumnsFromTable(dbName, tableName)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			String[] column = s.split(":");
		    job.add("columnname", column[0]);
		    job.add("datatype", column[1]);
		    job.add("length", column[2]);
		    job.add("scale", column[3]);
		    job.add("precision", column[4]);

			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}