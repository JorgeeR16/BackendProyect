package co.jers.base.backendproyect.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.jers.base.backendproyect.Model.Imagen;
import co.jers.base.backendproyect.Service.ImagenService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/imagen")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Imagen> getAll() {
        return imagenService.getAll();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Imagen> getId(@RequestBody Imagen ima) {
        return imagenService.getId(ima);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Imagen save(@RequestBody Imagen ima) {
        return imagenService.save(ima);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Imagen update(@RequestBody Imagen ima){
        return imagenService.update(ima);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@RequestBody Imagen ima){
        return imagenService.delete(ima);
    }
    
}
