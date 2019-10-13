package Vue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EspaceAdmin extends JFrame {
	private JTextField nomProf;
	private JLabel lblNom;
	private JLabel lblNewLabel;
	private JTextField prenomProf;
	private JButton ajouterProf;
	private JButton modifierProf;
	private JButton supprimerProf;
	private JPanel ongletEts;
	private JTextField mdpProf;
	private JLabel lblMotDePasse;
	private JLabel lblNom_1;
	private JTextField nomEt;
	private JLabel lblPrenom;
	private JTextField prenomEt;
	private JLabel lblMotDePass;
	private JTextField mdpEt;
	private JLabel lblSection;
	private JComboBox comboDepart;
	private JLabel lblAnne;
	private JComboBox comboLevel;
	private JButton ajouterEt;
	private JButton modifierEt;
	private JButton supprimerEt;
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
	private JPanel ongletHistorique;
	private JButton btnActualiser;
	private JTextField rechercheProf;
	private JTextField rechercheEt;
	private JTextField rechercheEco;
	private JTextField rechercheHist;
	private JComboBox comboTache;
	private JLabel lblFacult;
	private JComboBox comboFac;
	private JPanel ongletCours;
	private JTextField rechercheCours;
	private JScrollPane scrollPaneCours;
	private JTable tableCours;
	private JScrollPane scrollPane_2;
	private JTable tableHistorique;
	private JScrollPane scrollPane_3;
	private JTable tableAdmins;
	private JScrollPane scrollPane_4;
	private JTable tableEtudiants;
	private JScrollPane scrollPane_5;
	private JTable table;
	private JLabel lblNom_2;
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
	public JTextField getTextField() {
		return prenomProf;
	}
	public void setTextField(JTextField textField) {
		this.prenomProf = textField;
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
	public JPanel getOngletEts() {
		return ongletEts;
	}
	public void setOngletEts(JPanel ongletEts) {
		this.ongletEts = ongletEts;
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
	public JLabel getLblSection() {
		return lblSection;
	}
	public void setLblSection(JLabel lblSection) {
		this.lblSection = lblSection;
	}
	public JComboBox getComboDepart() {
		return comboDepart;
	}
	public void setComboDepart(JComboBox comboDepart) {
		this.comboDepart = comboDepart;
	}
	public JLabel getLblAnne() {
		return lblAnne;
	}
	public void setLblAnne(JLabel lblAnne) {
		this.lblAnne = lblAnne;
	}
	public JComboBox getComboLevel() {
		return comboLevel;
	}
	public void setComboLevel(JComboBox comboLevel) {
		this.comboLevel = comboLevel;
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
	public JTextField getMomAdm() {
		return nomAdm;
	}
	public void setMomAdm(JTextField momAdm) {
		this.nomAdm = momAdm;
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
	public JPanel getOngletHistorique() {
		return ongletHistorique;
	}
	public void setOngletHistorique(JPanel ongletHistorique) {
		this.ongletHistorique = ongletHistorique;
	}
	public JButton getBtnActualiser() {
		return btnActualiser;
	}
	public void setBtnActualiser(JButton btnActualiser) {
		this.btnActualiser = btnActualiser;
	}
	public JTextField getRechercheProf() {
		return rechercheProf;
	}
	public void setRechercheProf(JTextField rechercheProf) {
		this.rechercheProf = rechercheProf;
	}
	public JTextField getRechercheEt() {
		return rechercheEt;
	}
	public void setRechercheEt(JTextField rechercheEt) {
		this.rechercheEt = rechercheEt;
	}
	public JTextField getRechercheEco() {
		return rechercheEco;
	}
	public void setRechercheEco(JTextField rechercheEco) {
		this.rechercheEco = rechercheEco;
	}
	public JTextField getRechercheHist() {
		return rechercheHist;
	}
	public void setRechercheHist(JTextField rechercheHist) {
		this.rechercheHist = rechercheHist;
	}
	public JComboBox getComboTache() {
		return comboTache;
	}
	public void setComboTache(JComboBox comboTache) {
		this.comboTache = comboTache;
	}
	public JLabel getLblFacult() {
		return lblFacult;
	}
	public void setLblFacult(JLabel lblFacult) {
		this.lblFacult = lblFacult;
	}
	public JComboBox getComboFac() {
		return comboFac;
	}
	public void setComboFac(JComboBox comboFac) {
		this.comboFac = comboFac;
	}
	public JPanel getOngletCours() {
		return ongletCours;
	}
	public void setOngletCours(JPanel ongletCours) {
		this.ongletCours = ongletCours;
	}
	public JTextField getRechercheCours() {
		return rechercheCours;
	}
	public void setRechercheCours(JTextField rechercheCours) {
		this.rechercheCours = rechercheCours;
	}
	public JScrollPane getScrollPaneCours() {
		return scrollPaneCours;
	}
	public void setScrollPaneCours(JScrollPane scrollPaneCours) {
		this.scrollPaneCours = scrollPaneCours;
	}
	public JTable getTableCours() {
		return tableCours;
	}
	public void setTableCours(JTable tableCours) {
		this.tableCours = tableCours;
	}
	public JScrollPane getScrollPane_2() {
		return scrollPane_2;
	}
	public void setScrollPane_2(JScrollPane scrollPane_2) {
		this.scrollPane_2 = scrollPane_2;
	}
	public JTable getTableHistorique() {
		return tableHistorique;
	}
	public void setTableHistorique(JTable tableHistorique) {
		this.tableHistorique = tableHistorique;
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
	public JScrollPane getScrollPane_5() {
		return scrollPane_5;
	}
	public void setScrollPane_5(JScrollPane scrollPane_5) {
		this.scrollPane_5 = scrollPane_5;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JLabel getLblNom_2() {
		return lblNom_2;
	}
	public void setLblNom_2(JLabel lblNom_2) {
		this.lblNom_2 = lblNom_2;
	}
	public JLabel getLblVolume() {
		return lblVolume;
	}
	public void setLblVolume(JLabel lblVolume) {
		this.lblVolume = lblVolume;
	}
	public JLabel getLblDpartement_1() {
		return lblDpartement_1;
	}
	public void setLblDpartement_1(JLabel lblDpartement_1) {
		this.lblDpartement_1 = lblDpartement_1;
	}
	public JLabel getLblFacu() {
		return lblFacu;
	}
	public void setLblFacu(JLabel lblFacu) {
		this.lblFacu = lblFacu;
	}
	public JTextField getNomCours() {
		return nomCours;
	}
	public void setNomCours(JTextField nomCours) {
		this.nomCours = nomCours;
	}
	public JTextField getVolCours() {
		return volCours;
	}
	public void setVolCours(JTextField volCours) {
		this.volCours = volCours;
	}
	public JComboBox getComboDepCours() {
		return comboDepCours;
	}
	public void setComboDepCours(JComboBox comboDepCours) {
		this.comboDepCours = comboDepCours;
	}
	public JComboBox getComboFacCours() {
		return comboFacCours;
	}
	public void setComboFacCours(JComboBox comboFacCours) {
		this.comboFacCours = comboFacCours;
	}
	public JButton getAjouterCours() {
		return ajouterCours;
	}
	public void setAjouterCours(JButton ajouterCours) {
		this.ajouterCours = ajouterCours;
	}
	public JButton getModifierCours() {
		return modifierCours;
	}
	public void setModifierCours(JButton modifierCours) {
		this.modifierCours = modifierCours;
	}
	public JButton getSupprimerCours() {
		return supprimerCours;
	}
	public void setSupprimerCours(JButton supprimerCours) {
		this.supprimerCours = supprimerCours;
	}
	public JPanel getOngletFac() {
		return ongletFac;
	}
	public void setOngletFac(JPanel ongletFac) {
		this.ongletFac = ongletFac;
	}
	public JPanel getOngletProfs() {
		return ongletProfs;
	}
	public void setOngletProfs(JPanel ongletProfs) {
		this.ongletProfs = ongletProfs;
	}
	public JTextField getRechercheFac() {
		return rechercheFac;
	}
	public void setRechercheFac(JTextField rechercheFac) {
		this.rechercheFac = rechercheFac;
	}
	public JScrollPane getScrollPane_6() {
		return scrollPane_6;
	}
	public void setScrollPane_6(JScrollPane scrollPane_6) {
		this.scrollPane_6 = scrollPane_6;
	}
	public JTable getTable_1() {
		return table_1;
	}
	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}
	public JLabel getLblNomDeLa() {
		return lblNomDeLa;
	}
	public void setLblNomDeLa(JLabel lblNomDeLa) {
		this.lblNomDeLa = lblNomDeLa;
	}
	public JTextField getNomFac() {
		return nomFac;
	}
	public void setNomFac(JTextField nomFac) {
		this.nomFac = nomFac;
	}
	public JButton getBtnAjouter_1() {
		return btnAjouter_1;
	}
	public void setBtnAjouter_1(JButton btnAjouter_1) {
		this.btnAjouter_1 = btnAjouter_1;
	}
	public JButton getBtnModifier_1() {
		return btnModifier_1;
	}
	public void setBtnModifier_1(JButton btnModifier_1) {
		this.btnModifier_1 = btnModifier_1;
	}
	public JButton getBtnSuprimer() {
		return btnSuprimer;
	}
	public void setBtnSuprimer(JButton btnSuprimer) {
		this.btnSuprimer = btnSuprimer;
	}
	private JLabel lblVolume;
	private JLabel lblDpartement_1;
	private JLabel lblFacu;
	private JTextField nomCours;
	private JTextField volCours;
	private JComboBox comboDepCours;
	private JComboBox comboFacCours;
	private JButton ajouterCours;
	private JButton modifierCours;
	private JButton supprimerCours;
	private JPanel ongletFac;
	private JTextField rechercheFac;
	private JScrollPane scrollPane_6;
	private JTable table_1;
	private JLabel lblNomDeLa;
	private JTextField nomFac;
	private JButton btnAjouter_1;
	private JButton btnModifier_1;
	private JButton btnSuprimer;
	private JPanel ongletProfs;
	
	public EspaceAdmin() {
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][][]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "cell 0 0,grow");
		
		ongletProfs = new JPanel();
		tabbedPane.addTab("Professeurs", null, ongletProfs, null);
		tabbedPane.setEnabledAt(0, true);
		ongletProfs.setLayout(new MigLayout("", "[][grow][]", "[][][grow][][][][]"));
		
		rechercheProf = new JTextField();
		ongletProfs.add(rechercheProf, "cell 0 0 3 1,growx");
		rechercheProf.setColumns(10);
		
		scrollPane_5 = new JScrollPane();
		ongletProfs.add(scrollPane_5, "cell 0 1 3 2,grow");
		
		table = new JTable();
		scrollPane_5.setViewportView(table);
		
		lblNom = new JLabel("Nom :");
		ongletProfs.add(lblNom, "cell 0 3,alignx trailing");
		
		nomProf = new JTextField();
		ongletProfs.add(nomProf, "flowy,cell 1 3,growx");
		nomProf.setColumns(10);
		
		ajouterProf = new JButton("Ajouter");
		
		ongletProfs.add(ajouterProf, "cell 2 3");
		
		lblNewLabel = new JLabel("Prenom :");
		ongletProfs.add(lblNewLabel, "cell 0 4,alignx trailing");
		
		prenomProf = new JTextField();
		ongletProfs.add(prenomProf, "cell 1 4,growx");
		prenomProf.setColumns(10);
		
		modifierProf = new JButton("Modifier");
		ongletProfs.add(modifierProf, "cell 2 4");
		
		lblMotDePasse = new JLabel("mot de passe :");
		ongletProfs.add(lblMotDePasse, "cell 0 5,alignx trailing");
		
		mdpProf = new JTextField();
		ongletProfs.add(mdpProf, "cell 1 5,growx");
		mdpProf.setColumns(10);
		
		supprimerProf = new JButton("Supprimer");
		ongletProfs.add(supprimerProf, "cell 2 5");
		
		
		ongletCours = new JPanel();
		tabbedPane.addTab("Cours", null, ongletCours, null);
		tabbedPane.setEnabledAt(1, true);
		ongletCours.setLayout(new MigLayout("", "[][grow][]", "[][grow][][][][][]"));
		
		rechercheCours = new JTextField();
		ongletCours.add(rechercheCours, "cell 0 0 3 1,growx");
		rechercheCours.setColumns(10);
		
		scrollPaneCours = new JScrollPane();
		ongletCours.add(scrollPaneCours, "cell 0 1 3 1,grow");
		
		tableCours = new JTable();
		scrollPaneCours.setViewportView(tableCours);
		
		lblNom_2 = new JLabel("Nom :");
		ongletCours.add(lblNom_2, "cell 0 2,alignx trailing");
		
		nomCours = new JTextField();
		ongletCours.add(nomCours, "cell 1 2,growx");
		nomCours.setColumns(10);
		
		ajouterCours = new JButton("Ajouter");
		ongletCours.add(ajouterCours, "cell 2 2");
		
		lblVolume = new JLabel("Volume :");
		ongletCours.add(lblVolume, "cell 0 4,alignx trailing");
		
		volCours = new JTextField();
		ongletCours.add(volCours, "cell 1 4,growx");
		volCours.setColumns(10);
		
		modifierCours = new JButton("Modifier");
		ongletCours.add(modifierCours, "cell 2 4");
		
		lblDpartement_1 = new JLabel("Département :");
		ongletCours.add(lblDpartement_1, "cell 0 5,alignx right");
		
		comboDepCours = new JComboBox();
		ongletCours.add(comboDepCours, "cell 1 5,growx");
		
		supprimerCours = new JButton("Supprimer");
		ongletCours.add(supprimerCours, "cell 2 5");
		
		lblFacu = new JLabel("Faculté :");
		ongletCours.add(lblFacu, "cell 0 6,alignx right");
		
		comboFacCours = new JComboBox();
		ongletCours.add(comboFacCours, "cell 1 6,growx");
		
		ongletEts = new JPanel();
		tabbedPane.addTab("Etudiants", null, ongletEts, null);
		tabbedPane.setEnabledAt(2, true);
		ongletEts.setLayout(new MigLayout("", "[][grow][][grow][]", "[][grow][][][]"));
		
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
		
		lblSection = new JLabel("Département :");
		ongletEts.add(lblSection, "cell 2 2,alignx trailing");
		
		comboDepart = new JComboBox();
		ongletEts.add(comboDepart, "cell 3 2,growx");
		
		ajouterEt = new JButton("Ajouter");
		ongletEts.add(ajouterEt, "cell 4 2");
		
		lblPrenom = new JLabel("Prenom :");
		ongletEts.add(lblPrenom, "cell 0 3,alignx trailing");
		
		prenomEt = new JTextField();
		ongletEts.add(prenomEt, "cell 1 3,growx");
		prenomEt.setColumns(10);
		
		lblFacult = new JLabel("Faculté :");
		ongletEts.add(lblFacult, "cell 2 3,alignx trailing");
		
		comboFac = new JComboBox();
		ongletEts.add(comboFac, "cell 3 3,growx");
		
		modifierEt = new JButton("Modifier");
		ongletEts.add(modifierEt, "cell 4 3");
		
		lblMotDePass = new JLabel("mot de passe :");
		ongletEts.add(lblMotDePass, "cell 0 4,alignx trailing");
		
		mdpEt = new JTextField();
		ongletEts.add(mdpEt, "cell 1 4,growx");
		mdpEt.setColumns(10);
		
		lblAnne = new JLabel("Niveau :");
		ongletEts.add(lblAnne, "cell 2 4,alignx trailing");
		
		comboLevel = new JComboBox();
		ongletEts.add(comboLevel, "cell 3 4,growx");
		
		supprimerEt = new JButton("Supprimer");
		ongletEts.add(supprimerEt, "cell 4 4");
		
		ongletAdmins = new JPanel();
		tabbedPane.addTab("Administratifs", null, ongletAdmins, null);
		tabbedPane.setEnabledAt(3, true);
		ongletAdmins.setLayout(new MigLayout("", "[][grow][grow]", "[][grow][][][][]"));
		
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
		
		
		ongletHistorique = new JPanel();
		tabbedPane.addTab("Historique", null, ongletHistorique, null);
		tabbedPane.setEnabledAt(4, true);
		ongletHistorique.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		rechercheHist = new JTextField();
		ongletHistorique.add(rechercheHist, "cell 0 0,growx");
		rechercheHist.setColumns(10);
		
		scrollPane_2 = new JScrollPane();
		ongletHistorique.add(scrollPane_2, "cell 0 1,grow");
		
		tableHistorique = new JTable();
		scrollPane_2.setViewportView(tableHistorique);
		
		btnActualiser = new JButton("Actualiser");
		ongletHistorique.add(btnActualiser, "cell 0 2");
		
		ongletFac = new JPanel();
		tabbedPane.addTab("Faculté", null, ongletFac, null);
		ongletFac.setLayout(new MigLayout("", "[][grow][][][]", "[][grow][][]"));
		
		rechercheFac = new JTextField();
		ongletFac.add(rechercheFac, "cell 0 0 5 1,growx");
		rechercheFac.setColumns(10);
		
		scrollPane_6 = new JScrollPane();
		ongletFac.add(scrollPane_6, "cell 0 1 5 1,grow");
		
		table_1 = new JTable();
		scrollPane_6.setViewportView(table_1);
		
		lblNomDeLa = new JLabel("Nom de la Faculté :");
		ongletFac.add(lblNomDeLa, "cell 0 3");
		
		nomFac = new JTextField();
		ongletFac.add(nomFac, "cell 1 3,growx");
		nomFac.setColumns(10);
		
		btnAjouter_1 = new JButton("Ajouter");
		ongletFac.add(btnAjouter_1, "cell 2 3");
		
		btnModifier_1 = new JButton("Modifier");
		ongletFac.add(btnModifier_1, "cell 3 3");
				
		btnSuprimer = new JButton("Suprimer");
		ongletFac.add(btnSuprimer, "cell 4 3");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public JTextField getPrenomProf() {
		return prenomProf;
	}
	public void setPrenomProf(JTextField prenomProf) {
		this.prenomProf = prenomProf;
	}
	public JTextField getNomAdm() {
		return nomAdm;
	}
	public void setNomAdm(JTextField nomAdm) {
		this.nomAdm = nomAdm;
	}
}
