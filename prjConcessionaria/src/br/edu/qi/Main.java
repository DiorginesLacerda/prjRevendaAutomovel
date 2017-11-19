/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.util.ViewUtil;
import java.io.IOException;
import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import javax.swing.JOptionPane;

/**
 *
 * @author Diorgines
 */
public class Main extends Application {
    public static Stage stage = null;
    
    @Override
    public void start(Stage Primarystage) throws IOException {
        
        ViewUtil.ExibirTela("Home");
        /*try {
            if (stage != null) {
                stage.close();
            } else {
                stage = new Stage();
            }
            String caminho = ("controller/Home.fxml");
            Parent root = FXMLLoader.load(Main.class.getResource(caminho));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Houve algum erro no sistema", JOptionPane.ERROR_MESSAGE);
        }*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
