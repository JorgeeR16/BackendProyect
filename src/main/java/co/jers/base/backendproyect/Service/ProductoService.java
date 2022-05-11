package co.jers.base.backendproyect.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.jers.base.backendproyect.Model.Producto;
import co.jers.base.backendproyect.Repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoService;

    public List<Producto> getAll() {
        return productoService.getAll();
    }

    public Optional<Producto> getId(Long id) {
        return productoService.getId(id);
    }

    public Producto save(Producto prod) {
        if (prod.getIdProducto() == null) {
            return productoService.save(prod);

        } else {
            Optional<Producto> pro = productoService.getId(prod.getIdProducto());
            if (pro.isEmpty()) {
                return productoService.save(prod);
            }
        }
        return prod;
    }

    public Producto update(Producto prod) {
        if (prod.getIdProducto() != null) {
            Optional<Producto> pro = productoService.getId(prod.getIdProducto());
            if (pro.get().getNombreProducto() != null) {
                pro.get().setNombreProducto(prod.getNombreProducto());
            }
            return productoService.save(pro.get());
        }
        return prod;
    }

    public boolean delete(Long id) {
        Optional<Producto> pro = getId(id);
        if (!pro.isEmpty()) {
            productoService.delete(pro.get());
            return true;
        }
        return false;
    }

}
