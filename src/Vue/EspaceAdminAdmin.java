package Vue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class EspaceAdminAdmin extends JFrame {
	private JPanel ongletAdmins;
	private JLabel lblNewLabel_2;
	private JTextField nomAdm;
	private JLabel lblPrenom_1;
	private JTextField prenomAdm;
	private JLabel lblMotDePasse_1;
	private JTextField mdpAdm;
	private JLabel lblDpartement;
	private JComboBox comboFacAdm;
	private JButton ajouterAdm;
	private JButton modifierAdm;
	private JButton supprimerAdm;
	private JTextField rechercheEco;
	private JComboBox comboTache;
	private JScrollPane scrollPane_3;
	private JTable tableAdmins;
	public EspaceAdminAdmin() {
				
		ongletAdmins = new JPanel();
		ongletAdmins.setLayout(new MigLayout("fill", "[][grow][grow]", "[][grow][][][][]"));
		
		rechercheEco = new JTextField();
		ongletAdmins.add(rechercheEco, "cell 0 0 3 1,growx");
		rechercheEco.setColumns(10);
		
		scrollPane_3 = new JScrollPane();
		ongletAdmins.add(scrollPane_3, "cell 0 1 3 1,grow");
		
		tableAdmins = new JTable();
		scrollPane_3.setViewportView(tableAdmins);
		
		lblNewLabel_2 = new JLabel("Nom :");
		ongletAdmins.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		nomAdm = new JTextField();
		ongletAdmins.add(nomAdm, "cell 1 2,growx");
		nomAdm.setColumns(10);
		
		comboTache = new JComboBox();
		ongletAdmins.add(comboTache, "cell 2 2,growx");
		
		lblPrenom_1 = new JLabel("Prenom :");
		ongletAdmins.add(lblPrenom_1, "cell 0 3,alignx trailing");
		
		prenomAdm = new JTextField();
		ongletAdmins.add(prenomAdm, "cell 1 3,growx");
		prenomAdm.setColumns(10);
		
		ajouterAdm = new JButton("Ajouter");
		ongletAdmins.add(ajouterAdm, "cell 2 3");
		
		lblMotDePasse_1 = new JLabel("mot de passe :");
		ongletAdmins.add(lblMotDePasse_1, "cell 0 4,alignx trailing");
		
		mdpAdm = new JTextField();
		ongletAdmins.add(mdpAdm, "cell 1 4,growx");
		mdpAdm.setColumns(10);
		
		modifierAdm = new JButton("Modifier");
		ongletAdmins.add(modifierAdm, "cell 2 4");
		
		lblDpartement = new JLabel("Faculté :");
		ongletAdmins.add(lblDpartement, "cell 0 5,alignx trailing");
		
		comboFacAdm = new JComboBox();
		ongletAdmins.add(comboFacAdm, "cell 1 5,growx");
		
		supprimerAdm = new JButton("Supprimer");
		ongletAdmins.add(supprimerAdm, "cell 2 5");
	}
	public JPanel getOngletAdmins() {
		return ongletAdmins;
	}
	public void setOngletAdmins(JPanel ongletAdmins) {
		this.ongletAdmins = ongletAdmins;
	}
	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}
	public void setLblNewLabel_2(JLabel lblNewLabel_2) {
		this.lblNewLabel_2 = lblNewLabel_2;
	}
	public JTextField getNomAdm() {
		return nomAdm;
	}
	public void setNomAdm(JTextField nomAdm) {
		this.nomAdm = nomAdm;
	}
	public JLabel getLblPrenom_1() {
		return lblPrenom_1;
	}
	public void setLblPrenom_1(JLabel lblPrenom_1) {
		this.lblPrenom_1 = lblPrenom_1;
	}
	public JTextField getPrenomAdm() {
		return prenomAdm;
	}
	public void setPrenomAdm(JTextField prenomAdm) {
		this.prenomAdm = prenomAdm;
	}
	public JLabel getLblMotDePasse_1() {
		return lblMotDePasse_1;
	}
	public void setLblMotDePasse_1(JLabel lblMotDePasse_1) {
		this.lblMotDePasse_1 = lblMotDePasse_1;
	}
	public JTextField getMdpAdm() {
		return mdpAdm;
	}
	public void setMdpAdm(JTextField mdpAdm) {
		this.mdpAdm = mdpAdm;
	}
	public JLabel getLblDpartement() {
		return lblDpartement;
	}
	public void setLblDpartement(JLabel lblDpartement) {
		this.lblDpartement = lblDpartement;
	}
	public JComboBox getComboFacAdm() {
		return comboFacAdm;
	}
	public void setComboFacAdm(JComboBox comboFacAdm) {
		this.comboFacAdm = comboFacAdm;
	}
	public JButton getAjouterAdm() {
		return ajouterAdm;
	}
	public void setAjouterAdm(JButton ajouterAdm) {
		this.ajouterAdm = ajouterAdm;
	}
	public JButton getModifierAdm() {
		return modifierAdm;
	}
	public void setModifierAdm(JButton modifierAdm) {
		this.modifierAdm = modifierAdm;
	}
	public JButton getSupprimerAdm() {
		return supprimerAdm;
	}
	public void setSupprimerAdm(JButton supprimerAdm) {
		this.supprimerAdm = supprimerAdm;
	}
	public JTextField getRechercheEco() {
		return rechercheEco;
	}
	public void setRechercheEco(JTextField rechercheEco) {
		this.rechercheEco = rechercheEco;
	}
	public JComboBox getComboTache() {
		return comboTache;
	}
	public void setComboTache(JComboBox comboTache) {
		this.comboTache = comboTache;
	}
	public JScrollPane getScrollPane_3() {
		return scrollPane_3;
	}
	public void setScrollPane_3(JScrollPane scrollPane_3) {
		this.scrollPane_3 = scrollPane_3;
	}
	public JTable getTableAdmins() {
		return tableAdmins;
	}
	public void setTableAdmins(JTable tableAdmins) {
		this.tableAdmins = tableAdmins;
	}
		
}
