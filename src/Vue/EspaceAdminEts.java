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

public class EspaceAdminEts extends JFrame {
	private JPanel ongletEts;
	private JLabel lblNom_1;
	private JTextField nomEt;
	private JLabel lblPrenom;
	private JTextField prenomEt;
	private JLabel lblMotDePass;
	private JTextField mdpEt;
	private JButton ajouterEt;
	private JButton modifierEt;
	private JButton supprimerEt;
	private JTextField rechercheEt;
	private JScrollPane scrollPane_4;
	private JTable tableEtudiants;
	private JLabel lblLogin;
	private JTextField login;
	private JLabel lblClasse;
	private JComboBox comboClass;
	public EspaceAdminEts() {
				
		ongletEts = new JPanel();
		ongletEts.setLayout(new MigLayout("fill", "[][grow][][grow][]", "[][grow][][][][]"));
		
		rechercheEt = new JTextField();
		ongletEts.add(rechercheEt, "cell 0 0 5 1,growx");
		rechercheEt.setColumns(10);
		
		scrollPane_4 = new JScrollPane();
		ongletEts.add(scrollPane_4, "cell 0 1 5 1,grow");
		
		tableEtudiants = new JTable();
		scrollPane_4.setViewportView(tableEtudiants);
		
		lblNom_1 = new JLabel("nom :");
		ongletEts.add(lblNom_1, "cell 0 2,alignx trailing");
		
		nomEt = new JTextField();
		ongletEts.add(nomEt, "cell 1 2,growx");
		nomEt.setColumns(10);
		
		lblClasse = new JLabel("classe :");
		ongletEts.add(lblClasse, "cell 2 2,alignx trailing");
		
		comboClass = new JComboBox();
		ongletEts.add(comboClass, "cell 3 2,growx");
		
		ajouterEt = new JButton("Ajouter");
		ongletEts.add(ajouterEt, "cell 4 2");
		
		lblPrenom = new JLabel("Prenom :");
		ongletEts.add(lblPrenom, "cell 0 3,alignx trailing");
		
		prenomEt = new JTextField();
		ongletEts.add(prenomEt, "cell 1 3,growx");
		prenomEt.setColumns(10);
		
		lblLogin = new JLabel("Login :");
		ongletEts.add(lblLogin, "cell 2 3,alignx trailing");
		
		login = new JTextField();
		ongletEts.add(login, "cell 3 3,growx");
		login.setColumns(10);
		
		modifierEt = new JButton("Modifier");
		ongletEts.add(modifierEt, "cell 4 3");
		
		lblMotDePass = new JLabel("mot de passe :");
		ongletEts.add(lblMotDePass, "cell 0 4,alignx trailing");
		
		mdpEt = new JTextField();
		ongletEts.add(mdpEt, "cell 1 4,growx");
		mdpEt.setColumns(10);
		
		supprimerEt = new JButton("Supprimer");
		ongletEts.add(supprimerEt, "cell 4 4");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public JTextField getLogin() {
		return login;
	}
	public void setLogin(JTextField login) {
		this.login = login;
	}
	public JPanel getOngletEts() {
		return ongletEts;
	}
	public void setOngletEts(JPanel ongletEts) {
		this.ongletEts = ongletEts;
	}
	public JLabel getLblNom_1() {
		return lblNom_1;
	}
	public void setLblNom_1(JLabel lblNom_1) {
		this.lblNom_1 = lblNom_1;
	}
	public JTextField getNomEt() {
		return nomEt;
	}
	public void setNomEt(JTextField nomEt) {
		this.nomEt = nomEt;
	}
	public JLabel getLblPrenom() {
		return lblPrenom;
	}
	public void setLblPrenom(JLabel lblPrenom) {
		this.lblPrenom = lblPrenom;
	}
	public JTextField getPrenomEt() {
		return prenomEt;
	}
	public void setPrenomEt(JTextField prenomEt) {
		this.prenomEt = prenomEt;
	}
	public JLabel getLblMotDePass() {
		return lblMotDePass;
	}
	public void setLblMotDePass(JLabel lblMotDePass) {
		this.lblMotDePass = lblMotDePass;
	}
	public JTextField getMdpEt() {
		return mdpEt;
	}
	public void setMdpEt(JTextField mdpEt) {
		this.mdpEt = mdpEt;
	}
	public JComboBox getComboClass() {
		return comboClass;
	}
	public void setComboClass(JComboBox comboClass) {
		this.comboClass = comboClass;
	}
	public JButton getAjouterEt() {
		return ajouterEt;
	}
	public void setAjouterEt(JButton ajouterEt) {
		this.ajouterEt = ajouterEt;
	}
	public JButton getModifierEt() {
		return modifierEt;
	}
	public void setModifierEt(JButton modifierEt) {
		this.modifierEt = modifierEt;
	}
	public JButton getSupprimerEt() {
		return supprimerEt;
	}
	public void setSupprimerEt(JButton supprimerEt) {
		this.supprimerEt = supprimerEt;
	}
	public JTextField getRechercheEt() {
		return rechercheEt;
	}
	public void setRechercheEt(JTextField rechercheEt) {
		this.rechercheEt = rechercheEt;
	}
	public JScrollPane getScrollPane_4() {
		return scrollPane_4;
	}
	public void setScrollPane_4(JScrollPane scrollPane_4) {
		this.scrollPane_4 = scrollPane_4;
	}
	public JTable getTableEtudiants() {
		return tableEtudiants;
	}
	public void setTableEtudiants(JTable tableEtudiants) {
		this.tableEtudiants = tableEtudiants;
	}
}
