package nl.hu.v1sad.rulegenerator.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1sad.rulegenerator.persistence.RepositoryDatabaseDAO;

public class TargetDatabaseDAO extends BaseDAO {
	private RepositoryDatabaseDAO repoDAO = new RepositoryDatabaseDAO();
	private ArrayList<String> dbInfo = new ArrayList<String>();
	private ArrayList<String> tables = new ArrayList<String>();
	private ArrayList<String> columns = new ArrayList<String>();
	
	public void executeTrigger(String databaseName, String trigger) {
		dbInfo = repoDAO.selectTargetDBInfo(databaseName);
		try (Connection con = super.getTargetConnection(dbInfo.get(0), dbInfo.get(1), dbInfo.get(2), dbInfo.get(3), dbInfo.get(4), dbInfo.get(5), dbInfo.get(6))){
			Statement stmt = con.createStatement();
			stmt.executeQuery(trigger);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getAllTablesOfDatabase(String databaseName) {
		String query = "SELECT table_name FROM user_tables";
		dbInfo = repoDAO.selectTargetDBInfo(databaseName);
		tables.clear();
		try (Connection con = super.getTargetConnection(dbInfo.get(0), dbInfo.get(1), dbInfo.get(2), dbInfo.get(3), dbInfo.get(4), dbInfo.get(5), dbInfo.get(6))){
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String tablename = rs.getString("TABLE_NAME");
				tables.add(tablename);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}
	
	public ArrayList<String> getAllColumnsOfTable(String databaseName, String tableName) {
		String query = "SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH FROM USER_TAB_COLUMNS WHERE upper(table_name) = '" + tableName.toUpperCase() + "'";
		dbInfo = repoDAO.selectTargetDBInfo(databaseName);
		columns.clear();
		try (Connection con = super.getTargetConnection(dbInfo.get(0), dbInfo.get(1), dbInfo.get(2), dbInfo.get(3), dbInfo.get(4), dbInfo.get(5), dbInfo.get(6))){
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String columnname = rs.getString("COLUMN_NAME");
				String datatype = rs.getString("DATA_TYPE");
				String length = rs.getString("DATA_LENGTH");
			//	String scale = rs.getString("DATA_SCALE");
			//	String precision = rs.getString("DATA_PRECISION");
				columns.add(columnname+":"+datatype+":"+length);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return columns;
	}
}
