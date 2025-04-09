package alexander.rrhh.controlador;

import alexander.rrhh.modelo.Empleado;
import alexander.rrhh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"}) // React y Vite
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private IEmpleadoServicio empleadoServicio;

    /*@GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach(empleado -> logger.info(empleados.toString()));
        return empleados;
    }*/
    @GetMapping("/empleados")
    public ResponseEntity<Map<String, Object>> obtenerEmpleados() {
        try {
            List<Empleado> empleados = empleadoServicio.listarEmpleados();

            logger.info("Se encontraron {} empleados", empleados.size());
            logger.info(empleados.toString());


            Map<String, Object> response = new HashMap<>();
            response.put("empleados", empleados);
            response.put("total", empleados.size());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error al obtener la lista de empleados", e);
            return ResponseEntity.status(500).body(Map.of("mensaje", "Error al obtener empleados"));
        }
    }

    @PostMapping("/empleados")
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a agregar: {}", empleado);
        Empleado nuevoEmpleado = empleadoServicio.agregarEmpleado(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEmpleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable int id){
        Empleado empleado = empleadoServicio.buscarEmpleadosPorId(id);
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable int id, @RequestBody Empleado empleadoRecibido){
        Empleado empleado = empleadoServicio.buscarEmpleadosPorId(id);
        empleado.setNombre(empleadoRecibido.getNombre());
        empleado.setDepartamento(empleadoRecibido.getDepartamento());
        empleado.setSueldo(empleadoRecibido.getSueldo());
        empleadoServicio.agregarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable int id){
        empleadoServicio.eliminarEmpleadoPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
