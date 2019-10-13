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

public class EspaceAdminCours extends JFrame {
	private JPanel ongletCours;
	private JTextField rechercheCours;
	private JScrollPane scrollPaneCours;
	private JTable tableCours;
	private JLabel lblNom_2;
	private JLabel lblVolume;
	private JLabel lblDpartement_1;
	private JLabel lblFacu;
	private JTextField nomCours;
	private JTextField volCours;
	private JComboBox comboProfCours;
	private JComboBox comboClassCours;
	private JButton ajouterCours;
	private JButton modifierCours;
	private JButton supprimerCours;
	public EspaceAdminCours() {
				
		ongletCours = new JPanel();
		ongletCours.setLayout(new MigLayout("fill", "[][grow][grow]", "[][grow][][][][][]"));
		
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
		
		lblDpartement_1 = new JLabel("Professeur :");
		ongletCours.add(lblDpartement_1, "cell 0 5,alignx right");
		
		comboProfCours = new JComboBox();
		ongletCours.add(comboProfCours, "cell 1 5,growx");
		
		supprimerCours = new JButton("Supprimer");
		ongletCours.add(supprimerCours, "cell 2 5");
		
		lblFacu = new JLabel("Classe :");
		ongletCours.add(lblFacu, "cell 0 6,alignx right");
		
		comboClassCours = new JComboBox();
		ongletCours.add(comboClassCours, "cell 1 6,growx");
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

	public JComboBox getComboClassCours() {
		return comboClassCours;
	}
	public void setComboClassCours(JComboBox comboClassCours) {
		this.comboClassCours = comboClassCours;
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
	public JComboBox getComboProfCours() {
		return comboProfCours;
	}
	public void setComboProfCours(JComboBox comboProfCours) {
		this.comboProfCours = comboProfCours;
	}
}
