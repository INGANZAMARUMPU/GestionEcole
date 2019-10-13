package Events;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Model.ModelCours;
import Model.ModelDepartement;
import Model.ModelFaculte;
import Model.ModelNiveau;
import Vue.EspaceAdminDep;
import Vue.EspaceAdminFN;

@SuppressWarnings("serial")
public class ChargerAdminFac extends AbstractAction{
	private JTable tableFac;
	private JPanel onglet;
	private JDesktopPane contentPane;
	EspaceAdminFN adminFac;
	private AbstractAction actualiserTableFac;
	
	public ChargerAdminFac(JDesktopPane contentPane, EspaceAdminFN adminFac) {
		tableFac = adminFac.getTable();
		this.onglet = adminFac.getPanel();
		this.adminFac = adminFac;
		this.contentPane = contentPane;
		putValue(NAME, "Facultés");
		putValue(SHORT_DESCRIPTION, "Gerer les Facultés");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(onglet);
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Afficher Faculté");
			fen.setTitle("Faculté");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("La paneau est déjà  active");
		}
		tableFac.setModel(new ModelFaculte().gusomaModelFac());
		tableFac.addMouseListener(new MouseAdapter() {
			@Override
	        public void mouseClicked(MouseEvent arg0){
	            JTextField nom = adminFac.getNom();
	            nom.setText(tableFac.getValueAt(tableFac.getSelectedRow(), 1).toString());
	        }
	    });
		adminFac.getBtnAjouter().setAction(new AjouterFac(adminFac.getNom(), tableFac));
		adminFac.getBtnModifier().setAction(new ModifierFac(adminFac));
		adminFac.getBtnSupprimer().setAction(new SupprimerFac(tableFac));
	}
}

