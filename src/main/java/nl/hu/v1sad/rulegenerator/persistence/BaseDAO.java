package nl.hu.v1sad.rulegenerator.persistence;

import java.net.URI; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext; import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
public class BaseDAO {
 private static DataSource connectionPool;

 	public BaseDAO() {
 	}
 
 	protected final Connection getRepositoryConnection() {
 		Connection conn = null;
 		try{
 			conn = DriverManager.getConnection("jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl", "tosad_2017_2a_team2", "tosad_2017_2a_team2");
 		}
 		catch(SQLException e){
 			throw new RuntimeException(e);
 		}
 		return conn;
 	}
 
 	protected final Connection getTargetConnection(String driverPrefix, String url, String port, String divider, String SIDorSERVICENAME, String username, String password) {
 		Connection conn = null;
 		try{
 			conn = DriverManager.getConnection(driverPrefix + url + ":" + port + divider + SIDorSERVICENAME, username, password); //if SID, use : instead of / (after port) ALSO: other databases may have it differently
 		}
 		catch(SQLException e){
 			throw new RuntimeException(e);
 		}
 	return conn;
 }
}
