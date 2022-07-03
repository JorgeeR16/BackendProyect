package co.jers.base.backendproyect.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    String link = "localhost";
    //String link = "129.146.191.95";
    String url = "https://jestorers.herokuapp.com";
    //String url = "http://"+url+":8080";
    @GetMapping({ "/", "/hola" })
    public String bootstrap() {
        return "<!doctype html>" +
                "<html lang='en'>" +
                "  <head>" +
                "   <!-- Required meta tags -->" +
                "  <meta charset='utf-8'>" +
                " <meta name='viewport' content='width=device-width, initial-scale=1'>" +
                "    <!-- Bootstrap CSS -->" +
                "   <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"
                +
                "    <title>Hello, world!</title>" +
                " </head>" +
                "<body>" +
                " <h1>Hello, world!</h1>" +
                "<a class='btn btn-primary' href="+url+"/api/proveedor/all'>Prove</a>" +
                "<a class='btn btn-primary' href="+url+"/api/producto/all'>Produ</a>" +
                "<a class='btn btn-primary' href="+url+"/api/inventario/all'>Inven</a>" +
                "<a class='btn btn-primary' href="+url+"/api/imagen/all'>Imag</a>" +
                "<a class='btn btn-primary' href="+url+"/api/caracteristica/all'>Caracteri</a>"
                +

                "    <!-- Optional JavaScript; choose one of the two! -->" +
                "    <!-- Option 1: Bootstrap Bundle with Popper -->" +
                "   <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg'+OMhuP'+IlRH9sENBO0LRn5q'+8nbTov4'+1p' crossorigin='anonymous'></script>"
                +
                "    <!-- Option 2: Separate Popper and Bootstrap JS -->" +
                "  <!--" +
                " <script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js' integrity='sha384-7'+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB' crossorigin='anonymous'></script>"
                +
                " <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js' integrity='sha384-QJHtvGhmr9XOIpI6YVutG'+2QOK9T'+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13' crossorigin='anonymous'></script>"
                +
                "-->" +
                "</body>" +
                "</html>";
    }
}
