package co.jers.base.backendproyect.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import co.jers.base.backendproyect.Service.ProductoService;
import org.springframework.http.HttpStatus;
import co.jers.base.backendproyect.Model.Producto;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ProductoController {

    @Autowired
    private ProductoService productoController;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getAll() {
        return productoController.getAll();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Producto> getId(@RequestBody Producto pro) {
        return productoController.getId(pro);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody Producto pro) {
        return productoController.save(pro);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto update(@RequestBody Producto pro) {
        return productoController.update(pro);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Producto pro) {
        productoController.delete(pro);
    }

}
