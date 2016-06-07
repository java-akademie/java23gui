package ch.jmildner.gui.table;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;

	TData td;


	TableModel(TData td)
	{
		this.td = td;
	}


	@Override
	public int getColumnCount()
	{
		return td.meta.size();
	}


	@Override
	public String getColumnName(int columnIndex)
	{
		return td.meta.get(columnIndex);
	}


	@Override
	public int getRowCount()
	{
		return td.datal.size();
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		return td.datal.get(rowIndex)[columnIndex];
	}


	@Override
	public boolean isCellEditable(int row, int col)
	{
		if (col < 1 || col > 3)
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
		td.datal.get(row)[col] = (String) value;
	}
}
