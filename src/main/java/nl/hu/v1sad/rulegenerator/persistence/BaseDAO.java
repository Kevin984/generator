package nl.hu.v1sad.rulegenerator.persistence;

import java.net.URI; import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext; import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
public class BaseDAO {
 private static DataSource connectionPool;

 public BaseDAO() {
	/* 
 if (connectionPool == null) {
 try {
 final String DATABASE_URL_PROP = System.getenv("DATABASE_URL");

 if (DATABASE_URL_PROP != null) { // de applicatie draait op Heroku
	 
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
 System.out.print(DATABASE_URL_PROP);
 } else { // de applicatie draait lokaal
	 System.out.print(DATABASE_URL_PROP + " 22222");

 InitialContext ic = new InitialContext();
 connectionPool = (DataSource)ic.lookup("java:comp/env/jdbc/OracleDS");
 }
 } catch (Exception e) { throw new RuntimeException(e); }
 }*/
 }
 
 protected final Connection getRepositoryConnection() {
 //try {
//	 System.out.println(System.getenv("DATABASE_URL"));
 //return connectionPool.getConnection();
 Connection conn = null;
 
 try{
	 conn = DriverManager.getConnection("jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl", "tosad_2017_2a_team2", "tosad_2017_2a_team2");
 }
 catch(SQLException e){
	 throw new RuntimeException(e);
 }
 return conn;
// } catch (Exception ex) { throw new RuntimeException(ex); }
 }
}
