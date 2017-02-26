package ch.bcds.gui_template1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public final class TemplateFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private Dimension dim1 = new Dimension(400, 200);

	private Dimension dim2 = new Dimension(400, 200);


	public Dimension getDim1()
	{
		return dim1;
	}


	public Dimension getDim2()
	{
		return dim2;
	}


	private JPanel contentPanel;


	public JPanel getContentPanel()
	{
		return contentPanel;
	}


	public void setContentPanel(JPanel contentPanel)
	{
		this.contentPanel = contentPanel;
	}


	// the Actions
	private OpenDbAction openDbAction;
	private CloseDbAction closeDbAction;
	private CreateTableAction createTableAction;
	private InsertAction insertAction;
	private DropTableAction dropTableAction;
	private ClearAction clearAction;
	private HelpAction helpAction;
	private AboutAction aboutAction;
	private QuitAction quitAction;

	// Datenbank
	private JMenuItem miOpenDb = new JMenuItem("_openDb");
	private JMenuItem miCloseDb = new JMenuItem("_closeDb");
	private JMenuItem miCreateAdressen = new JMenuItem("_createAdressen");
	private JMenuItem miDropAdressen = new JMenuItem("_dropAdressen");
	private JMenuItem miInsertAdressen = new JMenuItem("_masseninsert");
	private JMenuItem miQuit = new JMenuItem("_quit");

	// Adressen
	private JMenuItem miAdressenAnzeigen = new JMenuItem("_Adressen anzeigen");
	private JMenuItem miAdressenBearbeiten = new JMenuItem("_Adressen bearbeiten (ins/upd/del)");

	// Sonstiges
	private JMenuItem miClear = new JMenuItem("_clear");
	private JMenuItem miHelp = new JMenuItem("_help");
	private JMenuItem miAbout = new JMenuItem("_about");


	public TemplateFrame(String s)
	{
		super(s);

		makeTheMenue();
		addTheListener();
		setTheActions();
	}


	private void setTheActions()
	{
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				quitAction.actionPerformed(null);
			}
		});

		//
		// closeDBAction = new CloseDBAction(panel);
		// panel.getBtCloseDB().setAction(closeDBAction);
		// panel.getMenuItemCloseDB().setAction(closeDBAction);
		//
		// createTableAction = new CreateTableAction(panel);
		// panel.getBtCreateTable().setAction(createTableAction);
		// panel.getMenuItemCreateTable().setAction(createTableAction);
		//
		// dropTableAction = new DropTableAction(panel);
		// panel.getBtDropTable().setAction(dropTableAction);
		// panel.getMenuItemDropTable().setAction(dropTableAction);
		//
		// clearAction = new ClearAction(panel);
		// panel.getBtClear().setAction(clearAction);
		// panel.getMenuItemClear().setAction(clearAction);


		insertAction = new InsertAction(this);
		miInsertAdressen.setAction(insertAction);

		createTableAction = new CreateTableAction(this);
		miCreateAdressen.setAction(createTableAction);
		
		dropTableAction = new DropTableAction(this);
		miDropAdressen.setAction(dropTableAction);

		closeDbAction = new CloseDbAction(this);
		miCloseDb.setAction(closeDbAction);

		openDbAction = new OpenDbAction(this);
		miOpenDb.setAction(openDbAction);

		clearAction = new ClearAction(this);
		miClear.setAction(clearAction);

		aboutAction = new AboutAction(this);
		miAbout.setAction(aboutAction);

		helpAction = new HelpAction(this);
		miHelp.setAction(helpAction);

		quitAction = new QuitAction(this);
		miQuit.setAction(quitAction);
	}


	private void addTheListener()
	{
	
		// Adressen
		miAdressenAnzeigen.addActionListener(this);
		miAdressenBearbeiten.addActionListener(this);
	}


	private void makeTheMenue()
	{
		JMenuBar menuBar = new JMenuBar();

		JMenu menuDatenbank = new JMenu("Datenbank");
		JMenu menuAdressen = new JMenu("Adressen");
		JMenu menuSonstiges = new JMenu("Hilfe");

		// menuDatenbank fuellen
		menuDatenbank.add(miOpenDb);
		menuDatenbank.add(miCreateAdressen);
		menuDatenbank.add(miDropAdressen);
		menuDatenbank.add(miInsertAdressen);
		menuDatenbank.add(miCloseDb);
		menuDatenbank.add(miQuit);

		// menuAdressen fuellen
		menuAdressen.add(miAdressenAnzeigen);
		menuAdressen.add(miAdressenBearbeiten);

		// menuSonstiges fuellen
		menuSonstiges.add(miClear);
		menuSonstiges.add(miHelp);
		menuSonstiges.add(miAbout);


		// menuBar fuellen
		menuBar.add(menuDatenbank);
		menuBar.add(menuAdressen);
		menuBar.add(menuSonstiges);

		// menuBar in Frame einfuegen
		this.setJMenuBar(menuBar);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(e.getActionCommand());
	}


	public JMenuItem getMiOpenDb()
	{
		return miOpenDb;
	}


	public JMenuItem getMiCreateAdressen()
	{
		return miCreateAdressen;
	}


	public JMenuItem getMiDropAdressen()
	{
		return miDropAdressen;
	}


	public JMenuItem getMiInsertAdressen()
	{
		return miInsertAdressen;
	}


	public JMenuItem getMiCloseDb()
	{
		return miCloseDb;
	}


	public JMenuItem getMiQuit()
	{
		return miQuit;
	}


	public JMenuItem getMiAdressenAnzeigen()
	{
		return miAdressenAnzeigen;
	}


	public JMenuItem getMiAdressenBearbeiten()
	{
		return miAdressenBearbeiten;
	}


	public JMenuItem getMiClear()
	{
		return miClear;
	}


	public JMenuItem getMiHelp()
	{
		return miHelp;
	}


	public JMenuItem getMiAbout()
	{
		return miAbout;
	}


}
