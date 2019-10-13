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

public class ModelEts{
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	private ModelUsers modelUsers = new ModelUsers();
	
	public DefaultTableModel gusomaModelEtudiants(){
		String col[] = {"id","Nom","Prenom", "class", "login"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		setRequete("SELECT Etudiants.id, Users.nom, Users.prenom, Etudiants.id_classe, Users.login "
					+ "FROM Etudiants INNER JOIN Users ON Etudiants.id_user=Users.id");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			while(resultat.next()) {
				Object[] tmp = new Object[5];
				for (int i = 1; i <= 5; i++) {
					if (i==4){
						String classe = resultat.getString(i);
						tmp[i-1] = new ModelClasse().gusomaNomClasse(classe);
					}else{
						tmp[i-1] = resultat.getString(i);
					}
				}
				tableModel.addRow(tmp);
			}
			return tableModel;
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR de lecture de la table Etudiants\n"+e.getMessage());
			return null;
		}
	}
	public int ajouterEts(String nom, String prenom, String mot_de_passe, int id_class, String login){
		if (!(nom.trim().equalsIgnoreCase("") | prenom.trim().equalsIgnoreCase(""))){
			modelUsers.ajouterUser(nom, prenom, mot_de_passe, 1, login);
			int idUser=modelUsers.getIdUser(nom, prenom, mot_de_passe);
			System.out.println(idUser);
			setRequete("INSERT INTO Etudiants(id_user, id_classe) VALUES (?, ?)");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setInt(1, idUser);
				stmt.setInt(2, id_class);
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
	public String getRequete() {
		return requete;
	}

	public void setRequete(String requête) {
		requete = requête;
	}
	
	public String getNomUser(int id) {
		
		String Requete = "SELECT nom  FROM Cours WHERE id = ?;";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete);
			ResultSet resultat = stmt.executeQuery()){
			
			if (resultat.next() ) return resultat.getString(1);
			return "<sans prof>";

			
		} catch (SQLException e) {
			System.out.println(Requete);
			System.out.println("ERREUR De lecture du Nom "+e);
			return "inconnu";
		}
	}
	public int modifierEts(String nom, String prenom, String mot_de_passe, Integer id_class, String login, String id) {
		
		if (!(nom.trim().isEmpty() | prenom.trim().isEmpty() | login.trim().isEmpty())){
			int idUser=modelUsers.getIdUser(nom, prenom, mot_de_passe);
			modelUsers.modifierUser(Integer.toString(idUser), nom, prenom, mot_de_passe, login);
			setRequete("UPDATE Etudiants SET id_classe=? WHERE id=?");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setInt(1, id_class);
				stmt.setString(2, id);
				stmt.execute();
				return 1;
			} catch (SQLException e) {
					System.out.println(getRequete());
					System.out.println("Il ya eu une erreur d'écriture dans la base de données "+e);
					return 0;
					}
		}else{
			System.out.println("Les valeurs recu sont vides");
			return 0;
		}
		
	}

}