package ch.jkurs2.gui;

import javax.swing.JFrame;

class PersonenverwaltungFrame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new PersonenverwaltungFrame();
	}


	PersonenverwaltungFrame()
	{
		super("Personenverwaltung");
		
		this.add(new PersonenverwaltungPanel());
		this.setLocation(200, 100);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
