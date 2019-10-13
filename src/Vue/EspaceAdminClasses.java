package Vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class EspaceAdminClasses extends JFrame {
	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}
	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}
	private JTable tableClasses;
	private JComboBox comboDep;
	private JButton btnModifier;
	private JLabel lblNiveau;
	private JComboBox comboNiveau;
	private JPanel ongletClasses;
	private JButton btnSupprimer;
	private JButton btnAjouter;
	public EspaceAdminClasses() {
		
		ongletClasses = new JPanel();
		getContentPane().add(ongletClasses, BorderLayout.CENTER);
		ongletClasses.setLayout(new MigLayout("", "[grow][grow][]", "[grow][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		ongletClasses.add(scrollPane, "cell 0 0 3 1,grow");
		
		tableClasses = new JTable();
		scrollPane.setViewportView(tableClasses);
		
		JLabel lblDpartement_1 = new JLabel("Département :");
		lblDpartement_1.setHorizontalAlignment(SwingConstants.RIGHT);
		ongletClasses.add(lblDpartement_1, "cell 0 1,alignx trailing");
		
		comboDep = new JComboBox();
		ongletClasses.add(comboDep, "cell 1 1,growx");
		
		btnAjouter = new JButton("Ajouter");
		ongletClasses.add(btnAjouter, "cell 2 1");
		
		lblNiveau = new JLabel("Niveau :");
		lblNiveau.setHorizontalAlignment(SwingConstants.RIGHT);
		ongletClasses.add(lblNiveau, "cell 0 2,alignx trailing");
		
		comboNiveau = new JComboBox();
		ongletClasses.add(comboNiveau, "cell 1 2,growx");
		
		btnModifier = new JButton("Modifier");
		ongletClasses.add(btnModifier, "cell 2 2");
		
		btnSupprimer = new JButton("Supprimer");
		ongletClasses.add(btnSupprimer, "cell 2 3");
	}
	public JPanel getOngletClasses() {
		return ongletClasses;
	}
	public void setOngletClasses(JPanel ongletClasses) {
		this.ongletClasses = ongletClasses;
	}
	public JComboBox getComboDep() {
		return comboDep;
	}
	public void setComboDep(JComboBox comboDep) {
		this.comboDep = comboDep;
	}
	public JButton getBtnModifier() {
		return btnModifier;
	}
	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}
	public JComboBox getComboNiveau() {
		return comboNiveau;
	}
	public void setComboNiveau(JComboBox comboNiveau) {
		this.comboNiveau = comboNiveau;
	}
	public JTable getTableClasses() {
		return tableClasses;
	}
	public void setTableClasses(JTable tableClasses) {
		this.tableClasses = tableClasses;
	}
}
