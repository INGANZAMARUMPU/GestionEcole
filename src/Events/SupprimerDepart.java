package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ModelDepartement;
import Model.ModelNiveau;
import Model.ModelUsers;

public class SupprimerDepart extends AbstractAction {

	private ModelDepartement modelDepartement = new ModelDepartement();
	private JTable table;
	
	public SupprimerDepart(JTable table) {
		putValue(NAME, "Supprimer");
		putValue(SHORT_DESCRIPTION, "Guhanagura Umu Prof actif");
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		modelDepartement.supprimerDepart(table.getValueAt(table.getSelectedRow(), 0).toString());
		table.setModel(new ModelDepartement().gusomaModelDepartement());
		
	}

}
