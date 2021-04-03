package Grupo31.g31;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class ImportExcel extends GUI{

	public static void main(String[]args){
		JFrame frame = new JFrame();
		frame.setLayout(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Select File for Linking");
				frame.setSize(400, 100);
				Container container = frame.getContentPane();
				container.setLayout(new GridBagLayout());

				final JTextField text=new JTextField(20);

				JButton b=new JButton("Select File");
				text.setBounds(20,20,120,20);
				b.setBounds(150,20,80,20);

				// b.setText("<html><font color="blue">Select File</font></html>");
				b.setHorizontalAlignment(SwingConstants.LEFT);
				//b.setBorderPainted(false);
				//b.setOpaque(false);
				// b.setBackground(Color.lightGray);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						JFileChooser fc = new JFileChooser();
						fc.addChoosableFileFilter(new OnlyExt());

						int returnval = fc.showOpenDialog(null);
						if (returnval == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();
							text.setText(file.getPath());
						}
					}
				});
				container.add(text);
				container.add(b);
				frame.setVisible(true);
	}
}

class OnlyExt extends javax.swing.filechooser.FileFilter{
	public boolean accept(File file) {
		if (file.isDirectory()) return false;
		String name = file.getName().toLowerCase();
		return (name.endsWith(".xls"));
	}
	public String getDescription() { return "Excel ( *.xls)"; }
}
