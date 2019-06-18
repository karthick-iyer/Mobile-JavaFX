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
public class Models {
    private int id;
    private String models;
    private String price;
    private String qty;

    public Models(int id, String models, String price, String qty) {
        this.id = id;
        this.models = models;
        this.price = price;
        this.qty = qty;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    
    
    
    
}
