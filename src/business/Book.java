package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Serializable {
    private static final long serialVersionUID = 1413145946492697142L;
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
        bookCopy = new ArrayList<>(Arrays.asList(new BookCopy(this)));
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
        bookCopy.add(book);
    }

    public List<BookCopy> getBookCopy() {
        return bookCopy;
    }
}
