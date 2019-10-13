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

public class ModelEconomes{
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	
	public int ajouterUser(String nom, String prenom, String mot_de_passe, int id_t, int id_d, int id_f, int id_c, int id_niv ){

		if(nom.length()!=0 & prenom.length()!=0 & id_t>0 & id_t<40){
			setRequete("INSERT INTO Users(nom, prenom, mot_de_passe, id_tache, id_departement, id_faculte, id_cours, id_niveau) "
						+ "VALUES (\""+nom+"\", \""+ prenom+"\""+", \""+ DigestUtils.md5Hex(mot_de_passe)+"\""
						+", \""+ id_t+"\""+", \""+ id_d+"\""+", \""+ id_f+"\""+ ""+", \""+ id_c+", \""+ id_niv+"\")");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				Statement stmt = (Statement) con.createStatement()){
				stmt.execute(getRequete());
				System.out.println("Vyagenze neza cane gose");
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
	
	
	public DefaultTableModel gusomaUsers(int id_tache){
		String col[] = {"id","Nom","Prenom", "Tache", "Classe"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		setRequete("SELECT * FROM Users WHERE id_tache="+id_tache);
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			while(resultat.next()) {
				Object[] tmp = new Object[5];
				for (int i = 1; i <= 5; i++) {
					if (i == 4) {
						continue;
					} else if (i==5){
							tmp[i-2] = new ModelTaches().gusomaNomTache(resultat.getInt(i));
					}else{
						tmp[i-1] = resultat.getString(i);
					}
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


	public int ajouterProf(String nom, String prenom, String mot_de_passe, int id_t){
		if(nom.length()!=0 & prenom.length()!=0 & id_t>0 & id_t<40){
			setRequete("INSERT INTO Users(nom, prenom, mot_de_passe, id_tache) "+ "VALUES (\""+nom+"\", \""
						+ prenom+"\""+", \""+ DigestUtils.md5Hex(mot_de_passe)+"\""+", "+ id_t+ ")");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				Statement stmt = (Statement) con.createStatement()){
				stmt.execute(getRequete());
				System.out.println("Vyagenze neza cane gose");
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
	
	public int ajouterAdmin(String nom, String prenom, String mot_de_passe, int id_t, String id_d){
		if(nom.length()!=0 & prenom.length()!=0 & id_t>0 & id_t<40){
			setRequete("INSERT INTO Users(nom, prenom, mot_de_passe, id_tache, id_departement) "+ "VALUES (\""+nom+
						"\", \""+ prenom+"\""+", \""+ DigestUtils.md5Hex(mot_de_passe)+"\""+", "+ id_t+", "+ id_d+")");
			
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				Statement stmt = (Statement) con.createStatement()){
				stmt.execute(getRequete());
				System.out.println("Vyagenze neza cane gose");
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

	public void modifierUser(String id, String nom, String prenom, String mdp, String id_t, String id_fac, String id_depart, String id_niv) {
		if(nom.length()!=0 & prenom.length()!=0){
			setRequete("UPDATE Users SET nom = \""+ nom + "\", prenom = \""+ prenom +"\", mot_de_passe = \""
						+ DigestUtils.md5Hex(mdp)+"\", id_tache = \""+ id_t +"\", id_niveau = \""+ id_niv 
						+"\", id_faculte = \""+ id_fac+"\", id_departement = \""+ id_depart +"\" WHERE id = "+ id);		
						
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				Statement stmt = (Statement) con.createStatement()){
				stmt.execute(getRequete());
				System.out.println("Vyagenze neza cane gose");
			} catch (SQLException e) {
					System.out.println(getRequete());
					System.out.println("Il ya eu une erreur d'écriture dans la base de données "+e);
					}
		}
	}	
	
	public void modifierProf(String id, String nom, String prenom, String mdp) {
		if(nom.length()!=0 & prenom.length()!=0){
			setRequete("UPDATE Users SET nom = \""+ nom + "\", prenom = \""+ prenom +"\", mot_de_passe = \""+ 
						DigestUtils.md5Hex(mdp)+"\" WHERE id = "+ id);		
						
			try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
				Statement stmt = (Statement) con.createStatement()){
				stmt.execute(getRequete());
				System.out.println("Vyagenze neza cane gose");
			} catch (SQLException e) {
					System.out.println(getRequete());
					System.out.println("Il ya eu une erreur d'écriture dans la base de données "+e);
					}
		}
	}

	public String getNomUser(int id) {
		
		String Requete = "SELECT nom  FROM Cours WHERE id = "+id+";";
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(Requete)){
			
			if (resultat.next() ) return resultat.getString(1);
			return "sans prof";

			
		} catch (SQLException e) {
			System.out.println(Requete);
			System.out.println("Il ya eu une erreur de lecture dans la base de données "+e);
			return "inconnu";
		}
	}

}