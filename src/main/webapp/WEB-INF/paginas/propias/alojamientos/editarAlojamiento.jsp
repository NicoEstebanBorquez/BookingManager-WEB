<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Editar alojamiento</title>
    </head>
    <body>
        <!-- Barra de Navegación -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacion.jsp"></jsp:include>

            <!-- Barra de Navegación Alojamientos -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacionAlojamientos.jsp"></jsp:include>

            <!-- CONTAINER-->
            <div class="container col-8">
                <h3>Editar alojamiento</h3>

                <!-- FORMULARIO -->
                <form  action="${pageContext.request.contextPath}/ControladorAlojamientos?id=${alojamientoSeleccionado.idAlojamiento}" method="POST">

                <!-- 1º FILA -->
                <div class="row">
                    <label class="form-label fw-bold" for="inputNombre">Nombre del alojamiento:</label>
                    <input class="form-control" type="text" name="inputNombre" value="${alojamientoSeleccionado.nombre}">
                </div>

                <!-- 2º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold" for="inputPlazas">Plazas:</label>
                        <input class="form-control" type="number" name="inputPlazas" value="${alojamientoSeleccionado.plazas}">
                    </div>
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold" for="inputDormitorios">Dormitorios:</label>
                            <input class="form-control" type="number" name="inputDormitorios" value="${alojamientoSeleccionado.dormitorios}">
                        </div>
                    </div>
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold" for="inputBanos">Baños:</label>
                            <input class="form-control" type="number" name="inputBanos" value="${alojamientoSeleccionado.banos}">
                        </div>
                    </div>
                </div>

                <!-- 3º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold" for="inputTerraza">Terraza:</label>
                        <input class="form-control" type="text" name="inputTerraza" value="${alojamientoSeleccionado.terraza}">
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold" for="inputPiscina">Piscina:</label>
                        <input class="form-control" type="text" name="inputPiscina" value="${alojamientoSeleccionado.piscina}">
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold" for="inputAparcamiento">Aparcamiento:</label>
                        <input class="form-control" type="text" name="inputAparcamiento" value="${alojamientoSeleccionado.aparcamiento}">
                    </div>
                </div>

                <!-- 4º FILA -->
                <div class="row">
                    <label class="form-label fw-bold" for="inputDireccion">Direccion:</label>
                    <input class="form-control" type="text" name="inputDireccion" value="${alojamientoSeleccionado.direccion}">
                </div>

                <!-- 5º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold" for="inputPoblacion">Poblacion:</label>
                        <input class="form-control" type="text" name="inputPoblacion" value="${alojamientoSeleccionado.poblacion}">
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold" for="inputProvincia">Provincia:</label>
                        <input class="form-control" type="text" name="inputProvincia" value="${alojamientoSeleccionado.provincia}">
                    </div>
                </div>

                <!-- 6º FILA -->

                <div class="row"><div class="row">
                        <label class="form-label" for="inputPropietario">Propietario</label>
                        <select name="inputPropietario" class="form-control">
                            <option value="${propietarioSeleccionado.idPropietario}" selected="selected">${propietarioSeleccionado.nombre} ${propietarioSeleccionado.apellidos}</option>
                            <c:forEach var="propietario" items="${listadoPropietarios}">
                                <option value="${propietario.idPropietario}">${propietario.nombre} ${propietario.apellidos}</option> 
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col">
                        <label class="form-label" for="inputUsuario">Usuario</label>
                        <select name="inputUsuario" class="form-control">
                            <option value="${usuarioValidado.getIdUsuario()}">${usuarioValidado.getNombre()} ${usuarioValidado.getApellidos()} - ${usuarioValidado.getEmail()}</option> 
                        </select>
                    </div>
                </div>

                <!-- BOTONES -->
                <div class="row">
                    <input type="submit" name="accion" value="Guardar" class="btn btn-success">
                    <input type="submit" name="accion" value="Cancelar" class="btn btn-warning">
                    <!--<a type="submit" class="btn btn-success" href="${pageContext.request.contextPath}/ControladorAlojamientos?accion=GuardarCambios&id=13">Guardar</a>--> <%-- ${alojamientoSeleccionado.idAlojamiento}--%>
                    <!--<a class="btn btn-warning" href="#">Cancelar</a>-->   
                </div>

                <!-- FIN FORMULARIO -->
            </form>

            <!-- FIN CONTAINER-->
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
