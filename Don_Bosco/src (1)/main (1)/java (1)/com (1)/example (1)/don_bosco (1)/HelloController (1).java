package com.example.don_bosco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Parent root;

    private Stage stage;

    private Scene scene;

    public static String Username = null;

//    public static String getUsername() {
//        return null;
//    }


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void switchTologin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml")); //pass scene name here
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchTosignup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signup.fxml")); //pass scene name here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

        public void switchTooverview(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("overview.fxml")); //pass scene name here
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

            public void switchTomoneypage(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("moneypage.fxml")); //pass scene name here
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
    public void switchToexpenses(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("expenses.fxml")); //pass scene name here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchTosavings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("savings.fxml")); //pass scene name here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchTologout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("logout.fxml")); //pass scene name here
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void overview(ActionEvent actionEvent) {
    }

    public void savings(ActionEvent actionEvent) {
    }

    public void OKbutton(ActionEvent actionEvent) {
    }
}