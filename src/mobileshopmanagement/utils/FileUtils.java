/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
/**
 *
 * @author madhu
 */
public class FileUtils {
    public static final String MKDIRPATH = ((System.getenv("USERPROFILE"))+("\\Documents\\MobileDir\\")); 
    private Path savePath = Paths.get(MKDIRPATH); 
    private String pathName = null;
    private String fileName = null;
    
    public File openFileChooser(){
        Stage stage = new Stage();
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
        fc.getExtensionFilters().addAll(ext1,ext2);
        File file = fc.showOpenDialog(stage);
        
        this.pathName = file.getAbsolutePath();
        this.fileName = file.getName();
        
        return file;
    }
    
    public Image displayImage(){
        BufferedImage bf;
        Image image = null;
            try {
                bf = ImageIO.read(openFileChooser());
                image = SwingFXUtils.toFXImage(bf, null);
            }catch(IOException ex){
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;
    }
    
    public String getImagePath(){
        return this.pathName;
    }
    
    public String getNamePath(){
        return this.fileName;
    }
    
    public boolean makeDir(){
        boolean isDirExists = Files.exists(savePath);
        
        if (isDirExists) {
            System.out.println("Dir Already Exists : " + savePath.toString());
        } else {
            try {
                savePath = Files.createDirectory(savePath);
                System.out.println("New Directory Created !!!" + savePath.toString());
            } catch (IOException e) {
                System.out.println("Error Occured While Creating Dir : " + savePath.toString());
            }
        }
        return isDirExists;
    }
    
    public String copyImage(){
        Path source = Paths.get(getImagePath());
        Path target = Paths.get(MKDIRPATH + File.separator + getNamePath());
        try {
            Files.copy(source, target,StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image Path : "+ target.toString() );
        } catch(FileAlreadyExistsException e) {
            //destination file already exists
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }
        return getNamePath();
    }
    
}
