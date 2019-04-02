/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.controller;

/**
 *
 * @author madhu
 */
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mobilesController {

    @FXML
    private JFXButton btn_buy;

    @FXML
    private JFXButton btn_edit;

    @FXML
    private JFXButton btn_add;

    @FXML
    void addClicked(ActionEvent event) {
        try {
            FXMLLoader menu =new FXMLLoader(getClass().getResource("/res/add_mobiles.fxml"));
            Parent MenuParent = (Parent) menu.load();
            Stage stage = new Stage();
            stage.initModality(Modality.NONE);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Dashboard - Mobile Shop");
            stage.setScene(new Scene(MenuParent));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void buyClicked(ActionEvent event) {
        try {
            FXMLLoader menu =new FXMLLoader(getClass().getResource("/res/billing.fxml"));
            Parent MenuParent = (Parent) menu.load();
            Stage stage = new Stage();
            stage.initModality(Modality.NONE);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Dashboard - Mobile Shop");
            stage.setScene(new Scene(MenuParent));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editClicked(ActionEvent event) {
        try {
            FXMLLoader menu =new FXMLLoader(getClass().getResource("/res/edit_mobiles.fxml"));
            Parent MenuParent = (Parent) menu.load();
            Stage stage = new Stage();
            stage.initModality(Modality.NONE);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Dashboard - Mobile Shop");
            stage.setScene(new Scene(MenuParent));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
    }
    }

}

