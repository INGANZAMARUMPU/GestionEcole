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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class EspaceAdminDep extends JFrame {
	private JTable table;
	private JTextField nomDep;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JComboBox comboFac;
	private JLabel lblNewLabel;
	private JPanel panel;
	public EspaceAdminDep() {
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][]", "[grow][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0 3 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNom = new JLabel("nom :");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNom, "cell 0 1,alignx trailing");
		
		nomDep = new JTextField();
		panel.add(nomDep, "cell 1 1,growx");
		nomDep.setColumns(10);
		
		btnAjouter = new JButton("Ajouter");
		panel.add(btnAjouter, "cell 2 1");
		
		lblNewLabel = new JLabel("Faculté :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel, "cell 0 2,alignx trailing");
		
		comboFac = new JComboBox();
		panel.add(comboFac, "cell 1 2,growx");
		
		btnModifier = new JButton("Modifier");
		panel.add(btnModifier, "cell 2 2");
		
		btnSupprimer = new JButton("supprimer");
		panel.add(btnSupprimer, "cell 2 3");
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JComboBox getComboFac() {
		return comboFac;
	}
	public void setComboFac(JComboBox comboBox) {
		this.comboFac = comboBox;
	}
	public JTextField getNomDep() {
		return nomDep;
	}
	public void setNomDep(JTextField nomDep) {
		this.nomDep = nomDep;
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
