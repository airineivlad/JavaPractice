/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clase.TrenMarfa;
import clase.TrenPasageri;
import claseAbstracte.Tren;
import dbcon.sqliteConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import jaxb.TrenListJAXB;
/**
 *
 * @author Airinei
 */
public class Main {
    public static boolean started;
    public static ServerSocket serverSocket;
    public static Socket soc;
    public static OutputStream out;
    public static InputStream in;
    public static ObjectOutputStream fout;
    public static ObjectInputStream fin;
    public static TrenMarfa trenMarfaPrimit;
    public static TrenPasageri trenPasageriPrimit;
    public static Connection con;
    public static ArrayList<Tren> listTren;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        con=sqliteConnection.dbConnector();
        if(con!=null){
            System.out.println("Conectiune cu bd realizata...");
        }
        //citesteBD();
        
        listTren=new ArrayList<Tren>();
        serverSocket = new ServerSocket(2001);
        soc=serverSocket.accept();
        out= soc.getOutputStream();
        in=soc.getInputStream();
        fout= new ObjectOutputStream(out);
        fin=new ObjectInputStream(in);
        
        
        fout.writeObject("Connected...\n");
//        TrenPasageri p = new TrenPasageri(3f,"Serie",4f,"Marca");
//        fout.writeObject(p);
        System.out.println("Connected...\n");
        started = true;
        
        Thread responseThread= new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    citesteSocket();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        responseThread.start();
        
        
    }
    
    public static void citesteSocket() throws IOException, ClassNotFoundException, SQLException, Exception{
        while(started){
           
            String s=(String)fin.readObject();
            System.out.println(s);
            
            if(s.equals("Close server\n")){
                soc.close();
                serverSocket.close();
                started=false;
                break;
            }
            
            if(s.equals("TrenPasageri...\n")){
                trenPasageriPrimit=(TrenPasageri)fin.readObject();
                listTren.add(trenPasageriPrimit);
                System.out.println(trenPasageriPrimit);
            }
            
            if(s.equals("TrenMarfa...\n")){
                trenMarfaPrimit=(TrenMarfa)fin.readObject();
                listTren.add(trenMarfaPrimit);
                System.out.println(trenMarfaPrimit);
            }
            
            if(s.equals("Insert")){
                insertBD();
            }
            
            if(s.equals("XML")){
                writeXML("trens.xml");
            }
        }
    }

    public static void insertBD() throws SQLException, Exception{
        //TrenPasageri tm= new TrenPasageri(3.0f,"S005",80.0f,"Coing");
        
        String clean="delete from Trenuri";
        PreparedStatement d=con.prepareStatement(clean);
        d.executeUpdate();
        String query="insert into Trenuri values (?,?,?,?,?,?)";
        PreparedStatement stm;
        stm = con.prepareStatement(query);
        
        stm.setString(6, "CNP1,CNP2");
        
        
        for(Tren tm:listTren){
            
            stm.setString(2, tm.getMarca());
            stm.setString(3, tm.getSerie());
            stm.setFloat(4, tm.getTonaj());
            stm.setFloat(5, tm.getCapacitate());
            if(tm instanceof TrenPasageri){
                stm.setString(1, "TrenPasageri");
                System.out.println("Inserting " + tm);
                stm.setString(6, ((TrenPasageri) tm).getCnpCalatori().toString());
            }
            
            if(tm instanceof TrenMarfa){
                stm.setString(1, "TrenMarfa");
                System.out.println("Inserting " + tm);
                stm.setString(6, ((TrenMarfa) tm).getSerieMarfuri().toString());
            }
            stm.addBatch();
        }
        
        stm.executeBatch();
        System.out.println("Trenuri inserate....\n");
        //rs.next();
//        
//        String tip=rs.getString(1);
//        String marca=rs.getString(2);
//        String serie=rs.getString(3);
//        Float tonaj=rs.getFloat(4);
//        Float capacitate=rs.getFloat(5);
//        
//        System.out.println(tip+marca+serie);
//        
        //rs.close();
    }
    
    public static ArrayList<Tren> citesteBD() throws SQLException, Exception{
        
        ArrayList<Tren> arr= new ArrayList<Tren>();
        
        String select="select * from Trenuri";
        Statement stm= con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        
        ResultSet rs=stm.executeQuery(select);
        //rs.beforeFirst();
        
        while(rs.next()){
            String tip=rs.getString(1);
            String marca=rs.getString(2);
            String serie=rs.getString(3);
            Float tonaj=rs.getFloat(4);
            Float capac=rs.getFloat(5);
            String cnpSerii=rs.getString(6);
            String[] elems=cnpSerii.split(",");
            Vector<String> v=new Vector<String>();
            for(String it:elems){
                v.add(it);
            }
            //System.out.println(tip+" " + marca+" " + serie+" " + tonaj+" " +capac+" " + cnpSerii);
            //tip, marca, serie, tonaj, capac, cnpSerii
            
            if(tip.equals("TrenMarfa")){
                TrenMarfa t= new TrenMarfa(capac, serie, tonaj, marca);
                t.setSerieMarfuri(v);
                arr.add(t);
            }
            
            if(tip.equals("TrenPasageri")){
                TrenPasageri t= new TrenPasageri(capac, serie, tonaj, marca);
                t.setCnpCalatori(v);
                arr.add(t);
            }
        }
        
        return arr;
    }
    
    public static void writeXML(String numeFis) throws Exception{
        
        ArrayList<Tren> ls=new ArrayList<Tren>();
        ls=citesteBD();
        TrenListJAXB tlx=new TrenListJAXB();
        tlx.marshall(ls,numeFis);
    }
}
