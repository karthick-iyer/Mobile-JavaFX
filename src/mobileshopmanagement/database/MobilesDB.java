/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.database;

/**
 *
 * @author madhu
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static mobileshopmanagement.database.Connect.*;
import mobileshopmanagement.model.Mobiles;

public class MobilesDB {

    private String insertSql = "INSERT INTO mobile(brand,model,display,platform,memory,camera,sensors,battery,colors,quantity,price,image) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

    public int insertMobile(Mobiles mobiles) {
        Connection connection = checkConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertSql);
            statement.setString(1, mobiles.getMobileBrand());
            statement.setString(2, mobiles.getMobileModel());
            statement.setString(3, mobiles.getMobileDisplay());
            statement.setString(4, mobiles.getMobilePlatform());
            statement.setString(5, mobiles.getMobileMemory());
            statement.setString(6, mobiles.getMobileCamera());
            statement.setString(7, mobiles.getMobileSensors());
            statement.setString(8, mobiles.getMobileBattery());
            statement.setString(9, mobiles.getMobileColors());
            statement.setInt(10, mobiles.getMobileQuantity());
            statement.setInt(11, (int) mobiles.getMobilePrice());
            statement.setString(12, mobiles.getMobileImage());

            result = statement.executeUpdate();
            statement.close();
            connection.commit();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Mobiles searchMobiles(String searchName) {
        /*String searchQuery = "Select * from mobile where model like '"+searchName+"' "
                + "or model Like '%"+searchName+"%' or model Like '%"+searchName+"' "
                + " model Like '"+searchName+"%'";*/

        String searchQuery = "Select * from mobile m where m.model Like '%" + searchName + "'"
                + "or m.model Like '%" + searchName + "%'or m.model Like '" + searchName + "'"
                + "or m.model Like '" + searchName + "%'";

        Connection connection = checkConnection();
        Statement statement = null;
        Mobiles mobiles = null;
        System.out.println(" Search SQL : " + searchName);
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);
            while (resultSet.next()) {
                mobiles = new Mobiles(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(13),
                        resultSet.getInt(11),
                        resultSet.getInt(12));
            }
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println(" Result set " + mobiles.getMobileImage());
            System.out.println(" Result set " + mobiles.getMobilePrice());

        } catch (Exception e) {
            System.err.println("Error in Search : " + e.getMessage());
        }
        return mobiles;
    }

    public boolean updateMobile(Mobiles mobiles) {
        String updateQuery = "UPDATE mobile SET BRAND=?,MODEL=?,DISPLAY=?,PLATFORM=?,"
                + "MEMORY=?,CAMERA=?,SENSORS=?,BATTERY=?,COLORS=?,QUANTITY=?,PRICE=?,"
                + "IMAGE=? WHERE ID=?";
        
        Connection connection = checkConnection();
        PreparedStatement statement = null;
        
        int result = 0;
        
        try {
            statement = connection.prepareStatement(updateQuery);
            
            statement.setString(1, mobiles.getMobileBrand());
            statement.setString(2, mobiles.getMobileModel());
            statement.setString(3, mobiles.getMobileDisplay());
            statement.setString(4, mobiles.getMobilePlatform());
            statement.setString(5, mobiles.getMobileMemory());
            statement.setString(6, mobiles.getMobileCamera());
            statement.setString(7, mobiles.getMobileSensors());
            statement.setString(8, mobiles.getMobileBattery());
            statement.setString(9, mobiles.getMobileColors());
            statement.setInt(10, mobiles.getMobileQuantity());
            statement.setLong(11, mobiles.getMobilePrice());
            statement.setString(12, mobiles.getMobileImage());
            statement.setInt(13, mobiles.getMobileId());
            
            result = statement.executeUpdate();
            
            statement.close();
            connection.close();
            } catch (SQLException e) {
            System.err.println("Error in Search : " + e.getMessage());
        }
            
        return result > 0;
    }
    
    public boolean deleteMobile(int id){
        String deleteQuery = "DELETE FROM mobile WHERE ID=?";
        Connection connection = checkConnection();
        
        int result = 0;
        
        try {
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            result = statement.executeUpdate();
            
            statement.setInt(1, id);
            result = statement.executeUpdate();
            
            statement.close();
            connection.close();
            } catch (SQLException e) {
            System.err.println("Error in delete : " + e.getMessage());
        }
        return result > 0;
    }
    
    public boolean updateQty(int qty,int id){
        String updateQtySql = "UPDATE mobile SET QUANTITY=? WHERE ID=?";
        Connection connection = checkConnection();
        
        int result = 0;
        
        System.out.println("id : " + id + " qty : " + qty );
        
        try {
            PreparedStatement statement = connection.prepareStatement(updateQtySql);
            
            statement.setInt(1, qty);
            statement.setInt(2, id);
            
            result = statement.executeUpdate();
            
            statement.close();
            connection.close();
            } catch (SQLException e) {
            System.err.println("Error in updateQty : " + e.getMessage());
            e.printStackTrace();
        }
        return result > 0;
    }

}
