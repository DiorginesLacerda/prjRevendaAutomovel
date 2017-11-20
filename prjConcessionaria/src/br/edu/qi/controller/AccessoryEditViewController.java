/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class AccessoryEditViewController implements Initializable {

    @FXML
    private TextField txtAccessory;
    @FXML
    private TextField txtValue;
    @FXML
    private Button btnSaveAccesory;
    @FXML
    private Button btnDeleteAccessory;
    @FXML
    private TableView<?> tbAccessory;
    @FXML
    private TableColumn<?, ?> tbcAccessoryName;
    @FXML
    private TableColumn<?, ?> tbcAccessoryValue;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerBtnSaveAccesory(ActionEvent event) {
    }

    @FXML
    private void handlerBtnDeleteAccessory(ActionEvent event) {
    }
    
}
