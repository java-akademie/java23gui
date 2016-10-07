package ch.jkurs.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.java_akademie.tools.MyPanel;

public class Rechner2Panel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private JButton add = new JButton("+");
	private JButton sub = new JButton("-");
	private JButton mul = new JButton("*");
	private JButton div = new JButton("/");
	private JButton random = new JButton("random");
	private JButton clear = new JButton("clear");
	private JButton ende = new JButton("ende");
	private JTextField w1 = new JTextField("", 15);
	private JTextField w2 = new JTextField("", 15);
	private JTextField erg = new JTextField("", 15);


	public Rechner2Panel()
	{
		makeTheLayout();
		addTheListener();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		double wert1 = 0, wert2 = 0;

		if (e.getSource() == ende)
		{
			System.exit(0);
		}

		if (e.getSource() == clear)
		{
			w1.setText("");
			w2.setText("");
			erg.setText("");
			return;
		}

		if (e.getSource() == random)
		{
			w1.setText("" + _Tools.getRandom(10000,2));
			w2.setText("" + _Tools.getRandom(5000,2));
			erg.setText("");
			return;
		}

		try
		{
			wert1 = Double.parseDouble(w1.getText());
			wert2 = Double.parseDouble(w2.getText());
		}
		catch (Exception ex)
		{
			erg.setText("fehlerhafte eingabe");
			return;
		}

		if (e.getSource() == add)
		{
			erg.setText("" + _Tools.runden(wert1 + wert2, 2));
		}

		if (e.getSource() == sub)
		{
			erg.setText("" + _Tools.runden(wert1 - wert2, 2));
		}

		if (e.getSource() == mul)
		{
			erg.setText("" + _Tools.runden(wert1 * wert2, 4));
		}

		if (e.getSource() == div)
		{
			erg.setText("" + _Tools.runden(wert1 / wert2, 5));
		}

	}


	private void addTheListener()
	{
		random.addActionListener(this);
		ende.addActionListener(this);
		clear.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
	}


	private void makeTheLayout()
	{
		boolean testZeile = false;

		MyPanel mp = new MyPanel(5, 14, testZeile);

		int zeile = testZeile ? 1 : 0;

		// zeile 1
		zeile++;
		mp.addCaptionCenter("RECHNER", zeile, 1, 5);

		// zeile 2
		zeile++;
		mp.addLabel("Wert1:", zeile, 1, 1);
		mp.add(w1, zeile, 2, 4, 1);

		// zeile 3
		zeile++;
		mp.addLabel("Wert2:", zeile, 1, 1);
		mp.add(w2, zeile, 2, 4, 1);

		// zeile 4
		zeile++;
		mp.add(add, zeile, 2, 1, 1);
		mp.add(sub, zeile, 3, 1, 1);
		mp.add(mul, zeile, 4, 1, 1);
		mp.add(div, zeile, 5, 1, 1);

		// zeile 5
		zeile++;
		mp.addLabel("Ergebnis:", zeile, 1, 1);
		mp.add(erg, zeile, 2, 4, 1);

		// zeile 6
		zeile++;
		mp.add(random, zeile, 3, 1, 1);
		mp.add(clear, zeile, 4, 1, 1);
		mp.add(ende, zeile, 5, 1, 1);

		this.add(mp);
	}

}
