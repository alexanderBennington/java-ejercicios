<%-- 
    Document   : agregarCliente
    Created on : 13 abr 2025, 22:56:35
    Author     : keval
--%>
<div class="modal fade" id="agregarClienteModal" tabindex="-1" aria-labelledby="agregarClienteLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="agregarClienteLabel">Agregar Cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="telefono" class="form-label">Teléfono</label>
                        <input type="tel" pattern="[0-9]{10}" title="Ingresa un número de 10 dígitos" class="form-control" id="telefono" name="telefono" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="saldo" class="form-label">Saldo</label>
                        <input type="number" step="any" min="0" class="form-control" id="saldo" name="saldo" required/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>                    
                    <button type="submit" class="btn btn-primary">Agregar</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    document.getElementById('saldo').addEventListener('input', function (e) {
        const valor = e.target.value;
        if (valor < 0) {
            e.target.value = 0;
        }
    });
    document.getElementById('saldo').addEventListener('keydown', function (e) {
        if (e.key === '-' || e.key === 'e') {
            e.preventDefault();
        }
    });
</script>