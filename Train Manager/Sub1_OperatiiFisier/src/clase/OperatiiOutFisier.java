/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import interfete.OperatiiFisier;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import clase.TrenPasageri;
import clase.TrenMarfa;
import claseAbstracte.Tren;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
/**
 *
 * @author Airinei
 */
public class OperatiiOutFisier implements OperatiiFisier, Comparable{
    File fisier;

    public OperatiiOutFisier() {
    }

    public OperatiiOutFisier(String fisier) {
        this.fisier = new File(fisier);
    }

    public File getFisier() {
        return fisier;
    }

    public void setFisier(File fisier) {
        this.fisier = fisier;
    }
    
    @Override
    public ArrayList<Tren> citesteObiectDinFisierText(Object o) {
        ArrayList<Tren> ls=new ArrayList<Tren>();
        Scanner sc = null;
        
        try {
            sc = new Scanner(fisier);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperatiiOutFisier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TrenPasageri p= null;
        TrenMarfa m=null;
        
        while(sc.hasNext()){
            String line=sc.nextLine();
            line=line.replace(" ","#");
            String[] elems=line.split("#");
            String[] lis=elems[4].split(",");
//            for(String it:elems){
//                System.out.println(it);
//            }
//            for(String it:lis){
//                System.out.println(it);
//            }
            
            if(o instanceof TrenPasageri){
                try {
                    p=new TrenPasageri(Float.parseFloat(elems[3]),elems[0] ,Float.parseFloat(elems[1]),elems[2]);
                    Vector<String> tm= new Vector<String>();
                    for(String it:lis){
                        tm.add(it);
                    }
                    p.setCnpCalatori(tm);
                    ls.add(p);
                    System.out.println(p);
                } catch (Exception ex) {
                    Logger.getLogger(OperatiiOutFisier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(o instanceof TrenMarfa){
                try {
                    m=new TrenMarfa(Float.parseFloat(elems[3]),elems[0] ,Float.parseFloat(elems[1]),elems[2]);
                    Vector<String> tm= new Vector<String>();
                    for(String it:lis){
                        tm.add(it);
                    }
                    m.setSerieMarfuri(tm);
                    ls.add(m);
                    System.out.println(m);
                } catch (Exception ex) {
                    Logger.getLogger(OperatiiOutFisier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        }
        
        sc.close();
        
        return ls;
    }

    @Override
    public void scrieObiectFisierTest(ArrayList<Tren> arr) {
        Formatter f=null;
        try {
            f = new Formatter(fisier);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperatiiOutFisier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Tren it :arr){
            if(it instanceof TrenPasageri){
                //TrenPasageri copie=(TrenPasageri)it ;
                String marca= it.getMarca();
                String serie=it.getSerie();
                float tonaj=it.getTonaj();
                float capac=it.getCapacitate();
                String CNP="";
                
                for(String s :((TrenPasageri) it).getCnpCalatori()){
                    CNP=CNP+ s+ ",";
                }
                f.format("%s %s %5.2f %5.2f %s\n", marca,serie,tonaj,capac,CNP);
            }
            
            if(it instanceof TrenMarfa){
                String marca= it.getMarca();
                String serie=it.getSerie();
                float tonaj=it.getTonaj();
                float capac=it.getCapacitate();
                String ser="";
                
                for(String s :((TrenMarfa) it).getSerieMarfuri()){
                    ser=ser+ s+ ",";
                }
                f.format("%s %s %5.2f %5.2f %s\n", marca,serie,tonaj,capac,ser);
            }
        }
        f.close();
    }

    @Override
    public int compareTo(Object o) {
        File f=(File)o;
        if(fisier.getTotalSpace()==f.getTotalSpace()){
            return 0;
        }else if (fisier.getTotalSpace()>f.getTotalSpace()){
            return 1;
        }else{
            return -1;
        }
    }
    
    @Override
    public Object clone(){
        OperatiiOutFisier copie= new OperatiiOutFisier();
        copie.setFisier(fisier);
        
        return copie;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OperatiiOutFisier other = (OperatiiOutFisier) obj;
        if (!Objects.equals(this.fisier, other.fisier)) {
            return false;
        }
        return true;
    }
    
    
}
