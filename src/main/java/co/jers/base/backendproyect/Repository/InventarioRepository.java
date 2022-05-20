package co.jers.base.backendproyect.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.jers.base.backendproyect.Interface.InventarioInterface;
import co.jers.base.backendproyect.Model.Inventario;

@Repository
public class InventarioRepository {
    
    @Autowired
    private InventarioInterface inventarioCRUD;

    public List<Inventario> getall(){
        return (List<Inventario>)inventarioCRUD.findAll();
    }

    public Optional<Inventario> getId(Long id){
        return inventarioCRUD.findById(id);
    }

    public Inventario save(Inventario inv){
        return inventarioCRUD.save(inv);
    }

    public void delete(Inventario id){
        inventarioCRUD.delete(id);
    }
}
