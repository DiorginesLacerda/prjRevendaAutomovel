/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.MarcaBo;
import br.edu.qi.model.Marca;
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
public class BrandEditViewController implements Initializable {

    private ObservableList<Marca> data;
    private MarcaBo bo;
    
    @FXML
    private TextField txBrand;
    @FXML
    private TableView<Marca> tbVBrands;
    @FXML
    private TableColumn tbColBrands;

    public BrandEditViewController() throws Exception {
        this.bo = new MarcaBo();
        
    }
    
    private List<Marca> getData(){
        try {
            List<Marca> list = bo.findAll();
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        //tbColBrands = new TableColumn<>();
        tbColBrands.setCellValueFactory(new PropertyValueFactory("nomeMarca"));
        data.addAll(getData());
        tbVBrands.setItems(data);
        
    }    

    @FXML
    private void handlerSaveBrand(ActionEvent event) {
    }

    @FXML
    private void handlerDeleteBrand(ActionEvent event) {
    }
    
}
