/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.utils;

import javafx.scene.control.Alert;

/**
 *
 * @author madhu
 */
public class AlertBox {
    
    public static final String APP_TITLE = "Mobile Management System";
    
    public Alert showInformationAlert(String info){
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle(APP_TITLE);
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(info);
        infoAlert.showAndWait();
        return infoAlert;
    }
    
    public Alert showErrorAlert(String info){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(APP_TITLE);
        errorAlert.setHeaderText(null);
        errorAlert.setContentText(info);
        errorAlert.showAndWait();
        return errorAlert;
    }
    
}
