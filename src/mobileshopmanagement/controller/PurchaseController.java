/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mobileshopmanagement.database.BillingDB;
import mobileshopmanagement.model.Customer;
import mobileshopmanagement.utils.AlertBox;

/**
 *
 * @author madhu
 */
public class PurchaseController {
    
    @FXML
    private JFXTextField ed_billno;

    @FXML
    private JFXButton btn_search;

    @FXML
    private Label lb_name;

    @FXML
    private Label lb_phone;

    @FXML
    private Label lb_email;

    @FXML
    private Label lb_address;

    @FXML
    private Label lb_imei;

    @FXML
    private Label lb_price;

    @FXML
    private Label lb_model;

    @FXML
    private Label lb_date;

    @FXML
    private Label lb_time;

    @FXML
    private Label lb_qty;

    @FXML
    private Label lb_payment;

    @FXML
    private JFXButton btn_back;
    
    private final BillingDB billingDB = new BillingDB();
    private final AlertBox alert = new AlertBox();
    
    @FXML
    void onBackClicked(ActionEvent event) {
        
    }

    @FXML
    void onSearchClicked(ActionEvent event) {
        Customer billing = billingDB.searchByBillNo(ed_billno.getText());
        
        if (billing!=null){
            lb_name.setText(billing.getName());
            lb_phone.setText(billing.getPhoneNo());
            lb_email.setText(billing.getEmail());
            lb_address.setText(billing.getAddress());
            lb_model.setText(billing.getModel());
            lb_imei.setText(billing.getImei());
            lb_price.setText(billing.getPrice());
            lb_date.setText(billing.getDate());
            lb_time.setText(billing.getTime());
            lb_qty.setText(billing.getQty());
            lb_payment.setText(billing.getPayment());
        }else{
            alert.showErrorAlert("No Bill Found");
        }
    }
    
}
