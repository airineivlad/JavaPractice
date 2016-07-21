/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class PortContainer extends Container implements Cloneable{

  private float volumContainerMare;
  private int nrMare;
  private float volumContainerMediu;
  private int nrMediu;
  private float volumContainerMic;
  private int nrMic;

    public PortContainer(float volumContainerMare, int nrMare, float volumContainerMediu, int nrMediu, float volumContainerMic, int nrMic, String eticheta, float lungime, float latime, float inaltime) {
        super(eticheta, lungime, latime, inaltime);
        this.volumContainerMare = volumContainerMare;
        this.nrMare = nrMare;
        this.volumContainerMediu = volumContainerMediu;
        this.nrMediu = nrMediu;
        this.volumContainerMic = volumContainerMic;
        this.nrMic = nrMic;
    }

    public float getVolumContainerMare() {
        return volumContainerMare;
    }

    public void setVolumContainerMare(float volumContainerMare) {
        this.volumContainerMare = volumContainerMare;
    }

    public int getNrMare() {
        return nrMare;
    }

    public void setNrMare(int nrMare) {
        this.nrMare = nrMare;
    }

    public float getVolumContainerMediu() {
        return volumContainerMediu;
    }

    public void setVolumContainerMediu(float volumContainerMediu) {
        this.volumContainerMediu = volumContainerMediu;
    }

    public int getNrMediu() {
        return nrMediu;
    }

    public void setNrMediu(int nrMediu) {
        this.nrMediu = nrMediu;
    }

    public float getVolumContainerMic() {
        return volumContainerMic;
    }

    public void setVolumContainerMic(float volumContainerMic) {
        this.volumContainerMic = volumContainerMic;
    }

    public int getNrMic() {
        return nrMic;
    }

    public void setNrMic(int nrMic) {
        this.nrMic = nrMic;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (PortContainer)super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    
  
  
  
  
  
  
  @Override
    double getVolum() {
        return (volumContainerMare*nrMare+volumContainerMediu*nrMediu+volumContainerMic*nrMic);
    }
    
}
