package ch.jmildner.xgui.rechner.ui;


import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RechnerFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	RechnerPanel panel;


	public RechnerFrame()
	{
		super("Rechner");
		initComponents();
		initListeners();
		initActions();

		setVisible(true);

	}


	private void initActions()
	{
	}


	private void initComponents()
	{
		panel = new RechnerPanel();

		this.add(panel);
		this.setLocation(100, 200);
		this.setMinimumSize(new Dimension(400, 300));
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				System.out.println("changedUpdate");

			}



			@Override
			public void insertUpdate(DocumentEvent e)
			{
				System.out.println("insertUpdate");
			}



			@Override
			public void removeUpdate(DocumentEvent e)
			{
				System.out.println("removeUpdate");
			}
		};

		panel.getWert1().getDocument()
				.addDocumentListener(myDocumentListener);
		panel.getWert2().getDocument()
				.addDocumentListener(myDocumentListener);


	}


	private void initListeners()
	{
		initMouseListener();
		initDocumentListener();
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
			}


			@Override
			public void keyReleased(KeyEvent e)
			{
			}


			@Override
			public void keyTyped(KeyEvent e)
			{
				System.out.println("" + e);
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
			}
		});
	}

}
