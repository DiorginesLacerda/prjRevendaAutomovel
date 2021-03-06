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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Marca generated by hbm2java
 */
@Entity
@Table(name="marca"
    ,catalog="dbrevenda"
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
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nomeMarca);
        hash = 97 * hash + Objects.hashCode(this.modelos);
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
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.nomeMarca, other.nomeMarca)) {
            return false;
        }
        if (!Objects.equals(this.modelos, other.modelos)) {
            return false;
        }
        return true;
    }




}


