package ch.bcds.gui_template1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;

import ch.jmb.tools.MyPanel;

public class AboutAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;


	TemplateFrame frame;


	public AboutAction(final TemplateFrame frame)
	{
		super("About");
		this.putValue(SHORT_DESCRIPTION, "Info ueber das Programm");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_T));

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
		panel.add(new JLabel("About About About"));

		return panel;
	}

}
