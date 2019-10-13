package Vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class EspaceAdminProf extends JFrame {
	private JTextField nomProf;
	private JLabel lblNom;
	private JLabel lblNewLabel;
	private JTextField prenomProf;
	private JButton ajouterProf;
	private JButton modifierProf;
	private JButton supprimerProf;
	private JTextField mdpProf;
	private JLabel lblMotDePasse;
	private JTextField rechercheProf;
	private JPanel ongletProfs;
	private JLabel lblLogin;
	private JTextField login;
	private JScrollPane scrollPane;
	private JTable table;
	public EspaceAdminProf() {
				
		ongletProfs = new JPanel(new MigLayout("", "[grow][grow][]", "[][grow][][][][][][][]"));
		ongletProfs.setLayout(new MigLayout("fill", "[grow][grow][grow]", "[][][grow][][][][]"));
		
		rechercheProf = new JTextField();
		ongletProfs.add(rechercheProf, "cell 0 0 3 1,growx");
		rechercheProf.setColumns(10);
		
		scrollPane = new JScrollPane();
		ongletProfs.add(scrollPane, "cell 0 1 3 4,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		ongletProfs.add(lblNom, "cell 0 5");
		
		nomProf = new JTextField();
		ongletProfs.add(nomProf, "growx");
		nomProf.setColumns(10);
		
		ajouterProf = new JButton("Ajouter");
		
		ongletProfs.add(ajouterProf, "cell 2 5");
		
		lblNewLabel = new JLabel("Prenom :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ongletProfs.add(lblNewLabel, "cell 0 6");
		
		prenomProf = new JTextField();
		ongletProfs.add(prenomProf, "growx");
		prenomProf.setColumns(10);
		
		modifierProf = new JButton("Modifier");
		ongletProfs.add(modifierProf, "cell 2 6");
		
		lblMotDePasse = new JLabel("mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
		ongletProfs.add(lblMotDePasse, "cell 0 7");
		
		mdpProf = new JTextField();
		ongletProfs.add(mdpProf, "growx");
		mdpProf.setColumns(10);
		
		supprimerProf = new JButton("Supprimer");
		ongletProfs.add(supprimerProf, "cell 2 7");
		
		lblLogin = new JLabel("Login :");
		ongletProfs.add(lblLogin, "cell 0 8");
		
		login = new JTextField();
		ongletProfs.add(login, "cell 1 8,growx");
		login.setColumns(10);
		
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JTextField getLogin() {
		return login;
	}
	public void setLogin(JTextField login) {
		this.login = login;
	}
	public JTextField getNomProf() {
		return nomProf;
	}
	public void setNomProf(JTextField nomProf) {
		this.nomProf = nomProf;
	}
	public JLabel getLblNom() {
		return lblNom;
	}
	public void setLblNom(JLabel lblNom) {
		this.lblNom = lblNom;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}
	public JTextField getPrenomProf() {
		return prenomProf;
	}
	public void setPrenomProf(JTextField prenomProf) {
		this.prenomProf = prenomProf;
	}
	public JButton getAjouterProf() {
		return ajouterProf;
	}
	public void setAjouterProf(JButton ajouterProf) {
		this.ajouterProf = ajouterProf;
	}
	public JButton getModifierProf() {
		return modifierProf;
	}
	public void setModifierProf(JButton modifierProf) {
		this.modifierProf = modifierProf;
	}
	public JButton getSupprimerProf() {
		return supprimerProf;
	}
	public void setSupprimerProf(JButton supprimerProf) {
		this.supprimerProf = supprimerProf;
	}
	public JTextField getMdpProf() {
		return mdpProf;
	}
	public void setMdpProf(JTextField mdpProf) {
		this.mdpProf = mdpProf;
	}
	public JLabel getLblMotDePasse() {
		return lblMotDePasse;
	}
	public void setLblMotDePasse(JLabel lblMotDePasse) {
		this.lblMotDePasse = lblMotDePasse;
	}
	public JTextField getRechercheProf() {
		return rechercheProf;
	}
	public void setRechercheProf(JTextField rechercheProf) {
		this.rechercheProf = rechercheProf;
	}
	public JPanel getOngletProfs() {
		return ongletProfs;
	}
	public void setOngletProfs(JPanel ongletProfs) {
		this.ongletProfs = ongletProfs;
	}
}
