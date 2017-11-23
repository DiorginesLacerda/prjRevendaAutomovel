/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.ProprietarioBo;
import br.edu.qi.model.Acessorio;
import br.edu.qi.model.Proprietario;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class ClientEditViewController implements Initializable {

    private ObservableList<Proprietario> data;
    private ProprietarioBo bo;
    
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
    private TableView<Proprietario> tbClients;
    @FXML
    private TableColumn tbColName;
    @FXML
    private TableColumn tbColEmail;

    public ClientEditViewController() throws Exception {
        this.bo = new ProprietarioBo();
    }
    
    private List<Proprietario> getData(){
        try {
            List<Proprietario> list = bo.findAll();
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    private void loadScreen(){
        txName.setText("");
        txCity.setText("");
        txEmail.setText("");
        txNeighborhood.setText("");
        txPhoneNumber.setText("");
        txStreet.setText("");
        txUf.setText("");
        data.addAll(getData());
    }

    /**
     * Initializes the controller class.
    */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        tbColName.setCellValueFactory(new PropertyValueFactory("nome"));
        tbColEmail.setCellValueFactory(new PropertyValueFactory("email"));
        loadScreen();
        tbClients.setItems(data);
    }    

    @FXML
    private void handlerBtnSave(ActionEvent event) throws Exception {
        Proprietario proprietario = new Proprietario();
        proprietario.setNome(txName.getText());
        proprietario.setCidade(txCity.getText());
        proprietario.setEmail(txEmail.getText());
        proprietario.setBairro(txNeighborhood.getText());
        proprietario.setTelefone(txPhoneNumber.getText());
        proprietario.setRua(txStreet.getText());
        proprietario.setEstado(txUf.getText());
        bo.save(proprietario);
        loadScreen();
        
    }

    @FXML
    private void handlerBtnDelete(ActionEvent event) {
    }
    
}
