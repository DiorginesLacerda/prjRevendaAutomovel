/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;


import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Diorgines
 */
public class ViewUtil {
    
    public static Stage stage = null;
    
    public static void ExibirTela(String tela) throws IOException {
        try {
            if (stage != null) {
                stage.close();
            } else {
                stage = new Stage();
            }
            String caminho = ("/view/" + tela + ".fxml");
             
            Parent root = FXMLLoader.load(ViewUtil.class.getResource(caminho));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Houve algum erro no sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
