
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcon;
import java.sql.*;

/**
 *
 * @author Airinei
 */
public class sqliteConnection {
    public static Connection con=null;
    public static Connection dbConnector() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        con=DriverManager.getConnection("jdbc:sqlite:D:\\ASE\\Anul 2\\Java\\Web Browser Project\\Sub1_MainPrjServer\\TRENURI.sqlite");
        return con;
    }
}
