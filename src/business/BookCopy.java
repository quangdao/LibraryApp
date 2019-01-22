package business;

public class BookCopy extends Book{
	private String copyID;
	
	
	public BookCopy(String copyID, Book book) {
		super(book.getBookID(), book.getTitle(), book.getIsbn(), book.getAuthors(), book.getNumberOfCopies());
		this.copyID = copyID;
	}
	
	
	
	
}
