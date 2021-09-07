<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Info del propietario</title>
    </head>
    <body>
        <!-- Barra de Navegaci�n -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacion.jsp"></jsp:include>

            <!-- Barra de Navegaci�n Propietarios -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacionPropietarios.jsp"></jsp:include>

            <!-- CONTAINER-->
            <div class="container col-8">
                <h3>Info del propietario</h3>

                <!-- FORMULARIO -->
                <form>

                    <!-- 1� FILA -->
                    <div class="row">
                        <div class="col">
                            <label class="form-label fw-bold">Nombre:</label>
                            <label class="form-label">${propietarioSeleccionado.nombre}</label>
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold">Apellidos:</label>
                        <label class="form-label">${propietarioSeleccionado.apellidos}</label>
                    </div>
                </div>

                <!-- 2� FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">DNI:</label>
                        <label class="form-label">${propietarioSeleccionado.dni}</label>
                    </div>
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold">Pasaporte:</label>
                            <label class="form-label">${propietarioSeleccionado.pasaporte}</label>
                        </div>
                    </div>                      
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold">Nacionalidad:</label>
                            <label class="form-label">${propietarioSeleccionado.nacionalidad}</label>
                        </div>
                    </div>
                </div>

                <!-- 3� FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Tel�fono:</label>
                        <label class="form-label">${propietarioSeleccionado.telefono}</label>
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold">Email:</label>
                        <label class="form-label">${propietarioSeleccionado.email}</label>
                    </div>
                </div>

                <!-- 4� FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Domicilio:</label>
                        <label class="form-label">${propietarioSeleccionado.domicilio}</label>
                    </div>
                </div>

                <!-- 5� FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Usuario:</label>
                        <label class="form-label">${usuarioSeleccionado.nombre} ${usuarioSeleccionado.apellidos} - ${usuarioSeleccionado.email}</label>
                    </div>
                </div>
                    
                <!-- BOTONES -->
                <div>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/ControladorPropietarios?accion=Editar&id=${propietarioSeleccionado.idPropietario}">Editar</a>
                    <a class="btn btn-danger"  href="${pageContext.request.contextPath}/ControladorPropietarios?accion=Eliminar&id=${propietarioSeleccionado.idPropietario}">Eliminar</a>   
                </div>

            </form>
                <br>
                <br>
                <br>
            <!-- FIN FORMULARIO -->


            <!-- PROPIEDADES  -->

            <h4>Alojamientos del propietario:</h4>

            <div class="container">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Ref.</th>
                            <th>Nombre</th>
                            <th>Plazas</th>
                            <th>Dormitorios</th>
                            <th>Direcci�n</th>
                            <th>Poblaci�n</th>
                            <th>Provincia</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="propiedad" items="${alojamientosPropietario}">
                            <tr>
                                <td>${propiedad.idAlojamiento}</td> 
                                <td>${propiedad.nombre}</td>
                                <td>${propiedad.plazas}</td>
                                <td>${propiedad.dormitorios}</td>
                                <td>${propiedad.direccion}</td>
                                <td>${propiedad.poblacion}</td>
                                <td>${propiedad.provincia}</td>  
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>


            <!-- FIN CONTAINER-->
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>


