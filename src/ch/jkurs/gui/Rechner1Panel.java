package ch.jkurs.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Rechner1Panel extends JPanel implements ActionListener
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


	public Rechner1Panel()
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
			erg.setText("" + _Tools.runden(wert1 + wert2, 4));
		}

		if (e.getSource() == sub)
		{
			erg.setText("" + _Tools.runden(wert1 - wert2, 4));
		}

		if (e.getSource() == mul)
		{
			erg.setText("" + _Tools.runden(wert1 * wert2, 8));
		}

		if (e.getSource() == div)
		{
			erg.setText("" + _Tools.runden(wert1 / wert2, 8));
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
		this.setLayout(new BorderLayout());

		this.add(new JLabel("                   R  E  C  H  N  E  R "), BorderLayout.NORTH);

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
		ps.add(random);
		ps.add(clear);
		ps.add(ende);

		this.add(ps, BorderLayout.SOUTH);
	}

}
