package ch.bcds.gui_template1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

import ch.jmb.tools.MyPanel;

public class DropTableAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;


	private TemplateFrame frame;


	public DropTableAction(final TemplateFrame frame)
	{
		super("DropTable");
		putValue(SHORT_DESCRIPTION, "drop Table");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_D));

		this.setEnabled(false);

		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("DropTable gedrueckt");

		DbTool db = DbTool.getInstance();

		StringBuilder prot = new StringBuilder();

		try
		{
			prot.append(db.dropAddress());
		}
		catch (Exception e)
		{
			prot.append(e.toString() + "\n");

		}
		finally
		{
			// Tabelle gibt es nicht (mehr)
			setEnabled(false);


			frame.getMiOpenDb().getAction().setEnabled(false);
			frame.getMiCloseDb().getAction().setEnabled(true);
			frame.getMiCreateAdressen().getAction().setEnabled(true);
			frame.getMiDropAdressen().getAction().setEnabled(false);
			frame.getMiInsertAdressen().getAction().setEnabled(false);
		}

		System.out.println(prot);
		MyPanel panel = new MyPanel(10, 10, false);
		JTextArea ta = new JTextArea();
		ta.append(prot.toString());
		panel.add(ta, 2, 2, 8, 5);
		frame.add(panel);
		frame.pack();
	}


}
