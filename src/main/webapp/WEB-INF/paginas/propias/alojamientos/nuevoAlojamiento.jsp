<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Nuevo alojamiento</title>
    </head>
    <body>
        <!-- Barra de Navegación -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacion.jsp"></jsp:include>

            <!-- Barra de Navegación Alojamientos -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacionAlojamientos.jsp"></jsp:include>


            <!-- CONTAINER-->
            <div class="container col-8">
                <h3>Nuevo alojamiento</h3>

                <!-- FORMULARIO -->
                <form action="${pageContext.request.contextPath}/ControladorAlojamientos?accion=InsertarAlojamiento" method="POST">


                <!-- 1º FILA -->
                <div class="row">
                    <label class="form-label" for="inputNombre">Nombre del alojamiento</label>
                    <input class="form-control" type="text" name="inputNombre">
                </div>


                <!-- 2º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label" for="inputPlazas">Plazas</label>
                        <select class="form-control" name="inputPlazas">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>
                    </div>

                    <div class="col">
                        <div>
                            <label class="form-label" for="inputDormitorios">Dormitorios</label>
                            <select class="form-control" name="inputDormitorios">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                        </div>
                    </div>

                    <div class="col">
                        <div>
                            <label class="form-label" for="inputBanos">Baños</label>
                            <select class="form-control" name="inputBanos">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                    </div>
                </div>


                <!-- 3º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label" for="inputTerraza">Terraza</label>
                        <select class="form-control" name="inputTerraza">
                            <option value="NO">No</option>
                            <option value="SI">Si</option>
                        </select>
                    </div>
                    <div class="col">
                        <label class="form-label" for="inputPiscina">Piscina</label>
                        <select class="form-control" name="inputPiscina">
                            <option value="NO">No</option>
                            <option value="SI">Si</option>
                        </select>
                    </div>
                    <div class="col">
                        <label class="form-label" for="inputAparcamiento">Aparcamiento</label>
                        <select class="form-control" name="inputAparcamiento">
                            <option value="NO">No</option>
                            <option value="SI">Si</option>
                        </select>
                    </div>
                </div>

                <!-- 4º FILA -->
                <div class="row">
                    <label class="form-label" for="inputDireccion">Direccion</label>
                    <input class="form-control" type="text" name="inputDireccion">
                </div>


                <!-- 5º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label" for="inputPoblacion">Poblacion</label>
                        <input class="form-control" type="text" name="inputPoblacion">
                    </div>
                    <div class="col">
                        <label class="form-label" for="inputProvincia">Provincia</label>
                        <input class="form-control" type="text" name="inputProvincia">
                    </div>
                </div>

                <!-- 6º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label" for="inputPropietario">Propietario</label>
                        <select name="inputPropietario" class="form-control">
                            <option value="0">Seleccionar:</option>
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
                        
                <!-- 7º FILA -->
                <div class="row">
                    <label class="form-label" for="input">Agregar nuevo Propietario:</label>
                    <a class="btn btn-warning col-1" href="#">+</a>
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
