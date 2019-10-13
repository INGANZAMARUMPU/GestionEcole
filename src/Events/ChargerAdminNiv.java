package Events;

import java.awt.Adjustable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class ChargerAdminNiv extends AbstractAction{
	private JTable tableNiv;
	private JPanel onglet;
	private JDesktopPane contentPane;
	EspaceAdminFN adminNiv;
	private AbstractAction actualiserTableNiv;
	
	public ChargerAdminNiv(JDesktopPane contentPane, EspaceAdminFN adminNiv) {
		tableNiv = adminNiv.getTable();
		this.onglet = adminNiv.getPanel();
		this.adminNiv = adminNiv;
		this.contentPane = contentPane;
		putValue(NAME, "Niveau");
		putValue(SHORT_DESCRIPTION, "Gerer les Niveau");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(onglet);
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Afficher Niveau");
			fen.setTitle("Niveau");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("La paneau est déjà active");
		}
		tableNiv.setModel(new ModelNiveau().gusomaModelNiv());
		tableNiv.addMouseListener(new MouseAdapter() {
			@Override
	        public void mouseClicked(MouseEvent arg0){
	            JTextField nom = adminNiv.getNom();
	            nom.setText(tableNiv.getValueAt(tableNiv.getSelectedRow(), 1).toString());
	        }
	    });

		adminNiv.getBtnAjouter().setAction(new AjouterNiv(adminNiv.getNom(), tableNiv));
		adminNiv.getBtnSupprimer().setAction(new SupprimerNiveau(tableNiv));
		adminNiv.getBtnModifier().setAction(new ModifierNiveau(adminNiv));
	}
}

