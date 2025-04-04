package alexander.contactos.servicio;

import alexander.contactos.modelo.Contacto;

import java.util.List;

public interface IContactoServicio {
    public List<Contacto> listarContactos();

    public Contacto BuscarContactoPorId(Integer idContacto);

    public void guardarContacto(Contacto contacto);

    public void eliminarContacto(Contacto contacto);
}
