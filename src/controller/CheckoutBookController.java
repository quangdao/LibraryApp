package controller;

import business.*;
import dataaccess.ObjectReader;
import dataaccess.ObjectWriter;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CheckoutBookController {
    private MainController main;
    public void setMain(MainController mainController) {
        this.main = mainController;
    }

    @FXML
    private TextField memberIdTextField;
    @FXML
    private TextField isbnNumberTextField;

    @FXML
    public void checkoutBook() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        List<Member> members = (ArrayList<Member>) ObjectReader.getObjectByFilename("members");
        List<Book> books = (ArrayList<Book>) ObjectReader.getObjectByFilename("books");

        boolean isFoundMember = false;
        boolean isAvailable = false;
        boolean isFoundBook = false;

        for (Member member : members) {
            if (member.getID().equals(memberIdTextField.getText())) {
                isFoundMember = true;
                for (Book book: books) {
                    if (book.getIsbn().equals(isbnNumberTextField.getText())) {
                        isFoundBook = true;
                        for (BookCopy bookCopy: book.getBookCopy()) {
                            if (bookCopy.getAvailable()) {
                                isAvailable = true;
                                bookCopy.setAvailable(false);
                                // would over all old data?
                                ObjectWriter.Output("books", books);
                                // write to checkout entry foundMember
                                this.checkoutRecord(bookCopy, member);
                                break;
                            }
                        }
                    }
                    if (isAvailable) {
                        break;
                    }
                }
                break;
            }
        }

        if (!isFoundMember) {
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No member found");
            alert.setContentText("System could not find this member!");
            alert.showAndWait();
            return;
        }

        if (isFoundBook) {
            if (isAvailable) {
                alert.initOwner(main.getPrimaryStage());
                alert.setTitle("Checkout successfully");
                alert.setContentText("This book has checkout successfully!");
                alert.showAndWait();
            } else {
                alert.initOwner(main.getPrimaryStage());
                alert.setTitle("No book available");
                alert.setContentText("This book is not available!");
                alert.showAndWait();
            }
        } else {
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Book not found");
            alert.setContentText("System could not find this book!");
            alert.showAndWait();
        }
    }

    private void checkoutRecord(BookCopy bookCopy, Member member) {
        LocalDate dueDate = LocalDate.now().plusDays(bookCopy.getLengthCheckout());
        List<CheckoutEntry> checkoutEntries = Arrays.asList(new CheckoutEntry(bookCopy, LocalDate.now(), dueDate));
        Checkout checkout = new Checkout(member, checkoutEntries);

        List<Checkout> checkouts =  (List<Checkout>)ObjectReader.getObjectByFilename("checkouts");
        checkouts.add(checkout);

        ObjectWriter.Output("checkouts", checkouts);
    }
}
