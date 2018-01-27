package nl.hu.v1sad.rulegenerator.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;



public class RuleTypeFactory {
	public BusinessRuleType getRuleType(String ruleType, ResultSet rs) {
		try {
			String firstTargetColumnName = rs.getString("FIRSTTARGETCOLUMNNAME");
			String secondTargetColumnName = rs.getString("SECONDTARGETCOLUMNNAME");
			String firstValue = rs.getString("FIRSTVALUE");
			String secondValue = rs.getString("SECONDVALUE");
			String firstTargetTableName = rs.getString("FIRSTTARGETTABLENAME");
			String secondTargetTableName = rs.getString("SECONDTARGETTABLENAME");
			String valueList = rs.getString("VALUELIST");
			String customCode = rs.getString("CUSTOMCODE");
		
			if (ruleType.equalsIgnoreCase("Attribute Compare Rule")) {
				return new AttributeCompareRule(firstTargetTableName, firstTargetColumnName, firstValue);
			}
			else if (ruleType.equalsIgnoreCase("Attribute Range Rule")) {
				return new AttributeRangeRule(firstTargetTableName, firstTargetColumnName, firstValue, secondValue);
			}
			else if (ruleType.equalsIgnoreCase("Attribute List Rule")) {
				return new AttributeListRule(firstTargetTableName, firstTargetColumnName, valueList);
			}
			else if (ruleType.equalsIgnoreCase("Attribute Other Rule")) {
				return new AttributeOtherRule(customCode);
			}
			else if (ruleType.equalsIgnoreCase("Tuple Compare Rule")) {
				return new TupleCompareRule(firstTargetTableName, firstTargetColumnName, secondTargetColumnName);
			}
			else if (ruleType.equalsIgnoreCase("Tuple Other Rule")) {
				return new TupleOtherRule(firstTargetTableName, customCode);
			}
			else if (ruleType.equalsIgnoreCase("Inter-Entity Compare Rule")) {
				return new InterEntityCompareRule(firstTargetColumnName, secondTargetColumnName, firstTargetTableName, secondTargetTableName);
			}
			else if (ruleType.equalsIgnoreCase("Entity Other Rule")) {
				return new EntityOtherRule(firstTargetTableName, customCode);
			}
			else if (ruleType.equalsIgnoreCase("Modify Rule")) {
				return new ModifyRule(customCode);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
