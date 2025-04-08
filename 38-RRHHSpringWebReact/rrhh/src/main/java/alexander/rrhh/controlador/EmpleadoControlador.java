package alexander.rrhh.controlador;

import alexander.rrhh.modelo.Empleado;
import alexander.rrhh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
