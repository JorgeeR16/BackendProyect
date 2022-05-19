package co.jers.base.backendproyect.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jers.base.backendproyect.Model.Caracteristica;

import co.jers.base.backendproyect.Repository.CaracteristicaRepositorio;


@Service
public class CaracterisitcasService {

    @Autowired
    private CaracteristicaRepositorio caracteristicaService;

    public List<Caracteristica> getAll() {
        return caracteristicaService.getAll();
    }

    public Optional<Caracteristica> getId(Long id) {
        return caracteristicaService.getId(id);
    }

    public Caracteristica save(Caracteristica cat) {
        if (cat.getIdCaracterisitica() == null) {
            return caracteristicaService.save(cat);
        } else {
            Optional<Caracteristica> pca = caracteristicaService.getId(cat.getIdCaracterisitica());
            if (pca.isEmpty()) {
                return caracteristicaService.save(cat);
            }
        }
        return cat;
    }

    public Caracteristica update(Caracteristica cat) {

        if (cat.getIdCaracterisitica() != null) {

            Optional<Caracteristica> pca = caracteristicaService.getId(cat.getIdCaracterisitica());
            if (!pca.isEmpty()) {
                if (pca.get().getColor() != null) {
                    pca.get().setColor(cat.getColor());
                }
                if (pca.get().getEstilo() != null) {
                    pca.get().setEstilo(cat.getEstilo());
                }
                if (pca.get().getMaterial() != null) {
                    pca.get().setMaterial(cat.getMaterial());
                }
                if (pca.get().getGenero() != null) {
                    pca.get().setGenero(cat.getGenero());
                }
                if (pca.get().getPrecio() != null) {
                    pca.get().setPrecio(cat.getPrecio());
                }
                return caracteristicaService.save(pca.get());
            }
        }
        return cat;
    }

    public boolean delete(Long id) {
        Optional<Caracteristica> pax = getId(id);
        if (!pax.isEmpty()) {
            caracteristicaService.delete(pax.get());
            return true;
        }
        return false;
    }

}
