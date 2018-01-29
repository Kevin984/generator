package nl.hu.v1sad.rulegenerator.domain;

import java.util.ArrayList;

import nl.hu.v1sad.rulegenerator.persistence.TargetDatabaseDAO;

public class Main {

	public static void main(String[] args) {
		// Main class for testing purposes
		TargetDatabaseDAO dao = new TargetDatabaseDAO();
		ArrayList<String> tables = dao.getAllTablesOfDatabase("myDatabase");
		System.out.println("All tables: " + tables);
		for (int i = 0;i<tables.size();i++) {
			System.out.println("Columns in table " + tables.get(i) + ": " + dao.getAllColumnsOfTable("myDatabase", tables.get(i)));
		}
	}

}
