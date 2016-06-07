package ch.jmildner.gui.table;

import java.util.ArrayList;
import java.util.List;

public class TData
{
	List<String> meta = new ArrayList<String>();

	{
		meta.add("id");
		meta.add("name");
		meta.add("addr");
		meta.add("tel");
		meta.add("");
		meta.add("");
	}

	String[][] data = {
			{ "101", "hugo", "basel", "4711", "DEL", "INS" },
			{ "102", "fritz", "bern", "1234", "DEL", "INS" },
			{ "1102", "franz", "bern", "1234", "DEL", "INS" },
			{ "2102", "max", "bern", "1234", "DEL", "INS" },
			{ "3102", "urs", "bern", "1234", "DEL", "INS" },
			{ "4102", "" + "", "bern", "1234", "DEL", "INS" },
			{ "15102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "25102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "35102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "45102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "55102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "65102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "75102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "85102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "95102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "105102", "maximilian", "bern", "1234", "DEL", "INS" },
			{ "910300", "friedrich", "genf", "4321", "DEL", "INS" } };

	List<String[]> datal = new ArrayList<String[]>();

	{
		for (String[] sa : data)
			datal.add(sa);
	}
}
