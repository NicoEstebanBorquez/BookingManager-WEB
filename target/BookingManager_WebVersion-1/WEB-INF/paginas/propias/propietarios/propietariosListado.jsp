<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Listado de Propietarios</title>
    </head>
    <body>
        <!-- Barra de Navegación -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacion.jsp"></jsp:include>
         
        <!-- Barra de Navegación Propietarios -->
        <jsp:include page="/WEB-INF/paginas/comunes/barraNavegacionPropietarios.jsp"></jsp:include>


        <div class="container">
            <h3>Listado de propietarios</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>Ref.</th>
                        <th>Nombre</th>
                        <th>Contacto</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="lista" items="${listadoPropietarios}">
                        <tr>
                            <td>${lista.idPropietario}</td> 
                            <td>${lista.nombre} ${lista.apellidos}</td>
                            <td>${lista.telefono}  -  ${lista.email}</td>
                            <td>
                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ControladorPropietarios?accion=Info&id=${lista.idPropietario}">Ver más</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>


