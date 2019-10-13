import javax.swing.JButton;
import javax.swing.UIManager;
import Events.Connexion;
import Vue.LoginForm;

public class LogIn {
	static LoginForm jonkur;
	static JButton btnConnecter;
	
	public static void main(String[] args) {
		jonkur = new LoginForm();
		btnConnecter = jonkur.getBtnSeConnecter();
		jonkur.getMdp().setAction(new Connexion(jonkur, jonkur.getLogin(), jonkur.getMdp()));
		btnConnecter.setAction(new Connexion(jonkur, jonkur.getLogin(), jonkur.getMdp()));

		jonkur.setLocationRelativeTo(null);
		jonkur.setVisible(true);
	}

}
