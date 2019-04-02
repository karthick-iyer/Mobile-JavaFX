/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement;

import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author madhu
 */
public class MobileShopManagement extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(v->System.out.println("Hello World!" ));
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
        
        Parent root = FXMLLoader.load(getClass().getResource("/res/login.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     
    public static void main(String[] args) {
        launch(args);
    }*/
    
}
