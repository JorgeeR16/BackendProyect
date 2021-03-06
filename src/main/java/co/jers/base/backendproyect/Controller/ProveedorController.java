package co.jers.base.backendproyect.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jers.base.backendproyect.Model.Proveedor;
import co.jers.base.backendproyect.Service.ProveedorService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/proveedor")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ProveedorController {

    @GetMapping("/holamundo")
    public String saludar() {
        return "Hola Mundo, si funciona";
    }

    @Autowired
    private ProveedorService proveedorControl;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Proveedor> getProveedor() {
        return proveedorControl.getAll();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Proveedor> getProveedorId(@RequestBody Proveedor prove) {
        return proveedorControl.getId(prove);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor save(@RequestBody Proveedor prove) {
        return proveedorControl.save(prove);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED) // cuando se hace una peticion el protocolo va a devolver un codigo "201"
    public Proveedor update(@RequestBody Proveedor prove) {
        return proveedorControl.update(prove);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@RequestBody Proveedor prove) {
        return proveedorControl.delete(prove);
    } 

}
