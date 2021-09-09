<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Info del cliente</title>
    </head>
    <body>
        <!-- Barra de Navegación -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacion.jsp"></jsp:include>

            <!-- Barra de Navegación Clientes -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacionClientes.jsp"></jsp:include>

            <!-- CONTAINER-->
            <div class="container col-8">
                <h3>Info del cliente</h3>

                <!-- FORMULARIO -->
                <form>

                    <!-- 1º FILA -->
                    <div class="row">
                        <div class="col">
                            <label class="form-label fw-bold">Nombre:</label>
                            <label class="form-label">${infoClienteSeleccionado.nombre}</label>
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold">Apellidos:</label>
                        <label class="form-label">${infoClienteSeleccionado.apellidos}</label>
                    </div>
                </div>

                <!-- 2º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">DNI:</label>
                        <label class="form-label">${infoClienteSeleccionado.dni}</label>
                    </div>
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold">Pasaporte:</label>
                            <label class="form-label">${infoClienteSeleccionado.pasaporte}</label>
                        </div>
                    </div>                      
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold">Nacionalidad:</label>
                            <label class="form-label">${infoClienteSeleccionado.nacionalidad}</label>
                        </div>
                    </div>
                </div>

                <!-- 3º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Teléfono:</label>
                        <label class="form-label">${infoClienteSeleccionado.telefono}</label>
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold">Email:</label>
                        <label class="form-label">${infoClienteSeleccionado.email}</label>
                    </div>
                </div>

                <!-- 4º FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Usuario:</label>
                        <label class="form-label">${usuarioSeleccionado.nombre} ${usuarioSeleccionado.apellidos} - ${usuarioSeleccionado.email}</label>
                    </div>
                </div>
                    
                <!-- BOTONES -->
                <div>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/ControladorClientes?accion=Editar&id=${infoClienteSeleccionado.idCliente}">Editar</a>
                    <a class="btn btn-danger"  href="${pageContext.request.contextPath}/ControladorClientes?accion=Eliminar&id=${infoClienteSeleccionado.idCliente}">Eliminar</a>   
                </div>

            </form>
                <br>
                <br>
                <br>
            <!-- FIN FORMULARIO -->


            <!-- PROPIEDADES  -->

            <h4>Reservas del cliente:</h4>

            <!-- FIN CONTAINER-->
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>


