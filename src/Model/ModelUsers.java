package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext.SmallAttributeSet;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

public class ModelUsers{
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	
	public int ajouterUser(String nom, String prenom, String mot_de_passe, int id_t, String login ){

		if (!(nom.trim().equalsIgnoreCase("") | prenom.trim().equalsIgnoreCase(""))){
			setRequete("INSERT INTO Users(nom, prenom, mot_de_passe, id_tache, login) " 
						+ "VALUES (?, ?, ?, ?, ?)");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setString(1, nom);
				stmt.setString(2, prenom);
				stmt.setString(3, DigestUtils.md5Hex(mot_de_passe));
				stmt.setInt(4, id_t);
				stmt.setString(5, login);
				stmt.execute();
				return 1;
			} catch (SQLException e) {
					System.out.println(getRequete());
					System.out.println("Il ya eu une erreur d'écriture dans la base de données "+e);
					return 0;
					}
		}else{
			return 0;
		}
	}	

	public int getTypeUser(String login, String mot_de_passe){
		String mdp = DigestUtils.md5Hex(mot_de_passe);
		setRequete("SELECT id_tache FROM Users WHERE login=? AND mot_de_passe =?");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, login.toLowerCase());
			stmt.setString(2, mdp);
			try(ResultSet resultat = stmt.executeQuery()){
				if(resultat.next()){
					int tache = resultat.getInt(1);
					return tache;			
				}else{
					return -1;
				}		
			}
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR\n"+e.toString());
			return -1;
		}
	}
	public int getIdUser(String nom, String prenom, String mot_de_passe){
		String mdp = DigestUtils.md5Hex(mot_de_passe);
		setRequete("SELECT id FROM Users WHERE nom=? AND prenom=? AND mot_de_passe =?");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, nom);
			stmt.setString(2, prenom);
			stmt.setString(3, mdp);
			try(ResultSet resultat = stmt.executeQuery()){
				if(resultat.next()){
					int tache = resultat.getInt(1);
					return tache;			
				}else{
					return -1;
				}		
			}
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR\n"+e.toString());
			return -1;
		}
	}
	public int getIdUser(String login, String mot_de_passe){
		String mdp = DigestUtils.md5Hex(mot_de_passe);
		setRequete("SELECT id FROM Users WHERE login=? AND mot_de_passe =?");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, login.toLowerCase());
			stmt.setString(2, mdp);
			try(ResultSet resultat = stmt.executeQuery()){
				if(resultat.next()){
					int tache = resultat.getInt(1);
					return tache;			
				}else{
					return -1;
				}		
			}
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR\n"+e.toString());
			return -1;
		}
	}
	
	public int guhanaguraUser(String id){
		setRequete("DELETE FROM Users where id = "+id);
		
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement()){
			stmt.execute(getRequete());
			System.out.println("Vyagenze neza cane gose");
			return 1;
		} catch (SQLException e) {
				System.out.println("Il ya eu une erreur d'écriture dans la base de données "+e);
				return 0;
				}
		}
	
	public ArrayList<String> gusomaNomsUsers(int id_tache){
		setRequete("SELECT nom FROM Users WHERE id_tache ="+id_tache);
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
	public void modifierUser(String id, String nom, String prenom, String mdp, String login) {
		if(!(nom.trim().isEmpty() | prenom.trim().isEmpty())){
			setRequete("UPDATE Users SET nom = ?, prenom = ?, mot_de_passe = ?, login = ? WHERE id = ?");		
						
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setString(1, nom);
				stmt.setString(2, prenom);
				stmt.setString(3, DigestUtils.md5Hex(mdp));
				stmt.setString(4, login);
				stmt.setString(5, id);
				stmt.execute();
			} catch (SQLException e) {
					System.out.println(getRequete());
					System.out.println("Il ya eu une erreur d'écriture dans la base de données "+e);
					}
		}
		
	}
	
	public String getRequete() {
		return requete;
	}

	public void setRequete(String requête) {
		requete = requête;
	}
	
	public String getNomUser(int id) {
		
		String Requete = "SELECT nom  FROM Users WHERE id = ?";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			
			stmt.setInt(1, id);
			ResultSet resultat = stmt.executeQuery();
			if (resultat.next() ) return resultat.getString(1);
			return "sans prof";

			
		} catch (SQLException e) {
			System.out.println(Requete);
			System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
			return "inconnu";
		}
	}

}