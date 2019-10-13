package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

public class ModelDepartement{
	
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	
	private int idDepart;
	private String nomDepart;

	public String getNomDepartement(String classe) {
		
		String Requete = "SELECT nom FROM Departement WHERE id =?";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setString(1, classe);
			try(ResultSet resultat = stmt.executeQuery()){
				
				if (resultat.next()){
					this.nomDepart = resultat.getString(1);
				}
			}
			return this.nomDepart;
		} catch (SQLException e) {
			System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
			return "";
		}
	}

	public int getIdDepart(String depart) {
		
		String Requete = "SELECT id  FROM Departement WHERE nom =?";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setString(1, depart);
			try(ResultSet resultat = stmt.executeQuery()){
				
				if (resultat.next()){
					this.idDepart = resultat.getInt(1);
				}
			}
			return this.idDepart;
		} catch (SQLException e) {
			System.out.println("Il ya eu une erreur de lecture dans la base de données Departement"+e);
			return -1;
		}
	}
	public ArrayList<String> gusomaNomsDepart(){
		setRequete("SELECT nom FROM Departement");
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
	
	public DefaultTableModel gusomaModelDepartement(){
		String col[] = {"id","Nom","Faculté"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		setRequete("SELECT * FROM Departement");
		
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			while(resultat.next()) {
				String[] tmp = new String[3];
				for (int i = 1; i<=3; i++) {
					String columnValue = resultat.getString(i);
					if (i==3) columnValue = new ModelFaculte().gusomaNomFac(resultat.getString(i));
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

	public void ajouterDep(String nom, int id_fac) {

		if (!(nom.trim().isEmpty())){
			setRequete("INSERT INTO Departement(nom, id_faculte) VALUES (?, ?)");
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				PreparedStatement stmt =  (PreparedStatement) con.prepareStatement(getRequete())){
				stmt.setString(1, nom);
				stmt.setInt(2, id_fac);
				stmt.execute();
			} catch (SQLException e) {
					System.out.println("ERREUR :"+e.getMessage());
					}
		}else{
			return;
		}
		
	}

	public void supprimerDepart(String id) {
		setRequete("DELETE FROM Departement where id =?");
		
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e.getMessage());
		}
	}

	public static String getRequete() {
		return requete;
	}

	public static void setRequete(String requete) {
		ModelDepartement.requete = requete;
	}

	public void setIdDepart(int id) {
		this.idDepart = id;
	}

	public String gusomaNomDepart(String columnValue) {
		return null;
	}

}