package co.jers.base.backendproyect.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.jers.base.backendproyect.Interface.ProveedorInterface;
import co.jers.base.backendproyect.Model.Proveedor;

@Repository
public class ProveedorRepository {

    @Autowired
    private ProveedorInterface proveedorCRUD;

    public List<Proveedor> getAll() { // Trae los proveedores en su totalidad como una lista
        return (List<Proveedor>) proveedorCRUD.findAll();
    }

    public Optional<Proveedor> getProveedor(Long id) {
        return proveedorCRUD.findById(id);
    }

    public Proveedor save(Proveedor prov) {
        return proveedorCRUD.save(prov);
    }

    public void delete(Proveedor prov) {
        proveedorCRUD.delete(prov);
    }

}
