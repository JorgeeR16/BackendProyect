package co.jers.base.backendproyect.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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

    @ManyToMany
    @JoinTable(name = "caracteristica_producto", joinColumns = @JoinColumn(name = "caracteristica_id"), inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos;// =new HashSet<>();

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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Caracteristica(Long idCaracterisitica, String color, String estilo, String material, String genero,
            String precio, List<Producto> productos) {
        super();
        this.idCaracterisitica = idCaracterisitica;
        this.color = color;
        this.estilo = estilo;
        this.material = material;
        this.genero = genero;
        this.precio = precio;
        this.productos = productos;
    }

    public Caracteristica(String color, String estilo, String material, String genero, String precio,
            List<Producto> productos) {
        super();
        this.color = color;
        this.estilo = estilo;
        this.material = material;
        this.genero = genero;
        this.precio = precio;
        this.productos = productos;
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

    public void añadirProducto(Producto producto) {
        this.productos.add(producto);
    }

}
