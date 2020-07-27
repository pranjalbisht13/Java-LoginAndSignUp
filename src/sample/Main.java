package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
         primaryStage.setTitle("Login  Page");
        primaryStage.setScene(new Scene(root, 500, 300));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
