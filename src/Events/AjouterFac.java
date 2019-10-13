package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import Model.ModelFaculte;

public class AjouterFac extends AbstractAction {
	
	private JTextField nom;
	private JTable tableFac;

	public AjouterFac(JTextField nom, JTable tableFac) {
		this.nom = nom;
		this.tableFac = tableFac;
		putValue(NAME, "Ajouter");
		putValue(SHORT_DESCRIPTION, "Ajouter Département");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new ModelFaculte().ajouterFaculte(nom.getText());
		tableFac.setModel(new ModelFaculte().gusomaModelFac());
		
	}

}
