package application;

import java.time.LocalDateTime;
import java.util.List;

import business.Author;
import business.Book;
import business.BookCopy;

public class BookController {
	public static Book createNewBook (String title, String isbn, List<Author> authors, List<BookCopy> copyIDs) {
		LocalDateTime currentTime = LocalDateTime.now();
		String bookID = ""+title.trim().substring(0, 2)+isbn.trim().substring(0, 2)+currentTime.getYear() + currentTime.getMonth() + currentTime.getDayOfMonth() +currentTime.getHour() +currentTime.getMinute()+currentTime.getSecond();
		
		return new Book(bookID, title, isbn, authors, copyIDs);
	}
	
	//public static BookCopy createNewCopy();
}
