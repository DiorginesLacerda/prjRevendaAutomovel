/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.AcessorioBo;
import br.edu.qi.model.Acessorio;
import br.edu.qi.model.Marca;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class AccessoryEditViewController implements Initializable {

    private ObservableList<Acessorio> data;
    private AcessorioBo bo;
    
    @FXML
    private TextField txtAccessory;
    @FXML
    private TextField txtValue;
    @FXML
    private Button btnSaveAccesory;
    @FXML
    private Button btnDeleteAccessory;
    @FXML
    private TableView<Acessorio> tbAccessory;
    @FXML
    private TableColumn tbcAccessoryName;
 

    public AccessoryEditViewController() throws Exception {
        this.bo = new AcessorioBo();
    }

    private List<Acessorio> getData(){
        try {
            List<Acessorio> list = bo.findAll();
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    private void loadScreen(){
        this.txtAccessory.setText("");
        data.clear();
        data.addAll(getData());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        tbcAccessoryName.setCellValueFactory(new PropertyValueFactory("nomeAcessorio"));
        loadScreen();
        tbAccessory.setItems(data);
    }    

    @FXML
    private void handlerBtnSaveAccesory(ActionEvent event) throws Exception {
        Acessorio acessorio = new Acessorio();
        acessorio.setNomeAcessorio(txtAccessory.getText());
        bo.save(acessorio);
        loadScreen();
    }

    @FXML
    private void handlerBtnDeleteAccessory(ActionEvent event) {
    }
    
}
