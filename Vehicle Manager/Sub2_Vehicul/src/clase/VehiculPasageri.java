/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import abstracte.Vehicul;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Airinei
 */
public class VehiculPasageri extends Vehicul implements Cloneable,Serializable{
    float capacitateTransport;
    Vector<String> cnpPasageri;

    public VehiculPasageri(String serie, float tonaj, String marca,float nrLocuri) throws Exception {
        super(serie, tonaj, marca);
        this.capacitateTransport=nrLocuri;
        
        if(tonaj<0){
            throw new Exception("Tonaj negativ");
        }
    }

    public VehiculPasageri() {
    }

    @Override
    public float getCapacitate() {
        return capacitateTransport;
    }

    public float getCapacitateTransport() {
        return capacitateTransport;
    }

    public void setCapacitateTransport(float capacitateTransport) {
        this.capacitateTransport = capacitateTransport;
    }

    public Vector<String> getCNPPasageri() {
        return cnpPasageri;
    }

    public void setCNPPasageri(Vector<String> cnpPasageri) {
        this.cnpPasageri = cnpPasageri;
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
        final VehiculPasageri other = (VehiculPasageri) obj;
        if (Float.floatToIntBits(this.capacitateTransport) != Float.floatToIntBits(other.capacitateTransport)) {
            return false;
        }
        if (!Objects.equals(this.cnpPasageri, other.cnpPasageri)) {
            return false;
        }
        return true;
    }
    
    
    public Object clone(){
        VehiculPasageri vc=null;
        try {
            vc=new VehiculPasageri(this.getSerie(),this.getTonaj(),this.getMarca(),this.getCapacitate());
            
            vc.setCapacitateTransport(this.getCapacitateTransport());
        } catch (Exception ex) {
            Logger.getLogger(VehiculPasageri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vc;
    }

    @Override
    public String toString() {
        return "VehiculPasageri{" + "serie=" + this.getSerie() + ", tonaj=" + this.getTonaj() + ", marca=" +  this.getMarca()+ ", capacitateTransport=" + capacitateTransport + ", cnpPasageri=" + cnpPasageri + '}';
    }
    
    
}
