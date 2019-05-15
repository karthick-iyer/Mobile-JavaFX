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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class menuController {

    @FXML
    private JFXButton btn_dashboard;

    @FXML
    private JFXButton btn_mobiles;

    @FXML
    private JFXButton btn_billing;

    @FXML
    private JFXButton btn_purchase;

    @FXML
    private JFXButton btn_about;

    @FXML
    private JFXButton btn_exit;

    @FXML
    void aboutClicked(ActionEvent event) {

    }

    @FXML
    void billingClicked(ActionEvent event) {
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
    void dashboardClicked(ActionEvent event) throws Exception{
        try {
            FXMLLoader menu =new FXMLLoader(getClass().getResource("/res/menu.fxml"));
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
    void exitClicked(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void mobilesClicked(ActionEvent event) {
        try {
            FXMLLoader menu =new FXMLLoader(getClass().getResource("/res/mobiles.fxml"));
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
    void purchaseClicked(ActionEvent event) {
        try {
            FXMLLoader menu =new FXMLLoader(getClass().getResource("/res/purchase.fxml"));
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

