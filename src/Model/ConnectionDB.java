package Model;

import java.awt.Color;
import java.awt.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	private Label champ;
	private int typeUser;
	private String prenom;
	private String nom;
	private String passwd;
	
	public ConnectionDB(Label champ, String nom, String prenom, String passwd){
		this.champ = champ;
		this.nom = nom;
		this.prenom = prenom;
		this.passwd = passwd;
	
	}
	
	public int getTypeUser(){
		if ((this.nom.isEmpty() | this.prenom.isEmpty() | this.passwd.isEmpty())){
			erreurConnection("tout les cases doivent etre remplis");
			return -1;
		}else{
		setRequete("SELECT id_tache FROM Users WHERE nom =" + this.nom.toString() 
				+ " AND prenom=" + this.prenom.toString() + " mot_de_passe = " + this.passwd.toString());
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			int tache = resultat.getInt(0);
			setTypeUser(tache);			
			return tache;
		} catch (SQLException e) {
				erreurConnection(e.toString());
				return -1;
				}
		}
	}
	public void erreurConnection(String message){
		this.champ.setText("Erreur: "+message);
		this.champ.setForeground(Color.RED);
	}

	public String getRequete() {
		return requete;
	}

	public void setRequete(String requête) {
		requete = requête;
	}

	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
	}

}
