package ch.jmildner.gui.klickmich;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KlickMich1 extends Frame
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new KlickMich1();
	}

	private Button b = new Button("klickMich");
	private TextField tf1 = new TextField("", 30);
	private TextField tf2 = new TextField("", 30);


	public KlickMich1()
	{
		super("KlickMich");
		makeTheLayout();
		addTheListener();
		anzeigen();
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


		/*
		 * der folgende Block ist noetig um das Programm durch anklicken des X in der rechten oberen Ecke beenden zu
		 * koennen
		 */
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}


	private void anzeigen()
	{
		setLocation(200, 100);
		pack();
		setVisible(true);
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
