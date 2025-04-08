package alexander.rrhh.servicio;

import alexander.rrhh.excepciones.EmpleadoNoEncontradoException;
import alexander.rrhh.modelo.Empleado;
import alexander.rrhh.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    public final EmpleadoRepositorio empleadoRepositorio;

    @Autowired
    public EmpleadoServicio(EmpleadoRepositorio empleadoRepositorio){
        this.empleadoRepositorio = empleadoRepositorio;
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadosPorId(Integer idEmpleado) {
        return empleadoRepositorio.findById(idEmpleado)
                .orElseThrow(() -> new EmpleadoNoEncontradoException(idEmpleado));
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleadoPorId(Integer idEmpleado) {
        if (!empleadoRepositorio.existsById(idEmpleado)) {
            throw new EmpleadoNoEncontradoException(idEmpleado);  // Puedes lanzar la misma excepción
        }
        empleadoRepositorio.deleteById(idEmpleado);
    }
}
