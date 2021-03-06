package br.edu.qi.model;
// Generated Nov 15, 2017 12:39:38 PM by Hibernate Tools 4.3.1


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

/**
 * Modelo generated by hbm2java
 */
@Entity
@Table(name="modelo"
    ,catalog="dbrevenda"
)
public class Modelo  implements java.io.Serializable {


     private Integer idModelo;
     private Marca marca;
     private String nomeModelo;
     private Set<Carro> carros = new HashSet<Carro>(0);

    public Modelo() {
    }

    public Modelo(Marca marca, String nomeModelo, Set<Carro> carros) {
       this.marca = marca;
       this.nomeModelo = nomeModelo;
       this.carros = carros;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_modelo", unique=true, nullable=false)
    public Integer getIdModelo() {
        return this.idModelo;
    }
    
    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_marca")
    public Marca getMarca() {
        return this.marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    
    @Column(name="nome_modelo", length=50)
    public String getNomeModelo() {
        return this.nomeModelo;
    }
    
    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="modelo")
    public Set<Carro> getCarros() {
        return this.carros;
    }
    
    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.marca);
        hash = 29 * hash + Objects.hashCode(this.nomeModelo);
        hash = 29 * hash + Objects.hashCode(this.carros);
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
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.nomeModelo, other.nomeModelo)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.carros, other.carros)) {
            return false;
        }
        return true;
    }




}


