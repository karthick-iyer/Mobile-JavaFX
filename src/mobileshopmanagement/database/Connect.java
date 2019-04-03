/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author madhu
 */
public class Connect {
    
    
    /*
    public Connect() {
        Connection connection = null;
        
        try {
            String dbUrl = "jdbc:sqlite:mobile.db";
            // create a connection to the database  
            connection = DriverManager.getConnection(dbUrl);  
              
            System.out.println("Connection to SQLite has been established.");  
        } catch (Exception e) {
            System.out.println(e.getMessage());  
        }finally{
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }*/
    /*
    public Connection getConnection(){
        Connection connection = null;
        
        try {
            String dbUrl = "jdbc:sqlite:mobile.db";
            // create a connection to the database  
            connection = DriverManager.getConnection(dbUrl);  
        }catch (Exception e) {
            System.out.println(e.getMessage());  
        }
        return connection;     
    }*/
    public static Connection checkConnection(){
        Connection connection = null;
        
        try {
            String dbUrl = "jdbc:sqlite:mobile.db";
            // create a connection to the database  
            connection = DriverManager.getConnection(dbUrl);
            System.out.println("Connection to SQLite has been established.");
        }catch (Exception e) {
            System.out.println(e.getMessage());  
        }
        
        return connection;
    }
}
