package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.ModelClasse;
import Model.ModelCours;
import Model.ModelDepartement;
import Model.ModelEts;
import Model.ModelFaculte;
import Model.ModelNiveau;
import Model.ModelUsers;

public class ModifierEtudiant extends AbstractAction {	
	private JTable table;
	private JTextField nom;
	private JTextField prenom;
	private JTextField mdp;
	private JComboBox classe;
	private String id;
	private ModelClasse modelClasse = new ModelClasse();
	private Integer id_class;
	private JTextField login;
	private ModelEts modelEts =  new ModelEts();
	
	public ModifierEtudiant(JTable tableEt, JTextField nom, JTextField prenom, JTextField mdp, JComboBox classe, JTextField login) {
		this.table = tableEt;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.classe = classe;
		this.mdp = mdp;
		this.login = login;
		putValue(NAME, "Modifier");
		putValue(SHORT_DESCRIPTION, "Kumodifiya Umu Etudiant actif");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		id = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
		id_class = modelClasse.getIdClass(classe.getSelectedItem().toString());
		modelEts.modifierEts(nom.getText(), prenom.getText(), mdp.getText(), id_class, login.getText(), id);
		table.setModel(modelEts.gusomaModelEtudiants());
		
	}

}
