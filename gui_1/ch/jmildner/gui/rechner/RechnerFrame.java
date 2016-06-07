package ch.jmildner.gui.rechner;

import javax.swing.JFrame;

public class RechnerFrame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new RechnerFrame(0);
		new RechnerFrame(1);
	}


	public RechnerFrame(int version)
	{
		super("Rechner");

		this.add(new RechnerPanel(version));

		this.pack();

		switch (version)
		{
			case 0:
				this.setLocation(100, 200);
				break;
			case 1:
				this.setLocation(300, 400);
				break;
			default:
				break;
		}

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
