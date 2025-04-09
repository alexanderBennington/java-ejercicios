package alexander.rrhh.servicio;

import alexander.rrhh.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    List<Empleado> listarEmpleados();

    Empleado buscarEmpleadosPorId(Integer idEmpleado);

    Empleado agregarEmpleado(Empleado empleado);

    void eliminarEmpleadoPorId(Integer idEmpleado);
}
