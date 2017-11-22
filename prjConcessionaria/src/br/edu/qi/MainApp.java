/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Diorgines
 */
public class MainApp extends Application {
    private Stage primaryStage;
    private Pane rootLayout;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Revenda");
        
        initRootLayout();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void initRootLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Home.fxml"));
            rootLayout = (Pane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
        }
    }
    
    public static Node getNode(String source){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(source));
            AnchorPane acessoryEditView = (AnchorPane) loader.load();
            return acessoryEditView;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public static Pane getPane(String source){
        try {
            Pane pane = FXMLLoader.load(MainApp.class.getResource(source));
            return pane;
        } catch (Exception e) {
        }
        return null;
    }
    
    
}
