package sample;

import com.sun.rowset.JdbcRowSetImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;


import javafx.event.ActionEvent;

import javax.naming.Name;

public class Controller {


    public Controller() throws SQLException, ClassNotFoundException {
    }

    @FXML

    private TextField nameField;
    @FXML
    private PasswordField pwdField;

    @FXML
    private Button loginButton;


    public void signUp(ActionEvent event) throws IOException {
        // Window owner1 = signUpButton.getScene().getWindow();

        Parent root2 = FXMLLoader.load(getClass().getResource("signUp.fxml"));

        Scene stage = new Scene(root2);

        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(stage);
        stage1.show();
    }

    public void login(ActionEvent event) throws SQLException {

        Alert alert = new Alert(AlertType.ERROR);

        Window owner = loginButton.getScene().getWindow();

        System.out.println(nameField.getText());
        System.out.println(pwdField.getText());

        if (nameField.getText().isEmpty()) {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("Please Enter your User Name");
            alert.show();

        }
         else if (pwdField.getText().isEmpty()) {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("Please enter valid password");
            alert.show();

        }

        String Name = nameField.getText();
        String password = pwdField.getText();

        Connection connection = new Connection();
        boolean flag = connection.connect(Name, password);

        if (!flag) {
            infoBox("Please enter correct User name and Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "Login Successful");
        }
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
}