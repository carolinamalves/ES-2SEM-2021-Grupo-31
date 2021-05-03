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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	String choosertitle;
	static String fname;
	static int tableWidth = 0;
	static int tableHeight = 0;

	//regras
	private JTextField input;
	private JTextField input2;
	private Button button;
	private Create_Method cm;
	private Leitura_Projetos j= new Leitura_Projetos();
	private JButton regra1;
	private JButton regra2;
	private JLabel labelLOC;
	private JLabel labelCYCLO;
	private JLabel labelWMC;
	private JLabel labelNOM;
	
	private JLabel labelTrue;
	private JLabel labelFalse;
	private JLabel lblNewLabel;
	private JPanel panel;

	//excel
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton_1;


	public GUI() {

		super("Code Smells");

		//teste2
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
<<<<<<< HEAD
				public void actionPerformed(ActionEvent e) {
					
				    int result;
			        
				    jChooser = new JFileChooser(); 
				    jChooser.setCurrentDirectory(new java.io.File("."));
				    jChooser.setDialogTitle(choosertitle);
				    jChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				    //
				    // disable the "All files" option.
				    //
				    jChooser.setAcceptAllFileFilterUsed(false);
				    //    
				     result = jChooser.showOpenDialog(null);
				    
				    if (result == JFileChooser.APPROVE_OPTION) { 
				      System.out.println("getCurrentDirectory(): " 
				         +  jChooser.getCurrentDirectory());
				      System.out.println("getSelectedFile() : " 
				         +  jChooser.getSelectedFile());
				     
				      
				     
				      
				      
				      fname = jChooser.getSelectedFile().toString().substring(jChooser.getSelectedFile().toString().lastIndexOf("\\") + 1);
				      Create_Method.fillmethod(j.lista(jChooser.getSelectedFile().toString()), fname );
				      
				    } else {
				      System.out.println("No Selection");
				      }			
				}
			});
=======
			public void actionPerformed(ActionEvent e) {
>>>>>>> branch 'main' of https://github.com/csmma1-iscteiul/ES-2SEM-2021-Grupo-31.git

				int result;

				jChooser = new JFileChooser(); 
				jChooser.setCurrentDirectory(new java.io.File("."));
				jChooser.setDialogTitle(choosertitle);
				jChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				//
				// disable the "All files" option.
				//
				jChooser.setAcceptAllFileFilterUsed(false);
				//    
				result = jChooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) { 
					System.out.println("getCurrentDirectory(): " 
							+  jChooser.getCurrentDirectory());
					System.out.println("getSelectedFile() : " 
							+  jChooser.getSelectedFile());

					fname = jChooser.getSelectedFile().toString().substring(jChooser.getSelectedFile().toString().lastIndexOf("\\") + 1);
					Create_Method.fillmethod(j.lista(jChooser.getSelectedFile().toString()), fname );

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


		//		CodeSmellsDetector = new JButton("Detect CodeSmells");
		//		GridBagConstraints gbc_CodeSmellsDetector = new GridBagConstraints();
		//		gbc_CodeSmellsDetector.insets = new Insets(0, 0, 5, 0);
		//		gbc_CodeSmellsDetector.gridx = 0;
		//		gbc_CodeSmellsDetector.gridy = 2;
		//		getContentPane().add(CodeSmellsDetector, gbc_CodeSmellsDetector);
		//		CodeSmellsDetector.setBackground(Color.LIGHT_GRAY);
		//		CodeSmellsDetector.addActionListener(new ActionListener() {
		//
		//			@Override
		//			public void actionPerformed(ActionEvent arg0) {
		//				jChooser.showOpenDialog(null);
		//
		//				File fileJava = jChooser.getSelectedFile();
		//				if (!fileJava.getName().endsWith("java")) {
		//					JOptionPane.showMessageDialog(null, "Please select only Java file.", "Error", JOptionPane.ERROR_MESSAGE);
		//				} else {
		//					Create_Method.fillmethod(fileJava);
		//					model = new DefaultTableModel(data, headers);
		//					tableWidth = model.getColumnCount() * 150;
		//					tableHeight = model.getRowCount() * 25;
		//					table.setPreferredSize(new Dimension(tableWidth, tableHeight));
		//
		//					table.setModel(model);
		//				}
		//			}
		//		});

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
				model.setRowCount(0);

				JComboBox comboBox1 = new JComboBox();

				comboBox1.addItem("LOC_method");
				comboBox1.addItem("CYLO_method");
				comboBox1.addItem("LOC_class");
				comboBox1.addItem("Nom_class");
				comboBox1.addItem("WMX_class");
				panel.add(comboBox1);


		regra1 = new JButton("LOC and CYCLO rules");
		regra1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				panel.removeAll();
				panel.revalidate();
				panel.repaint();



				JTextField v1 = new JTextField();
				panel.add(v1);
				v1.setColumns(10);

				JComboBox op = new JComboBox();
				op.addItem("and");
				op.addItem("or");
				panel.add(op);
				


				JComboBox comboBox2 = new JComboBox();

				comboBox2.addItem("LOC_method");
				comboBox2.addItem("CYLO_method");
				comboBox2.addItem("LOC_class");
				comboBox2.addItem("Nom_class");
				comboBox2.addItem("WMX_class");
				panel.add(comboBox2);
				
				
				JTextField v2 = new JTextField();
				panel.add(v2);
				v2.setColumns(10);

				labelCYCLO = new JLabel("CYCLO min");
				labelCYCLO.setFont(new Font("Tahoma", Font.PLAIN, 10));
				panel.add(labelCYCLO);


				button = new Button("submit");
				panel.add(button);

				panel.revalidate();
				panel.repaint();

				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {		
					


						//						String regra = ruleField.getText();
						String m1 = comboBox1.getSelectedItem().toString();
						int valor1 = Integer.parseInt(v1.getText());
						String oper= op.getSelectedItem().toString();
						String m2 = comboBox2.getSelectedItem().toString();
						int valor2 = Integer.parseInt(v2.getText());


								if(Rules.Regras(m1, valor1, oper, m2, valor2) == true) {
									labelTrue = new JLabel("TRUE");
									labelTrue.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelTrue.setForeground(Color.GREEN);
									panel.add(labelTrue);
									panel.revalidate();
									panel.repaint();
								
								}else{
									
									labelFalse = new JLabel("FALSE");
									labelFalse.setFont(new Font("Tahoma", Font.PLAIN, 15));
									labelFalse.setForeground(Color.RED);
									panel.add(labelFalse);
									panel.revalidate();
									panel.repaint();
								}

						String minLOC= input.getText();
						String minCYCLO = input2.getText();


						if(isNumeric(minLOC) && isNumeric(minCYCLO)) {

							int locNum = Integer.parseInt(minLOC, 10);
							int cycloNum = Integer.parseInt(minCYCLO, 10);

							if(Rules.Regra1(locNum, cycloNum)) {
								labelTrue = new JLabel("TRUE");
								labelTrue.setFont(new Font("Tahoma", Font.PLAIN, 15));
								labelTrue.setForeground(Color.GREEN);
								panel.add(labelTrue);

								System.out.println("REGRA 1 : TRUE");
								panel.revalidate();
								panel.repaint();
							}
							else {
								System.out.println("REGRA 1 : FALSE");
								labelFalse = new JLabel("FALSE");
								labelFalse.setFont(new Font("Tahoma", Font.PLAIN, 15));
								labelFalse.setForeground(Color.RED);
								panel.add(labelFalse);
								panel.revalidate();
								panel.repaint();

							}
							//
							//							if(cm.Regra2(locNum, wmcNum)) {
							//								System.out.println("REGRA 2 : TRUE");
							//							}
							//							else 
							//								System.out.println("REGRA 2 : FALSE");
							//
							//
							//
						}


					}



				});
				

			}
		});
		
		
		
		regra2 = new JButton("WMC and NOM rules");
		regra2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();

				//	DefaultTableModel model = (DefaultTableModel) table.getModel();
				//	model.setRowCount(0);

				labelWMC = new JLabel("WMC min");
				labelWMC.setFont(new Font("Tahoma", Font.PLAIN, 10));
				panel.add(labelWMC);

				input = new JTextField();
				panel.add(input);
				input.setColumns(10);

				labelNOM = new JLabel("NOM min");
				labelNOM.setFont(new Font("Tahoma", Font.PLAIN, 10));
				panel.add(labelNOM);

				input2 = new JTextField();
				panel.add(input2);
				input2.setColumns(20);

				button = new Button("submit");
				panel.add(button);

				panel.revalidate();
				panel.repaint();

				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {		

						String minWMC= input.getText();
						String minNOM = input2.getText();


						if(isNumeric(minWMC) && isNumeric(minNOM)) {

							int wmcNum = Integer.parseInt(minWMC, 10);
							int nomNum = Integer.parseInt(minNOM, 10);

							if(Rules.Regra2(wmcNum, nomNum)) {
								labelTrue = new JLabel("TRUE");
								labelTrue.setFont(new Font("Tahoma", Font.PLAIN, 15));
								labelTrue.setForeground(Color.GREEN);
								panel.add(labelTrue);

								System.out.println("REGRA 2 : TRUE");
								panel.revalidate();
								panel.repaint();
							}
							else {
								System.out.println("REGRA 2 : FALSE");
								labelFalse = new JLabel("FALSE");
								labelFalse.setFont(new Font("Tahoma", Font.PLAIN, 15));
								labelFalse.setForeground(Color.RED);
								panel.add(labelFalse);
								panel.revalidate();
								panel.repaint();

							}
							//
							//							if(cm.Regra2(locNum, wmcNum)) {
							//								System.out.println("REGRA 2 : TRUE");
							//							}
							//							else 
							//								System.out.println("REGRA 2 : FALSE");
							//
							//
							//
						}

					}

				});
				

			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		regra1.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(regra1);
		
		regra2.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(regra2);

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
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}