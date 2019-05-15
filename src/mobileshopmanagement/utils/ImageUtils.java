/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author madhu
 */
public class ImageUtils {
    
    public Image setImageFromPath(String path){
        BufferedImage bf;
        Image image = null;
        File imageFile = new File(FileUtils.MKDIRPATH + File.separator + path);
        try {
                bf = ImageIO.read(imageFile);
                image = SwingFXUtils.toFXImage(bf, null);
            }catch(IOException ex){
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        return image;
    }  
    
}
