/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import claseAbstracte.Tren;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Airinei
 */
public class TrenPasageri extends Tren implements Cloneable, Serializable{
    private float nrLocuri;
    public  Vector<String> cnpCalatori;
    
    public TrenPasageri(float nrLocuri, String serie, float tonaj, String marca) throws Exception {
        super(serie, tonaj, marca);
        this.nrLocuri = nrLocuri;
        cnpCalatori=new Vector<String>();
        
        if(tonaj<0){
            throw new Exception("Tonaj negativ");
        }
    }

    public Vector<String> getCnpCalatori() {
        return cnpCalatori;
    }

    public void setCnpCalatori(Vector<String> cnpCalatori) {
        this.cnpCalatori = cnpCalatori;
    }
    
    public String getCNPSerii() {
        return cnpCalatori.toString();
    }

    @Override
    public float getCapacitate() {
        return nrLocuri;
    }

    @Override
    public boolean equals(Object obj) {
        TrenPasageri other = (TrenPasageri) obj;
        if (Float.floatToIntBits(this.nrLocuri) != Float.floatToIntBits(other.nrLocuri)) {
            return false;
        }
        if (!Objects.equals(this.cnpCalatori, other.cnpCalatori)) {
            return false;
        }
        
        for(int i=0;i<this.cnpCalatori.size();i++){
            if(!this.cnpCalatori.get(i).equals(other.cnpCalatori.get(i))){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Object clone(){
        try {
            TrenPasageri tmp= new TrenPasageri(this.nrLocuri, this.getSerie(), this.getTonaj(), this.getMarca());
            tmp.setCnpCalatori(this.cnpCalatori);
            return tmp;
        } catch (Exception ex) {
            Logger.getLogger(TrenPasageri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public String toString() {
        return "TrenPasageri{" + this.getMarca() + " " + this.getSerie() + " " + this.getTonaj()+ " nrLocuri=" + nrLocuri + ", cnpCalatori=" + cnpCalatori + '}';
    }
    
  
}
