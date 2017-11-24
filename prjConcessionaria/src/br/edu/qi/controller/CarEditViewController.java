/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.MainApp;
import br.edu.qi.bo.AcessorioBo;
import br.edu.qi.bo.CarroBo;
import br.edu.qi.bo.ModeloBo;
import br.edu.qi.model.Acessorio;
import br.edu.qi.model.Carro;
import br.edu.qi.model.CarroAcessorio;
import br.edu.qi.model.Modelo;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diorgines
 */
public class CarEditViewController implements Initializable {

    private CarroBo bo;
    private ModeloBo modeloBo;
    private AcessorioBo acessorioBo;
    private Carro carro;
    
    @FXML
    private ComboBox<Modelo> cbbxModelCar;
    @FXML
    private TextField txYear;
    @FXML
    private TextField txValueCar;
    @FXML
    private ComboBox<String> cbbxColorCar;
    @FXML
    private TextArea txDescription;
    @FXML
    private VBox vbxAccessories;
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
    @FXML
    private HBox hbxKM;
    @FXML
    private AnchorPane dataPane;

    public CarEditViewController() throws Exception {
        this.bo = new CarroBo();
        this.modeloBo = new ModeloBo();
        this.acessorioBo = new AcessorioBo();
        this.carro = new Carro();
    }
    
    public CarEditViewController(Carro c) throws Exception {
        this.bo = new CarroBo();
        this.modeloBo = new ModeloBo();
        this.acessorioBo = new AcessorioBo();
        this.carro = c;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbbxColorCar.getItems().addAll(bo.getColors());
        loadScreen();
        loadAccessories();
    }
    
    private void loadModels(){
        cbbxModelCar.getItems().clear();
        cbbxModelCar.getItems().add(0,new Modelo(null, "Selecione", null));
        try {
            cbbxModelCar.getItems().addAll(modeloBo.findAll());
            cbbxModelCar.getSelectionModel().select(0);;
        } catch (Exception e) {
        }
    }
    
    private void loadScreen(){
        loadModels();
        cbbxColorCar.getSelectionModel().select(0);
        txYear.setText("");
        txDescription.setText("");
        txKm.setText("");
        txValueCar.setText("");
        rbNovo.setSelected(true);
        hbxKM.setVisible(false);
    }
    
    private void loadAccessories(){
        try {
            List<Acessorio> accessories = acessorioBo.findAll();
            Set<Acessorio> setAcessorio = new HashSet<>();
            
            accessories.forEach((accessory)->{
                vbxAccessories.getChildren().add(new CheckBox(accessory.getNomeAcessorio()));
            });
            vbxAccessories.getChildren().forEach((node)->{
                if(node instanceof CheckBox){
                    ((CheckBox) node).setSelected(true);
                }
            });
            
        } catch (Exception e) {
        }
    }
    

    @FXML
    private void handlerBtnSaveCar(ActionEvent event) {
    }

    @FXML
    private void handlerBtnDeleteCar(ActionEvent event) {
    }

    @FXML
    private void handlerBtnConsultCar(ActionEvent event) {
        showConsultCar();
    }
    
    private void showConsultCar(){
        Stage stage = new Stage();
        Pane pane= MainApp.getPane("view/ConsultCarView.fxml");
        stage.setScene(new Scene(pane));
        stage.setTitle("Consulta Veículos");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();
    }
    
}
