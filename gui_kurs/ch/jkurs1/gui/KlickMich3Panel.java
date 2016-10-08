package ch.jkurs1.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KlickMich3Panel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private _Layout layout;

	private JButton b = new JButton("klickMich");
	private JTextField tf1 = new JTextField("", 30);
	private JTextField tf2 = new JTextField("", 30);


	public KlickMich3Panel(_Layout layout)
	{
		this.layout = layout;
		makeTheLayout();
		addTheListener();
	}


	private void addTheListener()
	{
		b.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
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
		});
	}


	private void makeTheLayout()
	{
		switch (layout)
		{
			case flow:
				setLayout(new FlowLayout());
				add(b);
				add(tf1);
				add(tf2);
				break;
			case grid:
				setLayout(new GridLayout(3, 1));
				add(b);
				add(tf1);
				add(tf2);
				break;
			case border:
				setLayout(new BorderLayout());
				add(BorderLayout.NORTH, b);
				add(BorderLayout.EAST, tf1);
				add(BorderLayout.WEST, tf2);
				break;
		}
	}

}
