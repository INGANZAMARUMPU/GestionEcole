package Vue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EspaceEconome extends JFrame {
	private JTextField rechercher;
	private JTable table;
	private JTextField montant;
	public EspaceEconome() {
		getContentPane().setLayout(new MigLayout("", "[grow][grow][]", "[][][grow][]"));
		
		rechercher = new JTextField();
		getContentPane().add(rechercher, "cell 0 0,growx");
		rechercher.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 2 3 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("montant à ajouter :");
		getContentPane().add(lblNewLabel, "cell 0 3,alignx trailing");
		
		montant = new JTextField();
		getContentPane().add(montant, "cell 1 3,growx");
		montant.setColumns(10);
		
		JButton ajouterMontant = new JButton("Ajouter");
		getContentPane().add(ajouterMontant, "cell 2 3");
	}

}
