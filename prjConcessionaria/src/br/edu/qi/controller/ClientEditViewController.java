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
public class ClientEditViewController implements Initializable {

    @FXML
    private TextField txName;
    @FXML
    private TextField txStreet;
    @FXML
    private TextField txNumber;
    @FXML
    private TextField txNeighborhood;
    @FXML
    private TextField txCity;
    @FXML
    private TextField txUf;
    @FXML
    private TextField txEmail;
    @FXML
    private TextField txPhoneNumber;
    @FXML
    private TableView<?> tbClients;
    @FXML
    private TableColumn<?, ?> tbColName;
    @FXML
    private TableColumn<?, ?> tbColEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerBtnSave(ActionEvent event) {
    }

    @FXML
    private void handlerBtnDelete(ActionEvent event) {
    }
    
}
