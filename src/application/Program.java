package application;

import model.Book;
import view.FormRegisterBook;

public class Program {

	public static void main(String[] args) {
		
		FormRegisterBook frb = new FormRegisterBook();
		
		frb.setVisible(true);
		
		Book book = new Book(1, "Anne frank", "anne", "biografia");
		System.out.println(book);
		
	}

}
