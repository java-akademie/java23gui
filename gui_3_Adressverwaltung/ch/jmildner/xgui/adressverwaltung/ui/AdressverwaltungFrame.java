package ch.jmildner.xgui.adressverwaltung.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ch.jmildner.xgui.adressverwaltung.action.ClearAction;
import ch.jmildner.xgui.adressverwaltung.action.CloseDBAction;
import ch.jmildner.xgui.adressverwaltung.action.CreateTableAction;
import ch.jmildner.xgui.adressverwaltung.action.DropTableAction;
import ch.jmildner.xgui.adressverwaltung.action.OpenDBAction;
import ch.jmildner.xgui.adressverwaltung.action.QuitAction;

public final class AdressverwaltungFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private AdressverwaltungPanel panel;

	private OpenDBAction openDBAction;
	private CloseDBAction closeDBAction;
	private CreateTableAction createTableAction;
	private DropTableAction dropTableAction;
	private ClearAction clearAction;
	private QuitAction quitAction;


	public AdressverwaltungFrame()
	{
		super("Adressverwaltung ");

		makeAndShowTheLayout();
		setTheActions();
		addTheListeners();
	}


	private void addTheListeners()
	{
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				quitAction.actionPerformed(null);
			}
		});


		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					panel.getPopupMenu().show(panel, e.getX() - 20,
							e.getY() - 40);
				}
				System.out.println(e.getButton());
			}
		});

		DocumentListener documentListener = new DocumentListener()
		{


			@Override
			public void changedUpdate(DocumentEvent e)
			{
				panel.getBtClear().getAction().setEnabled(true);
			}



			@Override
			public void insertUpdate(DocumentEvent e)
			{
				panel.getBtClear().getAction().setEnabled(true);
			}



			@Override
			public void removeUpdate(DocumentEvent e)
			{
				panel.getBtClear().getAction().setEnabled(true);
			}

		};

		panel.getTfId().getDocument()
				.addDocumentListener(documentListener);

		panel.getTfName().getDocument()
				.addDocumentListener(documentListener);

		panel.getTfAddr().getDocument()
				.addDocumentListener(documentListener);

		panel.getTaProtokoll().getDocument()
				.addDocumentListener(documentListener);
	}


	public void makeAndShowTheLayout()
	{
		panel = new AdressverwaltungPanel();

		add(panel);
		setLocation(100, 200);
		// setMinimumSize(new Dimension(500, 450));
		pack();
		setVisible(true);
	}


	private void setTheActions()
	{
		openDBAction = new OpenDBAction(panel);
		panel.getBtOpenDB().setAction(openDBAction);
		panel.getMiOpenDB().setAction(openDBAction);

		closeDBAction = new CloseDBAction(panel);
		panel.getBtCloseDB().setAction(closeDBAction);
		panel.getMiCloseDB().setAction(closeDBAction);

		createTableAction = new CreateTableAction(panel);
		panel.getBtCreateTable().setAction(createTableAction);
		panel.getMiCreateTable().setAction(createTableAction);

		dropTableAction = new DropTableAction(panel);
		panel.getBtDropTable().setAction(dropTableAction);
		panel.getMiDropTable().setAction(dropTableAction);


		clearAction = new ClearAction(panel);
		panel.getBtClear().setAction(clearAction);
		panel.getMenuItemClear().setAction(clearAction);

		quitAction = new QuitAction(panel);
		panel.getBtQuit().setAction(quitAction);
	}
}
