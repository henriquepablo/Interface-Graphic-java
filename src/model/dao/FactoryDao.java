package model.dao;

import db.Db;
import model.dao.impl.BookDaoJDBC;

public class FactoryDao {
	
	public static BookDao createBookDao() {
		return new BookDaoJDBC(Db.getConnection());
	}
}
