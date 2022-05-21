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

    public Optional<Caracteristica> getId(Caracteristica cat) {
        return caracteristicaService.getId(cat.getIdCaracterisitica());
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
                if (cat.getColor() != null) {
                    pca.get().setColor(cat.getColor());
                }
                if (cat.getEstilo() != null) {
                    pca.get().setEstilo(cat.getEstilo());
                }
                if (cat.getMaterial() != null) {
                    pca.get().setMaterial(cat.getMaterial());
                }
                if (cat.getGenero() != null) {
                    pca.get().setGenero(cat.getGenero());
                }
                if (cat.getPrecio() != null) {
                    pca.get().setPrecio(cat.getPrecio());
                }
                if (cat.getProveedor() != null) {
                    pca.get().setProveedor(cat.getProveedor());
                }
                if (cat.getProducto() != null) {
                    pca.get().setProducto(cat.getProducto());
                }
                return caracteristicaService.save(pca.get());
            }
        }
        return cat;
    }

    public boolean delete(Caracteristica cat) {
        Optional<Caracteristica> pax = getId(cat);
        if (!pax.isEmpty()) {
            caracteristicaService.delete(pax.get());
            return true;
        }
        return false;
    }

}
