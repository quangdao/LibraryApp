package controller;

import dataccess.ObjectReader;
import javafx.fxml.FXML;

public class AddBookCopyController {
    private MainController main;
    public void setMain(MainController mainController) {
        this.main = mainController;
    }

    @FXML
    public void addBookCopy() {
        System.out.println(ObjectReader.getObjectByFilename("book"));

    }
}
