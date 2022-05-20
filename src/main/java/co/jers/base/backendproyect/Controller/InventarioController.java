package co.jers.base.backendproyect.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.jers.base.backendproyect.Model.Inventario;
import co.jers.base.backendproyect.Service.InventarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/inventario")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventario> getAll() {
        return inventarioService.getAll();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Inventario> getId(@RequestBody Inventario cat) {
        return inventarioService.getId(cat);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventario save(@RequestBody Inventario cat) {
        return inventarioService.save(cat);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventario update(@RequestBody Inventario cat){
        return inventarioService.update(cat);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@RequestBody Inventario cat){
        return inventarioService.delete(cat);
    }
}
