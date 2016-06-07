package ch.jmildner.gui.klickmich;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.java_akademie.tools.MyPanel;

public class KlickMich3Panel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JButton b = new JButton("klickMich");
	private JTextField tf1 = new JTextField("", 30);
	private JTextField tf2 = new JTextField("", 30);


	public KlickMich3Panel()
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
		MyPanel mp = new MyPanel();

		mp.addEmptyRow(8, ' ', 10, 6);

		mp.addCaptionCenter("UEBERSCHRIFT", 10, 1, 6);

		mp.add(b, 20, 1, 2);
		mp.add(tf1, 30, 1, 6);
		mp.add(tf2, 40, 1, 6);

		this.add(mp);
	}
}
