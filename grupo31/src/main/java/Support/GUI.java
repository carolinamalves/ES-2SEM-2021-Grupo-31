package Support;

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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Metrics.LOC_class;
import Metrics.LOC_method;
import Rules.CodeSmellQualityClass;
import Rules.CodeSmellQualityMethod;
import Rules.RulesGodClass;
import Rules.RulesLongMethod;

import javax.swing.JTextField;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
//@author grupo 31

public class GUI extends JFrame{

	/** The desktop dir. */
	static  File desktopDir = new File(System.getProperty("user.home"), "Desktop");

	/** The path to desktop. */
	static String pathToDesktop = desktopDir.getPath();

	/** The headers. */
	static Vector<String> headers = new Vector<String>();

	/** The model. */
	static DefaultTableModel model = null;

	/** The data. */
	static Vector<Vector<String>> data = new Vector<Vector<String>>();

	/** The Import. */
	static JButton Import;

	/** The Code smells detector. */
	static JButton CodeSmellsDetector;

	/** The j chooser. */
	static JFileChooser jChooser;

	/** The j chooser excel. */
	static JFileChooser jChooserExcel;

	/** The check rule. */
	static JCheckBox checkRule;

	/** The a. */
	static ArrayList <Method> a;

	/** The choosertitle. */
	String choosertitle;

	/** The fname. */
	static String fname;

	/** The table width. */
	static int tableWidth = 0;

	/** The table height. */
	static int tableHeight = 0;

	/** The j. */
	private Leitura_Projetos j= new Leitura_Projetos();

	/** The btn new button. */
	private JButton btnNewButton;

	/** The lbl new label. */
	private JLabel lblNewLabel;

	/** The panel. */
	private JPanel panel;

	/** The scroll pane. */
	private JScrollPane scrollPane;

	/** The table. */
	private JTable table;

	/** The btn new button 1. */
	private JButton btnNewButton_1;

	/** The panel 3. */
	JPanel panel3;

	/** The panel 4. */
	JPanel panel4;

	/** The panel carac. */
	JPanel panelCarac;

	/** The metrica L 1. */
	//God Class
	static String metricaL1;

	/** The metrica L 2. */
	static String metricaL2;

	/** The sinal L 1. */
	static String sinalL1;

	/** The sinal L 2. */
	static String sinalL2;

	/** The operador L 1. */
	static String operadorL1;

	/** The valor L 1. */
	static String valorL1;

	/** The valor L 2. */
	static String valorL2;

	/** The metrica L 3. */
	static String metricaL3;

	/** The sinal L 3. */
	static String sinalL3;

	/** The valor L 3. */
	static String valorL3;

	/** The operador L 2. */
	static String operadorL2;

	/** The met L 1. */
	static JComboBox metL1;

	/** The sin L 1. */
	static JComboBox sinL1;

	/** The val L 1. */
	static JTextField valL1;

	/** The oper L 1. */
	static JComboBox operL1;

	/** The met L 2. */
	static JComboBox metL2;

	/** The sin L 2. */
	static JComboBox sinL2;

	/** The val L 2. */
	static JTextField valL2;

	/** The oper L 2. */
	static JComboBox operL2;

	/** The met L 3. */
	static JComboBox metL3;

	/** The sin L 3. */
	static JComboBox sinL3;

	/** The val L 3. */
	static JTextField valL3;

	/** The metrica 1. */
	//Loc Method
	static String metrica1;

	/** The metrica 2. */
	static String metrica2;

	/** The sinal 1. */
	static String sinal1;

	/** The sinal 2. */
	static String sinal2;

	/** The operador 1. */
	static String operador1;

	/** The valor 1. */
	static String valor1;

	/** The valor 2. */
	static String valor2;

	/** The met G. */
	static JComboBox metG;

	/** The signal 3. */
	static JComboBox signal3;

	/** The valor 4. */
	static JTextField valor4;

	/** The op 2. */
	static JComboBox op2;

	/** The metrica G 2. */
	static JComboBox metricaG2;

	/** The signal 4. */
	static JComboBox signal4;

	/** The valor 5. */
	static JTextField valor5;

	/** The historico. */
	ArrayList<String> historico = new ArrayList<String>();

	/** The panel 2. */
	private JPanel panel2;

	public GUI() {

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

		btnNewButton_1 = new JButton("Extrair Métricas");
		btnNewButton_1.addActionListener(new ActionListener() {

			/**
			 * Action performed.
			 *
			 * @param e the e
			 */
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


					j.lista(jChooser.getSelectedFile().toString());

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
		Import = new JButton("Selecionar Ficheiro Excel");
		Import.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(Import, BorderLayout.EAST);
		Import.addActionListener(new ActionListener() {

			/**
			 * Action performed.
			 *
			 * @param arg0 the arg 0
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {

				jChooserExcel = new JFileChooser(); 
				jChooserExcel.setDialogTitle(choosertitle);
				jChooserExcel.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jChooserExcel.setAcceptAllFileFilterUsed(false);
				jChooserExcel.showOpenDialog(null);

				File file = jChooserExcel.getSelectedFile();

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

		btnNewButton = new JButton("Definir Regras");
		btnNewButton.addActionListener(new ActionListener() {

			/**
			 * Action performed.
			 *
			 * @param e the e
			 */
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setColumnCount(0);

				panel.revalidate();
				panel.repaint();

				JButton godC = new JButton("Regras GodClass");
				godC.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						panel2.removeAll();

						metL1 = new JComboBox();
						metL1.addItem("LOC_class");
						metL1.addItem("NOM_class");
						metL1.addItem("WMC_class");
						panel2.add(metL1);

						sinL1 = new JComboBox();
						sinL1.addItem(">");
						sinL1.addItem("<");
						panel2.add(sinL1);

						valL1 = new JTextField();
						panel2.add(valL1);
						valL1.setColumns(10);

						operL1 = new JComboBox();
						operL1.addItem("NULL");
						operL1.addItem("AND");
						operL1.addItem("OR");
						panel2.add(operL1);

						metL2 = new JComboBox();
						metL2.addItem("NULL");
						metL2.addItem("LOC_class");
						metL2.addItem("NOM_class");
						metL2.addItem("WMC_class");
						panel2.add(metL2);

						sinL2 = new JComboBox();
						sinL2.addItem("NULL");
						sinL2.addItem(">");
						sinL2.addItem("<");
						panel2.add(sinL2);

						valL2 = new JTextField();
						panel2.add(valL2);
						valL2.setColumns(10);

						operL2 = new JComboBox();
						operL2.addItem("NULL");
						operL2.addItem("AND");
						operL2.addItem("OR");
						panel2.add(operL2);

						metL3 = new JComboBox();
						metL3.addItem("NULL");
						metL3.addItem("LOC_class");
						metL3.addItem("NOM_class");
						metL3.addItem("WMC_class");
						panel2.add(metL3);

						sinL3 = new JComboBox();
						sinL3.addItem("NULL");
						sinL3.addItem(">");
						sinL3.addItem("<");
						panel2.add(sinL3);

						valL3 = new JTextField();
						panel2.add(valL3);
						valL3.setColumns(10);

						panel2.revalidate();
						panel2.repaint();
					}
				});

				godC.setBackground(Color.LIGHT_GRAY);
				panel.add(godC);

				JButton submitGodC = new  JButton ("Submeter God Class");
				submitGodC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						metricaL1 = metL1.getSelectedItem().toString();
						sinalL1 = sinL1.getSelectedItem().toString();
						valorL1 = valL1.getText();
						operadorL1 = operL1.getSelectedItem().toString();
						metricaL2 = metL2.getSelectedItem().toString();
						sinalL2 = sinL2.getSelectedItem().toString();
						valorL2 = valL2.getText();
						operadorL2 = operL2.getSelectedItem().toString();
						metricaL3 = metL3.getSelectedItem().toString();
						sinalL3 = sinL3.getSelectedItem().toString();
						valorL3 = valL3.getText();

						if (operadorL1 == "NULL") {
							String rule = (metricaL1 + " " + sinalL1 + " " + valorL1);
							historico.add(rule);							

							checkRule = new JCheckBox(rule); 

							panel3.add(checkRule);
							panel3.revalidate();
							panel3.repaint();
						}

						if (operadorL1 != "NULL" && operadorL2 == "NULL") {
							String rule = (metricaL1 + " " + sinalL1 + " " + valorL1 + " " + operadorL1 + " " + metricaL2 + " " + sinalL2 + " " + valorL2);
							historico.add(rule);

							checkRule = new JCheckBox(rule);

							panel3.add(checkRule);
							panel3.revalidate();
							panel3.repaint();
						}

						if (operadorL1 != "NULL" && operadorL2 != "NULL") {
							String rule = (metricaL1 + " " + sinalL1 + " " + valorL1 + " " + operadorL1 + " " + metricaL2 + " " + sinalL2 + " " + valorL2 + 
									" " + operadorL2 + " " + metricaL3 + " " + sinalL3 + " " + valorL3 );
							historico.add(rule);

							checkRule = new JCheckBox(rule);

							panel3.add(checkRule);
							panel3.revalidate();
							panel3.repaint();
						}								
					}
				});

				submitGodC.setBackground(Color.LIGHT_GRAY);
				panel.add(submitGodC);

				JButton longM = new JButton("Regra LongMethod");
				longM.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panel2.removeAll();

						metG = new JComboBox();
						metG.addItem("LOC_method");
						metG.addItem("CYCLO_method");
						panel2.add(metG);

						signal3 = new JComboBox();
						signal3.addItem(">");
						signal3.addItem("<");
						panel2.add(signal3);


						valor4 = new JTextField();
						panel2.add(valor4);
						valor4.setColumns(10);

						op2 = new JComboBox();
						op2.addItem("NULL");
						op2.addItem("AND");
						op2.addItem("OR");
						panel2.add(op2);

						metricaG2 = new JComboBox();
						metricaG2.addItem("NULL");
						metricaG2.addItem("LOC_method");
						metricaG2.addItem("CYCLO_method");
						panel2.add(metricaG2);

						signal4 = new JComboBox();
						signal4.addItem("NULL");
						signal4.addItem(">");
						signal4.addItem("<");
						panel2.add(signal4);

						valor5 = new JTextField();
						panel2.add(valor5);
						valor5.setColumns(10);

						panel2.revalidate();
						panel2.repaint();
					}
				});

				longM.setBackground(Color.LIGHT_GRAY);
				panel.add(longM);

				JButton submitLongMethod = new JButton("Submeter Long Method");
				submitLongMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						metrica1 = metG.getSelectedItem().toString();
						sinal1 = signal3.getSelectedItem().toString();
						valor1 = valor4.getText();
						operador1 = op2.getSelectedItem().toString();
						metrica2 = metricaG2.getSelectedItem().toString();
						sinal2 = signal4.getSelectedItem().toString();
						valor2 = valor5.getText();

						if (operador1 == "NULL") {
							String rule = (metrica1 + " " + sinal1 + " " + valor1);
							historico.add(rule);							

							checkRule = new JCheckBox(rule); 

							panel3.add(checkRule);
							panel3.revalidate();
							panel3.repaint();
						}

						if (operador1 != "NULL") {
							String rule = (metrica1 + " " + sinal1 + " " + valor1 + " " + operador1 + " " + metrica2 + " " + sinal2 + " " + valor2);
							historico.add(rule);

							checkRule = new JCheckBox(rule);

							panel3.add(checkRule);
							panel3.revalidate();
							panel3.repaint();
						}
					}
				});
				submitLongMethod.setBackground(Color.LIGHT_GRAY);
				panel.add(submitLongMethod);

				JButton detectCodeSmell = new JButton ("Detectar Code Smell");
				detectCodeSmell.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String regra = checkRule.getActionCommand();

						if (regra.indexOf("method") != -1) {
							RulesLongMethod.rules(checkRule.getActionCommand());
						}

						if (regra.indexOf("class") != -1) {
							RulesGodClass.rules(checkRule.getActionCommand());
						}
					}
				});
				detectCodeSmell.setBackground(Color.LIGHT_GRAY);
				panel3.add(detectCodeSmell);

				JButton updateHistorico = new JButton("Guardar Regras");
				updateHistorico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						history.updateHistoric(desktopDir+"\\historico.txt", historico);	
					}

				});
				updateHistorico.setBackground(Color.LIGHT_GRAY);
				panel.add(updateHistorico);

				JButton verHistorico = new JButton("Carregar histórico");
				verHistorico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						ArrayList<String> carregar = history.viewHistoric(desktopDir+"\\historico.txt");

						for (String s : carregar) {

							checkRule = new JCheckBox(s); 

							panel3.add(checkRule);

							panel3.revalidate();
							panel3.repaint();
						}
					}
				});
				JButton analyseValue = new JButton("Analisar Qualidade de CodeSmells"); 
				analyseValue.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String regra = checkRule.getActionCommand();

						if (regra.indexOf("method") != -1) {
							RulesLongMethod.rules(checkRule.getActionCommand());
						}

						if (regra.indexOf("class") != -1) {
							RulesGodClass.rules(checkRule.getActionCommand());
						}
						try {
							jChooserExcel = new JFileChooser(); 
							jChooserExcel.setDialogTitle(choosertitle);
							jChooserExcel.setFileSelectionMode(JFileChooser.FILES_ONLY);
							jChooserExcel.setAcceptAllFileFilterUsed(false);
							jChooserExcel.showOpenDialog(null);

							File file = jChooserExcel.getSelectedFile();

							if (regra.indexOf("class") != -1){

								CodeSmellQualityClass.compareValues(file.toString(), desktopDir+"\\src_metrics.xlsx");

								String vn = String.valueOf(CodeSmellQualityClass.VN);
								String fn = String.valueOf(CodeSmellQualityClass.FN);
								String vp = String.valueOf(CodeSmellQualityClass.VP);
								String fp = String.valueOf(CodeSmellQualityClass.FP);

								JLabel VN = new JLabel("Verdadeiros Negativos: " + vn);
								JLabel VP = new JLabel("Verdadeiros Positivos: " + vp);
								JLabel FP = new JLabel("Falsos Positivos: " + fp);
								JLabel FN = new JLabel("Falsos Negativos: " + fn);

								panel4.add(VN);
								panel4.add(VP);
								panel4.add(FP);
								panel4.add(FN);

								panel4.revalidate();
								panel4.repaint();

							}
							if (regra.indexOf("method") != -1) {		
								CodeSmellQualityMethod.compareValues(file.toString(), desktopDir+"\\src_metrics.xlsx");

								String vn = String.valueOf(CodeSmellQualityMethod.VN);
								String fn = String.valueOf(CodeSmellQualityMethod.FN);
								String vp = String.valueOf(CodeSmellQualityMethod.VP);
								String fp = String.valueOf(CodeSmellQualityMethod.FP);

								JLabel VN = new JLabel("Verdadeiros Negativos: " + vn);
								JLabel VP = new JLabel("Verdadeiros Positivos: " + vp);
								JLabel FP = new JLabel("Falsos Positivos: " + fp);
								JLabel FN = new JLabel("Falsos Negativos: " + fn);

								panel4.add(VN);
								panel4.add(VP);
								panel4.add(FP);
								panel4.add(FN);

								panel4.revalidate();
								panel4.repaint();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}	
				});
				analyseValue.setBackground(Color.LIGHT_GRAY);
				panel3.add(analyseValue);

				verHistorico.setBackground(Color.LIGHT_GRAY);
				panel.add(verHistorico);

				JButton apagarHistorico = new JButton("Apagar Histórico");
				apagarHistorico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						history.clear(desktopDir+"\\historico.txt");

						panel3.removeAll();
						panel3.revalidate();
						panel3.repaint();
					}
				});
				apagarHistorico.setBackground(Color.LIGHT_GRAY);
				panel.add(apagarHistorico);
			}		
		});

		btnNewButton.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(btnNewButton);

		JButton caracGerais = new JButton("Características Gerais");
		caracGerais.addActionListener(new ActionListener() {

			/**
			 * Action performed.
			 *
			 * @param e the e
			 */
			public void actionPerformed(ActionEvent e) {

				JLabel numP = new JLabel ("Número de Packages: " + String.valueOf(Leitura_Projetos.packages.size()));
				JLabel numC = new JLabel ("Número de Classes: " + String.valueOf(Leitura_Projetos.contadorClasses));
				JLabel numM = new JLabel ("Número de Métodos: " + String.valueOf(LOC_method.numMethods));
				JLabel numL = new JLabel ("Número de Linhas: " + String.valueOf(LOC_class.numLines));	

				panelCarac.add(numP);
				panelCarac.add(numC);
				panelCarac.add(numM);
				panelCarac.add(numL);

				panelCarac.revalidate();
				panelCarac.repaint();
			}
		});

		caracGerais.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(caracGerais);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		getContentPane().add(scrollPane, gbc_scrollPane);

		panelCarac = new JPanel();
		GridBagConstraints gbc_panelCarac = new GridBagConstraints();
		gbc_panelCarac.insets = new Insets(0, 0, 5, 0);
		gbc_panelCarac.fill = GridBagConstraints.BOTH;
		gbc_panelCarac.gridx = 0;
		gbc_panelCarac.gridy = 4;
		getContentPane().add(panelCarac, gbc_panelCarac);

		table = new JTable();
		scrollPane.setViewportView(table);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		getContentPane().add(panel, gbc_panel);

		panel2 = new JPanel();
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.insets = new Insets(0, 0, 5, 0);
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.gridx = 0;
		gbc_panel2.gridy = 6;
		getContentPane().add(panel2, gbc_panel2);
		setSize(800, 700);
		setResizable(true);
		setVisible(true);

		panel3 = new JPanel();
		GridBagConstraints gbc_panel3 = new GridBagConstraints();
		gbc_panel3.insets = new Insets(0, 0, 5, 0);
		gbc_panel3.fill = GridBagConstraints.BOTH;
		gbc_panel3.gridx = 0;
		gbc_panel3.gridy = 7;
		getContentPane().add(panel3, gbc_panel3);
		setSize(800, 700);
		setResizable(true);
		setVisible(true);

		panel4 = new JPanel();
		GridBagConstraints gbc_panel4 = new GridBagConstraints();
		gbc_panel4.insets = new Insets(0, 0, 5, 0);
		gbc_panel4.fill = GridBagConstraints.BOTH;
		gbc_panel4.gridx = 0;
		gbc_panel4.gridy = 8;
		getContentPane().add(panel4, gbc_panel4);
		setSize(800, 700);
		setResizable(true);
		setVisible(true);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main (String args[]) {
		new GUI();
	}

	/**
	 * Checks if is numeric.
	 *
	 * @param strNum the str num
	 * @return true, if is numeric
	 */
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