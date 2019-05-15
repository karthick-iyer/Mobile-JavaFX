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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;
import mobileshopmanagement.model.Mobiles;
import mobileshopmanagement.database.MobilesDB;
import mobileshopmanagement.utils.AlertBox;
import mobileshopmanagement.utils.FileUtils;
import mobileshopmanagement.utils.ImageUtils;

public class mobilesController {

    private final AlertBox alertBox = new AlertBox();

    @FXML
    private JFXTextField ed_search;

    @FXML
    private JFXButton btn_search;

    @FXML
    private JFXButton btn_buy;

    @FXML
    private JFXButton btn_edit;

    @FXML
    private JFXButton btn_add;

    @FXML
    private Label lb_brand;

    @FXML
    private Label lb_model;

    @FXML
    private Label lb_display;

    @FXML
    private Label lb_platform;

    @FXML
    private Label lb_memory;

    @FXML
    private Label lb_camera;

    @FXML
    private Label lb_sensors;

    @FXML
    private Label lb_battery;

    @FXML
    private Label lb_colors;

    @FXML
    private Label lb_qty;

    @FXML
    private Label lb_price;

    @FXML
    private ImageView img;

    private final ImageUtils imageUtils = new ImageUtils();

    @FXML
    void addClicked(ActionEvent event) {
        try {
            FXMLLoader menu = new FXMLLoader(getClass().getResource("/res/add_mobiles.fxml"));
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
            FXMLLoader menu = new FXMLLoader(getClass().getResource("/res/billing.fxml"));
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
            FXMLLoader menu = new FXMLLoader(getClass().getResource("/res/edit_mobiles.fxml"));
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
    void onSearchClicked(ActionEvent event) {
        String search = ed_search.getText().toString();
        MobilesDB mobilesDB = new MobilesDB();
        final Mobiles mobiles = mobilesDB.searchMobiles(search);

        if (mobiles != null) {
            lb_brand.setText(mobiles.getMobileBrand());
            lb_model.setText(mobiles.getMobileModel());
            lb_battery.setText(mobiles.getMobileBattery());
            lb_camera.setText(mobiles.getMobileCamera());
            lb_display.setText(mobiles.getMobileDisplay());
            lb_memory.setText(mobiles.getMobileMemory());
            lb_model.setText(mobiles.getMobileModel());
            lb_platform.setText(mobiles.getMobilePlatform());
            lb_sensors.setText(mobiles.getMobileSensors());
            lb_qty.setText(" " + mobiles.getMobileQuantity());
            lb_price.setText(" " + mobiles.getMobilePrice());
            img.setImage(imageUtils.setImageFromPath(mobiles.getMobileImage()));
        } else {
            alertBox.showErrorAlert("No Phone Found!");
        }
    }

}
