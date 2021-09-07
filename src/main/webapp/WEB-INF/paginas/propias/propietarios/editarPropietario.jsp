<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Editar propietarios</title>
    </head>
    <body>
        <!-- Barra de Navegación -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacion.jsp"></jsp:include>

            <!-- Barra de Navegación Propietarios -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacionPropietarios.jsp"></jsp:include>

            <!-- CONTAINER-->
            <div class="container col-8">
                <h3>Editar propietario</h3>

                <!-- FORMULARIO -->
                <form  action="${pageContext.request.contextPath}/ControladorPropietarios?id=${propietarioSeleccionado.idPropietario}" method="POST">
            

                <!-- 1º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold" for="inputNombre">Nombre:</label>
                        <input class="form-control" type="text" name="inputNombre" value="${propietarioSeleccionado.nombre}">
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold" for="inputApellidos">Apellidos:</label>
                        <input class="form-control" type="text" name="inputApellidos" value="${propietarioSeleccionado.apellidos}">
                    </div> 
                </div>


                <!-- 2º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold" for="inputDni">DNI:</label>
                        <input class="form-control" type="text" name="inputDni" value="${propietarioSeleccionado.dni}">
                    </div>
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold" for="inputPasaporte">Pasaporte:</label>
                            <input class="form-control" type="text" name="inputPasaporte" value="${propietarioSeleccionado.pasaporte}">
                        </div>
                    </div>
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold" for="inputNacionalidad">Nacionalidad:</label>
                            <input class="form-control" type="text" name="inputNacionalidad" value="${propietarioSeleccionado.nacionalidad}">
                        </div>
                    </div>
                </div>

                <!-- 3º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold" for="inputTelefono">Teléfono:</label>
                        <input class="form-control" type="text" name="inputTelefono" value="${propietarioSeleccionado.telefono}">
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold" for="inputEmail">Email:</label>
                        <input class="form-control" type="text" name="inputEmail" value="${propietarioSeleccionado.email}">
                    </div>
                </div>

                <!-- 4º FILA -->
                <div class="row">
                    <label class="form-label fw-bold" for="inputDomicilio">Domicilio:</label>
                    <input class="form-control" type="text" name="inputDomicilio" value="${propietarioSeleccionado.domicilio}">
                </div>


                <!-- BOTONES -->
                <div class="row">
                    <input type="submit" name="accion" value="Guardar" class="btn btn-success">
                    <input type="submit" name="accion" value="Cancelar" class="btn btn-warning">
                </div>

                <!-- FIN FORMULARIO -->
            </form>

            <!-- FIN CONTAINER-->
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
