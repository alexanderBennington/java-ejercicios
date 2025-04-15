<%-- 
    Document   : botonesNavegacionEdicion
    Created on : 14 abr 2025, 13:59:21
    Author     : keval
--%>

<section id="accionesEditar" class="py-4 mb-4">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/" class="btn btn-secondary btn-block w-100">
                    <i class="bi bi-arrow-left"></i> Regresar al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block w-100">
                    <i class="bi bi-check-lg"></i>Guardar cliente
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}" class="btn btn-danger btn-block w-100">
                    <i class="bi bi-trash"></i> Eliminar cliente
                </a>
            </div>
        </div>
    </div>
</section>