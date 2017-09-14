package ch.scjd.project;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ch.jmb.tools.SwingTools;

@SuppressWarnings("deprecation")
public class AnzeigePanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private AdressDB adb;

	private JTable table = new JTable();
	private JButton b1 = new JButton("button");


	public AnzeigePanel(AdressDB adb)
	{
		this.adb = adb;

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
	}


	private void b1Verarbeiten()
	{
		int row = table.getSelectedRow();

		if (row < 0)
		{
			System.out.println("keine Auswahl getroffen");
		}
		else
		{
			try
			{
				System.out.println(adb.getAdresse(row).getID()
						+ " ausgewaehlt");
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
			table.clearSelection();
		}
	}


	private void makeTheLayout()
	{
		Container p1 = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		p1.setLayout(gbl);

		table = new JTable(new TableModel(adb));
		JPanel tabPanel = new JPanel();
		tabPanel.add(new JScrollPane(table));

		SwingTools.addComponent(p1, gbl, tabPanel, 1, 1, 3, 1, 0, 0);
		SwingTools.addComponent(p1, gbl, b1, 2, 2, 1, 1, 0, 0);

		add(p1);
	}
}
