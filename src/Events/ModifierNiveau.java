package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import Model.ModelNiveau;
import Vue.EspaceAdminFN;

public class ModifierNiveau extends AbstractAction {

	private ModelNiveau modelNiveau = new ModelNiveau();
	private JTable table;
	private EspaceAdminFN ongletNiv;
	
	public ModifierNiveau(EspaceAdminFN adminNiv) {
		putValue(NAME, "Modifier");
		putValue(SHORT_DESCRIPTION, "Modifier le Niveau actif");
		this.ongletNiv = adminNiv;
		this.table = adminNiv.getTable();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		modelNiveau.modifierNiveau(table.getValueAt(table.getSelectedRow(), 0).toString(), ongletNiv.getNom().getText());
		table.setModel(new ModelNiveau().gusomaModelNiv());
		
	}

}
