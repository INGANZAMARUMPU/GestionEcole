package Events;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import Model.ModelDepartement;
import Model.ModelProf;
import Model.ModelTaches;
import Model.ModelUsers;
import Vue.EspaceAdminProf;
import Vue.LoginForm;
import net.miginfocom.swing.MigLayout;

public class ChargerAdminProf extends AbstractAction{
	
	ModelUsers modelUsers = new ModelUsers();
	ModelDepartement modelDepartement = new ModelDepartement();
	private JTable tableProf;
	private Container contentPane;
	private JPanel onglet;
	EspaceAdminProf adminProf;
	
	public ChargerAdminProf(Container contentPane, EspaceAdminProf adminProf) {
		this.contentPane = contentPane;
		this.onglet = adminProf.getOngletProfs();
		tableProf = adminProf.getTable();
		this.adminProf = adminProf;
		putValue(NAME, "Professeurs");
		putValue(SHORT_DESCRIPTION, "Afficher l'interface Professeurs");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(onglet);
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Afficher l'interface Professeurs");
			fen.setTitle("Professeurs");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("La paneau est déjà active");
		}
		ModelProf modelProf = new ModelProf();
		tableProf.setModel(modelProf.gusomaModelProf());

		tableProf.addMouseListener(new MouseAdapter() {
			@Override
	        public void mouseClicked(MouseEvent arg0){
	            JTextField nom = adminProf.getNomProf();
	            JTextField prenom = adminProf.getPrenomProf();
	            JTextField login = adminProf.getLogin();
	            nom.setText(tableProf.getValueAt(tableProf.getSelectedRow(), 1).toString());
	            prenom.setText(tableProf.getValueAt(tableProf.getSelectedRow(), 2).toString());
	            login.setText(tableProf.getValueAt(tableProf.getSelectedRow(), 3).toString());
	           	}
	    });

		adminProf.getAjouterProf().setAction(new AjouterProf(adminProf.getNomProf(), adminProf.getPrenomProf(),
								adminProf.getMdpProf(), adminProf.getLogin(), tableProf));
		adminProf.getSupprimerProf().setAction(new SupprimerProf(tableProf));
		adminProf.getModifierProf().setAction(new ModifierProf(tableProf, adminProf.getNomProf(), adminProf.getPrenomProf(), 
											adminProf.getMdpProf(), adminProf.getLogin()));
	}
}