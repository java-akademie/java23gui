package ch.bcds.gui_template1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;

import ch.java_akademie.tools.MyPanel;

public class HelpAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;


	TemplateFrame frame;


	public HelpAction(final TemplateFrame frame)
	{
		super("Help");
		this.putValue(SHORT_DESCRIPTION, "Hilfe");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_H));

		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{

		if (frame.getContentPanel() != null)
		{
			System.out.println("contentPanel wird removed");
			frame.remove(frame.getContentPanel());
			frame.setContentPanel(null);
		}
		else
			System.out.println("contentPanel is  null");


		frame.setContentPanel(makePanel());
		frame.add(frame.getContentPanel());
		frame.pack();
	}



	private MyPanel makePanel()
	{
		MyPanel panel = new MyPanel();
		panel.add(new JLabel("Help Help Help"));
		return panel;
	}

}
