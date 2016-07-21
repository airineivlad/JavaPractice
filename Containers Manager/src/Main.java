
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Main {
    public static void main(String args[]) throws FileNotFoundException, IOException{
    ArrayList<PortContainer> v=new ArrayList<>();
    v.add(new PortContainer(12, 2, 5, 4, 3, 2, "container 1", 160, 20, 20));
    v.add(new PortContainer(14, 2, 5, 4, 3, 2, "container 2", 150, 20, 20));    
    v.add(new PortContainer(16, 2, 5, 4, 3, 2, "container 3", 120, 20, 20));
    System.out.println(v.get(2).getVolum());
    
    ArrayList<Macara>m=new ArrayList<>();
    m.add(new Macara(1,9));
    m.add(new Macara(2,6));
    m.add(new Macara(3,3));
    Formatter f=new Formatter("PortContainere.csv");
    Iterator x;
    x = v.iterator();
    while(x.hasNext()){
        PortContainer p=(PortContainer) x.next();
        f.format("%.2f,%d,%.2f,%d,%.2f,%d,%s,%.2f,%.2f,%.2f\n", p.getVolumContainerMare(),p.getNrMare(),p.getVolumContainerMediu(),p.getNrMediu(),p.getVolumContainerMic(),p.getNrMic(),p.getEticheta(),p.getLungime(),p.getLatime(),p.getInaltime());
        }
    f.close();
    }
    
    }
    

