/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import clase.TrenMarfa;
import claseAbstracte.Tren;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Airinei
 */
public class TrenJAXB {
    public void marshall(Tren t,String fis) throws Exception{
        JAXBContext jc= JAXBContext.newInstance(Tren.class);
        Marshaller marsh=jc.createMarshaller();
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        TrenMarfa tm=(TrenMarfa)t;
        marsh.marshal(tm, new File("tren.xml"));
        
    }
}
