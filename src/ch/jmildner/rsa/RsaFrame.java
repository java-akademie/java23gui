package ch.jmildner.rsa;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RsaFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	RsaPanel myPanel;


	public RsaFrame()
	{
		super("Encoding/Decoding RSA");
		initComponents();
		initListeners();
		initActions();

		setVisible(true);
	}


	private void initActions()
	{
		ClearAction aClearAction = new ClearAction(myPanel);
		aClearAction.setEnabled(false);

		myPanel.getBtnClear().setAction(aClearAction);
		myPanel.getMenuItemClear().setAction(aClearAction);

		QuitAction aQuitAction = new QuitAction(myPanel);
		myPanel.getBtnQuit().setAction(aQuitAction);

		TryItAction aTryItAction = new TryItAction(myPanel);
		myPanel.getBtnTryIt().setAction(aTryItAction);
		myPanel.getBtnTryIt().getAction().setEnabled(false);

		GetRandomAction aGetRandomAction = new GetRandomAction(myPanel);
		myPanel.getBtnGetRandom().setAction(aGetRandomAction);

		RandomAndTryAction aRandomAndTryAction = new RandomAndTryAction(
				new GetRandomAction(myPanel), new TryItAction(myPanel));
		myPanel.getBtnRandomAndTry().setAction(aRandomAndTryAction);
	}


	private void initComponents()
	{
		myPanel = new RsaPanel();
		this.add(myPanel);
		this.setLocation(100, 200);
		this.setMinimumSize(new Dimension(580, 450));
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private void initListeners()
	{

		DocumentListener aDocumentListener = new DocumentListener()
		{


			@Override
			public void changedUpdate(DocumentEvent e)
			{
				myPanel.getBtnClear().getAction().setEnabled(true);
				myPanel.getBtnTryIt().getAction().setEnabled(true);
			}


			@Override
			public void insertUpdate(DocumentEvent e)
			{
				myPanel.getBtnClear().getAction().setEnabled(true);
				myPanel.getBtnTryIt().getAction().setEnabled(true);
			}


			@Override
			public void removeUpdate(DocumentEvent e)
			{
				myPanel.getBtnClear().getAction().setEnabled(true);
				myPanel.getBtnTryIt().getAction().setEnabled(true);
			}
		};

		myPanel.getTfP().getDocument()
				.addDocumentListener(aDocumentListener);
		myPanel.getTfQ().getDocument()
				.addDocumentListener(aDocumentListener);
		myPanel.getTfE().getDocument()
				.addDocumentListener(aDocumentListener);
		myPanel.getTfT().getDocument()
				.addDocumentListener(aDocumentListener);

		
		
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{System.out.println("mouseClicked: ---"+e.getButton());
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					myPanel.getPopupMenu1().show(myPanel,
							e.getX() - 20, e.getY() - 40);
				}
			}
		});

	}
}
