package Events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ModelCours;
import Model.ModelDepartement;
import Model.ModelUsers;

public class ChargerCours extends MouseAdapter{
	private JTable tableActif;
	private int type;
	
	public ChargerCours(JTable table, int type) {
		tableActif = table;
		this.type = type;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		ModelCours modelcours = new ModelCours();
//		DefaultTableModel containneur = new DefaultTableModel();
//		tableActif.setModel(containneur);
		System.out.println("tout est chargée");
		
		
	}

}
