package Grupo31.g31;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.binary.StringUtils;

import javax.swing.JScrollBar;
import java.awt.Panel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Choice;
import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;

public class GUI extends JFrame{
	private static String ENTER = "Enter";
	static Vector<String> headers = new Vector<String>();
	static DefaultTableModel model = null;
	static Vector<Vector<String>> data = new Vector<Vector<String>>();
	static JButton Import;
	static JButton CodeSmellsDetector;
	static JFileChooser jChooser;
	static ArrayList <Method> a;

	static int tableWidth = 0;
	static int tableHeight = 0;

	private Choice choice;
	private TextField textField;
	private JTextArea textArea;
	private JTextPane textPane;
	private JTextField input;
	private Button button;
	private Create_Method cm;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JScrollPane scroll;
	private JTable table;

	public GUI() {
		super("Code Smells");
	//teste
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jChooser = new JFileChooser();
		
		jChooser = new JFileChooser();
		model = new DefaultTableModel(data, headers);

		
		tableWidth = model.getColumnCount() * 150;
		tableHeight = model.getRowCount() * 25;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{584, 0};
		gridBagLayout.rowHeights = new int[]{33, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
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
		
		lblNewLabel = new JLabel("CODE SMELLS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		CodeSmellsDetector = new JButton("Detect CodeSmells");
		GridBagConstraints gbc_CodeSmellsDetector = new GridBagConstraints();
		gbc_CodeSmellsDetector.insets = new Insets(0, 0, 5, 0);
		gbc_CodeSmellsDetector.gridx = 0;
		gbc_CodeSmellsDetector.gridy = 2;
		getContentPane().add(CodeSmellsDetector, gbc_CodeSmellsDetector);
		CodeSmellsDetector.setBackground(Color.LIGHT_GRAY);
		CodeSmellsDetector.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jChooser.showOpenDialog(null);

				File fileJava = jChooser.getSelectedFile();
				if (!fileJava.getName().endsWith("java")) {
					JOptionPane.showMessageDialog(null, "Please select only Java file.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					cm.fillmethod(fileJava);
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
		gbc_buttonPanel.gridy = 4;
		getContentPane().add(buttonPanel, gbc_buttonPanel);
		
		
		
		
		btnNewButton = new JButton("Rules");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				input = new JTextField();
				scroll.setColumnHeaderView(input);
				input.setColumns(10);
				
				button = new Button("submit");
				scroll.setRowHeaderView(button);
				
			
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					
						
						String max = input.getText();
						System.out.println(max);
						
						if(isNumeric(max)) {
							
							int maxNum = Integer.parseInt(max, 10);
							
							if(cm.Regra1(maxNum, 1)) {
								System.out.println("REGRA 1 : TRUE");
							}
							else 
								System.out.println("REGRA 1 : FALSE");
							
							
							if(cm.Regra2(maxNum, 1)) {
								System.out.println("REGRA 2 : TRUE");
							}
							else 
								System.out.println("REGRA 2 : FALSE");
							
							
							
						}
		        
					}
				
				});
			
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(btnNewButton);
		
		scroll = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		getContentPane().add(scroll, gbc_scrollPane);
		
		table = new JTable();
		scroll.setViewportView(table);
		
		
	
		
		
		
		
		
		
		setSize(600, 600);
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
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}


