/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.*;

/**
 *
 * @author Airinei
 */
public class sqliteConn {
    public static  Connection con =null;
    public static Connection connector() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        con=DriverManager.getConnection("jdbc:sqlite:D:\\ASE\\Anul 2\\Java\\Web Browser Project\\Sub2_MainPrjServer\\Vehicul.sqlite");
        return con;
    }
}
