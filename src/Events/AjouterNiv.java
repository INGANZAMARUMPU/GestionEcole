package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.JTextField;

import Model.ModelNiveau;

public class AjouterNiv extends AbstractAction {
	
	private JTextField nom;
	private JTable tableNiv;

	public AjouterNiv(JTextField nom, JTable tableNiv) {
		this.nom = nom;
		this.tableNiv = tableNiv;
		putValue(NAME, "Ajouter");
		putValue(SHORT_DESCRIPTION, "Ajouter Département");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new ModelNiveau().ajouterNiveau(nom.getText());
		tableNiv.setModel(new ModelNiveau().gusomaModelNiv());
		
	}

}
