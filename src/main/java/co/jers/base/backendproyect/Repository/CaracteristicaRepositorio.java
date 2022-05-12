package co.jers.base.backendproyect.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.jers.base.backendproyect.Interface.CateristicaInterface;
import co.jers.base.backendproyect.Model.Caracteristica;


@Repository
public class CaracteristicaRepositorio {

    @Autowired
    private CateristicaInterface caracteristicaCRUD;

    public List<Caracteristica> getAll() {
        return (List<Caracteristica>) caracteristicaCRUD.findAll();
    }

    public Optional<Caracteristica> getId(Long id) {
        return caracteristicaCRUD.findById(id);
    }

    public Caracteristica save(Caracteristica cat) {
        return caracteristicaCRUD.save(cat);
    }

    public void delete(Caracteristica cat){
        caracteristicaCRUD.delete(cat);
    }

}
