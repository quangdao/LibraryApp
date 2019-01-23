package business;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    private String bookID;
    private String title;
    private String isbn;
    private List<Author> authors;
    private List<BookCopy> bookCopy;

    public Book(String bookID, String title, String isbn, List<Author> authors) {
        this.bookID = bookID;
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
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

    public int getNumberOfCopies() {
        return bookCopy.size();
    }

    public String getTitle() {
        return title;
    }

    public void addBookCopy(BookCopy book) {
        this.bookCopy.add(book);
    }
}
