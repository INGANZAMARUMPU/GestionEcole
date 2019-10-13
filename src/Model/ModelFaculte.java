package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.PreparedStatement;

public class ModelFaculte{
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	private int idFaculte;
	
	public DefaultTableModel gusomaModelFac(){
		String col[] = {"id","Nom"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		setRequete("SELECT * FROM Faculte");
		
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			while(resultat.next()) {
				String[] tmp = new String[2];
				for (int i = 1; i<3; i++) {
					String columnValue = resultat.getString(i);
					tmp[i-1] = columnValue;
					}
				
				tableModel.addRow(tmp);
			}
			return tableModel;
		} catch (SQLException e) {
			System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
			return null;
		}
	}
	
	public int ajouterFaculte(String nom){

		if(!(nom.trim().isEmpty())){
			setRequete("INSERT INTO Faculte(nom) VALUES (?)");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setString(1, nom);
				stmt.execute();
				return 1;
			} catch (SQLException e) {
				System.out.println(getRequete());
				System.out.println("ERREUR: "+e.getMessage());
				return 0;
			}
		}else{
			return 0;
		}
	}	
	
	public ArrayList<String> gusomaNomsFac(){
		setRequete("SELECT nom FROM Faculte");
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
	public String getRequete() {
		return requete;
	}

	public void setRequete(String request) {
		requete = request;
	}
	public String gusomaNomFac(String id) {
		
		String Requete = "SELECT nom  FROM Faculte WHERE id =?";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setString(1, id);
			try(ResultSet resultat = stmt.executeQuery()){
				
				if (resultat.next() ){
					return resultat.getString(1);
				}else{
					return "<Sans>";
				}
			}
			
		} catch (SQLException e) {
			System.out.println(Requete);
			System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
			return null;
		}
	}


	public void modifierFaculte(String id, String nom) {
		setRequete("UPDATE Faculte SET nom =? WHERE id=?");
		
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, nom);
			stmt.setString(2, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e.getMessage());
		}		
		
	}
	
	public Integer getIdFaculte(String nom) {
		
		String Requete = "SELECT id FROM Faculte WHERE nom = ?";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setString(1, nom);
			try (ResultSet resultat = stmt.executeQuery()){
				
				if (resultat.next() ){
					this.idFaculte = resultat.getInt(1);
				}
				return this.idFaculte;
			}
		} catch (SQLException e) {
				System.out.println("Il ya eu une erreur de lecture dans Facultés "+e);
				return -1;
				}
	}

	public void supprimerFaculte(String id) {

		setRequete("DELETE FROM Faculte where id =?");
		
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e.getMessage());
		}
		
	}

}