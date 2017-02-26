package ch.bcds.gui_template1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

import ch.java_akademie.tools.MyTools;
import ch.java_akademie.tools.TestDaten;

public class InsertAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	private TemplateFrame frame;


	public InsertAction(final TemplateFrame frame)
	{
		super("MassInsert");
		putValue(SHORT_DESCRIPTION, "insert von mehreren Adressen");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_I));

		this.setEnabled(false);

		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("MassInsert gedrueckt");

		DbTool db = DbTool.getInstance();

		StringBuilder prot = new StringBuilder();
		for (int i = 1; i <= 10; i++)
		{
			try
			{
				prot.append(db.insertAddress(MyTools.getRandom(), TestDaten.getName(),
						TestDaten.getAdresse()) + "\n");

				frame.getMiOpenDb().getAction().setEnabled(false);
				frame.getMiCloseDb().getAction().setEnabled(true);
				frame.getMiCreateAdressen().getAction().setEnabled(false);
				frame.getMiDropAdressen().getAction().setEnabled(true);
				frame.getMiInsertAdressen().getAction().setEnabled(true);
			}
			catch (Exception e)
			{
				frame.getMiOpenDb().getAction().setEnabled(false);
				frame.getMiCloseDb().getAction().setEnabled(true);
				frame.getMiCreateAdressen().getAction().setEnabled(true);
				frame.getMiDropAdressen().getAction().setEnabled(false);
				frame.getMiInsertAdressen().getAction().setEnabled(false);
				prot.append(e.toString());
				break;
			}

		}

		JTextArea ta = new JTextArea();
		ta.setText(prot.toString());
		System.out.println(prot.toString());
		frame.add(ta);
		frame.pack();
		// panel.getTaProtokoll().append(prot);

	}

}
