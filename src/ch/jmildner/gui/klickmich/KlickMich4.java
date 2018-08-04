package ch.jmildner.gui.klickmich;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ch.jmildner.tools.MyPanel;

public class KlickMich4 extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new KlickMich4();
	}

	private JButton pack = new JButton("PACK");
	private JButton klick = new JButton("klickMich");
	private JButton ende = new JButton("ENDE");
	private JTextField tf1 = new JTextField("", 30);
	private JTextField tf2 = new JTextField("", 30);

	private JTextField tf3 = new JTextField("", 30);
	private JRadioButton rbMasculin = new JRadioButton("maskulin",
			true);
	private JRadioButton rbFeminin = new JRadioButton("feminin");

	private JRadioButton rbNeutral = new JRadioButton("neutral");
	private JCheckBox cbSchinken = new JCheckBox("schinken");
	private JCheckBox cbKaese = new JCheckBox("kaese");

	private JCheckBox cbOliven = new JCheckBox("oliven");


	public KlickMich4()
	{
		super("KlickMich4");
		makeTheLayout();
		addTheListener();
		anzeigen();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == ende)
		{
			System.exit(0);
		}
		if (e.getSource() == klick)
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
		if (e.getSource() == pack)
		{
			tf1.setText("");
			tf2.setText("");

			pack();

			new Thread()
			{
				@Override
				public void run()
				{
					pack.setVisible(false);

					for (int i = 1; i <= 50000; i++)
					{
						System.out.println(i);
					}

					pack.setVisible(true);
				}
			}.start();

			StringBuilder erg = new StringBuilder();

			if (rbMasculin.isSelected())
			{
				erg = erg.append("masculin ");
			}

			if (rbFeminin.isSelected())
			{
				erg = erg.append("feminin ");
			}

			if (rbNeutral.isSelected())
			{
				erg = erg.append("neutral ");
			}

			if (cbKaese.isSelected())
			{
				erg = erg.append("kaese ");
			}

			if (cbSchinken.isSelected())
			{
				erg = erg.append("schinken ");
			}

			if (cbOliven.isSelected())
			{
				erg = erg.append("oliven ");
			}

			tf3.setText(erg + "");
		}
	}


	private void addTheListener()
	{
		klick.addActionListener(this);
		pack.addActionListener(this);
		ende.addActionListener(this);
	}


	private void anzeigen()
	{
		setLocation(200, 100);
		pack();
		setVisible(true);

		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}


	private void makeTheLayout()
	{
		MyPanel mp = new MyPanel();

		mp.addEmptyRow(8, '.', 1, 6);

		mp.addCaptionCenter("UEBERSCHRIFT", 10, 1, 6);

		mp.add(klick, 20, 1, 2);
		mp.add(ende, 20, 3, 2);
		mp.add(pack, 20, 5, 2);
		mp.add(tf1, 30, 1, 6);
		mp.add(tf2, 40, 1, 6);
		mp.add(tf3, 45, 1, 6);

		ButtonGroup g = new ButtonGroup();
		g.add(rbMasculin);
		g.add(rbFeminin);
		g.add(rbNeutral);
		mp.add(rbMasculin, 50, 1, 1);
		mp.add(rbFeminin, 60, 1, 1);
		mp.add(rbNeutral, 70, 1, 1);

		mp.add(cbKaese, 50, 4, 1);
		mp.add(cbSchinken, 60, 4, 1);
		mp.add(cbOliven, 70, 4, 1);

		add(mp);
	}
}
