package alexander.tareas.servicio;

import alexander.tareas.modelo.Tarea;

import java.util.List;

public interface ITareaServicio {
    public List<Tarea> listarTareas();

    public Tarea buscarTareaPorId(Integer idTarea);

    public void guardarTarea(Tarea tarea);

    public void eliminarTarea(Tarea tarea);
}
