package Grupo31.g31;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame{  
	private ImportExcel IE;

	static JTable table;
	static JScrollPane scroll;
	static Vector headers = new Vector();
	static DefaultTableModel model = null;
	static Vector data = new Vector();
	static JButton Import;
	static JButton CodeSmellsDetector;
	static JFileChooser jChooser;
	//static J

	static int tableWidth = 0;
	static int tableHeight = 0;

	public GUI() {
		super("Code Smells");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		jChooser = new JFileChooser();
		CodeSmellsDetector = new JButton("Detect CodeSmells");
		buttonPanel.add(CodeSmellsDetector, BorderLayout.WEST);
		CodeSmellsDetector.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jChooser.showOpenDialog(null);

				File file = jChooser.getSelectedFile();
				if (!file.getName().endsWith("java")) {
					JOptionPane.showMessageDialog(null, "Please select only Java file.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Create_Method.fillmethod();
					model = new DefaultTableModel(data, headers);
					tableWidth = model.getColumnCount() * 150;
					tableHeight = model.getRowCount() * 25;
					table.setPreferredSize(new Dimension(tableWidth, tableHeight));

					table.setModel(model);
				}
			}
		});
		
		jChooser = new JFileChooser();
		Import = new JButton("Select Excel File");
		buttonPanel.add(Import, BorderLayout.EAST);
		Import.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jChooser.showOpenDialog(null);

				File file = jChooser.getSelectedFile();
				if (!file.getName().endsWith("xls")) {
					JOptionPane.showMessageDialog(null, "Please select only Excel file.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					ImportExcel.fillData(file);
					model = new DefaultTableModel(data, headers);
					tableWidth = model.getColumnCount() * 150;
					tableHeight = model.getRowCount() * 25;
					table.setPreferredSize(new Dimension(tableWidth, tableHeight));

					table.setModel(model);
				}
			}
		});
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		model = new DefaultTableModel(data, headers);

		table.setModel(model);
		table.setBackground(Color.white);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		table.setRowHeight(25);
		table.setRowMargin(4);

		tableWidth = model.getColumnCount() * 150;
		tableHeight = model.getRowCount() * 25;
		table.setPreferredSize(new Dimension(tableWidth, tableHeight));

		scroll = new JScrollPane(table);
		scroll.setBackground(Color.pink);
		scroll.setPreferredSize(new Dimension(300, 300));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		getContentPane().add(scroll, BorderLayout.CENTER);
		setSize(600, 600);
		setResizable(true);
		setVisible(true);
	}

	public static void main (String args[]) {
		GUI gui = new GUI();
	}

}

