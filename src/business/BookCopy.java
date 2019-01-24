package business;

import java.io.Serializable;

public class BookCopy implements Serializable {
	private static final long serialVersionUID = 1059359475932838805L;
	private Book book;
	private boolean available;

	public BookCopy(Book book) {
		this.available = true;
		this.book = book;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Integer getLengthCheckout() {
		return book.getCheckoutLength();
	}

	public Book getBook() {
		return book;
	}
}
