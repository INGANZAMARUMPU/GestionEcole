package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.ModelCours;
import Model.ModelProf;
import Model.ModelUsers;

public class ModifierProf extends AbstractAction {
	
	private JTable table;
	private JTextField nom;
	private JTextField prenom;
	private JTextField mdp;
	private JTextField login;
	ModelCours modelCours = new ModelCours();
	ModelProf modelProf = new ModelProf();
	private String id;

	public ModifierProf(JTable tableProf, JTextField nom, JTextField prenom, JTextField mdp, JTextField login) {
		this.table = tableProf;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.login = login;
		putValue(NAME, "Modifier");
		putValue(SHORT_DESCRIPTION, "Kumodifiya Umu Prof actif");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		id = modelProf.getIdUser(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
		modelProf.modifierProf(id, nom.getText(), prenom.getText(), mdp.getText(), login.getText());
		DefaultTableModel containneur = modelProf.gusomaModelProf();
		table.setModel(containneur);
		
	}

}
