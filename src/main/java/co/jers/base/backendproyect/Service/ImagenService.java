package co.jers.base.backendproyect.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jers.base.backendproyect.Model.Imagen;
import co.jers.base.backendproyect.Repository.ImagenRepository;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> getAll() {
        return imagenRepository.getall();
    }

    public Optional<Imagen> getId(Imagen id) {
        return imagenRepository.getId(id.getIdImagen());
    }

    public Imagen save(Imagen inv) {
        if (inv.getIdImagen() == null) {
            return imagenRepository.save(inv);
        } else {
            Optional<Imagen> invpro = imagenRepository.getId(inv.getIdImagen());
            if (invpro.isEmpty()) {
                return imagenRepository.save(inv);
            }
        }
        return inv;
    }

    public Imagen update(Imagen inv) {
        if (inv.getIdImagen() != null) {
            Optional<Imagen> invpro = imagenRepository.getId(inv.getIdImagen());
            if (!invpro.isEmpty()) {
                if (inv.getImagen() != null) {
                    invpro.get().setImagen(inv.getImagen());
                }
                if (inv.getCaracteristica() != null) {
                    invpro.get().setCaracteristica(inv.getCaracteristica());
                }
                return imagenRepository.save(invpro.get());
            }
        }
        return inv;
    }

    public boolean delete(Imagen id) {
        Optional<Imagen> pau = getId(id);
        if (!pau.isEmpty()) {
            imagenRepository.delete(pau.get());
            return true;
        }
        return false;
    }
}
