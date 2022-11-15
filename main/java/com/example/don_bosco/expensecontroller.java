package com.example.don_bosco;






import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.EventObject;
import  com.example.don_bosco.logincontroller;


public class expensecontroller {

    @FXML
    private Button expenses;

    @FXML
    private Button logout;

    @FXML
    private Label message;

    @FXML
    private Button ok;

    @FXML
    private Button overview;

    @FXML
    private Button savings;

    @FXML
    private TextField tf_amt;


    @FXML
    private TextField tf_date;

    @FXML
    private TextField tf_type;


    @FXML
    public void ok(ActionEvent e) {
    //    String money_amt = null;
        String Exp_amt = (tf_amt.getText());
     //   String Eav_amt = null;
        String Exp_type = (tf_date.getText());
        String Exp_date = (tf_type.getText());
        String username = logincontroller.user;

        databaseController connectnow = new databaseController();
        Connection connectdb = connectnow.getconnection();
        PreparedStatement psinsert = null;
        PreparedStatement pscheck = null;
        ResultSet resultSet = null;
        if (!tf_amt.getText().isBlank() && !tf_date.getText().isBlank() && !tf_type.getText().isBlank()) {
            try {
                pscheck = connectdb.prepareStatement("select * from exp where Exp_amt= ?");
                // boolean username = false;
                pscheck.setString(1, String.valueOf(Exp_amt));
                resultSet = pscheck.executeQuery();
                if (resultSet.isBeforeFirst()) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("YOU CAN NOT USE THIS USERNAME.");
                    alert.show();
                } else {

                    psinsert = connectdb.prepareStatement("insert into exp (Exp_amt, Exp_type, Exp_date) VALUES (?,?,?)");
                    psinsert.setString(1, String.valueOf(Exp_amt));
                   // psinsert.setString(2, String.valueOf(sav_amt));
                  //  psinsert.setString(3, String.valueOf(money_amt));
                    psinsert.setString(2, String.valueOf(Exp_type));
                    psinsert.setString(3, String.valueOf(Exp_date));
//
                    psinsert.executeUpdate();
                    message.setText("Amount inserted!!");
                }
            } catch (SQLException ep) {
                ep.printStackTrace();
            }
        } else {
            message.setText("All Fields Are compulsory...");

        }

    }




    public void  overview(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("overview.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep)
        {
            ep.printStackTrace();
        }
    }




    public void  savings(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("savings.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep)
        {
            ep.printStackTrace();
        }
    }


    public void  money(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("money.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep)
        {
            ep.printStackTrace();
        }
    }

    public void  expenses(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("expenses.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep)
        {
            ep.printStackTrace();
        }
    }





    public void  logout(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep)
        {
            ep.printStackTrace();
        }
    }

}


