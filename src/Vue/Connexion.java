package Vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class Connexion extends JFrame {
	private JTextField prenom;
	private JTextField nom;
	private JTextField mdp;
	public Connexion() {
		getContentPane().setLayout(new MigLayout("center, center", "[][]", "[][][][][][][][][]"));
		
		JLabel lblNom = new JLabel("Nom :");
		getContentPane().add(lblNom, "cell 0 0,alignx right,growy");
		
		nom = new JTextField();
		getContentPane().add(nom, "cell 1 0,growx,aligny center");
		nom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		getContentPane().add(lblPrenom, "cell 0 1,alignx right,growy");
		
		prenom = new JTextField();
		getContentPane().add(prenom, "cell 1 1,growx,aligny center");
		prenom.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(lblMotDePasse, "cell 0 2,alignx right");
		
		mdp = new JTextField();
		mdp.setToolTipText("");
		getContentPane().add(mdp, "cell 1 2,growx,aligny center");
		mdp.setColumns(10);
		
		JButton btnSeConnecter = new JButton("Se connecter");
		getContentPane().add(btnSeConnecter, "cell 1 3");
		
		JLabel champErreur = new JLabel("");
		getContentPane().add(champErreur, "cell 0 4 2 1");
		
		this.setSize(272, 120);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
