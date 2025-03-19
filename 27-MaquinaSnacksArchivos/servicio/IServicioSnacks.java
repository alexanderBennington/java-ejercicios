package servicio;

import java.util.List;

import dominio.Snack;

public interface IServicioSnacks {
    void agregarSnack(Snack snack);
    void mostrarSnacks();
    List<Snack> obtenerSnack();
}