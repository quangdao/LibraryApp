package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import viewModel.CheckoutRecordEntry;

public class CheckoutRecordsController {
    private MainController main;
    public void setMain(MainController mainController) {
        this.main = mainController;
    }

    @FXML
    private TableView<CheckoutRecordEntry> checkoutTable;
    @FXML
    private TableColumn<CheckoutRecordEntry, String> isbnColumn;
    @FXML
    private TableColumn<CheckoutRecordEntry, String> bookNameColumn;
    @FXML
    private TableColumn<CheckoutRecordEntry, String> checkoutDateColumn;
    @FXML
    private TableColumn<CheckoutRecordEntry, String> dueDateColumn;

    @FXML
    public void initialize() {
//        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
//        permissionColumn.setCellValueFactory(new PropertyValueFactory<>("permission"));
    }
}
