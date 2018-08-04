package ch.jmildner.gui.work;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.jmildner.tools.MyPanel;

public class GuiUebung2Panel extends MyPanel
{
	private static final long serialVersionUID = 1L;

	private JButton b1 = new JButton("klickMich");
	private JButton b2 = new JButton("startDialog");
	private JTextField tf1 = new JTextField("", 30);
	private JTextField tf2 = new JTextField("", 30);
	private JTextArea ta = new JTextArea("", 10, 20);


	public GuiUebung2Panel()
	{
		this.makeTheLayout();
		this.addTheListener();
	}


	private void addTheListener()
	{
		b1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				klickmich();
			}
		});

		b2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dialog();
			}
		});
	}


	private void dialog()
	{

	}


	public void ende()
	{
		// aufraeumen();
	}


	private void klickmich()
	{
		if (tf1.getText().equals(""))
		{
			tf1.setText("Danke dass Du mich geklickt hast");
			tf2.setText("");
		}
		else
		{
			tf2.setText("Danke dass Du mich geklickt hast");
			tf1.setText("");
		}
	}


	private void makeTheLayout()
	{
		this.addEmptyGrid(8, '.', 12, 8);

		this.addCaptionCenter("UEBERSCHRIFT...", 10, 1, 10);
		JPanel p = new JPanel();

		p.setLayout(new GridLayout(3, 1));
		p.add(new JLabel("xxx"));
		p.add(new JLabel("yyy"));
		p.add(new JLabel("zzz"));
		this.add(p, 20, 1, 1, 40);
		// this.add(new JButton("xxx"),20,1,1,30);
		this.add(b1, 20, 2, 2);
		this.add(tf1, 30, 2, 7);
		this.add(tf2, 40, 2, 7);
		this.add(ta, 50, 2, 5, 60);
		this.add(new JRadioButton("aaa"), 50, 8, 1);
		this.add(new JRadioButton("bbb"), 60, 8, 1);
		this.add(new JRadioButton("ccc"), 70, 8, 1);
	}
}
