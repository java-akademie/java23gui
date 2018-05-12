package ch.jmildner.gui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import ch.jmildner.tools.MyPanel;



public class DialogPanel  extends MyPanel
{
	private static final long serialVersionUID = 1L;

	private JButton b1 = new JButton("klickMich");
	private JButton b2 = new JButton("startDialog");
	private JTextField tf1 = new JTextField("", 30);
	private JTextField tf2 = new JTextField("", 30);


	public DialogPanel()
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
		new About();
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
		this.addEmptyRow(8, ' ', 10, 6);

		this.addCaptionCenter("UEBERSCHRIFT", 10, 1, 6);

		this.add(b1, 20, 1, 2);
		this.add(b2, 20, 5, 2);
		this.add(tf1, 30, 1, 6);
		this.add(tf2, 40, 1, 6);
	}
}
