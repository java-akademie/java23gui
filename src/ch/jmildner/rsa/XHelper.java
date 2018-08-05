package ch.jmildner.rsa;

import java.math.BigInteger;

public class XHelper
{
	public static BigInteger entschluesseln(BigInteger v, BigInteger d,
			BigInteger n)
	{
		// x = (v hoch d) % n
		// BigInteger vHochD = pow(v, d);
		// BigInteger x = mod(vHochD, n);

		BigInteger x = hochMod(v, d, n);

		return x;
	}


	/**
	 * Liefert einen zufaelligen <code>int</code> aus der Domaene
	 * <code>1 - 0x7fffffff</code>.
	 * <p>
	 * Beispiel: <code>int i = MyTools.getRandom();</code>
	 * 
	 * @return randomWert
	 */
	public static int getRandom()
	{
		return getRandom(1, 0x7fffffff);
	}


	/**
	 * Liefert einen zufaelligen <code>int</code> aus der Domaene
	 * <code>min - max</code>. <br>
	 * min muss groesser 0 sein. <br>
	 * max muss groesser min sein. <br>
	 * Beispiel:
	 * <code>int i = MyTools.getRandom(1,46); // liefert eine Lottozahl</code>
	 * 
	 * @param min
	 *            Min-Wert
	 * @param max
	 *            Max-Wert
	 * 
	 * @return randomWert
	 */
	public static int getRandom(int min, int max)
	{
		if (min <= 0 || max <= min)
		{
			min = 1;
			max = 0x7fffffff;
		}

		return (int) (min + (Math.random() * (max - min + 1)));
	}


	/**
	 * Liefert eine zufaellige Primzahl <code>(long)</code> aus der
	 * Domaene <code>1L - 0xfffffffffffffffL</code>.
	 * <p>
	 * Beispiel: <code>int i = MyTools.getRandomPrime();</code>
	 * 
	 * @return randomWert
	 */
	public static long getRandomPrime()
	{
		return getRandomPrime(1L, 0x7fffffffffffffffL);
	}


	/**
	 * Liefert eine zufaellige Primzahl <code>(long)</code> aus der
	 * Domaene <code>min - max</code>. min muss groesser 0 sein. <br>
	 * max muss groesser min sein. <br>
	 * <p>
	 * Beispiel:
	 * <code>int i = MyTools.getRandomPrime(1,100000000);</code>
	 * <p>
	 * Die Funktion ermittelt eine Zufallszahl zwischen min und max und
	 * addiert solange 1 auf die ermittelte Zufallszahl, bis die Zahl
	 * eine Primzahl ist. Es kann passieren, dass zwischen der zuerst
	 * ermittelten Zufallszahl und dem Maximum keine Primzahl liegt. Es
	 * wird dann die naechsthoehere Zahl die eine Primzahl ist,
	 * zurueckgegeben.<br>
	 * Der Aufruf <code>MyTools.getRandomPrime(21,28);</code> gibt
	 * entweder 23 oder 29 zurueck.<br>
	 * 
	 * @param min
	 *            Min-Wert
	 * @param max
	 *            Max-Wert
	 * 
	 * @return randomWert
	 */
	public static long getRandomPrime(long min, long max)
	{
		if (min <= 0 || max <= min)
		{
			min = 1L;
			max = 0x7fffffffffffffffL;
		}

		long randomWert = (long) (min + (Math.random() * (max - min + 1)));

		while (true)
		{
			if (new BigInteger(randomWert + "")
					.isProbablePrime(999999999))
			{
				return randomWert;
			}

			randomWert++;
		}
	}


	public static BigInteger hochMod(BigInteger basis,
			BigInteger exponent, BigInteger modulo)
	{
		BigInteger ergebnis = null;

		ergebnis = pow(basis, exponent);
		ergebnis = mod(ergebnis, modulo);

		return ergebnis;
	}


	public static BigInteger max(BigInteger p, BigInteger q)
	{
		if (p.compareTo(q) > 0)
			return p;
		else
			return q;
	}


	public static BigInteger mod(BigInteger e, BigInteger o)
	{
		BigInteger rest = e;
		rest = e.divide(o);
		rest = e.subtract(rest.multiply(o));

		return rest;
	}


	public static BigInteger pow(BigInteger a, BigInteger b)
	{
		BigInteger erg = BigInteger.ONE;

		if (b.equals(BigInteger.ZERO))
			return erg;

		while (b.compareTo(BigInteger.ZERO) > 0)
		{
			erg = erg.multiply(a);
			b = b.subtract(BigInteger.ONE);
		}

		return erg;
	}


	public static BigInteger verschluesseln(BigInteger t, BigInteger e,
			BigInteger n)
	{
		// v = (t hoch e) % n

		// BigInteger tHochE = pow(t, e);
		// BigInteger v = mod(tHochE, n);

		BigInteger v = hochMod(t, e, n);
		return v;
	}
}
