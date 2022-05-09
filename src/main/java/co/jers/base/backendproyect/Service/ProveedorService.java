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

    public Optional<Proveedor> getId(Long id){
        return proveedorLogic.getProveedorId(id);
    }

    /*si me llega un proveedor la vamos a guardar
    pero si llega sin id es que no esta   y procedeemos a guardarlo
    pero si llega con id se debe validar si este ya existe      
    */
    public Proveedor save(Proveedor prove) {
        if (prove.getIdProveedor() == null) {//si no tiene es id nuevo
            return proveedorLogic.save(prove);
            
        } else {
            Optional<Proveedor> paux = proveedorLogic.getProveedorId(prove.getIdProveedor());//aqui validamos si el id existe 
            if (paux.isEmpty()) {
                return proveedorLogic.save(prove);                
            }return prove;
        }
    }
}
