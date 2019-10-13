package Events;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import Model.ModelCours;
import Model.ModelDepartement;
import Model.ModelEts;
import Model.ModelPoints;
import Model.ModelTaches;
import Model.ModelUsers;
import Vue.EspaceAdminEts;
import Vue.EspaceProfCours;
import net.miginfocom.swing.MigLayout;

public class ChargerProfCours extends AbstractAction{
	
	private Container contentPane;
	private EspaceProfCours profCours;
	private JTable tablePoints;
	private JComboBox comboClasse;

	public ChargerProfCours(Container contentPane, EspaceProfCours profCours) {
		this.contentPane = contentPane;
		this.profCours = profCours;
		tablePoints = profCours.getTable();
		comboClasse = profCours.getComboCours();
		putValue(NAME, "Points");
		putValue(SHORT_DESCRIPTION, "Afficher l'espace de Gestion de la note des Etudiants");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        JTextField tp = profCours.getPointsTP();
        JTextField session1 = profCours.getPointsSession1();
        JTextField session2 = profCours.getPointsSession2();
		ModelPoints modelPoints = new ModelPoints();
		ModelCours modelCours = new ModelCours();
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(profCours.getContentPane());
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Afficher l'espace de Gestion des Points Etudiants");
			fen.setTitle("Les Points");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("ERREUR Chargement Fenetre:"+e.getMessage());
		}
		profCours.getBtnCharger().setAction(new AbstractAction("Charger") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id_cours = modelCours.getIdCours(comboClasse.getSelectedItem().toString());
				DefaultTableModel model_table_point = modelPoints.gusomaModelPoints(id_cours);
				if(model_table_point.getRowCount()==0){
					modelPoints.creerlistPoints(modelCours.getIdCours(comboClasse.getSelectedItem().toString()));
					tablePoints.setModel(model_table_point);				
				}else{
					tablePoints.setModel(model_table_point);	
				}
			}
		});

		tablePoints.addMouseListener(new MouseAdapter() {
			@Override
	        public void mouseClicked(MouseEvent arg0){
	            tp.setText(tablePoints.getValueAt(tablePoints.getSelectedRow(), 3).toString());
	            session1.setText(tablePoints.getValueAt(tablePoints.getSelectedRow(), 4).toString());
	            session2.setText(tablePoints.getValueAt(tablePoints.getSelectedRow(), 5).toString());
	        }
	    });
		profCours.getValiderPoints().setAction(new AbstractAction("Valider") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				modelPoints.ajouterPoints(tp.getText(), session1.getText(), session2.getText(),
						Integer.parseInt(tablePoints.getValueAt(tablePoints.getSelectedRow(), 1).toString()));
				int id_cours = modelCours.getIdCours(comboClasse.getSelectedItem().toString());
				DefaultTableModel model_table_point = modelPoints.gusomaModelPoints(id_cours);
				tablePoints.setModel(model_table_point);	
				
			}
		});
		profCours.getBtnAppel().setAction(new AbstractAction("Appeler") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}
}