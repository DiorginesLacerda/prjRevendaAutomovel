/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.MarcaBo;
import br.edu.qi.bo.ModeloBo;
import br.edu.qi.model.Marca;
import br.edu.qi.model.Modelo;
import br.edu.qi.model.Proprietario;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class ModelCarViewController implements Initializable {
    
    private ObservableList<Modelo> data;
    private ModeloBo bo;
    private MarcaBo marcaBo;

    @FXML
    private TextField txModel;
    @FXML
    private ComboBox<Marca> cbbxBrand;
    @FXML
    private TableView<Modelo> tbModelBrand;
    @FXML
    private TableColumn tbcolModel;
    @FXML
    private TableColumn<Marca,String> tbcolBrand;

    public ModelCarViewController() throws Exception {
        this.bo = new ModeloBo(); 
        this.marcaBo = new MarcaBo();
    }

    private List<Modelo> getData(){
        try {
            List<Modelo> list = bo.findAll();
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    private void loadBrand() {
        cbbxBrand.getItems().clear();
        cbbxBrand.getItems().add(0,new Marca("Selecione",null));
        try {
            cbbxBrand.getItems().addAll(marcaBo.findAll());
            cbbxBrand.getSelectionModel().select(0);
        } catch (Exception e) {
        }
    }
    
    private void loadScreen(){
        this.txModel.setText("");
        data.clear();
        data.addAll(getData());
        loadBrand();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        tbcolModel.setCellValueFactory(new PropertyValueFactory("nomeModelo"));
        tbcolBrand.setCellValueFactory(new PropertyValueFactory("marca"));
        
        loadScreen();
        tbModelBrand.setItems(data);
        
            
        
    }    

    @FXML
    private void handlerSaveModel(ActionEvent event) throws Exception {
        Modelo modelo = new Modelo();
        modelo.setNomeModelo(txModel.getText());
        modelo.setMarca(cbbxBrand.getSelectionModel().getSelectedItem());
        bo.save(modelo);
        loadScreen();
    }

    @FXML
    private void handlerDeleteModel(ActionEvent event) {
    }
    
}
