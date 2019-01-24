package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class SearchOverdueBookController {
    @FXML
    private TextField isbnTextField;

    private MainController main;
    public void setMain(MainController mainController) {
        this.main = mainController;
    }

    @FXML
    public void searchBook() {
        if (isbnTextField.getText().isEmpty()) {
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/OverDueCheckoutRecordsView.fxml"));
            OverDueCheckoutRecordsController controller = new OverDueCheckoutRecordsController(isbnTextField.getText());
            controller.setMain(main);
            loader.setController(controller);
            AnchorPane memberPage = loader.load();

            // Create the dialog Stage.
            Stage memberStage = new Stage();
            memberStage.setTitle("Overdue Records");
            memberStage.initModality(Modality.WINDOW_MODAL);
            memberStage.initOwner(main.getPrimaryStage());
            Scene scene = new Scene(memberPage);
            memberStage.setScene(scene);

            // Show the dialog and wait until the user closes it
            memberStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
