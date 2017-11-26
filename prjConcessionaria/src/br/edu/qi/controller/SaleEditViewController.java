/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.AcessorioBo;
import br.edu.qi.bo.CarroBo;
import br.edu.qi.bo.ProprietarioBo;
import br.edu.qi.bo.VendaBo;
import br.edu.qi.model.Carro;
import br.edu.qi.model.Proprietario;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class SaleEditViewController implements Initializable {

    private VendaBo bo;
    private CarroBo carBo;
    private ProprietarioBo clientBo;
    private AcessorioBo accessoryBo;
    private Carro car;
    private Proprietario client;
    
    
    //@FXML
    //private TextField txClient;
    @FXML
    private TextArea txCarDetails;
    @FXML
    private AnchorPane apAccessories;
    @FXML
    private TextField txTotValue;
    @FXML
    private ComboBox cbbxClient;
    @FXML
    private ComboBox cbbxCar;
    @FXML
    private Label lbInstallment;
    @FXML
    private TextField txClient;
    @FXML
    private RadioButton rbCash;
    @FXML
    private ToggleGroup rgTypePayment;
    @FXML
    private RadioButton rbInstallment;
    @FXML
    private HBox hboxParcelas;

    public SaleEditViewController() throws Exception {
        this.bo = new VendaBo();
        this.carBo = new CarroBo();
        this.clientBo = new ProprietarioBo();
        this.accessoryBo = new AcessorioBo();
        this.car = new Carro();
        this.client = new Proprietario();
    }

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadClients();
        loadCars();
    }
    
    private void loadClients(){
        cbbxClient.getItems().clear();
        cbbxClient.getItems().add(0,("Selecione um Cliente"));
        try {
            cbbxClient.getItems().addAll(clientBo.findAll());
            cbbxClient.getSelectionModel().select(0);
        } catch (Exception e) {
        }
    }
   
    private void loadCars(){
        cbbxCar.getItems().clear();
        cbbxCar.getItems().add(0,new Carro("Selecione", ""));
        try {
            List<Carro> teste = carBo.findAll();
            cbbxCar.getItems().addAll(teste);
            cbbxCar.getSelectionModel().select(0);
        } catch (Exception e) {
        }
    }

    @FXML
    private void hanclerSelectedCar(ActionEvent event) {
    }

    /*
    @FXML
    private void handlerBtnSelectClient(MouseEvent event) {
    }*/

    @FXML
    private void handlerConcluseSale(ActionEvent event) {
    }

    @FXML
    private void handlerCancelSale(ActionEvent event) {
    }

    @FXML
    private void handlerConsultSales(ActionEvent event) {
    }

    @FXML
    private void handlerBtnSelectClient(ActionEvent event) {
    }

    @FXML
    private void handlerBtnSelectClient(MouseEvent event) {
    }
    
}
