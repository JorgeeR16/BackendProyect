package co.jers.base.backendproyect.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import co.jers.base.backendproyect.Service.CaracterisitcasService;

import co.jers.base.backendproyect.Model.Caracteristica;

@RestController
@RequestMapping("/api/caracteristica")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class CaracteristicasController {
    @Autowired
    private CaracterisitcasService caracteristicasController;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Caracteristica> getAll() {
        return caracteristicasController.getAll();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Caracteristica> getId(@PathVariable("id") Long id) {
        return caracteristicasController.getId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Caracteristica save(@RequestBody Caracteristica cat) {
        return caracteristicasController.save(cat);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Caracteristica update(@RequestBody Caracteristica cat){
        return caracteristicasController.update(cat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Long id){
        return caracteristicasController.delete(id);
    }

}
