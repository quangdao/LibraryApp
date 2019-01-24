package controller;

import java.util.List;

import business.Checkout;
import business.CheckoutEntry;
import dataaccess.ObjectReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import viewModel.CheckoutRecordEntryViewModel;

public class CheckoutRecordsController {
    private MainController main;

    @FXML
    private TableView<CheckoutRecordEntryViewModel> tableView;
    @FXML
    TableColumn<CheckoutRecordEntryViewModel, String> bookNameColumn;
    @FXML
    TableColumn<CheckoutRecordEntryViewModel, String> isbnColumn;
    @FXML
    TableColumn<CheckoutRecordEntryViewModel, String> checkoutDateColumn;
    @FXML
    TableColumn<CheckoutRecordEntryViewModel, String> dueDateColumn;

    public void setMain(MainController mainController) {
        this.main = mainController;
    }

    @FXML
    public void initialize() {
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbnNumber"));
        checkoutDateColumn.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        tableView.setItems(CheckoutRecordModels());
    }

    private ObservableList<CheckoutRecordEntryViewModel> CheckoutRecordModels() {
        List<Checkout> entries = (List<Checkout>) ObjectReader.getObjectByFilename("checkouts");
        ObservableList<CheckoutRecordEntryViewModel> list = FXCollections.observableArrayList();
        for (Checkout entry : entries) {
            for (CheckoutEntry checkoutEntry : entry.getCheckoutEntries()) {
                list.add(new CheckoutRecordEntryViewModel(checkoutEntry));
            }
        }
        return list;
    }
}

