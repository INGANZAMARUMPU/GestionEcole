package Events;

import java.awt.Label;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;

import GestionEcole.RunAdmin;
import GestionEcole.RunProf;
import Model.ModelProf;
import Model.ModelUsers;

public class Connexion extends AbstractAction {
	
	private JTextField mdp;
	private JTextField login;
	private int typeUser;
	private JFrame parent;
	private int idUser;
	
	public Connexion(JFrame parent, JTextField login, JTextField psswd){
		this.login = login;
		this.mdp = psswd;
		this.parent = parent;
		
		putValue(NAME, "Connection");
		putValue(SHORT_DESCRIPTION, "Kwikonecta");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		typeUser = new ModelUsers().getTypeUser(login.getText(), mdp.getText());
		switch (typeUser) {
		case 1:
			parent.setVisible(false);
//			RunEtudiant();
			break;
		case 2:
			parent.setVisible(false);
			idUser = new ModelUsers().getIdUser(login.getText(), mdp.getText());
			int idProf = new ModelProf().getIdProf(idUser);
			new RunProf(idProf);
			break;
		case 3:
			parent.setVisible(false);
//			new RunEconome();
			break;
		case 4:
			parent.setVisible(false);
			new RunAdmin();
			break;
		case 5:
			parent.setVisible(false);
			new RunAdmin();
			break;
		default:
			JOptionPane.showMessageDialog(parent, "Logins Incorrect");
				
		}
				
	}

}
