package viewModel;

import business.CheckoutEntry;
import business.Member;
import javafx.beans.property.SimpleStringProperty;

public class CheckoutRecordEntryViewModel {

    private SimpleStringProperty bookTitle;
    private SimpleStringProperty isbnNumber;
    private SimpleStringProperty checkoutDate;
    private SimpleStringProperty dueDate;
    private SimpleStringProperty memberName;

    public CheckoutRecordEntryViewModel(CheckoutEntry checkoutEntry, Member member) {
        bookTitle = new SimpleStringProperty(checkoutEntry.getBookCopy().getBook().getTitle());
        isbnNumber = new SimpleStringProperty(checkoutEntry.getBookCopy().getBook().getIsbn());
        checkoutDate = new SimpleStringProperty(checkoutEntry.getCheckoutDate().toString());
        dueDate = new SimpleStringProperty(checkoutEntry.getDueDate().toString());
        memberName  = new SimpleStringProperty(member.getFirstname());
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
    
    public SimpleStringProperty memberNameProperty() {
        return memberName;
    }
}