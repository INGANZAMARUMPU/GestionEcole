package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import Model.ModelFaculte;
import Model.ModelNiveau;
import Vue.EspaceAdminFN;

public class ModifierFac extends AbstractAction {

	private ModelFaculte modelFaculte = new ModelFaculte();
	private JTable table;
	private EspaceAdminFN ongletFac;
	
	public ModifierFac(EspaceAdminFN adminFac) {
		putValue(NAME, "Modifier");
		putValue(SHORT_DESCRIPTION, "Modifier la faculte actif");
		this.ongletFac = adminFac;
		this.table = adminFac.getTable();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		modelFaculte.modifierFaculte(table.getValueAt(table.getSelectedRow(), 0).toString(), ongletFac.getNom().getText());
		table.setModel(new ModelFaculte().gusomaModelFac());
		
	}

}
