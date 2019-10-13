package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import Model.ModelClasse;
import Model.ModelCours;
import Model.ModelDepartement;
import Model.ModelFaculte;
import Model.ModelNiveau;
import Model.ModelProf;
import Vue.EspaceAdminClasses;
import Vue.EspaceAdminCours;
import Vue.EspaceAdminFN;

public class ModifierCours extends AbstractAction {

	private ModelClasse modelClasse = new ModelClasse();
	private JTable table;
	private EspaceAdminCours ongletCours;
	
	public ModifierCours(EspaceAdminCours adminCours) {
		putValue(NAME, "Modifier");
		putValue(SHORT_DESCRIPTION, "Modifier la Classe active");
		this.ongletCours = adminCours;
		this.table = adminCours.getTableCours();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int id  = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
		String nom = ongletCours.getNomCours().getText();
		int volume = Integer.parseInt(ongletCours.getVolCours().getText());
		int id_prof = new ModelProf().getIdProf(ongletCours.getComboProfCours().getSelectedItem().toString());
		int id_classe = new ModelClasse().getIdClass(ongletCours.getComboClassCours().getSelectedItem().toString());
		new ModelCours().modifierCours(id, nom, volume, id_prof, id_classe);
		table.setModel(new ModelCours().gusomaModelCours());
	}

}
