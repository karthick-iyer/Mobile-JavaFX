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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mobileshopmanagement.database.BillingDB;

public class menuController implements Initializable{

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
    private Label lb_customer;

    @FXML
    private Label lb_sales;

    @FXML
    private Label lb_total;

    @FXML
    private Label lb_stocks;
    
    private BillingDB billingDB = new BillingDB();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        lb_customer.setText( "" + billingDB.getTotalCustomers());
        lb_sales.setText("" + billingDB.getTotalNoOfSales());
        lb_stocks.setText("" + billingDB.getTotalStockes());
        lb_total.setText(" "+ billingDB.getTotalSales());
        
    }

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

