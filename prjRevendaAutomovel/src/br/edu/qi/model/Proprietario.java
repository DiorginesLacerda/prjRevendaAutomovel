package br.edu.qi.model;
// Generated Nov 15, 2017 9:43:23 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Proprietario generated by hbm2java
 */
@Entity
@Table(name="proprietario"
    ,catalog="dbrevenda"
)
public class Proprietario  implements java.io.Serializable {


     private Integer proprietarioId;
     private String nome;
     private String telefone;
     private String email;
     private String rua;
     private String bairro;
     private String cidade;
     private String estado;
     private Set<Venda> vendas = new HashSet<Venda>(0);

    public Proprietario() {
    }

    public Proprietario(String nome, String telefone, String email, String rua, String bairro, String cidade, String estado, Set<Venda> vendas) {
       this.nome = nome;
       this.telefone = telefone;
       this.email = email;
       this.rua = rua;
       this.bairro = bairro;
       this.cidade = cidade;
       this.estado = estado;
       this.vendas = vendas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="proprietario_id", unique=true, nullable=false)
    public Integer getProprietarioId() {
        return this.proprietarioId;
    }
    
    public void setProprietarioId(Integer proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    
    @Column(name="nome", length=50)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="telefone", length=15)
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    @Column(name="email", length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="rua", length=50)
    public String getRua() {
        return this.rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }

    
    @Column(name="bairro", length=50)
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
    @Column(name="cidade", length=50)
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
    @Column(name="Estado", length=50)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proprietario")
    public Set<Venda> getVendas() {
        return this.vendas;
    }
    
    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }




}


