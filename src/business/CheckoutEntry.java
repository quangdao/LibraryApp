package business;

import java.time.LocalDate;

public class CheckoutEntry {
	private Book book;
	private LocalDate date;
	private LocalDate duedate;
	private double fines;
	private LocalDate returndate;
	
	
	public CheckoutEntry(Book book, LocalDate date, LocalDate duedate, double fines,LocalDate returndate) {
		this.book = book;
		this.date = date;
		this.duedate = duedate;
		this.fines = fines;
		this.returndate = returndate;
	}
}
