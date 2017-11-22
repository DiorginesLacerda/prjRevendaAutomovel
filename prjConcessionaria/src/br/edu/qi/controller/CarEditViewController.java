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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class CarEditViewController implements Initializable {

    @FXML
    private ComboBox<?> cbbxBrand;
    @FXML
    private ComboBox<?> cbbxModelCar;
    @FXML
    private TextField txYear;
    @FXML
    private TextField txValueCar;
    @FXML
    private ComboBox<?> cbbxColorCar;
    @FXML
    private TextArea txDescription;
    @FXML
    private AnchorPane apAccessories;
    @FXML
    private RadioButton rbUtilitario;
    @FXML
    private ToggleGroup rgType;
    @FXML
    private RadioButton rbPasseio;
    @FXML
    private RadioButton rbOffRoad;
    @FXML
    private RadioButton rbEsportivo;
    @FXML
    private RadioButton rbComercial;
    @FXML
    private RadioButton rbNovo;
    @FXML
    private ToggleGroup rgState;
    @FXML
    private RadioButton rbUsado;
    @FXML
    private TextField txKm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerBtnSaveCar(ActionEvent event) {
    }

    @FXML
    private void handlerBtnDeleteCar(ActionEvent event) {
    }

    @FXML
    private void handlerBtnConsultCar(ActionEvent event) {
    }
    
}
