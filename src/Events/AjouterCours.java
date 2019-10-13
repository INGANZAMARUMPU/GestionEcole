package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import Model.ModelClasse;
import Model.ModelCours;
import Model.ModelDepartement;
import Model.ModelFaculte;
import Model.ModelNiveau;
import Model.ModelProf;
import Vue.EspaceAdminClasses;
import Vue.EspaceAdminCours;
import Vue.EspaceAdminFN;

public class AjouterCours extends AbstractAction {

	private ModelClasse modelClasse = new ModelClasse();
	private JTable table;
	private EspaceAdminCours ongletCours;
	
	public AjouterCours(EspaceAdminCours adminCours) {
		putValue(NAME, "Ajouter");
		putValue(SHORT_DESCRIPTION, "ajouter le Cours actif");
		this.ongletCours = adminCours;
		this.table = adminCours.getTableCours();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String nom = ongletCours.getNomCours().getText();
		int volume = Integer.parseInt(ongletCours.getVolCours().getText());
		int id_prof = new ModelProf().getIdProf(ongletCours.getComboProfCours().getSelectedItem().toString());
		int id_classe = new ModelClasse().getIdClass(ongletCours.getComboClassCours().getSelectedItem().toString());
		new ModelCours().ajouterCours(nom, volume, id_prof, id_classe);
		table.setModel(new ModelCours().gusomaModelCours());
	}

}
