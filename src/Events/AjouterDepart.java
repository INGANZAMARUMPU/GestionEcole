package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import Model.ModelDepartement;
import Model.ModelFaculte;

public class AjouterDepart extends AbstractAction {
	
	private JTextField nom;
	private JComboBox faculte;
	private JTable tableDep;

	public AjouterDepart(JTextField nom, JComboBox faculte, JTable tableDep) {
		this.nom = nom;
		this.tableDep = tableDep;
		this.faculte = faculte;
		putValue(NAME, "Ajouter");
		putValue(SHORT_DESCRIPTION, "Ajouter Département");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		new ModelDepartement().ajouterDep(this.nom.getText(), new ModelFaculte().getIdFaculte(faculte.getSelectedItem().toString()));
		tableDep.setModel(new ModelDepartement().gusomaModelDepartement());
	}

}
