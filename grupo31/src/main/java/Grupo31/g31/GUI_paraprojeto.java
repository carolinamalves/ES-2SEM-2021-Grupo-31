package Grupo31.g31;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;


	public class GUI_paraprojeto extends JPanel
	   implements ActionListener {
	   JButton go;
	   static JFileChooser chooser;
	   String choosertitle;
	   Leitura_Projetos j= new Leitura_Projetos();

	   
	  public GUI_paraprojeto() {
	    go = new JButton("importar projeto");
	    go.addActionListener(this);
	    add(go);
	   }

	  public void actionPerformed(ActionEvent e) {
	    int result;
	        
	    chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle(choosertitle);
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    //
	    // disable the "All files" option.
	    //
	    chooser.setAcceptAllFileFilterUsed(false);
	    //    
	    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
	      System.out.println("getCurrentDirectory(): " 
	         +  chooser.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " 
	         +  chooser.getSelectedFile());
	      j.lista(  chooser.getSelectedFile().toString());
			j.getFicheiro();
	    }
	    else {
	      System.out.println("No Selection ");
	      }
	     }
	   
	  public Dimension getPreferredSize(){
	    return new Dimension(200, 200);
	    }
	    
	  public static void main(String s[]) {
	    JFrame frame = new JFrame("");
	    GUI_paraprojeto panel = new GUI_paraprojeto();
	    frame.addWindowListener(
	      new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	          System.exit(0);
	          }
	        }
	      );
	    frame.getContentPane().add(panel,"Center");
	    frame.setSize(panel.getPreferredSize());
	    frame.setVisible(true);
	 }	  
	}