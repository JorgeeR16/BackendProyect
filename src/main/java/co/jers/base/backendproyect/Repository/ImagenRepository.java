package co.jers.base.backendproyect.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.jers.base.backendproyect.Interface.ImagenInterface;
import co.jers.base.backendproyect.Model.Imagen;

@Repository
public class ImagenRepository {
    @Autowired
    private ImagenInterface imagenCRUD;

    public List<Imagen> getall(){
        return (List<Imagen>)imagenCRUD.findAll();
    }

    public Optional<Imagen> getId(Long id){
        return imagenCRUD.findById(id);
    }

    public Imagen save(Imagen inv){
        return imagenCRUD.save(inv);
    }

    public void delete(Imagen id){
        imagenCRUD.delete(id);
    }
}
