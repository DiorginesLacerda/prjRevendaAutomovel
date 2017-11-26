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
import br.edu.qi.util.NumberUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
    private List<Acessorio>accessories;
    
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
        this.carro = new Carro();
        loadAccessories();
    }
    
    private void loadAccessories(){
        vbxAccessories.getChildren().clear();
        try {
            this.accessories = acessorioBo.findAll();
            List<Acessorio> acssCar = new ArrayList<>();
            
            //create the checkBoxes of Accessories
            accessories.forEach((accessory)->{
                vbxAccessories.getChildren().add(new CheckBox(accessory.getNomeAcessorio()));
                carro.getCarroAcessorios().forEach((carroAcessorio)->{
                    if(carroAcessorio.getAcessorio().getIdAcessorio().equals
                       (accessory.getIdAcessorio())){
                        acssCar.add(accessory);
                    }
                });
            });
            
            //Change for selected the checkboxes for car
            acssCar.forEach((acessory)->{
                vbxAccessories.getChildren().forEach((node)->{
                    if(node instanceof CheckBox){
                        String nome = ((CheckBox) node).getText();
                        if(nome.equals(acessory.getNomeAcessorio()))
                            ((CheckBox) node).setSelected(true);
                    }
                });
            });
        } catch (Exception e) {
        }
    }
    
    private Set<CarroAcessorio> getSelectedAccessories(){
        //Busca os acessorios Selecionados
      //  List<String>selectedAccessories = new ArrayList<>();
        Set<CarroAcessorio> listCarroAcessorio = new HashSet<>();
        vbxAccessories.getChildren().forEach((node)->{
            if(node instanceof CheckBox){
                //Verifica se foi Selecionado
                if(((CheckBox) node).selectedProperty().getValue()){
                    String s = ((CheckBox) node).getText();
                    //Cria o Set para ser enviado
                    accessories.forEach((accessory)->{
                            if(accessory.getNomeAcessorio().equals(s)){
                                listCarroAcessorio.add(new CarroAcessorio(accessory, carro));
                            }
                    });
                    
                    //selectedAccessories.add(((CheckBox) node).getText());
                }
            }
        });
        
        /*
        selectedAccessories.forEach((textAcessory)->{
            accessories.forEach((accessory)->{
                if(accessory.getNomeAcessorio().equals(textAcessory)){
                    listCarroAcessorio.add(new CarroAcessorio(accessory, carro));
                }
            });
        });*/
        
        return listCarroAcessorio;
    }
    
    private String getTypeSelected(){
        if(rbComercial.isSelected())
            return rbComercial.getText();
        if(rbEsportivo.isSelected())
            return rbEsportivo.getText();
        if(rbOffRoad.isSelected())
            return rbOffRoad.getText();
        if(rbPasseio.isSelected())
            return rbPasseio.getText();
        if(rbUtilitario.isSelected())
            return rbPasseio.getText();
        return "";
    }
    
    
    @FXML
    private void handlerRbUsado(ActionEvent event) {
        if(rbUsado.isSelected())
            hbxKM.setVisible(true);
    }

    @FXML
    private void handlerRbNovo(ActionEvent event) {
        if(rbNovo.isSelected()){
            hbxKM.setVisible(false);
            //txKm.setText("0");
        }
            
    }
            
    @FXML
    private void handlerBtnSaveCar(ActionEvent event) throws Exception {
        getDataScreen();
        bo.save(this.carro);
        loadScreen();
        
    }

    @FXML
    private void handlerBtnDeleteCar(ActionEvent event) {
    }

    @FXML
    private void handlerBtnConsultCar(ActionEvent event) {
        showConsultCar();
    }
    
    private void getDataScreen() throws Exception{
        this.carro.setModelo(cbbxModelCar.getSelectionModel().getSelectedItem());
        this.carro.setCor(cbbxColorCar.getSelectionModel().getSelectedItem());
        this.carro.setDescricao(txDescription.getText());
        this.carro.setEstado(rbNovo.isSelected()?"Novo":"Usado");
        this.carro.setKm(rbNovo.isSelected()?0:NumberUtil.setFloat(txKm.getText()));
        this.carro.setCarroAcessorios(getSelectedAccessories());
        this.carro.setAno(txYear.getText());
        this.carro.setTipo(getTypeSelected());
        this.carro.setValor(NumberUtil.setFloat(txValueCar.getText()));
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
