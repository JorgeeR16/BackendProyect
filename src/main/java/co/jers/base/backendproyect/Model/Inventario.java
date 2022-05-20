package co.jers.base.backendproyect.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "inventarios")
public class Inventario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;
    private Long cantidadProducto;
    private String talla;


    @OneToMany(cascade = { CascadeType.PERSIST}, mappedBy = "inventario")
    @JsonIgnoreProperties({"Caracteristica","inventario"})
    private List<Caracteristica> caracteristicasInventario;


    public List<Caracteristica> getCaracteristicasInventario() {
        return caracteristicasInventario;
    }

    public void setCaracteristicasInventario(List<Caracteristica> caracteristicasInventario) {
        this.caracteristicasInventario = caracteristicasInventario;
    }

    public Long getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Long idInventario) {
        this.idInventario = idInventario;
    }

    public Long getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Long cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

}
