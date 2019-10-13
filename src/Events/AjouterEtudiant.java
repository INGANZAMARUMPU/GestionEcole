package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import Model.ModelClasse;
import Model.ModelEts;

public class AjouterEtudiant extends AbstractAction {
	
	private JTable table;
	private JTextField prenom;
	private JTextField nom;
	private JTextField mdp;
	private JComboBox classe;
	private JTextField login;
	private ModelEts modelEts = new ModelEts();
	private int id_class;

	public AjouterEtudiant(JTable tableEts, JTextField nom, JTextField prenom, JTextField mdp, JComboBox classe, JTextField login) {
		this.table = tableEts;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.classe = classe;
		this.mdp = mdp;
		this.login = login;
		putValue(NAME, "Ajouter");
		putValue(SHORT_DESCRIPTION, "Kwongeramwo Umu Etudiant");
	}

	@Override	
	public void actionPerformed(ActionEvent arg0) {
		id_class = new ModelClasse().getIdClass(classe.getSelectedItem().toString());
		modelEts.ajouterEts(nom.getText(), prenom.getText(), mdp.getText(), id_class, login.getText());
		table.setModel(modelEts.gusomaModelEtudiants());
		
	}

}
