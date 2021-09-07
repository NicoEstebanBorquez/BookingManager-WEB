package web;

import dominio.Alojamiento;
import dominio.AlojamientoDAO;
import dominio.Propietario;
import dominio.PropietarioDAO;
import dominio.Usuario;
import dominio.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorPropietarios")
public class ControladorPropietarios extends HttpServlet {

    //Propietario
    Propietario propietario = new Propietario();
    PropietarioDAO propietarioDAO = new PropietarioDAO();

    //Usuario
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    //Alojamiento
    Alojamiento alojamiento = new Alojamiento();
    AlojamientoDAO alojamientoDAO = new AlojamientoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "Listado":
                this.listadoPropietarios(request, response);
                break;
            case "NuevoPropietario":
                this.nuevoPropietario(request, response);
                break;
            case "Info":
                this.InfoPropietario(request, response);
                break;
            case "Editar":
                this.editarPropietario(request, response);
                break;
            case "Eliminar":
                this.eliminarPropietario(request, response);
                break;
            default:
                this.irPropietarios(request, response);
                break;
        }

    }

    private void irPropietarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspPropietarios = "/WEB-INF/paginas/propias/propietarios/propietarios.jsp";
        request.getRequestDispatcher(jspPropietarios).forward(request, response);
    }

    private void listadoPropietarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PropietarioDAO propietarioDAO = new PropietarioDAO();
        List<Propietario> lista = propietarioDAO.listar();
        request.setAttribute("listadoPropietarios", lista);

        String jspListadoPropietarios = "/WEB-INF/paginas/propias/propietarios/propietariosListado.jsp";
        request.getRequestDispatcher(jspListadoPropietarios).forward(request, response);
    }

    private void nuevoPropietario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspNuevoPropietario = "/WEB-INF/paginas/propias/propietarios/nuevoPropietario.jsp";
        request.getRequestDispatcher(jspNuevoPropietario).forward(request, response);
    }

    private void InfoPropietario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Id del propietario seleccionado
        int id = Integer.parseInt(request.getParameter("id"));

        //Datos del propietario
        propietario = propietarioDAO.encontrarPorId(id);
        request.setAttribute("propietarioSeleccionado", propietario);

        //Datos del usuario
        usuario = usuarioDAO.encontrarPorId(propietario.getIdUsuario());
        request.setAttribute("usuarioSeleccionado", usuario);

        //Datos del alojamiento
        List<Alojamiento> listaAlojamientos = alojamientoDAO.encontrarPorIdPropietario(id);
        request.setAttribute("alojamientosPropietario", listaAlojamientos);

        String jspInfoPropietario = "/WEB-INF/paginas/propias/propietarios/infoPropietario.jsp";
        request.getRequestDispatcher(jspInfoPropietario).forward(request, response);
    }
    
    private void editarPropietario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Id del Propietario seleccionado
        int id = Integer.parseInt(request.getParameter("id"));

        propietario = propietarioDAO.encontrarPorId(id);
        request.setAttribute("propietarioSeleccionado", propietario);

        String jspEditarPropietario = "/WEB-INF/paginas/propias/propietarios/editarPropietario.jsp";
        request.getRequestDispatcher(jspEditarPropietario).forward(request, response);
    }

    private void eliminarPropietario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Id del Propietario seleccionado
        int id = Integer.parseInt(request.getParameter("id"));
        int propietarioEliminado = propietarioDAO.eliminar(id);

        if (propietarioEliminado == 0) {
            System.out.println("####################### Propietario NO ELIMINADO");
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ Propietario ELIMINADO CORRECTAMENTE");
        }

        String jspPropietarioEliminado = "/WEB-INF/paginas/propias/propietarios/jspPropietarioEliminadoBORRAR.jsp";
        request.getRequestDispatcher(jspPropietarioEliminado).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "InsertarPropietario":
                this.insertarPropietario(request, response);
                break;
            /*    case "Guardar":
                this.guardarCambios(request, response);
                break;
            case "Cancelar":
                this.irAlojamientos(request, response);
                break;*/
            default:
                this.irPropietarios(request, response);
                break;
        }
    }

    private void insertarPropietario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Parámetros obtenidos desde el formulario
        String nombre = request.getParameter("inputNombre");
        String apellidos = request.getParameter("inputApellidos");
        String dni = request.getParameter("inputDni");
        String pasaporte = request.getParameter("inputPasaporte");
        String nacionalidad = request.getParameter("inputNacionalidad");
        String telefono = request.getParameter("inputTelefono");
        String domicilio = request.getParameter("inputDomicilio");
        String email = request.getParameter("inputEmail");
        int idUsuario = Integer.parseInt(request.getParameter("inputUsuario"));

        propietario = new Propietario(nombre, apellidos, dni, pasaporte, nacionalidad, telefono, domicilio, email, idUsuario);
        int propietarioInsertado = propietarioDAO.insertar(propietario);

        if (propietarioInsertado == 0) {
            System.out.println("########################### ERROR. EL PROPIETARIO NO SE HA INSERTADO");
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ PROPIETARIO AGREGADO CORRECTAMENTE");
        }

        String jspPropietarioAnadido = "/WEB-INF/paginas/propias/propietarios/propietarioAnadido.jsp";
        request.getRequestDispatcher(jspPropietarioAnadido).forward(request, response);
    }

}
