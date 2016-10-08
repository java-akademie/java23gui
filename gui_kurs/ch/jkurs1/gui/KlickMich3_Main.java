package ch.jkurs1.gui;

import java.awt.Frame;

public class KlickMich3_Main extends Frame
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new KlickMich3Frame(_Layout.flow);
		new KlickMich3Frame(_Layout.grid);
		new KlickMich3Frame(_Layout.border);
	}

}
