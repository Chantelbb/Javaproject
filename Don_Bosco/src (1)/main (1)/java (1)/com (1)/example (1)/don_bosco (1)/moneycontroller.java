package com.example.don_bosco;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class moneycontroller extends NullPointerException {





    public void  switchTomoneypage(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("moneypage.fxml"));
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

    


    public void switchTologout(ActionEvent actionEvent) {
    }

    public void overview(ActionEvent actionEvent) {
    }

    public void savings(ActionEvent actionEvent) {
    }

    public void expenses(ActionEvent actionEvent) {
    }

    public void OKbutton(ActionEvent actionEvent) {
    }

    public void switchToexpenses(ActionEvent actionEvent) {
    }
}
