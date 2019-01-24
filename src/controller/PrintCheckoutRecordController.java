package controller;

import business.Checkout;
import business.CheckoutEntry;
import dataaccess.ObjectReader;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.List;

public class PrintCheckoutRecordController {
    private MainController main;
    public void setMain(MainController mainController) {
        this.main = mainController;
    }

    @FXML
    private TextField memberIdTextField;

    @FXML
    public void printRecords() {
        String memberId = memberIdTextField.getText();

        if (memberId != null) {
            List<Checkout> entries = (List<Checkout>) ObjectReader.getObjectByFilename("checkouts");
            for (Checkout entry : entries) {
                if (memberId.equals(entry.getMember().getID())) {
                    for (CheckoutEntry checkoutEntry : entry.getCheckoutEntries()) {
                        System.out.println(checkoutEntry);
                    }
                }
            }
        }
    }
}
