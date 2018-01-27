package nl.hu.v1sad.rulegenerator.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import nl.hu.v1sad.rulegenerator.domain.BusinessRule;
import nl.hu.v1sad.rulegenerator.domain.BusinessRuleType;


public class OutputTemplate {

	public String getFilledTemplate(BusinessRule br) {
		String emptyTemplate = "";
		String filledTemplate = "";
		try{		
			BusinessRuleType ruleType = br.getRuleType();
			String ruleTypeName = ruleType.getName();
			String databaseType = br.getDatabaseType();

			BufferedReader bufferedReader = new BufferedReader(
		    //get the template by checking the businessrule for its Type
		    new FileReader("src/resources/templates/" + databaseType + "/" + ruleTypeName + ".sql")
		    );
			
		    StringBuilder sb = new StringBuilder();
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			emptyTemplate = sb.toString();
			bufferedReader.close();
						
			//replace the values in the template (operator, operands, target columns etc) with the method of the relevant ruletype
			filledTemplate = ruleType.fillTemplate(emptyTemplate, br);
			
		    }
		    catch (FileNotFoundException e){
		        e.printStackTrace();
		    }
		    catch (IOException e){
		        e.printStackTrace();
		    }
		return filledTemplate;
	}
}
