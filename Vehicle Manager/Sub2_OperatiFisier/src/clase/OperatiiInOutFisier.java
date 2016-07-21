/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import abstracte.Vehicul;
import interfete.OperatiiFisier;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Airinei
 */
public class OperatiiInOutFisier implements OperatiiFisier,Cloneable,Comparable{
    File fisier;
    
    public OperatiiInOutFisier() {
    }
    
    public OperatiiInOutFisier(String fisier) {
        this.fisier = new File(fisier);
    }

    @Override
    public ArrayList<Vehicul> citesteObiecteDinFisierText(Vehicul v, String fis) {
        Scanner s=null;
        ArrayList<Vehicul> ar = new ArrayList<Vehicul>();
        
        try {
            s = new Scanner(fisier);
            
            while(s.hasNext()){
                String line=s.nextLine();
                
                String sep="#";
                
                StringTokenizer st=new StringTokenizer(line,sep);
                String serie=st.nextToken();
                String tonaj=st.nextToken();
                String marca=st.nextToken();
                String capac=st.nextToken();
                String[] elems=st.nextToken().split(",");
                Vector<String> vi= new Vector<String>();
                for(String it: elems){
                    vi.add(it);
                }
                
                //System.out.println(serie + tonaj + marca  + capac + vi);
                
                if(v instanceof VehiculPasageri){
                    VehiculPasageri vp= new VehiculPasageri(serie, Float.parseFloat(tonaj), marca,  Float.parseFloat(capac));
                    vp.setCNPPasageri(vi);
                    ar.add(vp);
                }
                
                if(v instanceof VehiculCargo){
                    VehiculCargo vc=new VehiculCargo(serie, Float.parseFloat(tonaj), marca,  Float.parseFloat(capac));
                    vc.setSeriiMarfuri(vi);
                    ar.add(vc);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperatiiInOutFisier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OperatiiInOutFisier.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.close();
        return ar;
    }

    @Override
    public void scrieObiecteInFisierText(ArrayList<Vehicul> aL) {
        try {
            Formatter f=new Formatter(fisier);
            
            for(Vehicul v:aL){
                f.format(v.toString()+"\n");
                f.format("\r\n");
            }
            
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperatiiInOutFisier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public File getFisier() {
        return fisier;
    }

    public void setFisier(File fisier) {
        this.fisier = fisier;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OperatiiInOutFisier other = (OperatiiInOutFisier) obj;
        if (!Objects.equals(this.fisier, other.fisier)) {
            return false;
        }
        return true;
    }
    
    public int compareTo(Object obj){
        OperatiiInOutFisier op=(OperatiiInOutFisier)obj;
        
        if(this.fisier.getTotalSpace()==op.fisier.getTotalSpace()){
            return 0;
        }else if(this.fisier.getTotalSpace()>op.fisier.getTotalSpace()){
            return 1;
        }else{
            return -1;
        }
    }
    
    
}
