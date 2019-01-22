package business;

import java.util.List;

public  class Book {
	private String bookID;
	private String title;
	private String isbn;
	private List<Author> authors;
	private List<BookCopy> copyIDs;
	
	public Book(String bookID, String title,String isbn, List<Author> authors, List<BookCopy> copyIDs) {
		this.bookID = bookID;
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
		this.copyIDs = copyIDs;
	}
	
	
	
	
	public List<Author> getAuthors() {
		return authors;
	}
	
	public String getBookID() {
		return bookID;
	}
	public String getIsbn() {
		return isbn;
	}
	public List<BookCopy> getNumberOfCopies() {
		return copyIDs;
	}
	public String getTitle() {
		return title;
	}
	
	public void setcopyIDs(List<BookCopy> copyIDs) {
		this.copyIDs = copyIDs;
	}
	
	
	
	
	
}
