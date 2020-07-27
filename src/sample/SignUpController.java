package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class SignUpController {


    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldIEmail;

    @FXML
    private TextField textFieldIPass;

    @FXML

    private Button registerButton;

    @FXML
    private Button loginNow;




    public void register(ActionEvent event) throws SQLException {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        Window owner = registerButton.getScene().getWindow();

        System.out.println(textFieldName.getText());
        System.out.println(textFieldIEmail.getText());
        System.out.println(textFieldIPass.getText());

        if (textFieldName.getText().isEmpty()) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please enter your name");
            alert.show();

        }

        if (textFieldIEmail.getText().isEmpty()) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please enter your Email ID");
            alert.show();
        }
        if (textFieldIPass.getText().isEmpty()) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please enter your password");
            alert.show();
        }

        String NAME = textFieldName.getText();
        String Email = textFieldIEmail.getText();
        String Password = textFieldIPass.getText();

        MainConnection mainConnection = new MainConnection();
        mainConnection.connect(NAME, Email, Password);

       showAlert(Alert.AlertType.CONFIRMATION,owner," Registration Successful" ,"Welcome " + textFieldName.getText());
    }


        public static void infoBox(String infoMessage, String headerText, String title) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setContentText(infoMessage);
            alert.setTitle(title);
            alert.setHeaderText(headerText);
            alert.showAndWait();

        }

        private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.initOwner(owner);
            alert.show();
        }

    public void login1(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
       // Scene stage = new Scene(root);
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1.setScene((new Scene(root, 500, 300)));
        stage1.show();
    }
}


