/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mobileshopmanagement.database.*;
import mobileshopmanagement.database.DBHelper;
import mobileshopmanagement.utils.FileUtils;


/**
 *
 * @author madhu
 */
public class LoginController implements Initializable{

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    @FXML
    private Button btn_login;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        FileUtils file = new FileUtils();
        file.makeDir();
    }
    
    

    @FXML
    void loginClicked(ActionEvent event) throws Exception{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        String user = txt_username.getText().toString();
        String pass = txt_password.getText().toString();
        
        DBHelper dBHelper = new DBHelper();
        if(dBHelper.checkLogin(user, pass)){
            alert.setTitle("Login Successfull");
            alert.setHeaderText(null);
            alert.setContentText("Login Successfull");
            alert.showAndWait();
            
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
            
        }else{
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Login Failed");
            alert.showAndWait(); 
        }
    }
    
    private void txt_print(ActionEvent e){
        System.out.println("mobileshopmanagement.controller.LoginController.txt_print()");
    }
   
}
