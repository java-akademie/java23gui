package ch.jkurs4.gui_XRechner;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class XRechnerFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	XRechnerPanel panel;


	public XRechnerFrame()
	{
		super("Extended Rechner");

		initComponents(); // makeTheLayout
		initActions(); // addTheListener
		initListeners();
	}


	/**
	 * makeTheLayout() and show()
	 */
	private void initComponents()
	{
		panel = new XRechnerPanel();

		this.add(panel);
		this.pack();
		this.setMinimumSize(this.getSize());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	/**
	 * addTheListener
	 */
	private void initActions()
	{
		QuitAction quitAction = new QuitAction(panel);
		quitAction.setEnabled(true);
		panel.getBtnQuit().setAction(quitAction);

		ClearAction clearAction = new ClearAction(panel);
		clearAction.setEnabled(false);
		panel.getBtnClear().setAction(clearAction);

		AddAction addAction = new AddAction(panel);
		addAction.setEnabled(false);
		panel.getBtnAdd().setAction(addAction);

		MultAction multAction = new MultAction(panel);
		multAction.setEnabled(false);
		panel.getBtnMult().setAction(multAction);

		SubAction subAction = new SubAction(panel);
		subAction.setEnabled(false);
		panel.getBtnSub().setAction(subAction);

		DivAction divAction = new DivAction(panel);
		divAction.setEnabled(false);
		panel.getBtnDiv().setAction(divAction);
	}



	private void initListeners()
	{
		initDocumentListener();
		// initMouseListener();
	}



	/**
	 * Document Listener.
	 * 
	 * Dient der Behandlung von Eingaben.<br>
	 * 
	 * Wenn eine Berechnung gemacht wurde, sollte das Ergebnis gefuellt
	 * sein und der Clear-Button disabled werden.<br>
	 * Nach der ersten Eingabe in eines der Wertefelder sollte das
	 * Ergebnis geloescht werden und der Clear-Button enabled werden.
	 * 
	 */
	private void initDocumentListener()
	{
		DocumentListener myDocumentListener = new DocumentListener()
		{

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				panel.getBtnClear().getAction().setEnabled(true);
				panel.getErgebnis().setText("");
				enableOps();
			}



			@Override
			public void insertUpdate(DocumentEvent e)
			{
				panel.getBtnClear().getAction().setEnabled(true);
				panel.getErgebnis().setText("");
				enableOps();
			}



			@Override
			public void removeUpdate(DocumentEvent e)
			{
				panel.getBtnClear().getAction().setEnabled(true);
				panel.getErgebnis().setText("");
				enableOps();
			}
		};

		panel.getWert1().getDocument().addDocumentListener(myDocumentListener);
		panel.getWert2().getDocument().addDocumentListener(myDocumentListener);
	}


	protected void enableOps()
	{
		panel.getBtnAdd().getAction().setEnabled(true);
		panel.getBtnSub().getAction().setEnabled(true);
		panel.getBtnMult().getAction().setEnabled(true);
		panel.getBtnDiv().getAction().setEnabled(true);

	}

	protected void disableOps()
	{
		panel.getBtnAdd().getAction().setEnabled(false);
		panel.getBtnSub().getAction().setEnabled(false);
		panel.getBtnMult().getAction().setEnabled(false);
		panel.getBtnDiv().getAction().setEnabled(false);

	}

	/**
	 * 
	 */
	private void initMouseListener()
	{
		panel.getWert1().addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				System.out.println("1keyPressed: ---- " + e);
			}


			@Override
			public void keyReleased(KeyEvent e)
			{
				System.out.println("1keyReleased: ---- " + e);
			}


			@Override
			public void keyTyped(KeyEvent e)
			{
				System.out.println("1keyTyped: ---- " + e);
			}

		});
		panel.getWert2().addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				System.out.println("2keyPressed: ---- " + e);
			}


			@Override
			public void keyReleased(KeyEvent e)
			{
				System.out.println("2keyReleased: ---- " + e);
			}


			@Override
			public void keyTyped(KeyEvent e)
			{
				System.out.println("2keyTyped: ---- " + e);
			}

		});
		
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					System.out.println("rechte Maustaste gedrueckt!!");
				}
				System.out.println("xxxxx" + e.getButton()+" "+MouseEvent.BUTTON3);
			}
		});
	}

}
