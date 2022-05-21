package co.jers.base.backendproyect.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    private Long precio;

    @OneToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    @JsonIgnoreProperties({ "caracteristicas", "producto" })
    private Producto producto;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "caracteristica")
    @JsonIgnoreProperties("caracteristica")
    private List<Inventario> inventarios;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "caracteristica")
    @JsonIgnoreProperties("caracteristica")
    private List<Imagen> imagenes;

    public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

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

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Caracteristica(Long idCaracterisitica, String color, String estilo, String material, String genero,
            Long precio) {
        super();
        this.idCaracterisitica = idCaracterisitica;
        this.color = color;
        this.estilo = estilo;
        this.material = material;
        this.genero = genero;
        this.precio = precio;

    }

    public Caracteristica(String color, String estilo, String material, String genero, Long precio) {
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
