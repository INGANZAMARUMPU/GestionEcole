package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import Model.ModelClasse;
import Model.ModelDepartement;
import Model.ModelFaculte;
import Model.ModelNiveau;
import Vue.EspaceAdminClasses;
import Vue.EspaceAdminFN;

public class ModifierClasse extends AbstractAction {

	private ModelClasse modelClasse = new ModelClasse();
	private JTable table;
	private EspaceAdminClasses ongletClasses;
	
	public ModifierClasse(EspaceAdminClasses adminClasses) {
		putValue(NAME, "Modifier");
		putValue(SHORT_DESCRIPTION, "Modifier la Classe active");
		this.ongletClasses = adminClasses;
		this.table = adminClasses.getTableClasses();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int id_dep = new ModelDepartement().getIdDepart(ongletClasses.getComboDep().getSelectedItem().toString());
		int id_niv = new ModelNiveau().getIdNiveau(ongletClasses.getComboNiveau().getSelectedItem().toString());
		
		modelClasse.modifierClasse(table.getValueAt(table.getSelectedRow(), 0).toString(), 
									id_dep, id_niv);
		table.setModel(new ModelClasse().gusomaModelClasse());
		
	}

}
