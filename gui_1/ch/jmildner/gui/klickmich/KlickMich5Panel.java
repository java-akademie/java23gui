package ch.jmildner.gui.klickmich;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.java_akademie.tools.MyPanel;

public class KlickMich5Panel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton b1 = new JButton("klickMich");
	private JButton b2 = new JButton("nein klickMich");
	private JTextField tf1 = new JTextField("", 30);
	private JTextField tf2 = new JTextField("", 30);


	public KlickMich5Panel()
	{
		makeTheLayout();
		addTheListener();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == b1)
		{
			doAction("button 1");
			return;
		}

		if (e.getSource() == b2)
		{
			doAction("button 2");
			return;
		}
	}


	private void addTheListener()
	{
		b1.addActionListener(this);
		b2.addActionListener(this);
	}


	private void doAction(String s)
	{
		if (tf1.getText().equals(""))
		{
			tf1.setText(s + " - danke dass Du mich geklickt hast");
			tf2.setText("");
		}
		else
		{
			tf2.setText(s + " - danke dass Du mich geklickt hast");
			tf1.setText("");
		}
	}


	private void makeTheLayout()
	{
		MyPanel mp = new MyPanel(6, 8, false);

		mp.addCaptionCenter("UEBERSCHRIFT", 1, 1, 6);

		mp.add(b1, 20, 1, 2);
		mp.add(b2, 20, 3, 2);
		mp.add(tf1, 30, 1, 6);
		mp.add(tf2, 40, 1, 6);
		
		this.add(mp);
	}


}
