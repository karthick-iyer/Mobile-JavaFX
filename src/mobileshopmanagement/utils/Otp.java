/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import mobileshopmanagement.database.Connect;

/**
 *
 * @author madhu
 */
public class Otp {
    private Random random = new Random();
    
    private static String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

    static String apiToken = "436963864:AAGWXOu7-xnjwRfbbvr5LeRcNna7-1BKCBg";
    static String chatId = "@mobilevtu";
    static String text = "l";
    
    public static void sendOtp(String msg) {
        text = msg;
        urlString = String.format(urlString, apiToken, chatId, text);

        URL url;
        try {
            url = new URL(urlString);
        URLConnection conn = url.openConnection();

        StringBuilder sb = new StringBuilder();
        InputStream is = new BufferedInputStream(conn.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String inputLine = "";
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        }
        String response = sb.toString();
            System.out.println("Reponse is : "+response);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Otp.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public int generateMyOtp(){
        return random.nextInt(10000);
    }
    
    public int saveMyOtp(int otp){
        try {
            String otpSql = "INSERT INTO OTP(OTPNO) VALUES (?)";
            
            Connection con = Connect.checkConnection();
            PreparedStatement statement = con.prepareStatement(otpSql);
            statement.setString(1, ""+ otp);
            
            con.setAutoCommit(true);
            
            statement.executeUpdate();
            
            statement.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Otp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return otp;
    }
    
    public void clearAllOtp(){
        try {
            String otpSql = "DELETE FROM otp";
            
            Connection con = Connect.checkConnection();
            PreparedStatement statement = con.prepareStatement(otpSql);
            
            con.setAutoCommit(true);
   
            statement.executeUpdate();
            statement.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Otp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getMyOtp(){
        int otp = 0;
        try {
            String otpSql = "SELECT otpno FROM otp LIMIT 1";
            
            Connection con = Connect.checkConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(otpSql);
            
            while (rs.next()) {                
                otp = rs.getInt(1);
            }
            
            rs.close();
            
            statement.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Otp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return otp;
    }

}
