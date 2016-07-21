/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public abstract class Container {
    private String eticheta;
    private float lungime;
    private float latime;
    private float inaltime;

    public Container(String eticheta, float lungime, float latime, float inaltime) {
        this.eticheta = eticheta;
        this.lungime = lungime;
        this.latime = latime;
        this.inaltime = inaltime;
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public float getLungime() {
        return lungime;
    }

    public void setLungime(float lungime) {
        this.lungime = lungime;
    }

    public float getLatime() {
        return latime;
    }

    public void setLatime(float latime) {
        this.latime = latime;
    }

    public float getInaltime() {
        return inaltime;
    }

    public void setInaltime(float inaltime) {
        this.inaltime = inaltime;
    }
    
    abstract double getVolum();
    
    
}
