package co.jers.base.backendproyect.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import co.jers.base.backendproyect.Model.Proveedor;
import org.springframework.stereotype.Service;

import co.jers.base.backendproyect.Repository.ProveedorRepository;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorLogic;

    public List<Proveedor> getAll() {
        return proveedorLogic.getAll();
    }

    public Proveedor save(Proveedor prove) {
        if (prove.getIdProveedor() == null) {
           
            return  proveedorLogic.save(prove);
        }
        return proveedorLogic.save(prove);
    }

}
