package Events;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.ModelFaculte;
import Model.ModelTaches;
import Model.ModelUsers;;

public class AjouterAdmin extends AbstractAction {
	
	ModelUsers modelUsers = new ModelUsers();
	ModelTaches modelTaches = new ModelTaches();
	ModelFaculte modelFac = new ModelFaculte();
	private JTextField nom;
	private JTextField prenom;
	private JTextField mot_de_passe;
	private JComboBox Depart;
	private JComboBox tache;
	private int id_t;
	private String id_d;
	JTable tableAdmins;
	
	public AjouterAdmin(JTextField nom, JTextField prenom, JTextField mot_de_passe, JComboBox Depart, JComboBox tache, JTable tableAdmins) {
		this.nom = nom;
		this.prenom = prenom;
		this.mot_de_passe = mot_de_passe;
		this.Depart = Depart;
		this.tache = tache;
		this.tableAdmins = tableAdmins;
		
		putValue(NAME, "Ajouter");
		putValue(SHORT_DESCRIPTION, "Kwongeramwo Umu Admin");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.id_t = modelTaches.getIdTache(this.tache.getSelectedItem().toString());
		this.id_d = modelFac.getIdFaculte(this.Depart.getSelectedItem().toString()).toString();
		
		if (id_t != 3 | id_t != 4){
			JDialog erreur = new JDialog();
			erreur.setTitle("Erreur!");
			erreur.setSize(new Dimension(350, 30));
			erreur.setLocationRelativeTo(nom.getParent());
			erreur.add(new JLabel("Veuillez Choisir entre Doyen et Econome"));
			erreur.setVisible(true);
			return;
		} else{
//			modelUsers.ajouterAdmin(nom.getText(), prenom.getText(), mot_de_passe.getText(), id_t, id_d);
//			DefaultTableModel containneur = modelUsers.gusomaUsers(id_t);
//			tableAdmins.setModel(containneur);		
		}
		
	}

}
