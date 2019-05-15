/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static mobileshopmanagement.database.Connect.*;
import mobileshopmanagement.model.Customer;
import mobileshopmanagement.model.Models;

/**
 *
 * @author madhu
 */
public class BillingDB {

    private String insertQuery = "INSERT INTO `billing`(`name`,`phone`,"
            + "`email`,`address`,`model`,`imei`,`price`,`qty`,`date`,`time`,"
            + "`payment`,`billno`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private String updateQuery = "UPDATE `billing` SET (name=?,phone=?,"
            + "email=?,address=?,model=?,imei=?,price=?,qty=?,date=?,time=?,"
            + "payment=?,billno=?) WHERE id=?";

    private String deleteQuery = "DELETE FROM `billing` WHERE id=?";

    private String searchQuery = "SELECT * FROM `billing` WHERE `billno`=?";

    public Customer searchByBillNo(String billno) {
        Customer customer = null;

        Connection connection = checkConnection();
        PreparedStatement statement = null;

        System.out.println(" Search SQL : " + billno);
        try {
            statement = connection.prepareStatement(searchQuery);
            statement.setString(1, billno);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13));
            }
            System.err.println("" + resultSet.getString(2)
                    + resultSet.getString(3));
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.err.println("Error in Search : " + e.getMessage());
        }

        return customer;
    }

    public boolean isBillingDone(Customer customer) {
        int result = 0;

        Connection connection = checkConnection();
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertQuery);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getPhoneNo());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getModel());
            statement.setString(6, customer.getImei());
            statement.setString(7, customer.getPrice());
            statement.setString(8, customer.getDate());
            statement.setString(9, customer.getTime());
            statement.setString(10, customer.getQty());
            statement.setString(11, customer.getPayment());
            statement.setString(12, customer.getBillNo());
            
            result = statement.executeUpdate();
            
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.err.println("Error in Search : " + e.getMessage());
        }

        return result > 0;
    }
    
    public List<Models> getAllModels(){
        String getModelsSQL = "SELECT model,price,quantity FROM mobile";
        List<Models> models = new ArrayList<Models>();
        
        Connection connection = checkConnection();
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getModelsSQL);
            
            while (resultSet.next()) {
                Models m = new Models(resultSet.getString(1),resultSet.getString(2),
                resultSet.getString(3));
                models.add(m);
                
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println("Error in Search : " + e.getMessage());
        }
        
        
        
        return models;
    }
}
