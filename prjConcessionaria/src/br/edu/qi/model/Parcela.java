package br.edu.qi.model;
// Generated Nov 19, 2017 7:44:42 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Parcela generated by hbm2java
 */
@Entity
@Table(name="parcela"
    ,catalog="dbrevenda"
)
public class Parcela  implements java.io.Serializable {


     private Integer idParcela;
     private Venda venda;
     private Date dataParcela;
     private Long valorParcela;
     private Long multa;
     private Date dataPagamento;
     private Boolean pago;

    public Parcela() {
    }

    public Parcela(Venda venda, Date dataParcela, Long valorParcela, Long multa, Date dataPagamento, Boolean pago) {
       this.venda = venda;
       this.dataParcela = dataParcela;
       this.valorParcela = valorParcela;
       this.multa = multa;
       this.dataPagamento = dataPagamento;
       this.pago = pago;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_parcela", unique=true, nullable=false)
    public Integer getIdParcela() {
        return this.idParcela;
    }
    
    public void setIdParcela(Integer idParcela) {
        this.idParcela = idParcela;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nro_venda")
    public Venda getVenda() {
        return this.venda;
    }
    
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_parcela", length=10)
    public Date getDataParcela() {
        return this.dataParcela;
    }
    
    public void setDataParcela(Date dataParcela) {
        this.dataParcela = dataParcela;
    }

    
    @Column(name="valor_parcela", precision=10, scale=0)
    public Long getValorParcela() {
        return this.valorParcela;
    }
    
    public void setValorParcela(Long valorParcela) {
        this.valorParcela = valorParcela;
    }

    
    @Column(name="multa", precision=10, scale=0)
    public Long getMulta() {
        return this.multa;
    }
    
    public void setMulta(Long multa) {
        this.multa = multa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_pagamento", length=10)
    public Date getDataPagamento() {
        return this.dataPagamento;
    }
    
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    
    @Column(name="pago")
    public Boolean getPago() {
        return this.pago;
    }
    
    public void setPago(Boolean pago) {
        this.pago = pago;
    }




}


