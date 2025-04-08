package alexander.rrhh.excepciones;

public class EmpleadoNoEncontradoException extends RuntimeException{
    public EmpleadoNoEncontradoException(Integer idEmpleado){
        super("Empleado NO encontrado con ID: " + idEmpleado);
    }
}
