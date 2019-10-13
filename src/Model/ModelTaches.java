package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ModelTaches{
	
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	
	private int idTache;
	private String nomTache;

	public String getNomsTache(int id) {
		
		String Requete = "SELECT nom  FROM Taches WHERE nom = \""+id+"\"";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(Requete)){
			
			if (resultat.next()){
				this.nomTache = resultat.getString(1);
			}
			return this.nomTache;
		} catch (SQLException e) {
				System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
				return "";
				}
	}

	public int getIdTache(String tache) {
		
		String Requete = "SELECT id  FROM Taches WHERE nom = \""+tache+"\"";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(Requete)){
			
			if (resultat.next()){
				this.idTache = resultat.getInt(1);
			}
			return this.idTache;
		} catch (SQLException e) {
				System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
				return -1;
				}
	}
	public ArrayList<String> modelNomTache(){
		setRequete("SELECT nom FROM Taches");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			ArrayList<String> listResultat = new ArrayList<String>();
			
			while(resultat.next()) {
				listResultat.add(resultat.getString(1));
			}
			return listResultat;
		} catch (SQLException e) {
				System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
				return null;
				}
	}
	public static String getRequete() {
		return requete;
	}

	public static void setRequete(String requete) {
		ModelTaches.requete = requete;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}

	public String gusomaNomTache(int columnValue) {
		String Requete = "SELECT nom  FROM Taches WHERE id = "+columnValue+";";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(Requete)){		
				if (resultat.next() ){
					this.nomTache = resultat.getString(1);
				}
				return this.nomTache;
				
		} catch (SQLException e) {
				System.out.println(Requete);
					System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
					return "inconnu";
					}
		}
}