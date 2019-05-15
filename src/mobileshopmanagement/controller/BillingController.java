/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import mobileshopmanagement.database.BillingDB;
import mobileshopmanagement.model.Customer;
import mobileshopmanagement.model.Models;

/**
 *
 * @author madhu
 */
public class BillingController implements Initializable{
    
    @FXML
    private JFXComboBox<String> cmb_model;

    @FXML
    private JFXComboBox cmb_qty;

    @FXML
    private JFXButton btn_confirm;
    
     @FXML
    private JFXButton btn_paytm;

    @FXML
    private JFXButton btn_cash;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private Label lb_price;

    @FXML
    private Label lb_gst;

    @FXML
    private Label lb_cgst;

    @FXML
    private Label lb_total;

    @FXML
    private JFXTextField ed_name;

    @FXML
    private JFXTextField ed_phone;

    @FXML
    private JFXTextField ed_mail;

    @FXML
    private JFXTextField ed_imei;

    @FXML
    private JFXTextArea ed_address;

    @FXML
    private Label lb_date;

    @FXML
    private Label lb_time;

    @FXML
    private Label lb_billno;
    
    private BillingDB billingDB = new BillingDB();
    
    private int selectedModel,selectedQty = 0;
    private float total,grandTotal,gst,cgst = 0;
    private int updatedQty = 0;
    
    private List<Models> model = null;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = billingDB.getAllModels();
        
        List<String> qty = new ArrayList<String>();
        qty.add("1");
        qty.add("2");
        qty.add("3");
        qty.add("4");
        qty.add("5");
        
        model.forEach(i -> cmb_model.getItems().add(i.getModels()));
        
        cmb_qty.getItems().addAll(qty);
        
        lb_price.setText("Press Confrim to Show Price");
        
        lb_cgst.setText("" + 0);
        lb_gst.setText("" + 0);
        lb_total.setText("" + 0);
        
        btn_confirm.setDisable(true);
        btn_paytm.setDisable(true);
        btn_cash.setDisable(true);
        
    }
    
    @FXML
    void onCancelClick(ActionEvent event) {

    }

    @FXML
    void onCashClicked(ActionEvent event) {
        
    }

    @FXML
    void onConfrimClicked(ActionEvent event) {
        selectedModel = cmb_model.getSelectionModel().getSelectedIndex();
        total = convertToInt(model.get(selectedModel).getPrice());
        
        selectedQty = convertToInt(cmb_qty.getSelectionModel().getSelectedItem().toString());
        
        total = selectedQty * total;
        lb_price.setText("Price : " + total);
        
        gst = total * 0.06f;
        cgst = total * 0.06f;
        
        grandTotal = gst + cgst + total;
        
        lb_gst.setText("" + gst);
        lb_cgst.setText("" + cgst);
        lb_total.setText("" + grandTotal);
        
        updatedQty = selectedQty - convertToInt(model.get(selectedModel).getQty());
        
        btn_confirm.setDisable(true);
        
        btn_confirm.setDisable(false);
        btn_paytm.setDisable(false);
        btn_cash.setDisable(false);
        
    }
    

    @FXML
    void onModelSelected(ActionEvent event) {
        selectedModel = cmb_model.getSelectionModel().getSelectedIndex();
        total = convertToInt(model.get(selectedModel).getPrice());
        lb_price.setText("Price : " + total);
    }

    @FXML
    void onPaytmClicked(ActionEvent event) {
        
    }

    @FXML
    void onQtySelected(ActionEvent event) {
        btn_confirm.setDisable(false);
    }
    
    
    private int convertToInt(String v){
        return Integer.parseInt(v);
    }
    
    public Customer validateData(){
        Customer customer = null;
        
        if (ed_name.getText().isEmpty()){
            customer = null;
        }else{
            customer = new Customer(
                    ed_name.getText(), 
                    ed_phone.getText(), 
                    ed_mail.getText(),
                    ed_address.getText(), 
                    model.get(selectedModel).getModels(), 
                    ed_imei.getText(), 
                    "grandTotal", 
                    "date", 
                    "time", 
                    "updatedQty", 
                    "payment", 
                    "billNo");
        }
        return customer;
    }

    
}
