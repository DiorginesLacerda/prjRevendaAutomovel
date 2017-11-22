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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class ModelCarViewController implements Initializable {

    @FXML
    private TextField txModel;
    @FXML
    private ComboBox<?> cbbxBrand;
    @FXML
    private TableView<?> tbModelBrand;
    @FXML
    private TableColumn<?, ?> tbcolModel;
    @FXML
    private TableColumn<?, ?> tbcolBrand;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerSaveModel(ActionEvent event) {
    }

    @FXML
    private void handlerDeleteModel(ActionEvent event) {
    }
    
}
