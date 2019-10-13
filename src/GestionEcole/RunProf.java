package GestionEcole;
import javax.swing.DefaultComboBoxModel;

import Events.ChargerProfCours;
import Model.ModelCours;
import Vue.EspaceProfCours;
import Vue.WorkSpace;

public class RunProf  extends WorkSpace{
	private EspaceProfCours espaceProfCours= new EspaceProfCours();

	public RunProf(int id_prof){
		espaceProfCours.getComboCours().setModel(new DefaultComboBoxModel(new ModelCours().gusomaNomsCours(id_prof).toArray()));
		getMnInterface().add(new ChargerProfCours(getDesktopPane(), espaceProfCours));
		this.setSize(600, 440);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
