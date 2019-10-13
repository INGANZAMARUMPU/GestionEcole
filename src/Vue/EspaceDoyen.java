package Vue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EspaceDoyen extends JFrame {
	private JTextField rechercher;
	private JTextField point;
	private JTable table;
	public EspaceDoyen() {
		getContentPane().setLayout(new MigLayout("", "[grow][grow][]", "[][][grow][][][]"));
		
		rechercher = new JTextField();
		getContentPane().add(rechercher, "cell 0 0,growx");
		rechercher.setColumns(10);
		
		JComboBox comboClasse = new JComboBox();
		getContentPane().add(comboClasse, "cell 1 0,growx");
		
		JButton btnImprimer_1 = new JButton("imprimer");
		btnImprimer_1.setToolTipText("imprimer la liste des points");
		getContentPane().add(btnImprimer_1, "cell 2 0");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 2 3 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblPoint = new JLabel("Points :");
		getContentPane().add(lblPoint, "cell 0 3,alignx trailing");
		
		point = new JTextField();
		getContentPane().add(point, "cell 1 3,growx");
		point.setColumns(10);
		
		JButton btnInserer = new JButton("Inserer");
		getContentPane().add(btnInserer, "cell 2 3");
		
		JButton btnImprimer = new JButton("imprimer");
		btnImprimer.setToolTipText("imprimer le bulletin pour l'étudiant courant");
		getContentPane().add(btnImprimer, "cell 2 5");
	}

}
