package web;


import dominio.UsuarioDAO;
import dominio.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu != null) {

            if (menu.equals("iniciarSesion")) {
                this.formularioIniciarSesion(request, response);

            } else if (menu.equals("registrarse")) {
                this.formularioNuevoRegistro(request, response);

            } else if (menu.equals("PanelControl")) {
                this.irPanelControl(request, response);

            } else if (menu.equals("Alojamientos")) {
                this.irAlojamientos(request, response);

            } else if (menu.equals("Clientes")) {
                this.irClientes(request, response);

            } else if (menu.equals("Reservas")) {
                this.irReservas(request, response);

            } else if (menu.equals("Tarifas")) {
                this.irTarifas(request, response);

            } else if (menu.equals("Propietarios")) {
                this.irPropietarios(request, response);

            } else if (menu.equals("Planning")) {
                this.irPlanning(request, response);

            } else {
                this.volverInicio(request, response);
            }
        } else {
            this.volverInicio(request, response);
        }

    }

    private void volverInicio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("bookingManager.jsp");
    }

    private void formularioIniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String jspIniciarSesion = "/WEB-INF/paginas/propias/iniciarSesion.jsp";
        request.getRequestDispatcher(jspIniciarSesion).forward(request, response);
    }

    private void formularioNuevoRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspNuevoRegistro = "/WEB-INF/paginas/propias/nuevoRegistro.jsp";
        request.getRequestDispatcher(jspNuevoRegistro).forward(request, response);
    }

    private void irPanelControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspPanelControl = "/WEB-INF/paginas/propias/panelControl.jsp";
        request.getRequestDispatcher(jspPanelControl).forward(request, response);
    }

    // ALOJAMIENTOS --------------------------------------------------------------------
    private void irAlojamientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspAlojamientos = "/WEB-INF/paginas/propias/alojamientos/alojamientos.jsp";
        request.getRequestDispatcher(jspAlojamientos).forward(request, response);
    }

    // CLIENTES --------------------------------------------------------------------
    private void irClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspClientes = "/WEB-INF/paginas/propias/clientes/clientes.jsp";
        request.getRequestDispatcher(jspClientes).forward(request, response);
    }

    // RESERVAS --------------------------------------------------------------------
    private void irReservas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspReservas = "/WEB-INF/paginas/propias/reservas.jsp";
        request.getRequestDispatcher(jspReservas).forward(request, response);
    }

    // TARIFAS --------------------------------------------------------------------
    private void irTarifas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspTarifas = "/WEB-INF/paginas/propias/tarifas.jsp";
        request.getRequestDispatcher(jspTarifas).forward(request, response);
    }

    // PROPIETARIOS --------------------------------------------------------------------
    private void irPropietarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspPropietarios = "/WEB-INF/paginas/propias/propietarios/propietarios.jsp";
        request.getRequestDispatcher(jspPropietarios).forward(request, response);
    }

    // PLANNING --------------------------------------------------------------------
    private void irPlanning(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspPlanning = "/WEB-INF/paginas/propias/planning.jsp";
        request.getRequestDispatcher(jspPlanning).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("nuevoRegistro")) {
            switch (accion) {
                case "nuevoRegistro":
                    this.altaUsuario(request, response);
                    break;
                default:
                    this.volverInicio(request, response);
            }
        } else {
            this.volverInicio(request, response);
        }

    }

    private void altaUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = null;

        String nombre = request.getParameter("inputNombre");
        String apellidos = request.getParameter("inputApellidos");
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputContrasena");
        String confirmacionPassword = request.getParameter("inputConfirmarContrasena");

        if (password.equals(confirmacionPassword)) {
            usuario = new Usuario(nombre, apellidos, email, password);
            UsuarioDAO usuarioBD = new UsuarioDAO();
            usuarioBD.insert(usuario);
            System.out.println("LAS CONTRASEÑAS NO COINCIDEN");
        }
        this.volverInicio(request, response);
    }

}
