package ch.bcds.gui_template1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class QuitAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;


	TemplateFrame frame;


	public QuitAction(final TemplateFrame frame)
	{
		super("Quit");
		this.putValue(SHORT_DESCRIPTION, "Programm beenden");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_Q));

		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e == null)
			System.out.println("ende mit 'x'");
		else
			System.out.println("ende mit 'Quit'");

		frame.dispose();
		
		// frame.add(new JLabel("xxxxx"));
		// frame.setVisible(true);
		// frame.repaint();
	}

}
