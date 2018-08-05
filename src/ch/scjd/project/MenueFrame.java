package ch.scjd.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MenueFrame extends JFrame implements ActionListener,
		MenuStructure
{
	private static final long serialVersionUID = 1L;

	private JPanel contentPanel;

	AdressDB adb;



	public MenueFrame() throws Exception
	{
		super("Menue");

		connectDatabase();
		makeTheLayout();
		addTheListener();
		showTheLayout();
	}


	@Override
	public void actionPerformed(ActionEvent ae)
	{

		if (ae.getActionCommand().equals(RECHNER))
		{
			// updateContentPanel
			new Rechner();
			return;
		}

		if (ae.getActionCommand().equals(TIPPS))
		{
			this.updateContentPanel(new SwingPanel());
			return;
		}

		if (ae.getActionCommand().equals(ABOUT))
		{
			updateContentPanel(ABOUT);
			return;
		}

		if (ae.getActionCommand().equals(OPEN))
		{
			openDatabase();
			return;
		}

		if (ae.getActionCommand().equals(CLOSE))
		{
			closeDatabase();
			return;
		}

		if (ae.getActionCommand().equals(MAKE_TESTDATA))
		{
			makeTestdata();
			return;
		}

		if (ae.getActionCommand().equals(ANZEIGEN))
		{
			anzeigen();
			return;
		}

		if (ae.getActionCommand().equals(SORTIEREN))
		{
			sortieren();
			return;
		}

		if (ae.getActionCommand().equals(ALLE_ANZEIGEN))
		{
			updateContentPanel(new AnzeigePanel(adb));
			return;
		}

		if (ae.getActionCommand().equals(BEARBEITEN))
		{
			bearbeiten();
			return;
		}

		if (ae.getActionCommand().equals(EXIT))
		{
			beenden();
		}
	}


	private void addTheListener()
	{
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}


	private void anzeigen()
	{
		String s = null;

		try
		{
			s = adb.adressenAnzeigen();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}

		updateContentPanel(s);
	}


	private void bearbeiten()
	{
		System.out.println("bearbeiten");
		updateContentPanel("bearbeiten...");
	}



	private void beenden()
	{
		System.out.println("programm beendet");
		System.exit(0);
	}


	private void closeDatabase()
	{
		String s = null;

		try
		{
			s = adb.adressenAbspeichern();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}

		updateContentPanel(s);
	}


	private void connectDatabase() throws Exception
	{
		this.adb = (AdressDB) Naming.lookup("rmi://localhost/AdressDB");
	}


	private JMenuBar makeJMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();

		menuBar.add(makeMenuDatenbank());
		menuBar.add(makeMenuAdressen());
		menuBar.add(makeMenuHilfe());

		return menuBar;
	}


	private JMenu makeMenuAdressen()
	{
		JMenu menu = new JMenu(ADRESSEN);

		menu.add(makeMenuItem(ALLE_ANZEIGEN));
		menu.add(makeMenuItem(BEARBEITEN));

		return menu;
	}


	private JMenu makeMenuDatenbank()
	{
		JMenu menu = new JMenu(DATENBANK);

		menu.add(makeMenuItem(OPEN));
		menu.add(makeMenuItem(CLOSE));
		menu.add(makeMenuItem(MAKE_TESTDATA));
		menu.add(makeMenuItem(ANZEIGEN));
		menu.add(makeMenuItem(SORTIEREN));
		menu.add(makeMenuItem(EXIT));

		return menu;
	}


	private JMenu makeMenuHilfe()
	{
		JMenu menu = new JMenu(HILFE);

		menu.add(makeMenuItem(RECHNER));
		menu.add(makeMenuItem(TIPPS));
		menu.add(makeMenuItem(ABOUT));

		return menu;
	}


	private JMenuItem makeMenuItem(String s)
	{
		JMenuItem menuItem = new JMenuItem(s);
		menuItem.addActionListener(this);
		return menuItem;
	}


	private void makeTestdata()
	{
		String s = null;

		try
		{
			s = adb.makeTestdata();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}

		updateContentPanel(s);
	}


	private void makeTheLayout()
	{
		this.setJMenuBar(makeJMenuBar());
	}


	private void openDatabase()
	{
		String s = null;

		try
		{
			s = adb.adressenEinlesen();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}

		JPanel p1 = new JPanel();
		JTextArea textArea = new JTextArea(5, 22);
		textArea.append(s);
		p1.add(textArea);
		updateContentPanel(p1);
	}


	private void removeContentPanel()
	{
		if (contentPanel != null)
		{
			this.remove(contentPanel);
			contentPanel = null;
		}
	}


	private void showTheLayout()
	{
		this.setLocation(200, 100);
		this.setSize(880, 600);
		this.setVisible(true);
	}


	// private void rechner()
	// {
	// JPanel p1 =
	// new Rechner();
	// }


	private void sortieren()
	{
		String s = null;
		try
		{
			s = adb.adressenSortieren();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		updateContentPanel(s);
	}


	private void updateContentPanel(JPanel p)
	{
		removeContentPanel();
		contentPanel = p;
		this.add(contentPanel);
		setVisible(true);
	}


	private void updateContentPanel(String s)
	{
		JPanel p = new JPanel();
		p.add(new JLabel(s));
		updateContentPanel(p);
	}
}
