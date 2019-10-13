package Vue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class EspaceProfCours extends JFrame {
	private JTextField pointsTP;
	private JTable table;
	private JTextField rechercher;
	private JTextField pointsSession1;
	private JTextField pointsSession2;
	private JButton validerPoints;
	private JButton btnAppel;
	private JComboBox comboCours;
	private JButton btnCharger;
	public EspaceProfCours() {
		getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[][][grow][][][][][]"));
		
		rechercher = new JTextField();
		rechercher.setColumns(10);
		getContentPane().add(rechercher, "cell 0 0,growx");
		
		comboCours = new JComboBox();
		getContentPane().add(comboCours, "cell 1 0,growx");
		
		btnCharger = new JButton("Charger");
		getContentPane().add(btnCharger, "cell 2 0,growx");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 2 3 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblPointsAAjouter = new JLabel("TP :");
		getContentPane().add(lblPointsAAjouter, "cell 0 3,alignx right");
		
		pointsTP = new JTextField();
		getContentPane().add(pointsTP, "cell 1 3,growx");
		pointsTP.setColumns(10);
		
		validerPoints = new JButton("Valider");
		getContentPane().add(validerPoints, "cell 2 3,growx");
		
		JLabel lblPremiereSession = new JLabel("Premiere Session:");
		getContentPane().add(lblPremiereSession, "cell 0 4,alignx trailing");
		
		pointsSession1 = new JTextField();
		getContentPane().add(pointsSession1, "cell 1 4,growx");
		pointsSession1.setColumns(10);
		
		btnAppel = new JButton("Appels");
		getContentPane().add(btnAppel, "cell 2 4 1 2,grow");
		
		JLabel lblDeuxiemeSession = new JLabel("Deuxieme Session:");
		getContentPane().add(lblDeuxiemeSession, "cell 0 5,alignx trailing");
		
		pointsSession2 = new JTextField();
		getContentPane().add(pointsSession2, "cell 1 5,growx");
		pointsSession2.setColumns(10);
	}
	public JTextField getPointsTP() {
		return pointsTP;
	}
	public void setPointsTP(JTextField pointsTP) {
		this.pointsTP = pointsTP;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JTextField getRechercher() {
		return rechercher;
	}
	public void setRechercher(JTextField rechercher) {
		this.rechercher = rechercher;
	}
	public JTextField getPointsSession1() {
		return pointsSession1;
	}
	public void setPointsSession1(JTextField pointsSession1) {
		this.pointsSession1 = pointsSession1;
	}
	public JTextField getPointsSession2() {
		return pointsSession2;
	}
	public void setPointsSession2(JTextField pointsSession2) {
		this.pointsSession2 = pointsSession2;
	}
	public JButton getValiderPoints() {
		return validerPoints;
	}
	public void setValiderPoints(JButton validerPoints) {
		this.validerPoints = validerPoints;
	}
	public JButton getBtnAppel() {
		return btnAppel;
	}
	public void setBtnAppel(JButton btnAppel) {
		this.btnAppel = btnAppel;
	}
	public JComboBox getComboCours() {
		return comboCours;
	}
	public void setComboCours(JComboBox comboCours) {
		this.comboCours = comboCours;
	}
	public JButton getBtnCharger() {
		return btnCharger;
	}
	public void setBtnCharger(JButton btnCharger) {
		this.btnCharger = btnCharger;
	}
}
