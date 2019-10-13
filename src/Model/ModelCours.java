package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

public class ModelCours{
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	private int idCours;
	private String nomCours;
	

	public ArrayList<String> gusomaNomsCours(int id_prof){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setRequete("SELECT nomComplet FROM vueCours WHERE id_professeur=?");
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setInt(1, id_prof);
			ArrayList<String> listResultat;
			try(ResultSet resultat = stmt.executeQuery()){
				listResultat = new ArrayList<String>();
				
				while(resultat.next()) {
					listResultat.add(resultat.getString(1));
				}
			}
			return listResultat;
		} catch (SQLException e) {
			System.out.println("ERREUR Cours "+e.getMessage());
			return null;
		}
	}
	
	public int ajouterCours(String nom, int volume, int id_prof, int id_classe ){

		if (!(nom.trim().equalsIgnoreCase(""))){
			setRequete("INSERT INTO Cours(nom, volume, id_professeur, id_classe) " 
						+ "VALUES (?, ?, ?, ?)");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setString(1, nom);
				stmt.setInt(2, volume);
				stmt.setInt(3, id_prof);
				stmt.setInt(4, id_classe);
				stmt.execute();
				return 1;
			} catch (SQLException e) {
					System.out.println(getRequete());
					System.out.println("Erreur"+e.getMessage());
					return 0;
					}
		}else{
			return 0;
		}
	}	

	public DefaultTableModel gusomaModelCours(){
		String col[] = {"id","Nom","Volume", "classe", "professeur"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		setRequete("SELECT * FROM Cours");
		
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			while(resultat.next()) {
				String[] tmp = new String[7];
				for (int i = 1; i<6; i++) {
					String columnValue = resultat.getString(i);
					if (i==4) columnValue = new ModelClasse().gusomaNomClasse(resultat.getString(i));					
					if (i==5) columnValue = new ModelProf().gusomaNomProf(resultat.getString(i));
					tmp[i-1] = columnValue;
					}
				
				tableModel.addRow(tmp);
			}
			return tableModel;
		} catch (SQLException e) {
			System.out.println("Il ya eu une erreur de lecture dans la base de données "+e.getMessage());
			return null;
		}
	}
	
	public ArrayList<String> gusomaNomsCours(){
		setRequete("SELECT nom FROM Cours");
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			ArrayList<String> listResultat = new ArrayList<String>();
			
			while(resultat.next()) {
				listResultat.add(resultat.getString(1));
			}
			return listResultat;
		} catch (SQLException e) {
			System.out.println("Il ya eu une erreur de lecture dans la base de données "+e.getMessage());
			return null;
		}
	}
	public int getIdCours(String nomComplet) {
		
		String Requete = "SELECT id FROM vueCours WHERE nomComplet=?";
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setString(1, nomComplet);
			ResultSet resultat = stmt.executeQuery();
			
			if (resultat.next() ){
				this.idCours = resultat.getInt(1);
			}
			return this.idCours;
			
		} catch (SQLException e) {
			System.out.println("ERREUR Cours "+e.getMessage());
			return -1;
		}
	}

	public String gusomaNomCours(String cours) {
		
		String Requete = "SELECT nom  FROM Cours WHERE id = "+cours+";";
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(Requete)){
			
			if (resultat.next() ){
				this.nomCours = resultat.getString(1);
			}
			return this.nomCours;
			
		} catch (SQLException e) {
			System.out.println(Requete);
			System.out.println("Il ya eu une erreur de lecture dans la base de données "+e.getMessage());
			return "inconnu";
		}
	}
	
	public String getRequete() {
		return requete;
	}

	public void setRequete(String requête) {
		requete = requête;
	}

	public void modifierCours(int id, String nom, int volume, int id_prof, int id_classe) {
		if(!nom.isEmpty() & volume>5){
			setRequete("UPDATE Cours SET nom=?, volume=?, id_professeur=?, id_classe=? WHERE id=?");
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setString(1, nom);
				stmt.setInt(2, volume);
				stmt.setInt(3, id_prof);
				stmt.setInt(4, id_classe);
				stmt.setInt(5, id);
				stmt.execute();
				System.out.println("Vyagenze neza cane gose");
			} catch (SQLException e) {
					System.out.println("ERREUR Cours "+e.getMessage());
					}
		}else{
			return;
		}
		
	}

	public int getIdClass(String nomComplet) {
		
		String Requete = "SELECT id_classe FROM vueCours WHERE nomComplet=?";
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setString(1, nomComplet);
			ResultSet resultat = stmt.executeQuery();
			
			if (resultat.next() ){
				this.idCours = resultat.getInt(1);
			}
			return this.idCours;
			
		} catch (SQLException e) {
			System.out.println("ERREUR Cours "+e.getMessage());
			return -1;
		}
	}

	public int getIdClass(int id_cours) {
		
		String Requete = "SELECT id_classe FROM vueCours WHERE id=?";
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setInt(1, id_cours);;
			ResultSet resultat = stmt.executeQuery();
			
			if (resultat.next() ){
				this.idCours = resultat.getInt(1);
			}
			return this.idCours;
			
		} catch (SQLException e) {
			System.out.println("ERREUR Cours "+e.getMessage());
			return -1;
		}
	}

}