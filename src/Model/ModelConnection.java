package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelConnection{
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	private String typeUser = "None";
	
	public String getTypeUser(){
		return typeUser;
	}
	
	public String getTypeUser(String nom, String prenom, String motdepasse){
		setRequete("SELECT Taches.nom FROM Taches, Users WHERE Taches.id = Users.id_tache and"
					+ " Users.nom = \""+ nom + "\" and Users.prenom = \"" + prenom + "\" and "
					+ "Users.mot_de_passe = \"" + motdepasse + "\"");
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
				if(resultat.next()) this.typeUser = resultat.getString(1);
			} catch (SQLException e) {
				System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
				return "None";
			}
		return typeUser;
	}

	public String getRequete() {
		return requete;
	}

	public void setRequete(String requete) {
		ModelConnection.requete = requete;
	}
}