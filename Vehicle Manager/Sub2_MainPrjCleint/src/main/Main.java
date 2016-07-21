/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import abstracte.Vehicul;
import clase.OperatiiInOutFisier;
import clase.VehiculCargo;
import clase.VehiculPasageri;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Airinei
 */
public class Main {
    public static Socket soc;
    public static OutputStream out;
    public static InputStream in;
    public static ObjectOutputStream fout;
    public static ObjectInputStream fin;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
        OperatiiInOutFisier ou=new OperatiiInOutFisier("m.txt");
        ArrayList<Vehicul> ar=ou.citesteObiecteDinFisierText(new VehiculCargo(), "m.txt");
        
        for(Vehicul v:ar){
            System.out.println(v);
        }
        
//        OperatiiInOutFisier out=new OperatiiInOutFisier("mOut.txt");
//        out.scrieObiecteInFisierText(ar);
        
        soc=new Socket("localhost",2002);
        out=soc.getOutputStream();
        in=soc.getInputStream();
        fout=new ObjectOutputStream(out);
        fin=new ObjectInputStream(in);
        
        String first=(String)fin.readObject();
        System.out.println(first);
        
        fout.writeObject("vehiculCargo");
        VehiculCargo v=(VehiculCargo)ar.get(1);
        fout.writeObject(v);
        fout.writeObject("vehiculCargo");
        fout.writeObject(v);
        
        for(Vehicul vy:ar){
            fout.writeObject("vehiculCargo");
            fout.writeObject((VehiculCargo)vy);
        }
        
        fout.writeObject("closeConnection");
        
        soc.close();
    }
    
}
