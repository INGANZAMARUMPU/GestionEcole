package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelHistorique{
	private static String URL = "jdbc:mysql://localhost:3306/maBase?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	
	public void kwandikaHist(String nom, String prenom){
		if(nom.length()!=0 & prenom.length()!=0){
			setRequete("INSERT INTO indamukanyo(nom, prenom) VALUES (\""+nom.toUpperCase()+"\", \""+ prenom+"\")");
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				Statement stmt = (Statement) con.createStatement()){
				stmt.execute(getRequete());
				System.out.println("Vyagenze neza cane gose");
			} catch (SQLException e) {
					System.out.println("Il ya eu une erreur d'écriture dans la base de données "+e);
					}
		}else{
			gusomaHist();
		}
	}	
	
	public ArrayList<ArrayList<String>> gusomaHist(){
		setRequete("SELECT * FROM indamukanyo");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			ArrayList<ArrayList<String>> listResultat = new ArrayList<ArrayList<String>>();
			
			while(resultat.next()) {
				ArrayList<String> tmp = new ArrayList<String>();
				for (int i = 1; i <= 4; i++) {
					String columnValue = resultat.getString(i);
					tmp.add(columnValue);
			       }
				listResultat.add(tmp);
			}
			return listResultat;
		} catch (SQLException e) {
				System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
				return null;
				}
	}

	public String getRequete() {
		return requete;
	}

	public void setRequete(String requête) {
		requete = requête;
	}

}