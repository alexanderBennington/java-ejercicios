package alexander.rrhh.servicio;

import alexander.rrhh.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    List<Empleado> listarEmpleados();

    Empleado buscarEmpleadosPorId(Integer idEmpleado);

    void agregarEmpleado(Empleado empleado);

    void eliminarEmpleadoPorId(Integer idEmpleado);
}
