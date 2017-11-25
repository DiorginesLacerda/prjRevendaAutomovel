package br.edu.qi.model;
// Generated Nov 25, 2017 5:45:32 PM by Hibernate Tools 4.3.1


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
 * Marca generated by hbm2java
 */
@Entity
@Table(name="marca"
    ,catalog="dconcessionaria"
)
public class Marca  implements java.io.Serializable {


     private Integer idMarca;
     private String nomeMarca;
     private Set<Modelo> modelos = new HashSet<Modelo>(0);

    public Marca() {
    }

    public Marca(String nomeMarca, Set<Modelo> modelos) {
       this.nomeMarca = nomeMarca;
       this.modelos = modelos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_marca", unique=true, nullable=false)
    public Integer getIdMarca() {
        return this.idMarca;
    }
    
    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    
    @Column(name="nome_marca", length=50)
    public String getNomeMarca() {
        return this.nomeMarca;
    }
    
    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="marca")
    public Set<Modelo> getModelos() {
        return this.modelos;
    }
    
    public void setModelos(Set<Modelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString() {
        return this.nomeMarca;
    }

    



}


