package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Db;
import db.DbException;
import model.Book;
import model.dao.BookDao;

public class BookDaoJDBC implements BookDao{
	
	private Connection conn;
	
	public BookDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM livros");
			rs = st.executeQuery();
			
			List<Book> list = new ArrayList<>();
			
			while (rs.next()) {
				list.add(createObjBook(rs));
				
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			Db.closeStatement(st);
			Db.closeResultSet(rs);
		}
	}
	
	private Book createObjBook(ResultSet rs) throws SQLException{
		return new Book(
				rs.getInt("id"),
				rs.getString("nameBook"), 
				rs.getString("nameAuthor"), 
				rs.getString("descriptionBook"));
	}
}
