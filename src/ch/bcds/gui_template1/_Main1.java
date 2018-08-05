package ch.bcds.gui_template1;

public final class _Main1
{
	private _Main1()
	{
		TemplateFrame frame = new TemplateFrame("Template");
		frame.setLocation(100, 100);
		// frame.setSize(400, 200);
		frame.setMinimumSize(frame.getDim1());
		frame.setVisible(true);
		frame.pack();
	}


	public static void main(String[] args)
	{
		new _Main1();
	}
}
