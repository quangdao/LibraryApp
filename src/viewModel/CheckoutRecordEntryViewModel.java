package viewModel;

import business.CheckoutEntry;
import javafx.beans.property.SimpleStringProperty;

public class CheckoutRecordEntryViewModel {

    private SimpleStringProperty bookTitle;
    private SimpleStringProperty isbnNumber;
    private SimpleStringProperty checkoutDate;
    private SimpleStringProperty dueDate;

    public CheckoutRecordEntryViewModel(CheckoutEntry checkoutEntry) {
        bookTitle = new SimpleStringProperty(checkoutEntry.getBookCopy().getBook().getTitle());
        isbnNumber = new SimpleStringProperty(checkoutEntry.getBookCopy().getBook().getIsbn());
        checkoutDate = new SimpleStringProperty(checkoutEntry.getCheckoutDate().toString());
        dueDate = new SimpleStringProperty(checkoutEntry.getDueDate().toString());
    }

    public SimpleStringProperty checkoutDateProperty() {
        return checkoutDate;
    }

    public SimpleStringProperty dueDateProperty() {
        return dueDate;
    }

    public SimpleStringProperty bookTitleProperty() {
        return bookTitle;
    }

    public SimpleStringProperty isbnNumberProperty() {
        return isbnNumber;
    }
}