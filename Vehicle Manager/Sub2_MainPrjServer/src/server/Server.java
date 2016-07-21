/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import abstracte.Vehicul;
import clase.VehiculCargo;
import clase.VehiculPasageri;
import db.sqliteConn;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Airinei
 */
public class Server {
    public static ServerSocket sv;
    public static Socket soc;
    public static OutputStream out;
    public static InputStream in;
    public static ObjectOutputStream fout;
    public static ObjectInputStream fin;
    public static boolean started;
    public static ArrayList<Vehicul> arr;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        sv=new ServerSocket(2002);
        soc=sv.accept();
        System.out.println("Waiting for connection...\n");
        out=soc.getOutputStream();
        in=soc.getInputStream();
        fout=new ObjectOutputStream(out);
        fin=new ObjectInputStream(in);
        started=true;
        fout.writeObject("Connected...");
        System.out.println("Connected...\n");
        arr=new ArrayList<Vehicul>();
        
        Thread com=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    citesteSocket();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        com.start();
        
    }
    
    public static void citesteSocket() throws IOException, ClassNotFoundException, Exception{
        while(started){
            String tipC=(String)fin.readObject();
            System.out.println(tipC+"\n");
            VehiculCargo vc=new VehiculCargo(tipC, 0, tipC, 0);
            VehiculPasageri vp=new VehiculPasageri(tipC, 0, tipC, 0);
            
            if(tipC.equals("closeConnection")){
                System.out.println("Closed from client...\n");
                started=false;
                soc.close();
                sv.close();
                break;
            }
            
            if(tipC.equals("vehiculCargo")){
                vc=(VehiculCargo)fin.readObject();
                System.out.println(vc);
                arr.add(vc);
            }
            
            if(tipC.equals("vehiculPasageri")){
                vp=(VehiculPasageri)fin.readObject();
                System.out.println(vp);
                arr.add(vp);
            }
            
            if(tipC.equals("insert")){
                System.out.println("Inserting in db...\n");
                insertDB();
            }
            
            if(tipC.equals("XML")){
               System.out.println("Inserting in db...\n");
               createXML();
               
            }
        }
    }
    
    public static void insertDB() throws ClassNotFoundException, SQLException{
        Connection con=sqliteConn.connector();
        
        if(con!=null){
            System.out.println("Connected to DB...\n");
        }
        
        String select="select * from Vehicule";
        
        PreparedStatement st=con.prepareStatement(select);
        
        ResultSet rs=st.executeQuery();
        
        while(rs.next()){
            System.out.println(rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4));
        }
        
        con.close();
    }
    
    public static void createXML() throws ClassNotFoundException, SQLException, Exception{
        Connection con=sqliteConn.connector();
        
        if(con!=null){
            System.out.println("Connected to DB...\n");
        }
        
        String select="select * from Vehicule";
        
        PreparedStatement st=con.prepareStatement(select);
        
        ResultSet rs=st.executeQuery();
        ArrayList<Vehicul> arv=new ArrayList<Vehicul>();
        while(rs.next()){
            //System.out.println(rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4));
            
            String tip=rs.getString(2);
            String marca=rs.getString(3);
            String serie=rs.getString(4);
            Float tonaj=rs.getFloat(5);
            Float capac=rs.getFloat(6);
            String elems=rs.getString(7);
            String[] elem=elems.split(",");
            Vector<String> cnpSerii=new Vector<String>();
            
            for(String it:elem){
                cnpSerii.add(it);
            }
            if(tip.equals("VagonCargo")){
                VehiculCargo v=new VehiculCargo(serie,tonaj, marca,capac);
                v.setSeriiMarfuri(cnpSerii);
                
                arv.add(v);
            }
            
            if(tip.equals("VagonPasageri")){
                VehiculPasageri v=new VehiculPasageri(serie,tonaj, marca,capac);
                v.setCNPPasageri(cnpSerii);
                arv.add(v);
            }
        }
        
        for(Vehicul it:arv){
            System.out.println(it.toString());
        }
    }
}
