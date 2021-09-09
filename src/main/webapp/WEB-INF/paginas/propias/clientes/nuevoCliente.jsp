<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Nuevo Cliente</title>
    </head>
    <body>
        <!-- Barra de Navegación -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacion.jsp"></jsp:include>

            <!-- Barra de Navegación Clientes -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacionClientes.jsp"></jsp:include>


            <!-- CONTAINER-->
            <div class="container col-8">
                <h3>Nuevo cliente</h3>

                <!-- FORMULARIO -->
                <form action="${pageContext.request.contextPath}/ControladorClientes?accion=InsertarCliente" method="POST">

                <!-- 1º FILA -->
                <div class="row">
                    <div class="col"> 
                        <label class="form-label" for="inputNombre">Nombre</label>
                        <input class="form-control" type="text" name="inputNombre">
                    </div>
                    <div class="col">
                        <label class="form-label" for="inputApellidos">Apellidos</label>
                        <input class="form-control" type="text" name="inputApellidos">
                    </div>
                </div>


                <!-- 2º FILA -->
                <div class="row">
                    <div class="col"> 
                        <label class="form-label" for="inputDni">DNI</label>
                        <input class="form-control" type="text" name="inputDni">
                    </div>
                    <div class="col">
                        <label class="form-label" for="inputPasaporte">Pasaporte</label>
                        <input class="form-control" type="text" name="inputPasaporte">
                    </div>
                    <div class="col"> 
                        <label class="form-label" for="inputNacionalidad">Nacionalidad</label>
                        <input class="form-control" type="text" name="inputNacionalidad">
                    </div>
                </div>


                <!-- 3º FILA -->
                <div class="row">
                    <div class="col"> 
                        <label class="form-label" for="inputTelefono">Teléfono</label>
                        <input class="form-control" type="text" name="inputTelefono">
                    </div>
                    <div class="col">
                        <label class="form-label" for="inputEmail">Email</label>
                        <input class="form-control" type="email" name="inputEmail">
                    </div>
                </div>

                <!-- 4º FILA -->
                <div class="col">
                    <label class="form-label" for="inputUsuario">Usuario</label>
                    <select name="inputUsuario" class="form-control">
                        <option value="${usuarioValidado.getIdUsuario()}">${usuarioValidado.getNombre()} ${usuarioValidado.getApellidos()} - ${usuarioValidado.getEmail()}</option> 
                    </select>
                </div>


                <!-- BOTON -->
                <div class="row">
                    <input class="btn btn-secondary" type="submit" value="Guardar">
                </div>


                <!-- FIN FORMULARIO -->
            </form>

            <!-- FIN CONTAINER-->
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
