package co.jers.base.backendproyect.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class pruebacontroller {

    @GetMapping("/hola")
    public String saludar(){
        return "<h1>hola mundo se realizo un cambio<p>Hola se agrega este parrafo para validar que este funcionando el merrge y el branch</p></h1>";
    }
}
