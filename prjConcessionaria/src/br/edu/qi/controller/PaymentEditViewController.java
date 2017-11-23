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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class PaymentEditViewController implements Initializable {

    @FXML
    private TextField txFindCient;
    @FXML
    private Button btnFIndClient;
    @FXML
    private TableView<?> tbPayments;
    @FXML
    private TableColumn<?, ?> tbcolClient;
    @FXML
    private TableColumn<?, ?> tbcolNInstallment;
    @FXML
    private TableColumn<?, ?> tbcolExpiration;
    @FXML
    private TableColumn<?, ?> tcolValue;
    @FXML
    private TableColumn<?, ?> tbColStatus;
    @FXML
    private Button btnPay;
    @FXML
    private Button btnReverse;
    @FXML
    private Label lbStatus;
    @FXML
    private Label lbInstallment;
    @FXML
    private Label lbExpiration;
    @FXML
    private Label lbSaleNumber;
    @FXML
    private Label lbDatePayment;
    @FXML
    private Label lbValueInstallment;
    @FXML
    private Label lbPenalty;
    @FXML
    private Label lbValueTot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerBtnFindClient(ActionEvent event) {
    }

    @FXML
    private void handlerBtnPay(ActionEvent event) {
    }

    @FXML
    private void handlerBtnReverse(ActionEvent event) {
    }

    @FXML
    private void clickNumberSale(MouseEvent event) {
    }
    
}
