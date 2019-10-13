package Vue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class EspaceEtudiant extends JFrame {
	private JTextField rechercher;
	private JTable table;
	public EspaceEtudiant() {
		getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[][][grow][][][][][grow]"));
		
		JComboBox comboBox = new JComboBox();
		getContentPane().add(comboBox, "cell 0 0,growx");
		
		rechercher = new JTextField();
		getContentPane().add(rechercher, "cell 1 0,growx");
		rechercher.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 2 2 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
