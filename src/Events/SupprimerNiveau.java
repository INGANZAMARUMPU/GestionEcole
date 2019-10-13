package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ModelNiveau;
import Model.ModelUsers;

public class SupprimerNiveau extends AbstractAction {

	private ModelNiveau modelNiveau = new ModelNiveau();
	private JTable table;
	
	public SupprimerNiveau(JTable table) {
		putValue(NAME, "Supprimer");
		putValue(SHORT_DESCRIPTION, "Guhanagura Umu Prof actif");
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		modelNiveau.supprimerNiveau(table.getValueAt(table.getSelectedRow(), 0).toString());
		table.setModel(new ModelNiveau().gusomaModelNiv());
		
	}

}
