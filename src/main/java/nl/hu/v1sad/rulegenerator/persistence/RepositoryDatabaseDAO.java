package nl.hu.v1sad.rulegenerator.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;
import nl.hu.v1sad.rulegenerator.domain.Operator;
import nl.hu.v1sad.rulegenerator.services.RuleTypeFactory;

public class RepositoryDatabaseDAO extends BaseDAO{
	private ArrayList<BusinessRule> businessRules = new ArrayList<BusinessRule>();
	private ArrayList<String> dbInfo = new ArrayList<String>();
	private RuleTypeFactory factory = new RuleTypeFactory();
	
	public ArrayList<BusinessRule> selectBusinessRules(String databaseName) {
		String query = 	"SELECT BR.NAME AS BUSINESSRULENAME, BR.DATABASETYPE, BR.TRIGGERNAME, BR.ERRORTEXT AS ERRORMESSAGE, O.NAME AS OPERATORNAME, O.SIGN AS OPERATORSIGN, RT.NAME AS RULETYPENAME, BRRT.FIRSTTARGETCOLUMNNAME, BRRT.SECONDTARGETCOLUMNNAME, BRRT.FIRSTVALUE, BRRT.SECONDVALUE, BRRT.FIRSTTARGETTABLENAME, BRRT.SECONDTARGETTABLENAME, BRRT.VALUELIST, BRRT.CUSTOMCODE\n" + 
						"FROM BUSINESSRULE BR\n" + 
						"INNER JOIN BUSINESSRULE_RULETYPE BRRT\n" + 
						"ON BR.NAME = BRRT.BUSINESSRULENAME\n" + 
						"INNER JOIN BUSINESSRULETYPE RT\n" + 
						"ON RT.NAME = BRRT.BUSINESSRULETYPENAME\n" + 
						"INNER JOIN OPERATOR O\n" + 
						"ON O.NAME = BRRT.OPERATORNAME\n" + 
						"WHERE UPPER(BR.DATABASENAME) = '" + databaseName.toUpperCase() + "' \n" + 
						//"AND UPPER(BR.STATUS) = 'TOBEGENERATED'" +
						//"AND BR.NAME = 'testuuh2'";
						"AND UPPER(BR.STATUS) = 'TOBEGENERATED'";
				businessRules.clear();
		try (Connection con = super.getRepositoryConnection()){
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String operatorName = rs.getString("OPERATORNAME");
				String operatorSign = rs.getString("OPERATORSIGN");
				String ruleTypeName = rs.getString("RULETYPENAME");
				String databaseType = rs.getString("DATABASETYPE");
				String businessRuleName = rs.getString("BUSINESSRULENAME");
				String errorMessage = rs.getString("ERRORMESSAGE");


				Operator operator = new Operator(operatorName, operatorSign);
				BusinessRuleType ruleType = factory.getRuleType(ruleTypeName, rs);
				BusinessRule rule = new BusinessRule(businessRuleName, ruleType, operator, databaseType, errorMessage);
				businessRules.add(rule);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return businessRules;
	}
	
	public ArrayList<String> selectTargetDBInfo(String databaseName) {
		String query = 	"SELECT * FROM TARGETDATABASE WHERE UPPER(DATABASENAME) = '" + databaseName.toUpperCase() + "'";
		try (Connection con = super.getRepositoryConnection()){
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				dbInfo.add(rs.getString("DRIVERPREFIX"));
				dbInfo.add(rs.getString("HOST"));
				dbInfo.add(rs.getString("PORT"));
				if (rs.getString("SID") != null) {
					dbInfo.add(":");
					dbInfo.add(rs.getString("SID"));
				} else {
					dbInfo.add("/");
					dbInfo.add(rs.getString("SERVICENAME"));
				}
				dbInfo.add(rs.getString("USERNAME"));
				dbInfo.add(rs.getString("PASSWORD"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dbInfo;
	}
	
}
