package ch.jmildner.gui.rechner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.java_akademie.tools.MyPanel;

public class RechnerPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private JButton add = new JButton("+");
	private JButton sub = new JButton("-");
	private JButton mul = new JButton("*");
	private JButton div = new JButton("/");
	private JButton clear = new JButton("clear");
	private JButton ende = new JButton("ende");
	private JTextField w1 = new JTextField("", 15);
	private JTextField w2 = new JTextField("", 15);
	private JTextField erg = new JTextField("", 15);


	public RechnerPanel(int version)
	{
		makeTheLayout(version);
		addTheListener();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		double wert1 = 0, wert2 = 0;

		if (e.getSource() == add)
		{
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
			erg.setText("" + (wert1 + wert2));
		}

		if (e.getSource() == ende)
		{
			System.exit(0);
		}
		if (e.getSource() == clear)
		{
			w1.setText("");
			w2.setText("");
			erg.setText("");
		}
	}


	private void addTheListener()
	{
		ende.addActionListener(this);
		clear.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
	}


	private void makeTheLayout(int version)
	{
		switch (version)
		{
			case 0:
				makeTheLayout_0();
				break;
			case 1:
				makeTheLayout_1();
				break;
			default:
				break;
		}
	
	}


	private void makeTheLayout_0()
	{
		this.setLayout(new BorderLayout());

		this.add(new JLabel("Rechner"), BorderLayout.NORTH);

		JPanel pc = new JPanel();
		pc.setLayout(new GridLayout(4, 1));

		JPanel pw1 = new JPanel();
		pw1.add(new JLabel("Wert 1: "));
		pw1.add(w1);
		pc.add(pw1);


		JPanel pw2 = new JPanel();
		pw2.add(new JLabel("Wert 2: "));
		pw2.add(w2);
		pc.add(pw2);

		JPanel pbuttons = new JPanel();
		pbuttons.add(add);
		pbuttons.add(sub);
		pbuttons.add(mul);
		pbuttons.add(div);
		pc.add(pbuttons);

		JPanel perg = new JPanel();
		perg.add(new JLabel("Ergebnis: "));
		perg.add(erg);
		pc.add(perg);

		this.add(pc);

		JPanel ps = new JPanel();
		ps.setLayout(new FlowLayout());
		ps.add(clear);
		ps.add(ende);

		this.add(ps, BorderLayout.SOUTH);
	}


	private void makeTheLayout_1()
	{
		boolean testZeile = false;

		MyPanel mp = new MyPanel(5, 12, testZeile);

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
		mp.add(clear, zeile, 2, 2, 1);
		mp.add(ende, zeile, 4, 2, 1);

		this.add(mp);
	}

}
