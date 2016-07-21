/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracte;

import java.io.Serializable;

/**
 *
 * @author Airinei
 */
public abstract class Vehicul implements Serializable{
    private String serie;
    private float tonaj;
    private final String marca;

    public Vehicul(String serie, float tonaj,String marca ) {
        this.serie = serie;
        this.tonaj = tonaj;
        this.marca = marca;
    }
    
    public Vehicul() {
        marca="None";
    }

    public String getSerie() {
        return serie;
    }

    public float getTonaj() {
        return tonaj;
    }

    public String getMarca() {
        return marca;
    }
    
    public abstract float getCapacitate();

    @Override
    public String toString() {
        return "Vehicul{" + "serie=" + serie + ", tonaj=" + tonaj + ", marca=" + marca + '}';
    }
    
}
