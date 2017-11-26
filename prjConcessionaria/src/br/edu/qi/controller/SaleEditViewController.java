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
import br.edu.qi.model.Acessorio;
import br.edu.qi.model.Carro;
import br.edu.qi.model.CarroAcessorio;
import br.edu.qi.model.Parcela;
import br.edu.qi.model.Proprietario;
import br.edu.qi.model.Venda;
import br.edu.qi.util.NumberUtil;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    private Venda sale;
    private Proprietario client;
    private List<Acessorio>accessories;
    
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
    private HBox hbxInstallment;
    @FXML
    private VBox vbxAccessories;
    @FXML
    private TextField txInstallment;

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
        loadScreen();
    }
    
    private Set<CarroAcessorio> getSelectedAccessories(){
        //Busca os acessorios Selecionados
        List<String>selectedAccessories = new ArrayList<>();
        vbxAccessories.getChildren().forEach((node)->{
            if(node instanceof CheckBox){
                //Verifica se foi Selecionado
                if(((CheckBox) node).selectedProperty().getValue()){
                    selectedAccessories.add(((CheckBox) node).getText());
                }
            }
        });
        //Cria o Set para ser enviado
        Set<CarroAcessorio> listCarroAcessorio = new HashSet<>();
        selectedAccessories.forEach((textAcessory)->{
            accessories.forEach((accessory)->{
                if(accessory.getNomeAcessorio().equals(textAcessory)){
                    listCarroAcessorio.add(new CarroAcessorio(accessory, car));
                }
            });
        });
        
        return listCarroAcessorio;
    }
    
    private void loadScreen(){
        loadClients();
        loadCars();
        loadAccessories();
        txCarDetails.setText("");
        txInstallment.setText("1");
        txTotValue.setText("");
        lbInstallment.setText("0");
        rbCash.setSelected(true);
        hbxInstallment.setVisible(false);
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
    
    private void loadAccessories(){
        vbxAccessories.getChildren().clear();
        try {
            this.accessories = accessoryBo.findAll();
            List<Acessorio> acssCar = new ArrayList<>();
            
            //create the checkBoxes of Accessories
            accessories.forEach((accessory)->{
                vbxAccessories.getChildren().add(new CheckBox(accessory.getNomeAcessorio()));
                car.getCarroAcessorios().forEach((carroAcessorio)->{
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
    
    private char getTypePayment(){
        return rbCash.isSelected()?'C':'I';
    }
    
    private void getDataSale() throws Exception{
        client = (Proprietario) cbbxClient.getSelectionModel().getSelectedItem();
        LocalDate ld = LocalDate.now();
        Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date hoje = Date.from(instant);
        this.sale = new Venda();
        this.sale.setCarro(car);
        this.sale.setProprietario(client);
        //this.sale.setDataPagamento(hoje);
        this.sale.setDataVenda(hoje);
        this.sale.setFormaPagamento(getTypePayment());
        this.sale.setNroParcelas(txInstallment.getText().isEmpty()?0:NumberUtil.getInteger(txInstallment.getText()));
        this.sale.setValor(NumberUtil.LongtoDouble(this.car.getValor()));
        this.sale.setLiquidado(true);
    }

    @FXML
    private void hanclerSelectedCar(ActionEvent event) {
        this.car = (Carro) cbbxCar.getSelectionModel().getSelectedItem();
        
        if(cbbxCar.getSelectionModel().getSelectedIndex()==0){
            this.txCarDetails.setText("");
            this.txTotValue.setText("");
        }
        this.txCarDetails.setText(this.car.getResume());
        this.txTotValue.setText(String.format("%1$,.2f", NumberUtil.getFloat(this.car.getValor())));
        loadAccessories();
    }

    /*
    @FXML
    private void handlerBtnSelectClient(MouseEvent event) {
    }*/

    @FXML
    private void handlerConcluseSale(ActionEvent event) throws Exception {
        getSelectedAccessories();
        getDataSale();
        bo.save(sale);
        loadScreen();
    }

    @FXML
    private void handlerCancelSale(ActionEvent event) {
        loadScreen();
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

    @FXML
    private void handlerRbCashSelected(ActionEvent event) {
        hbxInstallment.setVisible(false);
        
    }

    @FXML
    private void handlerRbtallmentSelected(ActionEvent event) throws Exception {
        hbxInstallment.setVisible(true);
        txInstallment.setText("1");
        txInstallment.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                try {
                    if(!txInstallment.getText().isEmpty()){
                        lbInstallment.setText(String.format("%1$,.2f",
                            bo.calculaparcela(NumberUtil.getFloat(SaleEditViewController.this.car.getValor()),
                                    NumberUtil.getInteger(txInstallment.getText().isEmpty()?"0":txInstallment.getText()))));
                    }
                else{
                        lbInstallment.setText("0");
                    }  
                }catch (Exception ex) {
                    Logger.getLogger(SaleEditViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        lbInstallment.setText(String.format("%1$,.2f",
                bo.calculaparcela(NumberUtil.getFloat(this.car.getValor()),
                        NumberUtil.getInteger(txInstallment.getText().isEmpty()?"0":txInstallment.getText()))
        ));
    }

    @FXML
    private void handlerTxIstallment(ActionEvent event) throws Exception {
    }
    
}
