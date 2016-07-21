/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import clase.TrenList;
import claseAbstracte.Tren;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Airinei
 */
public class TrenListJAXB {
    public void marshall(ArrayList<Tren> ar, String fis) throws JAXBException{
        JAXBContext jc= JAXBContext.newInstance(TrenList.class);
        Marshaller marsh=jc.createMarshaller();
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        TrenList t=new TrenList();
        t.setList(ar);
        marsh.marshal(t, new File(fis));
    }
}
