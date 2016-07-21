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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Airinei
 */
@XmlRootElement(name="Tren Marfa")
public class TrenMarfa extends Tren implements Cloneable, Serializable{
    private float capacitateTransportKg;
    public Vector<String> serieMarfuri;

    
    
    public TrenMarfa(float capacitateTransportKg, String serie, float tonaj, String marca) throws Exception {
        super(serie, tonaj, marca);
        this.capacitateTransportKg = capacitateTransportKg;
        serieMarfuri = new Vector<String>();
        if(tonaj<0){
            throw new Exception("Tonaj negativ");
        }
    }

    public TrenMarfa() {
    }
    
    
    public Vector<String> getSerieMarfuri() {
        return serieMarfuri;
    }
    
    
    
    public void setSerieMarfuri(Vector<String> serieMarfuri) {
        this.serieMarfuri = serieMarfuri;
    }
    
    @Override
    public float getCapacitate() {
         return this.capacitateTransportKg;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        TrenMarfa other = (TrenMarfa) obj;
        if (Float.floatToIntBits(this.capacitateTransportKg) != Float.floatToIntBits(other.capacitateTransportKg)) {
            return false;
        }
        if (!Objects.equals(this.serieMarfuri, other.serieMarfuri)) {
            return false;
        }
        
        for(int i=0;i<this.serieMarfuri.size();i++){
            if(!this.serieMarfuri.get(i).equals(other.serieMarfuri.get(i))){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Object clone(){
        try {
            TrenMarfa tmp= new TrenMarfa(this.capacitateTransportKg, this.getSerie(), this.getTonaj(), this.getMarca());
            tmp.setSerieMarfuri(this.serieMarfuri);
            return tmp;
        } catch (Exception ex) {
            Logger.getLogger(TrenMarfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public String toString() {
        return "TrenMarfa{"  + this.getMarca() + " " + this.getSerie() + " " + this.getTonaj()+ "capacitateTransportKg=" + capacitateTransportKg + ", serieMarfuri=" + serieMarfuri + '}';
    }

    @XmlElement
    @Override
    public String getCNPSerii() {
        return serieMarfuri.toString();
    }
    
    
}
