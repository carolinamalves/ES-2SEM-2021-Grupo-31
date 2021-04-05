package Grupo31.g31;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI {

	private JFrame frame;

	public final static int WIDTH = 500;
	public final static int HEIGHT = 500;

	public GUI() {

		frame = new JFrame("APP");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(new BorderLayout());
		addFrameContent();
	}
	 
	private void addFrameContent() {
		JPanel upperP = new JPanel();
		JPanel lowerP = new JPanel();

		upperP.setLayout(new FlowLayout());
		lowerP.setLayout(new GridLayout(1, 2));

		JTextField searchTF = new JTextField("", 30);
		JButton searchB = new JButton("Search");

		JTextArea textTA = new JTextArea();
		textTA.setEditable(false);
		textTA.setLineWrap(true);

		upperP.add(searchTF);
		upperP.add(searchB);
		lowerP.add(new JScrollPane(textTA));

		frame.add(upperP, BorderLayout.NORTH);
		frame.add(lowerP, BorderLayout.CENTER);
		

	}

	public void open() {
		frame.setVisible(true);
	}
}