package ch.scjd.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import ch.jmildner.tools.MyPanel;

public class Rechner extends JDialog
{
	private static final long serialVersionUID = 1L;

	JButton add = new JButton("+");
	JButton sub = new JButton("-");
	JButton mul = new JButton("*");
	JButton div = new JButton("/");
	JButton ende = new JButton("ende");

	JTextField a = new JTextField("", 10);
	JTextField b = new JTextField("", 10);
	JTextField e = new JTextField("", 10);


	public Rechner()
	{
		// super("RECHNER");
		makeTheLayout();
		addTheListener();
		showTheLayout();
	}


	private void add()
	{
		double x = makeDouble(a.getText());
		double y = makeDouble(b.getText());
		e.setText("" + (x + y));
	}


	private void addTheListener()
	{
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				ende();
			}
		});

		ende.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				ende();
			}
		});

		add.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				add();
			}
		});

		sub.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				sub();
			}
		});

		mul.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				mul();
			}
		});

		div.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				div();
			}
		});
	}


	private void div()
	{
		double x = makeDouble(a.getText());
		double y = makeDouble(b.getText());
		e.setText("" + (x / y));
	}


	public void ende()
	{
		this.setVisible(false);
	}


	private double makeDouble(String s)
	{
		if (s.equals(""))
		{
			return 0;
		}
		else
		{
			return Double.parseDouble(s);
		}
	}


	private void makeTheLayout()
	{
		MyPanel mp = new MyPanel();
		mp.add(a, 20, 1, 4);
		mp.add(b, 30, 1, 4);
		mp.add(add, 40, 1, 1);
		mp.add(sub, 40, 2, 1);
		mp.add(mul, 40, 4, 1);
		mp.add(div, 40, 5, 1);
		mp.add(e, 50, 1, 4);

		mp.add(ende, 60, 4, 1);

		this.add(mp);
	}


	private void mul()
	{
		double x = makeDouble(a.getText());
		double y = makeDouble(b.getText());
		e.setText("" + (x * y));
	}


	private void showTheLayout()
	{
		this.setTitle("rechner");
		this.setModal(false);
		this.setAlwaysOnTop(true);
		this.setLocation(450, 250);
		this.pack();
		this.setVisible(false);
	}


	private void sub()
	{
		double x = makeDouble(a.getText());
		double y = makeDouble(b.getText());
		e.setText("" + (x - y));
	}
}
