/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import clase.TrenMarfa;
import clase.TrenPasageri;
import claseAbstracte.Tren;
import java.util.ArrayList;
import java.util.Vector;
import jaxb.TrenJAXB;
import jaxb.TrenListJAXB;

/**
 *
 * @author Airinei
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        TrenMarfa test1=new TrenMarfa(13,"1234",13.4f,"Marca1");
        TrenPasageri test2=new TrenPasageri(14,"2134",13.4f,"Marca1");
        test1.serieMarfuri.add("1");
        test1.serieMarfuri.add("1");
        test2.cnpCalatori.add("2");
        test2.cnpCalatori.add("2");
        
        System.out.println(test1);
        System.out.println(test2);
        
        TrenMarfa test3=(TrenMarfa)test1.clone();
        Vector<String> v= new Vector<String>();
        v.add("3");
        
        test1.setSerieMarfuri(v);
        System.out.println(test3);
        
        ArrayList<Tren> ar=new ArrayList<Tren>();
        ar.add(test1);
        ar.add(test2);
        ar.add(test3);
        
        TrenJAXB tx=new TrenJAXB();
        tx.marshall(test3, "tren.xml");
        
        TrenListJAXB tlx=new TrenListJAXB();
        tlx.marshall(ar,"trenuri.xml");
    }
    
}
