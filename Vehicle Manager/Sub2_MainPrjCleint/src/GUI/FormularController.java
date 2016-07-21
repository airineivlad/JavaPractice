/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import abstracte.Vehicul;
import clase.OperatiiInOutFisier;
import clase.VehiculCargo;
import clase.VehiculPasageri;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Airinei
 */
public class FormularController implements Initializable {

    @FXML
    private Button incarcaDate;
    @FXML
    private Button connectServer;
    @FXML
    private Button trimiteServer;
    @FXML
    private TextField fisierText;
    @FXML
    private TextArea console;
    @FXML
    private RadioButton vcRadio;
    @FXML
    private ToggleGroup Grp;
    @FXML
    private RadioButton vpRadio;
    @FXML
    private Button sendBD;
    @FXML
    private Button creazaXML;
    
    ArrayList<Vehicul> arr;
    @FXML
    private ListView<String> listViewVehicul;
    List<String> ls;
    
    Socket soc;
    OutputStream out;
    InputStream in;
    ObjectOutputStream fout;
    ObjectInputStream fin;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vcRadio.fire();
        fisierText.setText("m.txt");
        arr=new ArrayList<Vehicul>();
       
        
        
    }    

    @FXML
    private void incarcaDateAction(ActionEvent event) throws Exception {
        OperatiiInOutFisier out=new OperatiiInOutFisier(fisierText.getText());
        ArrayList<Vehicul> ar=new ArrayList<Vehicul>();
        
        
        ls=new ArrayList<String>();
        if(vcRadio.isSelected()){
            ar=out.citesteObiecteDinFisierText(new VehiculCargo("serie", 0, "marca", 0), "asda");
            Alert ale=new Alert(AlertType.WARNING);
            ale.setContentText("clasa vehicul cargo selectata");
            ale.showAndWait();
        }
        
        if(vpRadio.isSelected()){
            ar=out.citesteObiecteDinFisierText(new VehiculPasageri("serie", 0, "marca", 0), "asda");
            Alert are= new Alert(AlertType.WARNING);
            are.setContentText("clasa vehicul pasa sel");
            are.showAndWait();
        }
        
        
//        
        for(Vehicul it:ar){
            arr.add(it);
            String marca=it.getMarca();
            String serie=it.getSerie();
            Float tonaj=it.getTonaj();
            Float capac=it.getTonaj();
            String tip=" ";
            if(it instanceof VehiculCargo){
                tip="Vehicul Cargo";
                
            }
            
            if(it instanceof VehiculPasageri){
                tip="Vehicul Cargo";
            }
            
            ls.add(it.toString());
            System.out.println(it.toString());
            //tabelView1.
        }
        
        listViewVehicul.getItems().addAll(ls);
    }

    @FXML
    private void conecteazaServerAction(ActionEvent event) throws IOException, ClassNotFoundException {
        soc=new Socket("localhost",2002);
        out=soc.getOutputStream();
        in=soc.getInputStream();
        fout=new ObjectOutputStream(out);
        fin=new ObjectInputStream(in);
        
        String msg=(String)fin.readObject();
        console.appendText(msg+"\n");
        
    }

    @FXML
    private void trimiteServerAction(ActionEvent event) throws IOException {
        
        for(Vehicul it:arr){
            System.out.println("Se trimite la server " + it.toString()+"\n");
            console.appendText("Se trimite la server " + it.toString()+"\n");
            
            String tip="";
            if(it instanceof VehiculPasageri){
                tip="vehiculPasageri";
            }
            
            if(it instanceof VehiculCargo){
                tip="vehiculCargo";
            }
            
            fout.writeObject(tip);
            fout.writeObject(it);
        }
    }

    @FXML
    private void sendBDAction(ActionEvent event) throws IOException {
        fout.writeObject("insert");
    }

    @FXML
    private void creazaXMLAction(ActionEvent event) throws IOException {
        fout.writeObject("XML");
    }

    @FXML
    private void safeExitAction(ActionEvent event) throws IOException {
        fout.writeObject("closeConnection");
        soc.close();
        Platform.exit();
    }
    
}
