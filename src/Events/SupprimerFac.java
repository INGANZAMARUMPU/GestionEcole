package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ModelFaculte;
import Model.ModelNiveau;
import Model.ModelUsers;

public class SupprimerFac extends AbstractAction {

	private ModelFaculte modelFaculte = new ModelFaculte();
	private JTable table;
	
	public SupprimerFac(JTable table) {
		putValue(NAME, "Supprimer");
		putValue(SHORT_DESCRIPTION, "Supprimer la Faculté actif");
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		modelFaculte.supprimerFaculte(table.getValueAt(table.getSelectedRow(), 0).toString());
		table.setModel(new ModelFaculte().gusomaModelFac());
		
	}

}
