package Vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

public class WorkSpace extends JFrame {
	private JPanel ongletHistorique;
	private JButton btnActualiser;
	private JScrollPane scrollPane_2;
	private JTable tableHistorique;
	private JPanel ongletFac;
	private JTextField rechercheFac;
	private JScrollPane scrollPane_6;
	private JTable tableFac;
	private JLabel lblNomDeLa;
	private JTextField nomFac;
	private JButton btnAjouter_1;
	private JButton btnModifier_1;
	private JButton btnSuprimer;
	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenu mnInterface;
	private JMenuItem mntmQuitter;
	private JMenuItem mntmDeconnection;
	private JMenu mnWindows;
	private JMenuItem mntmHistorique;
	private JDesktopPane desktopPane;

	public WorkSpace() {				
		
		ongletHistorique = new JPanel();
		scrollPane_2 = new JScrollPane();
		ongletHistorique.add(scrollPane_2, "cell 0 1,grow");
		
		tableHistorique = new JTable();
		scrollPane_2.setViewportView(tableHistorique);
		
		btnActualiser = new JButton("Actualiser");
		ongletHistorique.add(btnActualiser, "cell 0 2");
		
		ongletFac = new JPanel();
		ongletFac.setLayout(new MigLayout("fill", "[][grow][][][]", "[][grow][][]"));
		
		rechercheFac = new JTextField();
		ongletFac.add(rechercheFac, "cell 0 0 5 1,growx");
		rechercheFac.setColumns(10);
		
		scrollPane_6 = new JScrollPane();
		ongletFac.add(scrollPane_6, "cell 0 1 5 1,grow");
		
		tableFac = new JTable();
		scrollPane_6.setViewportView(tableFac);
		
		lblNomDeLa = new JLabel("Nom de la Faculté :");
		ongletFac.add(lblNomDeLa, "cell 0 3");
		
		nomFac = new JTextField();
		ongletFac.add(nomFac, "cell 1 3,growx");
		nomFac.setColumns(10);
		
		btnAjouter_1 = new JButton("Ajouter");
		ongletFac.add(btnAjouter_1, "cell 2 3");
		
		btnModifier_1 = new JButton("Modifier");
		ongletFac.add(btnModifier_1, "cell 3 3");
				
		btnSuprimer = new JButton("Suprimer");
		ongletFac.add(btnSuprimer, "cell 4 3");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		mntmDeconnection = new JMenuItem("Deconnection");
		mnFichier.add(mntmDeconnection);
		
		mntmQuitter = new JMenuItem("Quitter");
		mnFichier.add(mntmQuitter);
		
		mnInterface = new JMenu("Inteface");
		menuBar.add(mnInterface);
		
		mnWindows = new JMenu("Windows");
		menuBar.add(mnWindows);
		
		mntmHistorique = new JMenuItem("Historique");
		mnWindows.add(mntmHistorique);
		getContentPane().setLayout(new MigLayout("fill", "[grow]", "[grow]"));
		
		desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, "cell 0 0,grow");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMnFichier() {
		return mnFichier;
	}

	public void setMnFichier(JMenu mnFichier) {
		this.mnFichier = mnFichier;
	}

	public JMenu getMnInterface() {
		return mnInterface;
	}

	public void setMnInterface(JMenu mnInterface) {
		this.mnInterface = mnInterface;
	}

	public JMenuItem getMntmQuitter() {
		return mntmQuitter;
	}

	public void setMntmQuitter(JMenuItem mntmQuitter) {
		this.mntmQuitter = mntmQuitter;
	}

	public JMenuItem getMntmDeconnection() {
		return mntmDeconnection;
	}

	public void setMntmDeconnection(JMenuItem mntmDeconnection) {
		this.mntmDeconnection = mntmDeconnection;
	}

	public JMenu getMnWindows() {
		return mnWindows;
	}

	public void setMnWindows(JMenu mnWindows) {
		this.mnWindows = mnWindows;
	}

	public JMenuItem getMntmHistorique() {
		return mntmHistorique;
	}

	public void setMntmHistorique(JMenuItem mntmHistorique) {
		this.mntmHistorique = mntmHistorique;
	}
	
}
