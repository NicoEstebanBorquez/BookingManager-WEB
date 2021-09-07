<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/40f59e3244.js" crossorigin="anonymous"></script>

        <title>Registro - BookingManager</title>
    </head>


    <body>
        
        <section>
            <div class="container">
                <div class="row">
                    <div  class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h1>Registro</h1>
                            </div>
                            <div class="card-body">
                                <form action="${pageContext.request.contextPath}/ServletControlador?menu=nuevoRegistro&accion=nuevoRegistro" method="POST" class="was-validated">
                                    <div class="form-group">
                                        <label for="inputNombre">Nombre</label></br>
                                        <input type="text" class="form-control" name="inputNombre" required></br>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputApellidos">Apellidos</label></br>
                                        <input type="text" class="form-control" name="inputApellidos" required></br>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputEmail">Email</label></br>
                                        <input type="email" class="form-control" name="inputEmail" required></br>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputContrasena">Contraseña</label></br>
                                        <input type="password" class="form-control" name="inputContrasena" required></br>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputConfirmarContrasena">Confirmar Contraseña</label></br>
                                        <input type="password" class="form-control" name="inputConfirmarContrasena" required></br></br>
                                    </div>

                                    <button type="submit">Enviar</button>
                                </form>
                            </div>
                            <div class="card-footer">
                                <div>
                                    <p>¿Tienes una cuenta? <a href="www.google.es">Entrar</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <div class="container">
            <div class="row">
                <a href="index.jsp">Volver al Inicio</a>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>