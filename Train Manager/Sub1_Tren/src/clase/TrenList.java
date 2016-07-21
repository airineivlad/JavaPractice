/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import claseAbstracte.Tren;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Airinei
 */
@XmlRootElement(name="Trenuri")
public class TrenList {
    private ArrayList<Tren> list = new ArrayList<Tren>();

    public TrenList() {
    }
    
    @XmlElement(name="Tren")
    public ArrayList<Tren> getList() {
        return list;
    }

    public void setList(ArrayList<Tren> list) {
        this.list = list;
    }
    
    
}
