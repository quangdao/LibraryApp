package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {
    private static final long serialVersionUID = -7269538443983243789L;
    private BookCopy bookCopy;
    private LocalDate date;
    private LocalDate duedate;

    public CheckoutEntry(BookCopy bookCopy, LocalDate date, LocalDate dueDate) {
        this.bookCopy = bookCopy;
        this.date = date;
        this.duedate = dueDate;
    }
}
