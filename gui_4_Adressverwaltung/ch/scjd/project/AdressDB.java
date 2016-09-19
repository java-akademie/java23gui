package ch.scjd.project;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface AdressDB extends Remote
{
	public String adressenAbspeichern() throws RemoteException;


	public String adressenAnzeigen() throws RemoteException;


	public String adressenEinlesen() throws RemoteException;


	public String adressenSortieren() throws RemoteException;


	public Vector<?> fuellenColHeader() throws RemoteException;


	public Vector<?> fuellenData() throws RemoteException;


	public Adresse getAdresse(int id) throws RemoteException;


	public int getAnzahlAdressen() throws RemoteException;


	public String makeTestdata() throws RemoteException;
}
