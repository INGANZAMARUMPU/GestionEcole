package Events;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import Model.ModelDepartement;
import Model.ModelFaculte;
import Vue.EspaceAdminDep;

public class ChargerAdminDep extends AbstractAction{
	private JTable tableDep;
	private JPanel onglet;
	private JDesktopPane contentPane;
	EspaceAdminDep adminDep;
	private AbstractAction actualiserTableDep;
	
	public ChargerAdminDep(JDesktopPane contentPane, EspaceAdminDep adminDep) {
		tableDep = adminDep.getTable();
		this.onglet = adminDep.getPanel();
		this.adminDep = adminDep;
		this.contentPane = contentPane;
		putValue(NAME, "Departements");
		putValue(SHORT_DESCRIPTION, "Gerer les Departements");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(onglet);
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Départements");
			fen.setTitle("Départements");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("La paneau est déjà active");
		}
		adminDep.getComboFac().setModel(new DefaultComboBoxModel(new ModelFaculte().gusomaNomsFac().toArray()));
		tableDep.setModel(new ModelDepartement().gusomaModelDepartement());
		tableDep.addMouseListener(new MouseAdapter() {
			@Override
	        public void mouseClicked(MouseEvent arg0){
	            JTextField nom = adminDep.getNomDep();
	            nom.setText(tableDep.getValueAt(tableDep.getSelectedRow(), 1).toString());
	        }
	    });

//				tableDep.setModel(new ModelFaculte().gusomaModelFac());

		adminDep.getBtnAjouter().setAction(new AjouterDepart(adminDep.getNomDep(), adminDep.getComboFac(), tableDep));
		adminDep.getBtnSupprimer().setAction(new SupprimerDepart(tableDep));

	}
}

