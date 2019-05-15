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
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import mobileshopmanagement.utils.FileUtils;
import mobileshopmanagement.model.Mobiles;
import mobileshopmanagement.database.MobilesDB;
import mobileshopmanagement.utils.AlertBox;


public class addMobilesController {
     
    private final AlertBox alertBox = new AlertBox();
    
     @FXML
    private ImageView iv_mobile;

    @FXML
    private JFXTextField txt_brand;

    @FXML
    private JFXTextField txt_model;

    @FXML
    private JFXTextField txt_display;

    @FXML
    private JFXTextField txt_platform;

    @FXML
    private JFXTextField txt_memory;

    @FXML
    private JFXTextField txt_camera;

    @FXML
    private JFXTextField txt_sensors;

    @FXML
    private JFXTextField txt_battery;

    @FXML
    private JFXTextField txt_colors;

    @FXML
    private JFXTextField txt_quantity;

    @FXML
    private JFXTextField txt_price;

    @FXML
    private JFXButton btn_add;

    @FXML
    private JFXButton btn_back;

    @FXML
    private JFXButton btn_upload;
    
    private FileUtils imageUtils = new FileUtils();
    
    private List<Mobiles> mobileList = new ArrayList<>();
    
    private String imagePath = null;
    private String brand,model,display,platform,memory,camera,sensors,battery,colors = null;
    private int quantity,price = 0;
    
    MobilesDB mobilesDB = new MobilesDB();
    
    @FXML
    void imageUpload(ActionEvent event) {
        iv_mobile.setImage(imageUtils.displayImage());
    }

    @FXML
    void onAddClicked(ActionEvent event) {
        imagePath = imageUtils.copyImage();
        if (vaildate()) {
            System.out.println("Enter All The Fields");
        } else {
            makeData();
        }
    }

    @FXML
    void onBackClicked(ActionEvent event) {
        
    }
    
    private boolean vaildate(){
        brand = txt_brand.getText().toString();
        model = txt_model.getText().toString();
        display = txt_display.getText().toString();
        platform = txt_platform.getText().toString();
        memory = txt_memory.getText().toString();
        camera = txt_camera.getText().toString();
        sensors = txt_sensors.getText().toString();
        battery = txt_battery.getText().toString();
        colors = txt_colors.getText().toString();

        if(brand.isEmpty() || model.isEmpty() || display.isEmpty() || platform.isEmpty() || memory.isEmpty() || imagePath.isEmpty() 
                || camera.isEmpty() || sensors.isEmpty() || battery.isEmpty() || colors.isEmpty() || txt_price.getText().isEmpty() || txt_price.getText().isEmpty())
            return true;
        else{
            quantity = Integer.parseInt(txt_quantity.getText().toString());
            price = Integer.parseInt(txt_price.getText().toString());
            return false;
        }
    }
    
     
    
    private void makeData(){
        Mobiles mobiles = new Mobiles(0, brand, model, display, platform, memory, camera, sensors, battery, colors, imagePath, quantity, price);
        
        if(mobilesDB.insertMobile(mobiles) > 0){
            alertBox.showInformationAlert(model + "added Successfully");
            System.out.println("Mobile added Successfully");
        }else{
            alertBox.showErrorAlert(model + "Failed To Added!");
            System.out.println("Error Occured...!!!");
        }
        
    }
}
