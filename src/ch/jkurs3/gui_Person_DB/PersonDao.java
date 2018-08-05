package ch.jkurs3.gui_Person_DB;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao
{
	void create() throws SQLException;
	void drop() throws SQLException;
	
	int delete(Person p) throws SQLException;
	int deleteById(Integer id) throws SQLException;
	int deleteByName(String name) throws SQLException;
	List<Person> getAll() throws SQLException;
	Person getById(Integer id) throws SQLException;
	List<Person> getByName(String name) throws SQLException;
	void insert(Person p) throws SQLException;
	int update(Person p) throws SQLException;
}
