package viewModel;

import business.CheckoutEntry;
import business.Member;
import javafx.beans.property.SimpleStringProperty;

public class OverdueBooksViewModel {
    private SimpleStringProperty bookTitle;
    private SimpleStringProperty isbnNumber;
    private SimpleStringProperty numberOfCopy;
    private SimpleStringProperty dueDate;
    private SimpleStringProperty memberName;

    public OverdueBooksViewModel(CheckoutEntry checkoutEntry, Member member, String numberOfCopies) {
        bookTitle = new SimpleStringProperty(checkoutEntry.getBookCopy().getBook().getTitle());
        isbnNumber = new SimpleStringProperty(checkoutEntry.getBookCopy().getBook().getIsbn());
        numberOfCopy = new SimpleStringProperty(numberOfCopies);
        dueDate = new SimpleStringProperty(checkoutEntry.getDueDate().toString());
        memberName  = new SimpleStringProperty(member.getFirstname());
    }

    public SimpleStringProperty numberOfCopyProperty() {
        return numberOfCopy;
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

