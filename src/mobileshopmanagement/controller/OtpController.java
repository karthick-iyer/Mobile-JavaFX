/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mobileshopmanagement.utils.AlertBox;
import mobileshopmanagement.utils.Otp;

/**
 *
 * @author madhu
 */
public class OtpController implements Initializable {

    private Otp otp = new Otp();
    private int myOtp = 0;
    private AlertBox alertBox = new AlertBox();
    
    public static final String msg = "Hello Mobile Admin, OTP to login is : ";
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        sentOtp();
        alertBox.showInformationAlert("OTP Sent Successfully..!!");
    }

    @FXML
    private TextField txt_otp;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_resend;

    @FXML
    void onLoginClicked(ActionEvent event) {
        if (txt_otp.getText().equalsIgnoreCase(""+otp.getMyOtp())) {
            alertBox.showInformationAlert("Login Success fully...!!!");
            try {
                FXMLLoader menu = new FXMLLoader(getClass().getResource("/res/menu.fxml"));
                Parent MenuParent = (Parent) menu.load();
                Stage stage = new Stage();
                stage.initModality(Modality.NONE);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("OTP Login - Mobile Shop");
                stage.setScene(new Scene(MenuParent));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            alertBox.showErrorAlert("Enter Correct Otp...!!!");
        }
    }

    @FXML
    void onResendClicked(ActionEvent event) {
        Otp.sendOtp(msg + otp.getMyOtp());
        alertBox.showInformationAlert("OTP Sent Successfully..!!");
    }

    private void sentOtp() {
        otp.clearAllOtp();
        otp.saveMyOtp(otp.generateMyOtp());
        Otp.sendOtp(msg + otp.getMyOtp());
    }
}
