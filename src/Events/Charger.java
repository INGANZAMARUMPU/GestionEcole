package Events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ModelDepartement;
import Model.ModelUsers;

public class Charger extends MouseAdapter{
	
	ModelUsers modelUsers = new ModelUsers();
	ModelDepartement modelDepartement = new ModelDepartement();
	private JTable tableActif;
	private int type;
	
	public Charger(JTable table, int type) {
		tableActif = table;
		this.type = type;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		ModelUsers modeluser = new ModelUsers();
		DefaultTableModel containneur = modeluser.gusomaUsers(type);
		tableActif.setModel(containneur);
		System.out.println("tout est chargée");
		
		
	}
	
	public void recharger() {
		ModelUsers modeluser = new ModelUsers();
		DefaultTableModel containneur = modeluser.gusomaUsers(type);
		tableActif.setModel(containneur);
		System.out.println("tout est chargée");
		
	}

}
