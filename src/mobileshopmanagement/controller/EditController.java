/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import mobileshopmanagement.database.MobilesDB;
import mobileshopmanagement.model.Mobiles;
import mobileshopmanagement.utils.AlertBox;
import mobileshopmanagement.utils.ImageUtils;
import static javafx.application.Platform.*;

/**
 *
 * @author madhu
 */
public class EditController {

    private final AlertBox alertBox = new AlertBox();

    @FXML
    private ImageView imageView;

    @FXML
    private JFXTextField ed_brand;

    @FXML
    private JFXTextField ed_model;

    @FXML
    private JFXTextField ed_display;

    @FXML
    private JFXTextField ed_platform;

    @FXML
    private JFXTextField ed_memory;

    @FXML
    private JFXTextField ed_camera;

    @FXML
    private JFXTextField ed_sensor;

    @FXML
    private JFXTextField ed_battery;

    @FXML
    private JFXTextField ed_colors;

    @FXML
    private JFXTextField ed_qty;

    @FXML
    private JFXTextField ed_price;

    @FXML
    private JFXButton btn_update;

    @FXML
    private JFXButton btn_back;

    @FXML
    private JFXButton btn_delete;

    @FXML
    private JFXTextField ed_search;

    @FXML
    private JFXButton btn_search;

    private final ImageUtils imageUtils = new ImageUtils();
    private final MobilesDB mobilesDB = new MobilesDB();
    private Mobiles mobiles = null;
  
    
    @FXML
    void onBackClicked(ActionEvent event) {
        exit();
    }

    @FXML
    void onDeleteClicked(ActionEvent event) {
        if (mobilesDB.deleteMobile(mobiles.getMobileId())) {
            alertBox.showInformationAlert(mobiles.getMobileModel() + " Deleted Successfully !");
        } else {
            alertBox.showInformationAlert(mobiles.getMobileModel() + " Failed To Delete");
        }

    }

    @FXML
    void onSearchClicked(ActionEvent event) {
        String search = ed_search.getText().toString();
        MobilesDB mobilesDB = new MobilesDB();
        mobiles = mobilesDB.searchMobiles(search);

        if (mobiles != null) {
            ed_brand.setText(mobiles.getMobileBrand());
            ed_model.setText(mobiles.getMobileModel());
            ed_display.setText(mobiles.getMobileDisplay());
            ed_platform.setText(mobiles.getMobilePlatform());
            ed_memory.setText(mobiles.getMobileMemory());
            ed_camera.setText(mobiles.getMobileCamera());
            ed_sensor.setText(mobiles.getMobileSensors());
            ed_battery.setText(mobiles.getMobileBattery());
            ed_colors.setText(mobiles.getMobileColors());
            ed_qty.setText("" + mobiles.getMobileQuantity());
            ed_price.setText("" + mobiles.getMobilePrice());
            imageView.setImage(imageUtils.setImageFromPath(mobiles.getMobileImage()));
        } else {
            alertBox.showErrorAlert("No Phone Found !");
        }
    }

    @FXML
    void onUpdateClicked(ActionEvent event) {
        if (ValidateDate() != null) {
            if (mobilesDB.updateMobile(ValidateDate()) ){
                alertBox.showInformationAlert(ValidateDate().getMobileModel() +  " Updated Successfully !");
            }
            else{
                alertBox.showErrorAlert(ValidateDate().getMobileModel() + " Failed To Updated !");
            }
        } else {
            alertBox.showErrorAlert("Enter All Fields");
        }
    }
    
    private Mobiles ValidateDate(){
        Mobiles updateData = null;
        updateData = new Mobiles(
                mobiles.getMobileId(), 
                ed_brand.getText(), 
                ed_model.getText(), 
                ed_display.getText(), 
                ed_platform.getText(), 
                ed_memory.getText(), 
                ed_camera.getText(), 
                ed_sensor.getText(), 
                ed_battery.getText(), 
                ed_colors.getText(), 
                mobiles.getMobileImage(), 
                Integer.parseInt(ed_qty.getText()), 
                Integer.parseInt(ed_price.getText()));
        return updateData;
    }

}
