package controller;

import business.Checkout;
import business.CheckoutEntry;
import dataaccess.ObjectReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import viewModel.OverdueBooksViewModel;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class OverDueCheckoutRecordsController implements Initializable {
    private MainController main;
    private String isbnBook;

    public void setMain(MainController mainController) {
        this.main = mainController;
    }

    public OverDueCheckoutRecordsController(String isbnBook) {
        this.isbnBook = isbnBook;
    }

    @FXML
    private TableView<OverdueBooksViewModel> overDueTable;
    @FXML
    TableColumn<OverdueBooksViewModel, String> bookTitleColumn;
    @FXML
    TableColumn<OverdueBooksViewModel, String> isbnColumn;
    @FXML
    TableColumn<OverdueBooksViewModel, Integer> numberOfCopyColumn;
    @FXML
    TableColumn<OverdueBooksViewModel, String> dueDateColumn;
    @FXML
    TableColumn<OverdueBooksViewModel, String> memberNameColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbnNumber"));
        numberOfCopyColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfCopy"));
        memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        overDueTable.setItems(CheckoutRecordModels());
    }

    private ObservableList<OverdueBooksViewModel> CheckoutRecordModels() {
        List<Checkout> entries = (List<Checkout>) ObjectReader.getObjectByFilename("checkouts");
        ObservableList<OverdueBooksViewModel> list = FXCollections.observableArrayList();
        for (Checkout entry : entries) {
            for (CheckoutEntry checkoutEntry : entry.getCheckoutEntries()) {
                if (checkoutEntry.getDueDate().isBefore(LocalDate.now()) && checkoutEntry.getBookCopy().getBook().getIsbn().equals(isbnBook)) {
                    list.add(new OverdueBooksViewModel(checkoutEntry, entry.getMember(), String.valueOf(checkoutEntry.getBookCopy().getBook().getNumberOfCopies())));
                }
            }
        }
        return list;
    }
}
