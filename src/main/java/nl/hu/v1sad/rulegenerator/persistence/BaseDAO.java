package nl.hu.v1sad.rulegenerator.persistence;

import java.net.URI; import java.sql.Connection;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext; import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
public class BaseDAO {
 private static DataSource connectionPool;

 public BaseDAO() {
 if (connectionPool == null) {
 try {
 final String DATABASE_URL_PROP = System.getenv("DATABASE_URL");

 if (DATABASE_URL_PROP != null) { // de applicatie draait op Heroku
	 
	 Hashtable env = new Hashtable(5);
	   env.put(Context.INITIAL_CONTEXT_FACTORY,
	           "weblogic.jndi.WLInitialContextFactory");
	   env.put(Context.PROVIDER_URL,
	           "t3://weblogicServer:7001");
	   Context ctx = new InitialContext(env);
	 DataSource ds = (DataSource)ctx.lookup("OracleDS");
	 
	 ds.getConnection();
	 
 URI dbUri = new URI(DATABASE_URL_PROP);
 String dbUrl = "jdbc:oracle:thin:@" + dbUri.getHost() + dbUri.getPath();
 BasicDataSource pool = new BasicDataSource();

 if (dbUri.getUserInfo() != null) {
 pool.setUsername(dbUri.getUserInfo().split(":")[0]);
 pool.setPassword(dbUri.getUserInfo().split(":")[1]);
 }

 pool.setMaxIdle(4); // maximaal 4 ongebruikte connecties
 pool.setMaxTotal(20); // maximaal 20 connecties in Heroku
 pool.setDriverClassName("oracle.jdbc.driver.OracleDriver");
 pool.setUrl(dbUrl);
 pool.setInitialSize(1);

 connectionPool = pool;
 } else { // de applicatie draait lokaal
 InitialContext ic = new InitialContext();
 connectionPool = (DataSource)ic.lookup("java:comp/env/jdbc/OracleDS");
 }
 } catch (Exception e) { throw new RuntimeException(e); }
 }
 }
 
 protected final Connection getRepositoryConnection() {
 try {
 return connectionPool.getConnection();
 } catch (Exception ex) { throw new RuntimeException(ex); }
 }
 
 protected final Connection getTargetConnection(String dbPrefix, String url, int port, String serviceName, String SID,  String username, String password){
	 try{
		 
		 return connectionPool.getConnection(); //dit moet nog veranderd worden naar de target database (ook oplossing verzinnen voor als t MySQL etc is ivm jdbc jar/drivers)
	 }
	 catch(Exception e){
		 throw new RuntimeException(e);
	 }
 }
}
