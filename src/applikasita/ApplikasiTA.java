/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package applikasita;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class ApplikasiTA {
    public ApplikasiTA() {
    }
    Connection con;
    Statement sta;
    
    public static void main(String[] args) {
        ApplikasiTA db = new ApplikasiTA();
        db.config();
        System.err.println(db.getConnection());
    }

    public void config() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uasAlpro2",
                    "root", "");
            sta = con.createStatement();
            System.err.println(con);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApplikasiTA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ApplikasiTA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        return con;
    }    
    
}
