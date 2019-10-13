package Events;

import java.awt.color.ProfileDataException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.annotation.processing.ProcessingEnvironment;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.ModelClasse;
import Model.ModelCours;
import Model.ModelDepartement;
import Model.ModelProf;
import Model.ModelTaches;
import Vue.EspaceAdminCours;

public class ChargerAdminCours extends AbstractAction{
	private JTable tableCours;
	private JPanel onglet;
	private JDesktopPane contentPane;
	private EspaceAdminCours adminCours;
	protected JTextField nom;
	protected JTextField volume;
	
	public ChargerAdminCours(JDesktopPane contentPane, EspaceAdminCours adminCours) {
		this.adminCours = adminCours;
		tableCours = adminCours.getTableCours();
		this.onglet = adminCours.getOngletCours();
		this.contentPane = contentPane;
		putValue(NAME, "Cours");
		putValue(SHORT_DESCRIPTION, "Gerer les Cours");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(onglet);
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Cours");
			fen.setTitle("Cours");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("La paneau est déjà active");
		}
		adminCours.getComboProfCours().setModel(new DefaultComboBoxModel(new ModelProf().gusomaNomsProf().toArray()));
		adminCours.getComboClassCours().setModel(new DefaultComboBoxModel(new ModelClasse().gusomaNomsClasses().toArray()));
		tableCours.setModel(new ModelCours().gusomaModelCours());
		tableCours.addMouseListener(new MouseAdapter() {
			@Override
	        public void mouseClicked(MouseEvent arg0){
		        nom = adminCours.getNomCours();
		        volume = adminCours.getVolCours();
	            nom.setText(tableCours.getValueAt(tableCours.getSelectedRow(), 1).toString());
	            volume.setText(tableCours.getValueAt(tableCours.getSelectedRow(), 2).toString());
	        }
	    });
		adminCours.getModifierCours().setAction(new ModifierCours(adminCours));
		adminCours.getAjouterCours().setAction(new AjouterCours(adminCours));
	}
}

