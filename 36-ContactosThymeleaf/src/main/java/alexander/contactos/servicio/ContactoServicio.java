package alexander.contactos.servicio;

import alexander.contactos.modelo.Contacto;
import alexander.contactos.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServicio implements IContactoServicio{

    private final ContactoRepositorio contactoRepositorio;

    @Autowired
    public ContactoServicio(ContactoRepositorio contactoRepositorio){
        this.contactoRepositorio = contactoRepositorio;
    }

    @Override
    public List<Contacto> listarContactos() {
        return contactoRepositorio.findAll();
    }

    @Override
    public Contacto BuscarContactoPorId(Integer idContacto) {
        Contacto contacto = contactoRepositorio.findById(idContacto).orElse(null);
        return contacto;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        contactoRepositorio.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        contactoRepositorio.delete(contacto);
    }
}
