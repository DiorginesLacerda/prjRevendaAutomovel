/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;

import br.edu.qi.MainApp;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Diorgines
 */
public class HelperAlert {
    
    public static void msgDialog(String msg, String title, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
       // stage.getIcons().add(MainApp.icon);
        alert.setContentText(msg);
        alert.show();
    }
}
