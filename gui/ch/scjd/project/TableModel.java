package ch.scjd.project;

import java.rmi.RemoteException;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private static final boolean DEBUG = true;
	AdressDB adb;


	public TableModel(AdressDB adb)
	{
		this.adb = adb;
	}


	@Override
	public int getColumnCount()
	{
		return 3;
	}


	@Override
	public String getColumnName(int i)
	{
		switch (i)
		{
			case 0:
				return "Identifikation";
			case 1:
				return "Name";
			case 2:
				return "Adresse";
			default:
				return "??";
		}
	}


	@Override
	public int getRowCount()
	{
		try
		{
			return adb.getAnzahlAdressen();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public Object getValueAt(int row, int col)
	{
		switch (col)
		{
			case 0:
				try
				{
					return adb.getAdresse(row).getID() + "";
				}
				catch (RemoteException e)
				{
					e.printStackTrace();
				}
			case 1:
				try
				{
					return adb.getAdresse(row).getName();
				}
				catch (RemoteException e1)
				{
					e1.printStackTrace();
				}
			case 2:
				try
				{
					return adb.getAdresse(row).getAddr();
				}
				catch (RemoteException e2)
				{
					e2.printStackTrace();
				}
			default:
				return null;

		}
	}


	@Override
	public boolean isCellEditable(int row, int col)
	{
		if (col < 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}


	@Override
	public void setValueAt(Object value, int row, int col)
	{
		if (DEBUG)
		{
			System.out.println("setting value at " + row + ", " + col
					+ " to " + value + " (an instance of "
					+ value.getClass() + ")");
		}

		switch (col)
		{
			case 1:
				try
				{
					adb.getAdresse(row).setName((String) value);
				}
				catch (RemoteException e1)
				{
					e1.printStackTrace();
				}
				break;
			case 2:
				try
				{
					adb.getAdresse(row).setAddr((String) value);
				}
				catch (RemoteException e)
				{
					e.printStackTrace();
				}
				break;
			default:
				;
		}

		fireTableCellUpdated(row, col);
	}
}
