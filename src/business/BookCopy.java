package business;

import java.io.Serializable;

public class BookCopy implements Serializable {
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
}
