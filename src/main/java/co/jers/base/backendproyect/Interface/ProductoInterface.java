package co.jers.base.backendproyect.Interface;

import org.springframework.data.repository.CrudRepository;

import co.jers.base.backendproyect.Model.Producto;

public interface ProductoInterface extends CrudRepository<Producto, Long>{
        
}
