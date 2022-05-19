package co.jers.base.backendproyect.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "caracteristicas")
public class Caracteristica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCaracterisitica;
    private String color;
    private String estilo;
    private String material;
    private String genero;
    private String precio;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    @JsonIgnoreProperties("caracteristicas")
    private Producto producto;

    public Long getIdCaracterisitica() {
        return idCaracterisitica;
    }

    public void setIdCaracterisitica(Long idCaracterisitica) {
        this.idCaracterisitica = idCaracterisitica;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Caracteristica(Long idCaracterisitica, String color, String estilo, String material, String genero,
            String precio) {
        super();
        this.idCaracterisitica = idCaracterisitica;
        this.color = color;
        this.estilo = estilo;
        this.material = material;
        this.genero = genero;
        this.precio = precio;

    }

    public Caracteristica(String color, String estilo, String material, String genero, String precio) {
        this.color = color;
        this.estilo = estilo;
        this.material = material;
        this.genero = genero;
        this.precio = precio;
    }

    public Caracteristica() {
        super();
    }
}
