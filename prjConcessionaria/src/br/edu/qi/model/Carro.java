package br.edu.qi.model;
// Generated Nov 25, 2017 7:26:47 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
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

/**
 * Carro generated by hbm2java
 */
@Entity
@Table(name="carro"
    ,catalog="dconcessionaria"
)
public class Carro  implements java.io.Serializable {


     private Integer idCarro;
     private Modelo modelo;
     private String cor;
     private String descricao;
     private String estado;
     private Long km;
     private Long valor;
     private String ano;
     private String tipo;
     private Set<CarroAcessorio> carroAcessorios = new HashSet<CarroAcessorio>(0);
     private Set<Venda> vendas = new HashSet<Venda>(0);

    public Carro(String nome, String estado) {
        this.modelo = new Modelo();
        this.modelo.setNomeModelo(nome);
        this.estado = estado;
    }
    
    public Carro() {
    }

    public Carro(Modelo modelo, String cor, String descricao, String estado, Long km, Long valor, String ano, String tipo, Set<CarroAcessorio> carroAcessorios, Set<Venda> vendas) {
       this.modelo = modelo;
       this.cor = cor;
       this.descricao = descricao;
       this.estado = estado;
       this.km = km;
       this.valor = valor;
       this.ano = ano;
       this.tipo = tipo;
       this.carroAcessorios = carroAcessorios;
       this.vendas = vendas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_carro", unique=true, nullable=false)
    public Integer getIdCarro() {
        return this.idCarro;
    }
    
    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_modelo")
    public Modelo getModelo() {
        return this.modelo;
    }
    
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    
    @Column(name="cor", length=50)
    public String getCor() {
        return this.cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }

    
    @Column(name="descricao", length=65535)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Column(name="estado", length=65535)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Column(name="km", precision=10, scale=0)
    public Long getKm() {
        return this.km;
    }
    
    public void setKm(Long km) {
        this.km = km;
    }

    
    @Column(name="valor", precision=10, scale=0)
    public Long getValor() {
        return this.valor;
    }
    
    public void setValor(Long valor) {
        this.valor = valor;
    }

    
    @Column(name="ano", length=65535)
    public String getAno() {
        return this.ano;
    }
    
    public void setAno(String ano) {
        this.ano = ano;
    }

    
    @Column(name="tipo", length=65535)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="carro")
    public Set<CarroAcessorio> getCarroAcessorios() {
        return this.carroAcessorios;
    }
    
    public void setCarroAcessorios(Set<CarroAcessorio> carroAcessorios) {
        this.carroAcessorios = carroAcessorios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="carro")
    public Set<Venda> getVendas() {
        return this.vendas;
    }
    
    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        if(this.estado == "")
            return this.modelo.getNomeModelo();
        String s = this.modelo.getNomeModelo() + " " +this.cor +" ano:"+this.ano;
        return s;
        
    }
    
    
}


