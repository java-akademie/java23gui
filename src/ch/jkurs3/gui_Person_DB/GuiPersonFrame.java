package ch.jkurs3.gui_Person_DB;

import javax.swing.JFrame;



public class GuiPersonFrame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new GuiPersonFrame();
	}


	public GuiPersonFrame()
	{
		super("Person");

		add(new GuiPersonPanel(this));

		this.pack();
		this.setLocation(100, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
