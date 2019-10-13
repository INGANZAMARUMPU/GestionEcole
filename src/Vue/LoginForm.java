package Vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class LoginForm extends JFrame {
	private JTextField login;
	private JPasswordField mdp;
	private JButton btnSeConnecter;
	public LoginForm() {
		getContentPane().setLayout(new MigLayout("center, center", "[][]", "[][][][][][][][][][][][][]"));
		
		JLabel lblPrenom = new JLabel("Login :");
		getContentPane().add(lblPrenom, "cell 0 5,alignx right,growy");
		
		login = new JTextField();
		getContentPane().add(login, "cell 1 5,growx,aligny center");
		login.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(lblMotDePasse, "cell 0 6,alignx right");
		
		mdp = new JPasswordField();
		mdp.setToolTipText("");
		getContentPane().add(mdp, "cell 1 6,growx,aligny center");
		mdp.setColumns(10);
		
		btnSeConnecter = new JButton("Se connecter");
		getContentPane().add(btnSeConnecter, "cell 1 7");
		
		JLabel champErreur = new JLabel("");
		getContentPane().add(champErreur, "cell 0 8 2 1");
		
		this.setSize(272, 140);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public JTextField getLogin() {
		return login;
	}
	public void setLogin(JTextField login) {
		this.login = login;
	}
	public JPasswordField getMdp() {
		return mdp;
	}
	public void setMdp(JPasswordField mdp) {
		this.mdp = mdp;
	}
	public JButton getBtnSeConnecter() {
		return btnSeConnecter;
	}
	public void setBtnSeConnecter(JButton btnSeConnecter) {
		this.btnSeConnecter = btnSeConnecter;
	}

}
