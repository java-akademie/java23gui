package ch.jmildner.gui.project;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.jmb.tools.SwingTools;


@SuppressWarnings("deprecation")
public class SwingPanel extends JPanel
{

	private static final long serialVersionUID = 1L;

	JButton b1 = new JButton("bu1xxxxxxxxx");
	JButton b2 = new JButton("bu2xxxxxxxxx");
	JButton b3 = new JButton("bu3xxxxxxxxx");
	JButton b4 = new JButton("x");
	JButton b5 = new JButton("y");
	JButton b6 = new JButton("z");
	JTextField tf1 = new JTextField("", 5);


	public SwingPanel()
	{
		makeTheLayout();
		addTheListener();
	}


	private void addTheListener()
	{
		b1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				b1Verarbeiten();
			}
		});

		b2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				b2Verarbeiten();
			}
		});

		b3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				b3Verarbeiten();
			}
		});
	}


	private void b1Verarbeiten()
	{
		tf1.setText("b1 gedrueckt");
	}


	private void b2Verarbeiten()
	{
		tf1.setText("b2 gedrueckt");
	}


	private void b3Verarbeiten()
	{
		tf1.setText("b3 gedrueckt");
	}


	private void makeTheLayout()
	{
		Container p1 = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		p1.setLayout(gbl);

		SwingTools.addComponent(p1, gbl, b1, 1, 1, 1, 1, 1, 4);
		SwingTools.addComponent(p1, gbl, b2, 1, 2, 1, 1, 1, 5);
		SwingTools.addComponent(p1, gbl, b3, 1, 3, 1, 1, 1, 6);
		SwingTools.addComponent(p1, gbl, tf1, 2, 1, 3, 1, 1, 0);
		SwingTools.addComponent(p1, gbl, b4, 3, 1, 1, 1, 0, 6);
		SwingTools.addComponent(p1, gbl, b5, 4, 2, 1, 1, 0, 5);
		SwingTools.addComponent(p1, gbl, b6, 5, 3, 1, 1, 0, 4);

		add(p1);
	}
}
