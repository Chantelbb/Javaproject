package com.example.don_bosco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.*;
    public  class signupController extends NullPointerException {

        @FXML
        private Label message;
        @FXML
        private TextField Username;
        //@FXML
        //private TextField lastname;
        //@FXML
        //private TextField firstname;
        @FXML
        private TextField Email;
        @FXML
        private PasswordField Password;
        // @FXML
        //private PasswordField tf_confirmpassword;

        @FXML
        protected void switchTooverview(ActionEvent e) {

         // String Firstname = tf_firstname.getText();
           // String Lastname = tf_lastname.getText();
            String username = Username.getText();
            String email = Email.getText();
            String password = Password.getText();
            //String Confirmpassword = tf_confirmpassword.getText();

            databaseController connectnow = new databaseController();
            Connection connectdb = connectnow.getconnection();
            PreparedStatement psinsert = null;
            PreparedStatement pscheck = null;
            ResultSet resultSet = null;
            if ( !Username.getText().isBlank() && !Email.getText().isBlank() && !Password.getText().isBlank()) {
                try {
                    pscheck = connectdb.prepareStatement("select * from user where username= ?");
                    pscheck.setString(1, String.valueOf(username));
                    resultSet = pscheck.executeQuery();
                    if (resultSet.isBeforeFirst()) {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("YOU CAN NOT USE THIS USERNAME.");
                        alert.show();
                    } else {

                        psinsert = connectdb.prepareStatement("insert into user VALUES (?,?,?)");
                        psinsert.setString(1, String.valueOf(username));
                        //psinsert.setString(2, Firstname);
                       // psinsert.setString(3, Lastname);
                        psinsert.setString(2, email);
                        psinsert.setString(3, password);
                       // psinsert.setString(6, Confirmpassword);
                        psinsert.executeUpdate();
                        message.setText("Registered Successfully!!");
                    }
                } catch (SQLException ep) {
                    ep.printStackTrace();
                }
            } else {
                message.setText("All Fields Are compulsory...");

            }

        }

        @FXML
        protected void login(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                ((Node) (e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
        }

        @FXML
        protected void signup(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                ((Node) (e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
        }
    }

