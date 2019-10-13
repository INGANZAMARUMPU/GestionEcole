package Vue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EspaceProf extends JFrame {
	private JTextField rechercher;
	private JTextField points;
	private JTable table;
	public EspaceProf() {
		getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[][][grow][][][]"));
		
		JComboBox comboClasse = new JComboBox();
		getContentPane().add(comboClasse, "cell 0 0,growx");
		
		JComboBox comboNiveau = new JComboBox();
		getContentPane().add(comboNiveau, "cell 1 0,growx");
		
		rechercher = new JTextField();
		getContentPane().add(rechercher, "cell 2 0,growx");
		rechercher.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 2 3 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblPointsAAjouter = new JLabel("points à ajouter :");
		getContentPane().add(lblPointsAAjouter, "cell 0 3");
		
		points = new JTextField();
		getContentPane().add(points, "cell 1 3,growx");
		points.setColumns(10);
		
		JButton ajouterPoints = new JButton("Ajouter");
		getContentPane().add(ajouterPoints, "cell 2 3");
	}

}
