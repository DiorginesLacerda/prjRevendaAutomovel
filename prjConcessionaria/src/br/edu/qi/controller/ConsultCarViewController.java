/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class ConsultCarViewController implements Initializable {

    @FXML
    private TextField txFind;
    @FXML
    private TableView<?> tbCars;
    @FXML
    private TableColumn<?, ?> tbColYear;
    @FXML
    private TableColumn<?, ?> tbColBrand;
    @FXML
    private TableColumn<?, ?> tbColModelCar;
    @FXML
    private TableColumn<?, ?> tbColColor;
    @FXML
    private TableColumn<?, ?> tbColType;
    @FXML
    private TableColumn<?, ?> tbColState;
    @FXML
    private TableColumn<?, ?> tbColKm;
    @FXML
    private TableColumn<?, ?> tbColValueCar;
    
    private AnchorPane dataPane;
    
    private void setDataPane(String source){
        dataPane.getChildren().clear();
        dataPane.getChildren().add(MainApp.getNode(source));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerbtnFind(ActionEvent event) {
    }

    @FXML
    private void handlerBtnBackPage(ActionEvent event) {
        
    }
    
}
