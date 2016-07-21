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
public class VehiculCargo extends Vehicul implements Cloneable,Serializable{
    float nrLocuri;
    Vector<String> seriiMarfuri;

    public VehiculCargo(String serie, float tonaj, String marca,float nrLocuri) throws Exception {
        super(serie, tonaj, marca);
        this.nrLocuri=nrLocuri;
        
        if(tonaj<0){
            throw new Exception("Tonaj negativ");
        }
    }

    public VehiculCargo() {
    }

    @Override
    public float getCapacitate() {
        return nrLocuri;
    }

    public float getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(float nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public Vector<String> getSeriiMarfuri() {
        return seriiMarfuri;
    }

    public void setSeriiMarfuri(Vector<String> seriiMarfuri) {
        this.seriiMarfuri = seriiMarfuri;
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
        final VehiculCargo other = (VehiculCargo) obj;
        if (Float.floatToIntBits(this.nrLocuri) != Float.floatToIntBits(other.nrLocuri)) {
            return false;
        }
        if (!Objects.equals(this.seriiMarfuri, other.seriiMarfuri)) {
            return false;
        }
        return true;
    }
    
    
    public Object clone(){
        VehiculCargo vc=null;
        try {
            vc=new VehiculCargo(this.getSerie(),this.getTonaj(),this.getMarca(),this.getNrLocuri());
            
            vc.setSeriiMarfuri(this.getSeriiMarfuri());
        } catch (Exception ex) {
            Logger.getLogger(VehiculCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vc;
    }

    @Override
    public String toString() {
        return "VehiculCargo{"+ "serie=" + this.getSerie() + ", tonaj=" + this.getTonaj() + ", marca=" +  this.getMarca()+ ", nrLocuri=" + nrLocuri + ", seriiMarfuri=" + seriiMarfuri + '}';
    }
    
    
}
