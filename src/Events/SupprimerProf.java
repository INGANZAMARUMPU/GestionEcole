package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ModelUsers;

public class SupprimerProf extends AbstractAction {

	private JTable table;
	private String id;
	private ModelUsers modelUser = new ModelUsers();
	
	public SupprimerProf(JTable table) {
		putValue(NAME, "Supprimer");
		putValue(SHORT_DESCRIPTION, "Guhanagura Umu Prof actif");
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		id = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
		modelUser.guhanaguraUser(id);
//		DefaultTableModel containneur = modelUser.gusomaUsers(2);
//		table.setModel(containneur);
		
	}

}
