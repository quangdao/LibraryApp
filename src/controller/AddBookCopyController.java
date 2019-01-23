package controller;

import business.Book;
import business.BookCopy;
import dataccess.ObjectReader;
import dataccess.ObjectWriter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddBookCopyController {
    private MainController main;

    @FXML
    private TextField isbnTextField;

    public void setMain(MainController mainController) {
        this.main = mainController;
    }

    @FXML
    public void addBookCopy() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(main.getPrimaryStage());

        List<Book> books = (ArrayList<Book>)ObjectReader.getObjectByFilename("books");
        for(Book book: books) {
            if (book.getIsbn().equals(isbnTextField.getText())) {
                book.addBookCopy(new BookCopy(book));
                alert.setTitle("Make a copy successfully");
                alert.setContentText("You have made a copy of this book successfully!");
                alert.showAndWait();
                books.add(book);
                break;
            }
        }

        ObjectWriter.Output("books", books);
    }
}
