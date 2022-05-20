package co.jers.base.backendproyect.Interface;

import org.springframework.data.repository.CrudRepository;

import co.jers.base.backendproyect.Model.Inventario;

public interface InventarioInterface extends CrudRepository<Inventario, Long> {
    
}
