package co.jers.base.backendproyect.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Proveedor> getId(Long id) {
        return proveedorLogic.getId(id);
    }

    /*
     * si me llega un proveedor la vamos a guardar
     * pero si llega sin id es que no esta y procedeemos a guardarlo
     * pero si llega con id se debe validar si este ya existe
     */
    public Proveedor save(Proveedor prove) {
        if (prove.getIdProveedor() == null) {// si no tiene es id nuevo
            return proveedorLogic.save(prove);
        } else {
            Optional<Proveedor> paux = proveedorLogic.getId(prove.getIdProveedor());// aqui validamos si el id
                                                                                    // existe
            if (paux.isEmpty()) {
                return proveedorLogic.save(prove);
            }
            return prove;
        }
    }

    public Proveedor update(Proveedor prove) {// se actualizaran los datos que traigan un id
        if (prove.getIdProveedor() != null) {// se validara si se envio id
            Optional<Proveedor> pax = proveedorLogic.getId(prove.getIdProveedor());// si existe debe traer el
                                                                                   // objeto
            if (!pax.isEmpty()) {
                if (prove.getNameProveedor() != null) {
                    pax.get().setNameProveedor(prove.getNameProveedor());
                }
                if (prove.getDireccion() != null) {
                    pax.get().setDireccion(prove.getDireccion());
                }
                if (prove.getTelefono() != null) {
                    pax.get().setTelefono(prove.getTelefono());
                }

                return proveedorLogic.save(pax.get());
            }
        }
        return prove;
    }

    public boolean delete(Long id) {
        Optional<Proveedor> pau = getId(id);
        if (!pau.isEmpty()) {
            proveedorLogic.delete(pau.get());
            return true;
        }
        return false;
    }
}
