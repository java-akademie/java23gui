package ch.jmildner.gui.dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class About extends JDialog
{
	private static final long serialVersionUID = 1L;


	public About()
	{
		JButton ende = new JButton("ende");
		this.setLayout(new FlowLayout());
		this.add(new JLabel("About: .... "));
		this.add(ende);

		ende.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
			}
		});

		this.setModal(true);
		this.setLocation(450, 250);
		this.pack();
		this.setVisible(true);
	}


}
