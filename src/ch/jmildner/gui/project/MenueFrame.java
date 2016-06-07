package ch.jmildner.gui.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MenueFrame extends JFrame implements ActionListener
{
	static public final String DATENBANK = "Datenbank";
	static public final String OPEN = "open";
	static public final String CLOSE = "close";
	static public final String MAKE_TESTDATA = "makeTestdata";
	static public final String ANZEIGEN = "anzeigen";
	static public final String SORTIEREN = "sortieren";
	static public final String EXIT = "exit";

	static public final String ADRESSEN = "Adressen";
	static public final String ALLE_ANZEIGEN = "alle anzeigen";
	static public final String BEARBEITEN = "bearbeiten";

	static public final String HILFE = "Hilfe";
	static public final String RECHNER = "Rechner";
	static public final String TIPPS = "Tipps";
	static public final String ABOUT = "About";

	private static final long serialVersionUID = 1L;


	public static void main(String[] args) throws Exception
	{
		new MenueFrame();
	}


	private JPanel contentPanel;


	Rechner r;


	public MenueFrame() throws Exception
	{
		super("Menue");

		// connectDatabase();

		makeTheLayout();
		addTheListener();
		showTheLayout();
	}


	@Override
	public void actionPerformed(ActionEvent ae)
	{

		if (ae.getActionCommand().equals(RECHNER))
		{
			if (r == null)
				r = new Rechner();
			r.setVisible(true);
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


	private JMenuBar makeJMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();

		menuBar.add(makeMenuDatenbank());
		menuBar.add(makeMenuAdressen());
		menuBar.add(makeMenuHilfe());
		menuBar.add(makeMenuDB());

		return menuBar;
	}


	private JMenu makeMenu(String n)
	{
		JMenu menu = new JMenu(n);
		menu.add(makeMenuItem(CLOSE));
		menu.add(makeMenuItem(MAKE_TESTDATA));
		return menu;
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


	private JMenu makeMenuDB()
	{
		JMenu menu = new JMenu("DB");

		menu.add(makeMenu("KUNDEN"));
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



	private void makeTheLayout()
	{
		this.setJMenuBar(makeJMenuBar());
	}


	private void removeContentPanel()
	{
		if (contentPanel != null)
		{
			this.remove(contentPanel);
			contentPanel = null;
		}
	}


	// private void rechner()
	// {
	// JPanel p1 =
	// new Rechner();
	// }


	private void showTheLayout()
	{
		this.setLocation(200, 100);
		this.setSize(880, 600);
		this.setVisible(true);
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
