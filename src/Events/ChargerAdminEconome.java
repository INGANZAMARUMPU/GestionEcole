package Events;

import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import Model.ModelDepartement;
import Model.ModelEconomes;
import Model.ModelUsers;

public class ChargerAdminEconome extends AbstractAction{
	
	ModelUsers modelUsers = new ModelUsers();
	ModelDepartement modelDepartement = new ModelDepartement();
	private JTable tableUser;
	private Container contentPane;
	private JPanel onglet;
	
	public ChargerAdminEconome(Container contentPane, JPanel onglet, JTable table) {
		this.contentPane = contentPane;
		this.onglet = onglet;
		tableUser = table;
		putValue(NAME, "Economes");
		putValue(SHORT_DESCRIPTION, "Kwongeramwo Umu Prof");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{			
			JInternalFrame fen = new JInternalFrame();
			fen.getContentPane().add(onglet);
			fen.pack();
			fen.setResizable(true);
			fen.setClosable(true);
			fen.setToolTipText("Afficher l'espace gestion Economes");
			fen.setTitle("Economes");
			fen.setVisible(true);
			fen.setMaximizable(true);
			fen.setIconifiable(true);
			contentPane.add(fen);
            
		}catch (Exception e) {
			System.out.println("La paneau est déjà active");
		}
		ModelEconomes modelEconome = new ModelEconomes();
//		tableUser.setModel(modelEconome.gusomaEconomes());
	}
}