package ch.bcds.gui_template2;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class EjbTestFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private EjbTestPanel panel;

	private ExitAction exitAction;


	public EjbTestFrame()
	{
		super("EJB Test");

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
				exitAction.actionPerformed(null);
			}
		});


		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					panel.getPopupMenu().show(panel, e.getX() - 20, e.getY() - 40);
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

		panel.getTfId().getDocument().addDocumentListener(documentListener);

		panel.getTfName().getDocument().addDocumentListener(documentListener);

		panel.getTfAddr().getDocument().addDocumentListener(documentListener);

		panel.getTaProtokoll().getDocument().addDocumentListener(documentListener);
	}


	public void makeAndShowTheLayout()
	{
		panel = new EjbTestPanel();

		add(panel);
		setLocation(100, 200);
		setMinimumSize(new Dimension(500, 450));
		pack();
		setVisible(true);
	}


	private void setTheActions()
	{

		exitAction = new ExitAction(panel);
		panel.getBtAction().setAction(exitAction);
	}
}
