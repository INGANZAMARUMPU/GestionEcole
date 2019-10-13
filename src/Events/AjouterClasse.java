package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import Model.ModelClasse;
import Model.ModelDepartement;
import Model.ModelFaculte;
import Model.ModelNiveau;
import Vue.EspaceAdminClasses;

public class AjouterClasse extends AbstractAction {
	
	private JComboBox comboFac;
	private JComboBox comboDep;
	private JComboBox comboNiv;
	private JTable tableClasse;

	public AjouterClasse(EspaceAdminClasses adminClasses) {
		this.comboDep = adminClasses.getComboDep();
		this.comboNiv = adminClasses.getComboNiveau();
		this.tableClasse = adminClasses.getTableClasses();
		putValue(NAME, "Ajouter");
		putValue(SHORT_DESCRIPTION, "Ajouter Département");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new ModelClasse().ajouterClasse(
				new ModelDepartement().getIdDepart(comboDep.getSelectedItem().toString()),
				new ModelNiveau().getIdNiveau(comboNiv.getSelectedItem().toString())
				);
		tableClasse.setModel(new ModelClasse().gusomaModelClasse());
		
	}

}
