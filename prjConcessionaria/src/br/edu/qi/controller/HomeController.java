/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    
    private AnchorPane setDataPane(String source) throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource(source));
        //dataPane.getChildren().setAll(node);
        return pane;
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
    }

    @FXML
    private void handlerBtnBrand(ActionEvent event) {
    }

    @FXML
    private void handlerBtnModelCar(ActionEvent event) {
    }

    @FXML
    private void handlerBtnAccessories(ActionEvent event) throws IOException {
        dataPane.getChildren().clear();
        dataPane.getChildren().add(MainApp.showView("view/AccessoryEditView.fxml"));
    }

    @FXML
    private void handlerBtnCadClient(ActionEvent event) {
    }

    @FXML
    private void handlerBtnRegSale(ActionEvent event) {
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
