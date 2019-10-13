package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import Model.ModelClasse;
import Model.ModelDepartement;
import Model.ModelNiveau;
import Vue.EspaceAdminClasses;

public class ChargerAdminClasses extends AbstractAction{
	private JTable tableClasses;
	private JPanel onglet;
	private JDesktopPane contentPane;
	private EspaceAdminClasses adminClasses;
	
	public ChargerAdminClasses(JDesktopPane contentPane, EspaceAdminClasses adminClasses) {
		tableClasses = adminClasses.getTableClasses();
		this.onglet = adminClasses.getOngletClasses();
		this.adminClasses = adminClasses;
		this.contentPane = contentPane;
		putValue(NAME, "Classes");
		putValue(SHORT_DESCRIPTION, "Gerer les Classes");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(onglet);
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Classes");
			fen.setTitle("Classes");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("La paneau est déjà active");
		}
		adminClasses.getComboNiveau().setModel(new DefaultComboBoxModel(new ModelNiveau().gusomaNomNiveau().toArray()));
		adminClasses.getComboDep().setModel(new DefaultComboBoxModel(new ModelDepartement().gusomaNomsDepart().toArray()));
		tableClasses.setModel(new ModelClasse().gusomaModelClasse());
		adminClasses.getBtnAjouter().setAction(new AjouterClasse(adminClasses));
		adminClasses.getBtnSupprimer().setAction(new SupprimerClasse(adminClasses));
		adminClasses.getBtnModifier().setAction(new ModifierClasse(adminClasses));
	}
}

