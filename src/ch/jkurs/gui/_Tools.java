package ch.jkurs.gui;

public class _Tools
{

	public static double getRandom(int range,int stellen)
	{
		double x = Math.pow(10, stellen);
		long zahl = (int) (Math.random() * range * x);
		return zahl / x;
	}


	public static double runden(double wert, int stellen)
	{
		double x = Math.pow(10, stellen);
		return (double) (Math.round(wert * x) / x);
	}

}
