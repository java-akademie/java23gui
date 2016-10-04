package ch.jmildner.gui.klickmich;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlickMich2Panel extends Panel
{
	private static final long serialVersionUID = 1L;

	private Button b = new Button("klickMich");
	private TextField tf1 = new TextField("", 30);
	private TextField tf2 = new TextField("", 30);


	public KlickMich2Panel()
	{
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
		// setLayout(new BorderLayout());
		// setLayout(new GridLayout(3, 1));
		setLayout(new FlowLayout());

		add(BorderLayout.NORTH, b);
		add(BorderLayout.EAST, tf1);
		add(BorderLayout.WEST, tf2);
	}
}
