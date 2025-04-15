<%-- 
    Document   : editarCliente
    Created on : 14 abr 2025, 14:10:35
    Author     : keval
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es" data-bs-theme="dark">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Editar Cliente</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}" method="POST" class="was-validated">
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>
            <div class="container my-4">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h4>Editar Cliente</h4>
                    </div>
                    <div class="card-body">
                        <div class="form-group mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required value="${cliente.nombre}"/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="apellido" class="form-label">Apellido</label>
                            <input type="text" class="form-control" id="apellido" name="apellido" required value="${cliente.apellido}"/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required value="${cliente.email}"/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="telefono" class="form-label">Teléfono</label>
                            <input type="tel" pattern="[0-9]{10}" title="Ingresa un número de 10 dígitos" class="form-control" id="telefono" name="telefono" required value="${cliente.telefono}"/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="saldo" class="form-label">Saldo</label>
                            <input type="number" step="any" min="0" class="form-control" id="saldo" name="saldo" required value="${cliente.saldo}"/>
                        </div>
                        <button type="submit" class="btn btn-success">Guardar Cambios</button>
                    </div>
                </div>
            </div>
        </form>

        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
        <script>
            document.getElementById('saldo').addEventListener('input', function (e) {
                const valor = e.target.value;
                if (value < = 0) {
                    e.target.value = 0;
                }
            });
            document.getElementById('saldo').addEventListener('keydown', function (e) {
                if (e.key === '-' || e.key === 'e') {
                    e.preventDefault();
                }
            });
        </script>
    </body>
</html>
