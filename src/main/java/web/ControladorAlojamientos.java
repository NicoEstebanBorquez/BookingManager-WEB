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
import javax.servlet.http.*;

@WebServlet("/ControladorAlojamientos")
public class ControladorAlojamientos extends HttpServlet {

    //Alojamiento
    AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
    Alojamiento alojamiento = null;

    //Propietario
    Propietario propietario = new Propietario();
    PropietarioDAO propietarioDAO = new PropietarioDAO();
    
    //Usuario
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "Listado":
                this.listadoAlojamientos(request, response);
                break;
            case "Info":
                this.InfoAlojamiento(request, response);
                break;
            case "NuevoAlojamiento":
                this.nuevoAlojamiento(request, response);
                break;
            case "InsertarAlojamiento":
                this.insertarAlojamiento(request, response);
                break;
            case "Editar":
                this.editarAlojamiento(request, response);
                break;
            case "Eliminar":
                this.eliminarAlojamiento(request, response);
                break;
            default:
                this.irAlojamientos(request, response);
                break;
        }

    }

    private void irAlojamientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspAlojamientos = "/WEB-INF/paginas/propias/alojamientos/alojamientos.jsp";
        request.getRequestDispatcher(jspAlojamientos).forward(request, response);
    }

    private void listadoAlojamientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
        List<Alojamiento> lista = alojamientoDAO.listar();
        request.setAttribute("listadoAlojamientos", lista);

        String jspListadoAlojamientos = "/WEB-INF/paginas/propias/alojamientos/alojamientosListado.jsp";
        request.getRequestDispatcher(jspListadoAlojamientos).forward(request, response);
    }

    private void InfoAlojamiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Id del alojamiento seleccionado
        int id = Integer.parseInt(request.getParameter("id"));

        //Datos del alojamiento
        alojamiento = alojamientoDAO.encontrarPorId(id);
        request.setAttribute("alojamientoSeleccionado", alojamiento);

        //Datos del propietario
        propietario = propietarioDAO.encontrarPorId(alojamiento.getIdPropietario());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("propietarioSeleccionado", propietario);
        
        //Datos del usuario
        usuario = usuarioDAO.encontrarPorId(alojamiento.getIdUsuario());
        request.setAttribute("usuarioSeleccionado", usuario);
        
        
        String jspInfoAlojamiento = "/WEB-INF/paginas/propias/alojamientos/infoAlojamiento.jsp";
        request.getRequestDispatcher(jspInfoAlojamiento).forward(request, response);
    }

    private void nuevoAlojamiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Obtiene lista de propietarios para añadirlos a la lista desplegable
        this.listadoPropietarios(request, response);
        
        String jspNuevoAlojamiento = "/WEB-INF/paginas/propias/alojamientos/nuevoAlojamiento.jsp";
        request.getRequestDispatcher(jspNuevoAlojamiento).forward(request, response);
    }

    private void editarAlojamiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Id del alojamiento seleccionado
        int id = Integer.parseInt(request.getParameter("id"));

        alojamiento = alojamientoDAO.encontrarPorId(id);
        request.setAttribute("alojamientoSeleccionado", alojamiento);
       
        //Obtiene lista de propietarios para añadirlos a la lista desplegable
        this.listadoPropietarios(request, response);

        String jspEditarAlojamiento = "/WEB-INF/paginas/propias/alojamientos/editarAlojamiento.jsp";
        request.getRequestDispatcher(jspEditarAlojamiento).forward(request, response);
    }

    private void eliminarAlojamiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Id del alojamiento seleccionado
        int id = Integer.parseInt(request.getParameter("id"));
        int alojamientoEliminado = alojamientoDAO.eliminar(id);

        if (alojamientoEliminado == 0) {
            System.out.println("####################### ALOJAMIENTO NO ELIMINADO");
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ ALOJAMIENTO ELIMINADO CORRECTAMENTE");
        }

        String jspAlojamientoEliminado = "/WEB-INF/paginas/propias/alojamientos/jspAlojamientoEliminadoBORRAR.jsp";
        request.getRequestDispatcher(jspAlojamientoEliminado).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "InsertarAlojamiento":
                this.insertarAlojamiento(request, response);
                break;
            case "Guardar":
                this.guardarCambios(request, response);
                break;
            case "Cancelar":
                this.irAlojamientos(request, response);
                break;
            default:
                this.irAlojamientos(request, response);
                break;
        }
    }

    private void insertarAlojamiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        //Parámetros obtenidos desde el formulario
        String nombre = request.getParameter("inputNombre");   
        int plazas = Integer.parseInt(request.getParameter("inputPlazas")); 
        int dormitorios = Integer.parseInt(request.getParameter("inputDormitorios"));
        int banos = Integer.parseInt(request.getParameter("inputBanos"));
        String terraza = request.getParameter("inputTerraza");
        String piscina = request.getParameter("inputPiscina");
        String aparcamiento = request.getParameter("inputAparcamiento");
        String direccion = request.getParameter("inputDireccion");
        String poblacion = request.getParameter("inputPoblacion");
        String provincia = request.getParameter("inputProvincia");
        int idPropietario = Integer.parseInt(request.getParameter("inputPropietario"));
        int idUsuario = Integer.parseInt(request.getParameter("inputUsuario"));
    
        alojamiento = new Alojamiento(nombre, plazas, dormitorios, banos, terraza, piscina, aparcamiento, direccion, poblacion, provincia, idPropietario, idUsuario);
        int alojamientoInsertado = alojamientoDAO.insertar(alojamiento);

        if (alojamientoInsertado == 0) {
            System.out.println("########################### ERROR. EL ALOJAMIENTO NO SE HA INSERTADO");
        } else {    
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ALOJAMIENTO INSERTADO CORRECTAMENTE");
        }

        String jspalojamientoAnadido = "/WEB-INF/paginas/propias/alojamientos/alojamientoAnadido.jsp";
        request.getRequestDispatcher(jspalojamientoAnadido).forward(request, response);
    }

    private void guardarCambios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        //Parámetros obtenidos desde el formulario
        String nombre = request.getParameter("inputNombre");
        int plazas = Integer.parseInt(request.getParameter("inputPlazas"));
        int dormitorios = Integer.parseInt(request.getParameter("inputDormitorios"));
        int banos = Integer.parseInt(request.getParameter("inputBanos"));
        String terraza = request.getParameter("inputTerraza");
        String piscina = request.getParameter("inputPiscina");
        String aparcamiento = request.getParameter("inputAparcamiento");
        String direccion = request.getParameter("inputDireccion");
        String poblacion = request.getParameter("inputPoblacion");
        String provincia = request.getParameter("inputProvincia");
        int idPropietario = Integer.parseInt(request.getParameter("inputPropietario"));
        int idUsuario = Integer.parseInt(request.getParameter("inputUsuario"));
        int idAlojamiento = id;

        alojamiento = new Alojamiento(id, nombre, plazas, dormitorios, banos, terraza, piscina, aparcamiento, direccion, poblacion, provincia, idPropietario, idUsuario);
        int alojamientoActualizado = alojamientoDAO.actualizar(alojamiento);

        if (alojamientoActualizado == 0) {
            System.out.println("########################### ERROR. EL ALOJAMIENTO NO SE HA ACTUALIZADO");
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ALOJAMIENTO ACTUALIZADO CORRECTAMENTE");
        }

        String jspAlojamientoCambiosGuardados = "/WEB-INF/paginas/propias/alojamientos/alojamientoCambiosGuardados.jsp";
        request.getRequestDispatcher(jspAlojamientoCambiosGuardados).forward(request, response);
    }

    
    private void listadoPropietarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PropietarioDAO propietarioDAO = new PropietarioDAO();
        List<Propietario> listaPropietarios = propietarioDAO.listar();
        request.setAttribute("listadoPropietarios", listaPropietarios);
    }
}
