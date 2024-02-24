package model;

public class Book {
	
	private Integer id;
	private String nameBook;
	private String nameAuthor;
	private String description;
	
	public Book() {
		
	}

	public Book(Integer id, String nameBook, String nameAuthor, String description) {
		this.id = id;
		this.nameBook = nameBook;
		this.nameAuthor = nameAuthor;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", nameBook=" + nameBook + ", nameAuthor=" + nameAuthor + ", description="
				+ description + "]";
	}
}
