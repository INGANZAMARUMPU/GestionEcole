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

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

public class ModelProf{
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	private ModelUsers modelUsers = new ModelUsers();
	
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


	public void modifierProf(String id, String nom, String prenom, String mdp, String login) {
		new ModelUsers().modifierUser(id, nom, prenom, mdp, login);		
	}
	
	public DefaultTableModel gusomaModelProf(){
		String col[] = {"id","Nom","Prenom", "login"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		setRequete("SELECT Professeurs.id, Users.nom, Users.prenom, Users.login FROM Professeurs INNER JOIN Users "
					+ "ON Professeurs.id_user = Users.id");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			while(resultat.next()) {
				Object[] tmp = new Object[4];
				for (int i = 1; i <= 4; i++) {
						tmp[i-1] = resultat.getString(i);
			       }
				tableModel.addRow(tmp);
			}
			return tableModel;
		} catch (SQLException e) {
				System.out.println("Il ya eu une erreur de lecture dans la base de données Users"+e);
				return null;
				}
	}

	public String getRequete() {
		return requete;
	}

	public void setRequete(String requête) {
		requete = requête;
	}


	public int ajouterProf(String nom, String prenom, String mot_de_passe, String login){
		
		if (!(nom.trim().isEmpty() | prenom.trim().isEmpty() | login.trim().isEmpty())){
			modelUsers.ajouterUser(nom, prenom, mot_de_passe, 2, login);
			int idUser=modelUsers.getIdUser(nom, prenom, mot_de_passe);
			System.out.println(idUser);
			setRequete("INSERT INTO Professeurs(id_user) VALUES (?)");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setInt(1, idUser);
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

	public ArrayList<String> gusomaNomsProf() {
		setRequete("SELECT nomComplet FROM vueProf");
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
			System.out.println(getRequete());
			System.out.println("ERREUR :"+e.getMessage());
			return null;
		}
	}
	public String gusomaNomProf(String id) {
		setRequete("SELECT nomComplet FROM vueProf where id = ?");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, id);
			
			try(ResultSet resultat = stmt.executeQuery()){
				String nom = "Sans";
				if (resultat.next()) {
					nom = resultat.getString(1);
				}
				return nom;
			}
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR :"+e.getMessage());
			return null;
		}
	}

	public int getIdProf(String nomEtPrenom) {
		setRequete("SELECT id FROM vueProf where nomComplet = ?");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			
			stmt.setString(1, nomEtPrenom);
			
			try(ResultSet resultat = stmt.executeQuery()){
				int id = -1;
				if (resultat.next()) {
					id = resultat.getInt(1);
				}
				return id;
			}
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR :"+e.getMessage());
			return -1;
		}
	}

	public int getIdProf(int id_user) {
		setRequete("SELECT id FROM vueProf where id_User = ?");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			
			stmt.setInt(1, id_user);;
			
			try(ResultSet resultat = stmt.executeQuery()){
				int id = -1;
				if (resultat.next()) {
					id = resultat.getInt(1);
				}
				return id;
			}
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR :"+e.getMessage());
			return -1;
		}
	}
	public String getIdUser(String id) {
		setRequete("SELECT id_user FROM Professeurs where id = ?");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			
			stmt.setString(1, id);
			
			try(ResultSet resultat = stmt.executeQuery()){
				String idUser = "-1";
				if (resultat.next()) {
					idUser = resultat.getString(1);
				}
				return idUser;
			}
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR :"+e.getMessage());
			return null;
		}
		
	}

}