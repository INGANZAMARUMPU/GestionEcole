package GestionEcole;

import javax.swing.DefaultComboBoxModel;
import Events.ChargerAdminClasses;
import Events.ChargerAdminCours;
import Events.ChargerAdminDep;
import Events.ChargerAdminEts;
import Events.ChargerAdminFac;
import Events.ChargerAdminNiv;
import Events.ChargerAdminProf;
import Model.ModelFaculte;
import Model.ModelTaches;
import Vue.EspaceAdminAdmin;
import Vue.EspaceAdminClasses;
import Vue.EspaceAdminCours;
import Vue.EspaceAdminFN;
import Vue.EspaceAdminEts;
import Vue.EspaceAdminDep;
import Vue.EspaceAdminProf;
import Vue.WorkSpace;

public class RunAdmin extends WorkSpace{
	
	private EspaceAdminAdmin adminAdmin = new EspaceAdminAdmin();
	private EspaceAdminEts adminEts = new EspaceAdminEts();
	private EspaceAdminCours adminCours = new EspaceAdminCours();
	private EspaceAdminProf adminProf = new EspaceAdminProf();
	private EspaceAdminClasses adminClasses = new EspaceAdminClasses();
	private EspaceAdminFN adminFac = new EspaceAdminFN();
	private EspaceAdminFN adminNiv = new EspaceAdminFN();
	private EspaceAdminDep adminDep = new EspaceAdminDep();
	
	@SuppressWarnings({ "unchecked"})
	public RunAdmin() {
		
		adminAdmin.getComboFacAdm().setModel(new DefaultComboBoxModel(new ModelFaculte().gusomaNomsFac().toArray()));
		adminAdmin.getComboTache().setModel(new DefaultComboBoxModel(new ModelTaches().modelNomTache().toArray()));
		
		getMnInterface().add(new ChargerAdminEts(getDesktopPane(), adminEts));
		getMnInterface().add(new ChargerAdminClasses(getDesktopPane(), adminClasses));
		getMnInterface().add(new ChargerAdminProf(getDesktopPane(), adminProf));
//		getMnInterface().add(new ChargerAdminEconome(getDesktopPane(), adminAdmin.getOngletAdmins(), tableAdmins));
//		getMnInterface().add(new ChargerAdminDoyen(getDesktopPane(), adminAdmin.getOngletAdmins(), tableAdmins));
		getMnInterface().add(new ChargerAdminCours(getDesktopPane(), adminCours));
		getMnInterface().add(new ChargerAdminDep(getDesktopPane(), adminDep));
		getMnInterface().add(new ChargerAdminFac(getDesktopPane(), adminFac ));
		getMnInterface().add(new ChargerAdminNiv(getDesktopPane(), adminNiv ));
		this.setSize(600, 440);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
