package Events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.ModelProf;
import Model.ModelUsers;;

public class AjouterProf extends AbstractAction {
	private JTextField nom;
	private JTextField prenom;
	private JTextField passwd;
	private JTextField login;
	JTable tableProf;
	private ModelProf modelProf = new ModelProf();
	
	public AjouterProf(JTextField nom, JTextField prenom, JTextField passwd, JTextField login, JTable tableProf) {
		this.nom = nom;
		this.prenom = prenom;
		this.passwd = passwd;
		this.login = login;
		this.tableProf = tableProf;
		
		putValue(NAME, "Ajouter");
		putValue(SHORT_DESCRIPTION, "Kwongeramwo Umu Prof");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		modelProf.ajouterProf(nom.getText(), prenom.getText(), passwd.getText(), login.getText());
		DefaultTableModel containneur = modelProf.gusomaModelProf();
		tableProf.setModel(containneur);
		
	}

}
