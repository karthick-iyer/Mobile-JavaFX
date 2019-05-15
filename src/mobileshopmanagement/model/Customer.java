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
public class Customer {
    
    private int id;
    private String name;
    private String phoneNo;
    private String email;
    private String address;
    private String model;
    private String imei;
    private String price;
    private String date;
    private String time;
    private String qty;
    private String payment;
    private String billNo;

    public Customer(String name, String phoneNo, String email, String address, String model, String imei, String price, String date, String time, String qty, String payment, String billNo) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.model = model;
        this.imei = imei;
        this.price = price;
        this.date = date;
        this.time = time;
        this.qty = qty;
        this.payment = payment;
        this.billNo = billNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
}
