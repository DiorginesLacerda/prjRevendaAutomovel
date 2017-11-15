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
 * Acessorio generated by hbm2java
 */
@Entity
@Table(name="acessorio"
    ,catalog="dbrevenda"
)
public class Acessorio  implements java.io.Serializable {


     private Integer idAcessorio;
     private String nomeAcessorio;
     private Set<CarroAcessorio> carroAcessorios = new HashSet<CarroAcessorio>(0);

    public Acessorio() {
    }

    public Acessorio(String nomeAcessorio, Set<CarroAcessorio> carroAcessorios) {
       this.nomeAcessorio = nomeAcessorio;
       this.carroAcessorios = carroAcessorios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_acessorio", unique=true, nullable=false)
    public Integer getIdAcessorio() {
        return this.idAcessorio;
    }
    
    public void setIdAcessorio(Integer idAcessorio) {
        this.idAcessorio = idAcessorio;
    }

    
    @Column(name="nome_acessorio", length=50)
    public String getNomeAcessorio() {
        return this.nomeAcessorio;
    }
    
    public void setNomeAcessorio(String nomeAcessorio) {
        this.nomeAcessorio = nomeAcessorio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="acessorio")
    public Set<CarroAcessorio> getCarroAcessorios() {
        return this.carroAcessorios;
    }
    
    public void setCarroAcessorios(Set<CarroAcessorio> carroAcessorios) {
        this.carroAcessorios = carroAcessorios;
    }




}


