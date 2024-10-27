package org.example.newq;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.text.Text;

public class FindSrcDst implements Initializable {

    @FXML
    private ChoiceBox<String> dstBox;

    @FXML
    private Button okButton;

    @FXML
    private ChoiceBox<String> srcBox;

    @FXML
    private   Text pathPrint;

    public static String src;
    public static String dst;
    @FXML
    void okButtonOnAction(ActionEvent event) {
         src=srcBox.getSelectionModel().getSelectedItem();
         dst=dstBox.getSelectionModel().getSelectedItem();
        String st= Dijkstras.start();
        pathPrint.setText(st);
    }

    public static int setSrc(){
        if(src=="MAIN GATE"){
            return 0;
        }if(src=="DVM"){
            return 5;
        }if(src=="TSC"){
            return 2;
        }if(src=="M.A.WAZE"){
            return 1;
        }if(src=="AGRICULTURE"){
            return 3;
        }if(src=="BUS STAND"){
            return 4;
        }
        return 0;
    }
    public static int setDst(){
        if(dst=="MAIN GATE"){
            return 0;
        }if(dst=="DVM"){
            return 5;
        }if(dst=="TSC"){
            return 2;
        }if(dst=="M.A.WAZE"){
            return 1;
        }if(dst=="AGRICULTURE"){
            return 3;
        }if(dst=="BUS STAND"){
            return 4;
        }
        return 0;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            srcBox.getItems().addAll("MAIN GATE","DVM","TSC","M.A.WAZE","AGRICULTURE","BUS STAND");
            dstBox.getItems().addAll("MAIN GATE","DVM","TSC","M.A.WAZE","AGRICULTURE","BUS STAND");
    }
}
