package Events;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import Model.ModelDepartement;
import Model.ModelDoyens;
import Model.ModelTaches;
import Model.ModelUsers;
import net.miginfocom.swing.MigLayout;

public class ChargerAdminDoyen extends AbstractAction{
	
	ModelUsers modelUsers = new ModelUsers();
	ModelDepartement modelDepartement = new ModelDepartement();
	private JTable tableUser;
	private Container contentPane;
	private JPanel onglet;
	
	public ChargerAdminDoyen(Container contentPane, JPanel onglet, JTable table) {
		this.contentPane = contentPane;
		this.onglet = onglet;
		tableUser = table;
		putValue(NAME, "Doyens");
		putValue(SHORT_DESCRIPTION, "Afficher l'espace de gestion des doyens");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(onglet);
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Afficher l'espace de gestion des doyens");
			fen.setTitle("Doyens");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("La paneau est déjà active");
		}
		ModelDoyens modelDoyens = new ModelDoyens();
//		tableUser.setModel(modelDoyens.gusomaUsers(type));
	}
}