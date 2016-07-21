/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clase.OperatiiOutFisier;
import clase.TrenPasageri;
import clase.TrenMarfa;
import claseAbstracte.Tren;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Airinei
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        OperatiiOutFisier oPasageri=new OperatiiOutFisier("VehiculPasageri01.txt");
        
        //o.citesteObiectDinFisierText(new TrenPasageri(13.f,"asd",12f,"asd"));
        
        OperatiiOutFisier outPasageri=new OperatiiOutFisier("VehiculPasageri01OUT.txt");
        ArrayList<Tren> arr=oPasageri.citesteObiectDinFisierText(new TrenPasageri(0f,"Sample",12f,"Sample"));
        outPasageri.scrieObiectFisierTest(arr);
        
        OperatiiOutFisier oM=new OperatiiOutFisier("VehiculCargo01.txt");
        
        //o.citesteObiectDinFisierText(new TrenPasageri(13.f,"asd",12f,"asd"));
        
        OperatiiOutFisier outMarfa=new OperatiiOutFisier("VehiculCargo01OUT.txt");
        ArrayList<Tren> arrMarfa=oM.citesteObiectDinFisierText(new TrenMarfa(0f,"Sample",12f,"Sample"));
        outMarfa.scrieObiectFisierTest(arrMarfa);
        
        TrenPasageri p=(TrenPasageri) arr.get(1);
        System.out.println(p.getMarca());
        
        TrenMarfa m =(TrenMarfa) arrMarfa.get(1);
        System.out.println(m.getCapacitate());
        
        System.out.println(p);

        Socket soc= new Socket("localhost",2001);
        OutputStream out= soc.getOutputStream();
        InputStream in=soc.getInputStream();
        ObjectInputStream fin= new ObjectInputStream(in);
        ObjectOutputStream fout = new ObjectOutputStream(out);
        
        System.out.println(fin.readObject());
        //TrenPasageri msj=(TrenPasageri)fin.readObject();
        //System.out.println(msj);
        
        fout.writeObject("TrenPasageri...\n");
        fout.writeObject(p);
        fout.writeObject("TrenMarfa...\n");
        fout.writeObject(m);
        
        Thread scrieObiecte = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                for(int i=0;i<=5;i++){
                    
                    Thread.sleep(800);
                    
                    if(i%2==0){
                        fout.writeObject("TrenMarfa...\n");
                        fout.writeObject(m);
                       
                    }
                    
                    if(i%2==1){
                        fout.writeObject("TrenPasageri...\n");
                        fout.writeObject(p);
                    }
                }
                fout.writeObject("Close server\n");
                soc.close();
                } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        scrieObiecte.start();
        
        
    }
    
}
