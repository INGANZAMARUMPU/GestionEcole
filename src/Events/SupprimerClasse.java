package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import Model.ModelClasse;
import Vue.EspaceAdminClasses;

public class SupprimerClasse extends AbstractAction {

	private ModelClasse modelClasse = new ModelClasse();
	private JTable table;
	private EspaceAdminClasses ongletClasse;
	
	public SupprimerClasse(EspaceAdminClasses adminClasses) {
		putValue(NAME, "Supprimer");
		putValue(SHORT_DESCRIPTION, "Guhanagura Classe actif");
		this.table = adminClasses.getTableClasses();
		this.ongletClasse = adminClasses;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		modelClasse.supprimerClasse(table.getValueAt(table.getSelectedRow(), 0).toString());
		table.setModel(new ModelClasse().gusomaModelClasse());
		
	}

}
