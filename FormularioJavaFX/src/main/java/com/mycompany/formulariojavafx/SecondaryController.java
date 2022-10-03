package com.mycompany.formulariojavafx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private TextField tfUsuario;
    
    @FXML
    private TextField tfContraseña;
    
    @FXML
    private TextField tfDescuento;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    
}