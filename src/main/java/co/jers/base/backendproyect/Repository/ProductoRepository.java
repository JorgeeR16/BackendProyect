package co.jers.base.backendproyect.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.jers.base.backendproyect.Interface.ProductoInterface;
import co.jers.base.backendproyect.Model.Producto;

@Repository
public class ProductoRepository {

    @Autowired
    private ProductoInterface productoCRUD;

    public List<Producto> getAll() {
        return (List<Producto>) productoCRUD.findAll();
    }

    public Optional<Producto> getId(Long id) {
        return productoCRUD.findById(id);
    }

    public Producto save(Producto prod) {
        return productoCRUD.save(prod);
    }

    public void delete(Producto id) {
        productoCRUD.delete(id);
    }

}
