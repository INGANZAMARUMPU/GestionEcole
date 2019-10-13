package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.PreparedStatement;

public class ModelPoints{
	private static String URL = "jdbc:mysql://localhost:3306/Etablissement?useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "jonk2010";
	private static String requete;
	
	public DefaultTableModel gusomaModelPoints(int id_cours){
		String col[] = {"id","Nom", "Prenom", "Notes TP", "1eme Session", "2eme Session"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		setRequete("SELECT id, nom, prenom, tp, session1, session2 "
					+ "FROM vuePoints WHERE id_cours="+id_cours);
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			
			while(resultat.next()) {
				String[] tmp = new String[6];
				for (int i = 1; i <= 6; i++) {
					tmp[i-1] = resultat.getString(i);
				}
				tableModel.addRow(tmp);
			}
			return tableModel;
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR Points: "+e.getMessage());
			return null;
		}
	}
	public void creerlistPoints(int id_cours){
		int id_classe = new ModelCours().getIdClass(id_cours);
		setRequete("SELECT id FROM Etudiants WHERE id_classe="+id_classe);
		try (
			Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = (Statement) con.createStatement();
			ResultSet resultat = stmt.executeQuery(getRequete())){
			while(resultat.next()) {
//				System.out.println(resultat.getString(1));
				try (
					Connection con2 = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
					Statement stmt2 = (Statement) con2.createStatement()){
						setRequete("INSERT INTO Points(id_etudiant, id_cours) "
								+ "VALUES ("+resultat.getString(1)+","+id_cours+")");
						System.out.println(getRequete());
						stmt2.execute(getRequete());
				} catch (Exception e) {
					System.out.println(getRequete());
					System.out.println("ERREUR Points: "+e.getMessage());
				}
			}
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR Points: "+e.getMessage());
		}
	}
	public int ajouterPoints(String tp, String session1, String session2, int id_point){
		setRequete("UPDATE Points SET tp=?, session1=?, session2=?) "
				+ "WHERE id=?");
		
		try (Connection con = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(getRequete())){
			stmt.setString(1, tp);
			stmt.setString(2, session1);
			stmt.setString(3, session2);
			stmt.setInt(4, id_point);
			stmt.execute();
			return 1;
		} catch (SQLException e) {
			System.out.println(getRequete());
			System.out.println("ERREUR Points "+e.getMessage());
			return 0;
		}

	}
	public String getRequete() {
		return requete;
	}

	public void setRequete(String requête) {
		requete = requête;
	}
}