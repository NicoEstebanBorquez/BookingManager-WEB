<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Info del alojamiento</title>
    </head>
    <body>
        <!-- Barra de Navegaci?n -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacion.jsp"></jsp:include>

            <!-- Barra de Navegaci?n Alojamientos -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacionAlojamientos.jsp"></jsp:include>

            <!-- CONTAINER-->
            <div class="container col-8">
                <h3>Info del alojamiento</h3>

                <!-- FORMULARIO -->
                <form>

                    <!-- 1? FILA -->
                    <div class="row">
                        <div class="col">
                            <label class="form-label fw-bold">Nombre del alojamiento:</label>
                            <label class="form-label">${alojamientoSeleccionado.nombre}</label>
                    </div>

                    <!-- 2? FILA -->
                    <div class="row">
                        <div class="col">
                            <label class="form-label fw-bold">Plazas:</label>
                            <label class="form-label">${alojamientoSeleccionado.plazas}</label>
                        </div>
                    </div>
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold">Dormitorios:</label>
                            <label class="form-label">${alojamientoSeleccionado.dormitorios}</label>
                        </div>
                    </div>
                    <div class="col">
                        <div>
                            <label class="form-label fw-bold">Ba?os:</label>
                            <label class="form-label">${alojamientoSeleccionado.banos}</label>
                        </div>
                    </div>
                </div>

                <!-- 3? FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Terraza:</label>
                        <label class="form-label">${alojamientoSeleccionado.terraza}</label>
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold">Piscina:</label>
                        <label class="form-label">${alojamientoSeleccionado.piscina}</label>
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold">Aparcamiento:</label>
                        <label class="form-label">${alojamientoSeleccionado.aparcamiento}</label>
                    </div>
                </div>

                <!-- 4? FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Direccion:</label>
                        <label class="form-label">${alojamientoSeleccionado.direccion}</label>
                    </div>
                </div>

                <!-- 5? FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Poblacion:</label>
                        <label class="form-label">${alojamientoSeleccionado.poblacion}</label>
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold">Provincia:</label>
                        <label class="form-label">${alojamientoSeleccionado.provincia}</label>
                    </div>
                </div>

                <!-- 6? FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Usuario:</label>
                        <label class="form-label">${usuarioSeleccionado.nombre} ${usuarioSeleccionado.apellidos} - ${usuarioSeleccionado.email}</label>
                    </div>
                </div>

                <!-- BOTONES -->
                <div>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/ControladorAlojamientos?accion=Editar&id=${alojamientoSeleccionado.idAlojamiento}">Editar</a>
                    <a class="btn btn-danger"  href="${pageContext.request.contextPath}/ControladorAlojamientos?accion=Eliminar&id=${alojamientoSeleccionado.idAlojamiento}">Eliminar</a>   
                </div>
                <br>
                <br>
                <!-- FIN FORMULARIO -->

                <!-- DATOS PROPIETARIO -->
            </form>

            <h4>Datos de contacto del propietario:</h4>

            <!-- FORMULARIO -->
            <form>

                <!-- 1? FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Nombre:</label>
                        <label class="form-label">${propietarioSeleccionado.nombre} ${propietarioSeleccionado.apellidos}</label>
                    </div>
                </div>

                <!-- 2? FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">N? tel?fono:</label>
                        <label class="form-label">${propietarioSeleccionado.telefono}</label>
                    </div>
                    <div class="col">
                        <label class="form-label fw-bold">Email:</label>
                        <label class="form-label">${propietarioSeleccionado.email}</label>
                    </div>
                </div>

                <!-- 3? FILA -->
                <div class="row">
                    <div class="col">
                        <label class="form-label fw-bold">Domicilio:</label>
                        <label class="form-label">${propietarioSeleccionado.domicilio}</label>
                    </div>
                </div>
            </form>

            <!-- FIN CONTAINER-->
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
