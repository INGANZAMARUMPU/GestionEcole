package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

public class ModelNiveau{
	
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	
	private int idNiveau;
	private String nomNiveau;
	
	public DefaultTableModel gusomaModelNiv(){
		String col[] = {"id","Nom"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		setRequete("SELECT * FROM Niveau");
		
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
			System.out.println("ERREUR: "+e.getMessage());
			return null;
		}
	}

	public String getNomNiveau(String classe) {
		
		String Requete = "SELECT nom FROM Niveau WHERE id =?";
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setString(1, classe);
			try(ResultSet resultat = stmt.executeQuery()){
				if (resultat.next()){
					this.nomNiveau = resultat.getString(1);
				}
				return this.nomNiveau;				
			}
		} catch (SQLException e) {
				System.out.println("ERREUR: "+e);
				return "";
				}
	}

	public int getIdNiveau(String tache) {
		
		String Requete = "SELECT id FROM Niveau WHERE nom =?";
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setString(1, tache);
			try(ResultSet resultat = stmt.executeQuery()){
				if (resultat.next()) this.idNiveau = resultat.getInt(1);
				return this.idNiveau;
				}
		} catch (SQLException e) {
				System.out.println("Il ya eu une erreur de lecture dans Niveau "+e);
				return -1;
				}
	}
	
	public void ajouterNiveau(String nom){

		if(!(nom.trim().isEmpty())){
			setRequete("INSERT INTO Niveau(nom) VALUES (?)");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setString(1, nom);
				stmt.executeUpdate();	
				}
			catch (SQLException e) {
					System.out.println(getRequete());
					System.out.println("ERREUR: "+e.getMessage());
					}
			}
	}
	
	public ArrayList<String> gusomaNomNiveau(){
		setRequete("SELECT nom FROM Niveau");
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

	public void supprimerNiveau(String id) {
		setRequete("DELETE FROM Niveau where id =?");
		
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e.getMessage());
		}
	}

	public void modifierNiveau(String id, String nom) {
		setRequete("UPDATE Niveau SET nom =? WHERE id=?" );
		
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, nom);
			stmt.setString(2, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e.getMessage());
		}
	}	
	
	public static String getRequete() {
		return requete;
	}

	public static void setRequete(String requete) {
		ModelNiveau.requete = requete;
	}	
	
}