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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class BrandEditViewController implements Initializable {

    @FXML
    private TextField txBrand;
    @FXML
    private TableView<?> tbVBrands;
    @FXML
    private TableColumn<?, ?> tbColBrands;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerSaveBrand(ActionEvent event) {
    }

    @FXML
    private void handlerDeleteBrand(ActionEvent event) {
    }
    
}