package Events;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
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

import Model.ModelClasse;
import Model.ModelDepartement;
import Model.ModelEts;
import Model.ModelTaches;
import Model.ModelUsers;
import Vue.EspaceAdminEts;
import net.miginfocom.swing.MigLayout;

public class ChargerAdminEts extends AbstractAction{
	
	ModelUsers modelUsers = new ModelUsers();
	ModelDepartement modelDepartement = new ModelDepartement();
	private JTable tableEts;
	private Container contentPane;
	private JPanel onglet;
	private EspaceAdminEts adminEts;
	
	public ChargerAdminEts(Container contentPane, EspaceAdminEts adminEts) {
		this.contentPane = contentPane;
		this.onglet = adminEts.getOngletEts();
		tableEts = adminEts.getTableEtudiants();
		this.adminEts = adminEts;
		putValue(NAME, "Etudiants");
		putValue(SHORT_DESCRIPTION, "Afficher l'espace de Gestion des Etudiants");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(onglet);
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Afficher l'espace de Gestion des Etudiants");
			fen.setTitle("Etudiants");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("La paneau est déjà active");
		}
		ModelEts modelEtudiant = new ModelEts();
		adminEts.getComboClass().setModel(new DefaultComboBoxModel(new ModelClasse().gusomaNomsClasses().toArray()));
		tableEts.setModel(modelEtudiant.gusomaModelEtudiants());

		tableEts.addMouseListener(new MouseAdapter() {
			@Override
	        public void mouseClicked(MouseEvent arg0){
	            JTextField nom = adminEts.getNomEt();
	            JTextField prenom = adminEts.getPrenomEt();
	            JTextField login = adminEts.getLogin();
	            nom.setText(tableEts.getValueAt(tableEts.getSelectedRow(), 1).toString());
	            prenom.setText(tableEts.getValueAt(tableEts.getSelectedRow(), 2).toString());
	            login.setText(tableEts.getValueAt(tableEts.getSelectedRow(), 4).toString());
	        }
	    });

		adminEts.getModifierEt().setAction(new ModifierEtudiant(tableEts, adminEts.getNomEt(), adminEts.getPrenomEt(),
								adminEts.getMdpEt(), adminEts.getComboClass(), adminEts.getLogin()));
		adminEts.getAjouterEt().setAction(new AjouterEtudiant(tableEts, adminEts.getNomEt(), adminEts.getPrenomEt(),
								adminEts.getMdpEt(), adminEts.getComboClass(), adminEts.getLogin()));
	}
}