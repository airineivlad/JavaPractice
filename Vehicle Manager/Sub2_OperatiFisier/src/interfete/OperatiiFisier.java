/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfete;

import abstracte.Vehicul;
import java.util.ArrayList;

/**
 *
 * @author Airinei
 */
public interface OperatiiFisier {
        public ArrayList<Vehicul> citesteObiecteDinFisierText(Vehicul v,String fis);
        public void scrieObiecteInFisierText(ArrayList<Vehicul> aL);
}
