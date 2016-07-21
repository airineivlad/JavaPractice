/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseAbstracte;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Airinei
 */
@XmlRootElement(name="Tren")
public abstract class Tren implements Serializable{
    private String serie;
    private float tonaj;
    final String marca;

    public Tren(String serie, float tonaj, String marca) {
        this.serie = serie;
        this.tonaj = tonaj;
        this.marca = marca;
    }

    public Tren() {
        this.marca="None";
    }
    
    @XmlElement
    public String getSerie() {
        return serie;
    }
    @XmlElement
    public float getTonaj() {
        return tonaj;
    }
    
    @XmlElement
    public String getMarca() {
        return marca;
    }
    
    @XmlElement
    public abstract float getCapacitate();
    
    @XmlElement
    public abstract String getCNPSerii();
}


