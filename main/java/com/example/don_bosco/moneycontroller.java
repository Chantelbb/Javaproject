package com.example.don_bosco;


//public class moneycontroller extends NullPointerException {




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


public class moneycontroller {

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
    private TextField tf_amount;


    @FXML
        public void ok(ActionEvent e){
            String money_amt =(tf_amount.getText());
            String exp_amt = null;
            String sav_amt = null;
           String exp_type = null;
            String exp_date = null;
//

            databaseController connectnow = new databaseController();
            Connection connectdb = connectnow.getconnection();
            PreparedStatement psinsert = null;
            PreparedStatement pscheck = null;
            ResultSet resultSet = null;
            if (!tf_amount.getText().isBlank()) {
                try {
                    pscheck = connectdb.prepareStatement("select * from category where money_amt= ?");
                    // boolean username = false;
                    pscheck.setString(1, String.valueOf(money_amt));
                    resultSet = pscheck.executeQuery();
                    if (resultSet.isBeforeFirst()) {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("YOU CAN NOT USE THIS USERNAME.");
                        alert.show();
                    } else {

                        psinsert = connectdb.prepareStatement("insert into category (exp_amt, sav_amt, money_amt, exp_type, exp_date) VALUES (?,?,?,?,?)");
                        psinsert.setString(1, String.valueOf(exp_amt));
                        psinsert.setString(2,String.valueOf(sav_amt));
                        psinsert.setString(3, String.valueOf(money_amt));
                        psinsert.setString(4, String.valueOf(exp_type));
                        psinsert.setString(5, String.valueOf(exp_date));
//
                        psinsert.executeUpdate();
                        message.setText("Amount inserted!!");
                    }
                } catch (SQLException ep) {
                    ep.printStackTrace();
                }
            }
            else {
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
