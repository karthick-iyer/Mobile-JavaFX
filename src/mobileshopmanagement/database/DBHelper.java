/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author madhu
 */
public class DBHelper {
    
    public boolean checkLogin(String user,String pass){
        String sql = "SELECT * from login WHERE username='"+user+"' and password='"+pass+"'";
        int count = 0;
        try {
            Connection connection = Connect.checkConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            count =  resultSet.getInt("id");
            System.out.println("Count : "+ count);
            /*while (resultSet.next()) {                
                System.out.println(resultSet.getInt("id")+  "\t" +
                        resultSet.getString("username")+  "\t" +
                        resultSet.getString("password")+  "\t");
            }*/
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        if (count > 0)
                return true;
            else
                return false;
    }
            
    
}
