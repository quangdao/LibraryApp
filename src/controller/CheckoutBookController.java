package controller;

import business.Book;
import business.BookCopy;
import business.Member;
import dataccess.ObjectReader;
import dataccess.ObjectWriter;
import javafx.fxml.FXML;

import java.util.ArrayList;
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

        boolean isFoundMember = false;
        boolean isAvailable = false;
        boolean isFoundBook = false;

        for (Member member : members) {
            if (member.getID().equals(memberIdTextField.getText())) {
                isFoundMember = true;
                break;
            }
        }
        List<Book> books = (ArrayList<Book>) ObjectReader.getObjectByFilename("books");

        if (isFoundMember) {
            for (Book book: books) {
                if (book.getIsbn().equals(isbnNumberTextField.getText())) {
                    isFoundBook = true;
                    for (BookCopy bookCopy: book.getBookCopy()) {
                        if (bookCopy.getAvailable()) {
                            isAvailable = true;
                            bookCopy.setAvailable(false);
                            ObjectWriter.Output("books", books);
                        }
                    }
                }
            }
        } else {
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
                alert.setContentText("This book has no available!");
                alert.showAndWait();
            }
        } else {
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Book not found");
            alert.setContentText("System could not find this book!");
            alert.showAndWait();
        }

    }
}
