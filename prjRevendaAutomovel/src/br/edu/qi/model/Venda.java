package br.edu.qi.model;
// Generated Nov 15, 2017 12:39:38 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Venda generated by hbm2java
 */
@Entity
@Table(name="venda"
    ,catalog="dbrevenda"
)
public class Venda  implements java.io.Serializable {


     private Integer nroVenda;
     private Carro carro;
     private Proprietario proprietario;
     private Date dataVenda;
     private Date dataPagamento;
     private Character formaPagamento;
     private Integer nroParcelas;
     private Long valor;
     private Boolean liquidado;
     private Set<Parcela> parcelas = new HashSet<Parcela>(0);

    public Venda() {
    }

    public Venda(Carro carro, Proprietario proprietario, Date dataVenda, Date dataPagamento, Character formaPagamento, Integer nroParcelas, Long valor, Boolean liquidado, Set<Parcela> parcelas) {
       this.carro = carro;
       this.proprietario = proprietario;
       this.dataVenda = dataVenda;
       this.dataPagamento = dataPagamento;
       this.formaPagamento = formaPagamento;
       this.nroParcelas = nroParcelas;
       this.valor = valor;
       this.liquidado = liquidado;
       this.parcelas = parcelas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="nro_venda", unique=true, nullable=false)
    public Integer getNroVenda() {
        return this.nroVenda;
    }
    
    public void setNroVenda(Integer nroVenda) {
        this.nroVenda = nroVenda;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_carro")
    public Carro getCarro() {
        return this.carro;
    }
    
    public void setCarro(Carro carro) {
        this.carro = carro;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="proprietario_id")
    public Proprietario getProprietario() {
        return this.proprietario;
    }
    
    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_venda", length=10)
    public Date getDataVenda() {
        return this.dataVenda;
    }
    
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_pagamento", length=10)
    public Date getDataPagamento() {
        return this.dataPagamento;
    }
    
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    
    @Column(name="forma_pagamento", length=1)
    public Character getFormaPagamento() {
        return this.formaPagamento;
    }
    
    public void setFormaPagamento(Character formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    
    @Column(name="nro_parcelas")
    public Integer getNroParcelas() {
        return this.nroParcelas;
    }
    
    public void setNroParcelas(Integer nroParcelas) {
        this.nroParcelas = nroParcelas;
    }

    
    @Column(name="valor", precision=10, scale=0)
    public Long getValor() {
        return this.valor;
    }
    
    public void setValor(Long valor) {
        this.valor = valor;
    }

    
    @Column(name="liquidado")
    public Boolean getLiquidado() {
        return this.liquidado;
    }
    
    public void setLiquidado(Boolean liquidado) {
        this.liquidado = liquidado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="venda")
    public Set<Parcela> getParcelas() {
        return this.parcelas;
    }
    
    public void setParcelas(Set<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.carro);
        hash = 59 * hash + Objects.hashCode(this.proprietario);
        hash = 59 * hash + Objects.hashCode(this.dataVenda);
        hash = 59 * hash + Objects.hashCode(this.dataPagamento);
        hash = 59 * hash + Objects.hashCode(this.formaPagamento);
        hash = 59 * hash + Objects.hashCode(this.nroParcelas);
        hash = 59 * hash + Objects.hashCode(this.valor);
        hash = 59 * hash + Objects.hashCode(this.liquidado);
        hash = 59 * hash + Objects.hashCode(this.parcelas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.carro, other.carro)) {
            return false;
        }
        if (!Objects.equals(this.proprietario, other.proprietario)) {
            return false;
        }
        if (!Objects.equals(this.dataVenda, other.dataVenda)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamento, other.dataPagamento)) {
            return false;
        }
        if (!Objects.equals(this.formaPagamento, other.formaPagamento)) {
            return false;
        }
        if (!Objects.equals(this.nroParcelas, other.nroParcelas)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.liquidado, other.liquidado)) {
            return false;
        }
        if (!Objects.equals(this.parcelas, other.parcelas)) {
            return false;
        }
        return true;
    }




}


