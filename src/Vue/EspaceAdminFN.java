package Vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class EspaceAdminFN extends JFrame {
	private JTable table;
	private JTextField nom;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JPanel panel;
	public EspaceAdminFN() {
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][][][]", "[grow][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0 5 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNom = new JLabel("nom:");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNom, "cell 0 1,alignx trailing");
		
		nom = new JTextField();
		panel.add(nom, "cell 1 1,growx");
		nom.setColumns(10);
		
		btnAjouter = new JButton("Ajouter");
		panel.add(btnAjouter, "cell 2 1");
		
		btnModifier = new JButton("Modifier");
		panel.add(btnModifier, "cell 3 1");
		
		btnSupprimer = new JButton("supprimer");
		panel.add(btnSupprimer, "cell 4 1");
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JTextField getNom() {
		return nom;
	}
	public void setNom(JTextField nom) {
		this.nom = nom;
	}
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}
	public JButton getBtnModifier() {
		return btnModifier;
	}
	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}
	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}
	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}

}
