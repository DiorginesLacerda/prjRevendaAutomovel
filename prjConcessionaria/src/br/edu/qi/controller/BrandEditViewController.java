/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.MarcaBo;
import br.edu.qi.model.Marca;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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

    private ObservableList<Marca> data;
    private MarcaBo bo;
    
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
        try {
            this.bo = new MarcaBo();
        } catch (Exception ex) {
            Logger.getLogger(BrandEditViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handlerSaveBrand(ActionEvent event) {
    }

    @FXML
    private void handlerDeleteBrand(ActionEvent event) {
    }
    
}
