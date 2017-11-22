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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnCar;
    @FXML
    private Button btnBrand;
    @FXML
    private Button btnModelCar;
    @FXML
    private Button btnAccessories;
    @FXML
    private Button btnCadClient;
    @FXML
    private Button btnRegSale;
    @FXML
    private Button btnRegPayment;
    @FXML
    private Button btnClassDiagram;
    @FXML
    private Button btnScriptDatabase;
    @FXML
    private ImageView imgCar;
    @FXML
    private AnchorPane dataPane;
    
    public void setDataPane(String source){
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
    private void handlerBtnCar(ActionEvent event) {
        setDataPane("view/CarEditView.fxml");
    }

    @FXML
    private void handlerBtnBrand(ActionEvent event) {
        setDataPane("view/BrandEditView.fxml");
    }

    @FXML
    private void handlerBtnModelCar(ActionEvent event) {
        setDataPane("view/ModelCarView.fxml");
    }

    @FXML
    private void handlerBtnAccessories(ActionEvent event) {
        setDataPane("view/AccessoryEditView.fxml");
    }

    @FXML
    private void handlerBtnCadClient(ActionEvent event) {
        setDataPane("view/ClientEditView.fxml");
    }

    @FXML
    private void handlerBtnRegSale(ActionEvent event) {
        setDataPane("view/SaleEditView.fxml");
    }

    @FXML
    private void handlerBtnRegPayment(ActionEvent event) {
    }

    @FXML
    private void handlerBtnClassDiagram(ActionEvent event) {
    }

    @FXML
    private void handlerBtnDatabase(ActionEvent event) {
    }
    
}
