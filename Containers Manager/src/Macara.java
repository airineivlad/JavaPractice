/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Macara implements Descarcare {
    private int tipContainer;
    private int timpManipulare;

    public Macara(int tipContainer, int timpManipulare) {
        this.tipContainer = tipContainer;
        this.timpManipulare = timpManipulare;
    }

    public int getTipContainer() {
        return tipContainer;
    }

    public void setTipContainer(int tipContainer) {
        this.tipContainer = tipContainer;
    }

    public int getTimpManipulare() {
        return timpManipulare;
    }

    public void setTimpManipulare(int timpManipulare) {
        this.timpManipulare = timpManipulare;
    }

    @Override
    public double DescarcaContainer(PortContainer p, Macara m){
        if(m.getTipContainer()==1)
            return (double)p.getNrMare();
        if(m.getTipContainer()==2)
            return (double)p.getNrMediu();
        else
            return (double)p.getNrMic();
    }
    
}
