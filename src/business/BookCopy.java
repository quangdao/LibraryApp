package business;

import java.io.Serializable;

public class BookCopy extends Book implements Serializable {
	
	public BookCopy(Book book) {
		super(book.getBookID(), book.getTitle(), book.getIsbn(), book.getAuthors());
	}
}
