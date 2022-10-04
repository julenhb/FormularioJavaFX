package com.mycompany.formulariojavafx;

import clases.CRUDUsuario;
import clases.ConnectionDB;
import clases.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SecondaryController {

    @FXML
    private Connection con;

    @FXML
    private TextField tfUsuario;

    @FXML
    private TextField tfPass;

    @FXML
    private TextField tfDescuento;

    @FXML
    private ToggleGroup premiumR;

    @FXML
    private ArrayList<Usuario> usuarios;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private boolean choosePremium(ToggleGroup t) {

        boolean auxPremium;

        if (((RadioButton) premiumR.getSelectedToggle()).getText().equalsIgnoreCase("si")) {
            auxPremium = true;
        } else {
            auxPremium = false;
        }
        return auxPremium;

    }

    @FXML
    private void anadirUsuario() { //Añadir Usuario

        con = ConnectionDB.openConnection();
       
        Usuario usu1 = new Usuario(choosePremium(premiumR), tfUsuario.getText(), tfPass.getText(), Integer.parseInt(this.tfDescuento.getText()));
        usuarios.add(usu1);
        CRUDUsuario.insertarUsuario(con, usu1);

    }
    
    @FXML
    private void salir(){ //SALIR
        System.exit(0);
    }
    
    @FXML
    private void buscarUsuario(){ //BUSCAR USUARIO
        CRUDUsuario.buscarUsuario(con, this.tfUsuario.getText());
    }
    
    @FXML
    private void totalIngresos(){ //TOTALM INGRESOS
        CRUDUsuario.totalIngresos(con);
    }
    
    @FXML
    private void limpiar(){
        tfUsuario.setText("");
        tfPass.setText("");
        tfDescuento.setText("");
        premiumR.selectToggle(null);
    }

}
    
    
    
    
    

