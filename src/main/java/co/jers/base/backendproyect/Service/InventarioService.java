package co.jers.base.backendproyect.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jers.base.backendproyect.Model.Inventario;
import co.jers.base.backendproyect.Repository.InventarioRepository;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getAll() {
        return inventarioRepository.getall();
    }

    public Optional<Inventario> getId(Inventario id) {
        return inventarioRepository.getId(id.getIdInventario());
    }

    public Inventario save(Inventario inv) {
        if (inv.getIdInventario() == null) {
            return inventarioRepository.save(inv);
        } else {
            Optional<Inventario> invpro = inventarioRepository.getId(inv.getIdInventario());
            if (invpro.isEmpty()) {
                return inventarioRepository.save(inv);
            }
        }
        return inv;
    }

    public Inventario update(Inventario inv) {
        if (inv.getIdInventario() != null) {
            Optional<Inventario> invpro = inventarioRepository.getId(inv.getIdInventario());
            if (!invpro.isEmpty()) {
                if (inv.getCantidadProducto() != null) {
                    invpro.get().setCantidadProducto(inv.getCantidadProducto());
                }
                if (inv.getTalla() != null) {
                    invpro.get().setTalla(inv.getTalla());
                }
                return inventarioRepository.save(invpro.get());
            }
        }
        return inv;
    }

    
    public boolean delete(Inventario id) {
        Optional<Inventario> pau = getId(id);
        if (!pau.isEmpty()) {
            inventarioRepository.delete(pau.get());
            return true;
        }
        return false;
    }

}
