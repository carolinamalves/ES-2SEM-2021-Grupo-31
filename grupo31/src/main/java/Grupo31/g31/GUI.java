package Grupo31.g31;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.github.javaparser.ParseException;

public class GUI extends JFrame{

	static Vector<String> headers = new Vector<String>();
	static DefaultTableModel model = null;
	static Vector<Vector<String>> data = new Vector<Vector<String>>();
	static JButton Import;
	static JButton CodeSmellsDetector;
	static JFileChooser jChooser;

	static ArrayList <Method> a;

	String choosertitle;
	static String fname;

	static int tableWidth = 0;
	static int tableHeight = 0;

	private Leitura_Projetos j= new Leitura_Projetos();
	private JButton btnNewButton;

	private JLabel lblNewLabel;
	private JPanel panel;

	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton_1;

	static int v1;
	static int v2;
	static int v3;
	static int v4;

	JTextField valor1;
	JTextField valor2;
	JTextField valor3;
	JTextField valor4;

	public GUI() {

		super("Code Smells");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jChooser = new JFileChooser();

		jChooser = new JFileChooser();
		model = new DefaultTableModel(data, headers);

		tableWidth = model.getColumnCount() * 150;
		tableHeight = model.getRowCount() * 25;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{584, 0};
		gridBagLayout.rowHeights = new int[]{33, 0, 0, 0, 356, 27, 19, -21, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		lblNewLabel = new JLabel("CODE SMELLS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		btnNewButton_1 = new JButton("Importar Projetos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result;

				jChooser = new JFileChooser(); 
				jChooser.setCurrentDirectory(new java.io.File("."));
				jChooser.setDialogTitle(choosertitle);
				jChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jChooser.setAcceptAllFileFilterUsed(false);

				result = jChooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) { 

					fname = jChooser.getSelectedFile().toString().substring(jChooser.getSelectedFile().toString()
							.lastIndexOf("\\") + 1);

					try {
						Create_Method.createMethod(j.lista(jChooser.getSelectedFile().toString()));
					} catch (ParseException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					System.out.println("No Selection");
				}			
			}
		});

		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		Import = new JButton("Select Excel File");
		Import.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(Import, BorderLayout.EAST);
		Import.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				jChooser.showOpenDialog(null);
				File file = jChooser.getSelectedFile();
				
				if (!file.getName().endsWith("xlsx")) {
					
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
		
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(0, 0, 5, 0);
		gbc_buttonPanel.anchor = GridBagConstraints.NORTH;
		gbc_buttonPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 3;
		getContentPane().add(buttonPanel, gbc_buttonPanel);

		btnNewButton = new JButton("Define Rules");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setColumnCount(0);

				panel.revalidate();
				panel.repaint();

				JButton longM = new JButton("Apply Long Method Rule");
				longM.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						JLabel first = new JLabel();
						first.setText("Loc Metric > ");
						panel.add(first);

						valor1 = new JTextField();
						panel.add(valor1);
						valor1.setColumns(10);

						JLabel second = new JLabel();
						second.setText(" && Cyclo Metric > ");
						panel.add(second);

						valor2 = new JTextField();
						panel.add(valor2);
						valor2.setColumns(10);

						panel.revalidate();
						panel.repaint();
					}
				});
				
				longM.setBackground(Color.LIGHT_GRAY);
				panel.add(longM);

				JButton GodC = new JButton("Apply Long Method Rule");
				GodC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						JLabel first = new JLabel();
						first.setText("WMC Metric > ");
						panel.add(first);

						valor3 = new JTextField();
						panel.add(valor3);
						valor3.setColumns(10);

						JLabel second = new JLabel();
						second.setText(" || NomCLass Metric > ");
						panel.add(second);

						valor4 = new JTextField();
						panel.add(valor4);
						valor4.setColumns(10);

						panel.revalidate();
						panel.repaint();
					}
				});
				
				GodC.setBackground(Color.LIGHT_GRAY);
				panel.add(GodC);

				JButton submit1 = new JButton("Submit");
				submit1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						v1 = Integer.parseInt(valor1.getText());
						v2 = Integer.parseInt(valor2.getText());
						v3 = Integer.parseInt(valor3.getText());
						v4 = Integer.parseInt(valor4.getText());
						
						Create_Method.createExcel();
					}
				});
				
				submit1.setBackground(Color.LIGHT_GRAY);
				panel.add(submit1);
			}
		});
		
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(btnNewButton);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		getContentPane().add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		getContentPane().add(panel, gbc_panel);
		setSize(800, 700);
		setResizable(true);
		setVisible(true);
	}

	public static void main (String args[]) {
		new GUI();
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}