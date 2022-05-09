package co.jers.base.backendproyect.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="proveedores")
public class Proveedor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;
    private String nameProduct;

    
    public Long getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }


}