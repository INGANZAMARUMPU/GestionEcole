package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.PreparedStatement;

public class ModelClasse {

	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private String nom;
	private Connection con;
	
	public ModelClasse(){
		try {
			this.con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> gusomaNomsClasses() {
		String Requete = "SELECT nomComplet FROM vueClasses";
		ArrayList<String> nomsClasses = new ArrayList<>();
		try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete);
			ResultSet resultat = stmt.executeQuery()){
			while (resultat.next()){
				nomsClasses.add(resultat.getString(1));
			}
			return nomsClasses;
		} catch (SQLException e) {
				System.out.println("ERREUR: "+e.getMessage());
				return null;
				}
	}
	
	public String gusomaNomClasse(String id) {
		String Requete = "SELECT nomComplet  FROM vueClasses WHERE id=?";
		try (java.sql.PreparedStatement stmt = con.prepareStatement(Requete)){
			stmt.setString(1, id);
			try(ResultSet resultat = stmt.executeQuery()){
				if (resultat.next()){
					nom = resultat.getString(1);
				}else{
					nom = "sans";
				}
				return nom;
			}
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e);
			return null;
		}
	}
	
	public DefaultTableModel gusomaModelClasse(){
		String col[] = {"id","Departement", "Niveau"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		String Requete = "SELECT * FROM Classes";
		
		try (Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(Requete)){
			while(resultat.next()) {
				String[] tmp = new String[4];
				for (int i = 1; i<=4; i++) {
					if (i==1) tmp[i-1] = resultat.getString(i);
					if (i==2) tmp[i-1] = new ModelDepartement().getNomDepartement(resultat.getString(i));
					if (i==3) tmp[i-1] = new ModelNiveau().getNomNiveau(resultat.getString(i));
					}
				
				tableModel.addRow(tmp);
			}
			return tableModel;
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e.getMessage());
			return null;
		}
	}

	public void ajouterClasse(int idDepart, int idNiveau) {
		String Requete = "INSERT INTO Classes(id_departement, id_niveau) VALUES (?,?)";
		
		try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setInt(1, idDepart);
			stmt.setInt(2, idNiveau);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(Requete);
			System.out.println("ERREUR: "+e.getMessage());
		}
	}
	public void modifierClasse(String id, int id_dep, int id_niv){

		String Requete = "UPDATE Classes SET id_departement=? ,id_niveau = ? WHERE id=?" ;
		
		try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setInt(1, id_dep);
			stmt.setInt(2, id_niv);
			stmt.setString(3, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e.getMessage());
		}
	}

	public void supprimerClasse(String id) {
		String Requete ="DELETE FROM Classes where id =?";
		
		try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(Requete)){
			stmt.setString(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e.getMessage());
		}
		
	}

	public int getIdClass(String nom) {
		String Requete = "SELECT id  FROM vueClasses WHERE nomComplet=?";
		try (java.sql.PreparedStatement stmt = con.prepareStatement(Requete)){
			stmt.setString(1, nom);
			int id = -1;
			try(ResultSet resultat = stmt.executeQuery()){
				if (resultat.next()) id = resultat.getInt(1);
				return id;
			}
		} catch (SQLException e) {
			System.out.println("ERREUR: "+e);
			return -1;
		}
	}
}
