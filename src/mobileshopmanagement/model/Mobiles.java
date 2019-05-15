/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.model;

/**
 *
 * @author madhu
 */
public class Mobiles {
    
    private int MobileId;
    private String MobileBrand;
    private String MobileModel;
    private String MobileDisplay;
    private String MobilePlatform;
    private String MobileMemory;
    private String MobileCamera;
    private String MobileSensors;
    private String MobileBattery;
    private String MobileColors;
    private String MobileImage;
    private int MobileQuantity;
    private int MobilePrice;

    public Mobiles(int MobileId, String MobileBrand, String MobileModel, String MobileDisplay, String MobilePlatform, String MobileMemory, String MobileCamera, String MobileSensors, String MobileBattery, String MobileColors, String MobileImage, int MobileQuantity, int MobilePrice) {
        this.MobileId = MobileId;
        this.MobileBrand = MobileBrand;
        this.MobileModel = MobileModel;
        this.MobileDisplay = MobileDisplay;
        this.MobilePlatform = MobilePlatform;
        this.MobileMemory = MobileMemory;
        this.MobileCamera = MobileCamera;
        this.MobileSensors = MobileSensors;
        this.MobileBattery = MobileBattery;
        this.MobileColors = MobileColors;
        this.MobileImage = MobileImage;
        this.MobileQuantity = MobileQuantity;
        this.MobilePrice = MobilePrice;
    }

    public int getMobileId() {
        return MobileId;
    }

    public void setMobileId(int MobileId) {
        this.MobileId = MobileId;
    }

    public String getMobileBrand() {
        return MobileBrand;
    }

    public void setMobileBrand(String MobileBrand) {
        this.MobileBrand = MobileBrand;
    }

    public String getMobileModel() {
        return MobileModel;
    }

    public void setMobileModel(String MobileModel) {
        this.MobileModel = MobileModel;
    }

    public String getMobileDisplay() {
        return MobileDisplay;
    }

    public void setMobileDisplay(String MobileDisplay) {
        this.MobileDisplay = MobileDisplay;
    }

    public String getMobilePlatform() {
        return MobilePlatform;
    }

    public void setMobilePlatform(String MobilePlatform) {
        this.MobilePlatform = MobilePlatform;
    }

    public String getMobileMemory() {
        return MobileMemory;
    }

    public void setMobileMemory(String MobileMemory) {
        this.MobileMemory = MobileMemory;
    }

    public String getMobileCamera() {
        return MobileCamera;
    }

    public void setMobileCamera(String MobileCamera) {
        this.MobileCamera = MobileCamera;
    }

    public String getMobileSensors() {
        return MobileSensors;
    }

    public void setMobileSensors(String MobileSensors) {
        this.MobileSensors = MobileSensors;
    }

    public String getMobileBattery() {
        return MobileBattery;
    }

    public void setMobileBattery(String MobileBattery) {
        this.MobileBattery = MobileBattery;
    }

    public String getMobileColors() {
        return MobileColors;
    }

    public void setMobileColors(String MobileColors) {
        this.MobileColors = MobileColors;
    }

    public String getMobileImage() {
        return MobileImage;
    }

    public void setMobileImage(String MobileImage) {
        this.MobileImage = MobileImage;
    }

    public int getMobileQuantity() {
        return MobileQuantity;
    }

    public void setMobileQuantity(int MobileQuantity) {
        this.MobileQuantity = MobileQuantity;
    }

    public long getMobilePrice() {
        return MobilePrice;
    }

    public void setMobilePrice(int MobilePrice) {
        this.MobilePrice = MobilePrice;
    }
    
    

    
}
