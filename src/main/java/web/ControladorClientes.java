package web;

import dominio.Cliente;
import dominio.ClienteDAO;
import dominio.Usuario;
import dominio.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorClientes")
public class ControladorClientes extends HttpServlet {

    //Cliente
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();

    //Usuario
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "Listado":
                this.listadoClientes(request, response);
                break;
            case "Info":
                this.InfoCliente(request, response);
                break;
            case "NuevoCliente":
                this.nuevoCliente(request, response);
                break;
            case "Editar":
                this.editarCliente(request, response);
                break;
            case "Eliminar":
                this.eliminarCliente(request, response);
                break;
            default:
                this.irClientes(request, response);
                break;
        }

    }

    private void irClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspClientes = "/WEB-INF/paginas/propias/clientes/clientes.jsp";
        request.getRequestDispatcher(jspClientes).forward(request, response);
    }

    private void listadoClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> lista = clienteDAO.listar();
        request.setAttribute("listadoClientes", lista);

        String jspListadoClientes = "/WEB-INF/paginas/propias/clientes/clientesListado.jsp";
        request.getRequestDispatcher(jspListadoClientes).forward(request, response);
    }

    private void InfoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Id del cliente seleccionado
        int id = Integer.parseInt(request.getParameter("id"));

        //Datos del cliente
        cliente = clienteDAO.encontrarPorId(id);
        request.setAttribute("infoClienteSeleccionado", cliente);

        //Datos del usuario
        usuario = usuarioDAO.encontrarPorId(cliente.getIdUsuario());
        request.setAttribute("usuarioSeleccionado", usuario);

        String jspInfoCliente = "/WEB-INF/paginas/propias/clientes/infoCliente.jsp";
        request.getRequestDispatcher(jspInfoCliente).forward(request, response);
    }

    private void nuevoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspNuevoCliente = "/WEB-INF/paginas/propias/clientes/nuevoCliente.jsp";
        request.getRequestDispatcher(jspNuevoCliente).forward(request, response);
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Id del cliente seleccionado
        int id = Integer.parseInt(request.getParameter("id"));

        cliente = clienteDAO.encontrarPorId(id);
        request.setAttribute("clienteSeleccionado", cliente);

        String jspEditarCliente = "/WEB-INF/paginas/propias/clientes/editarCliente.jsp";
        request.getRequestDispatcher(jspEditarCliente).forward(request, response);
    }
   
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Id del Cliente seleccionado
        int id = Integer.parseInt(request.getParameter("id"));
        int clienteEliminado = clienteDAO.eliminar(id);

        if (clienteEliminado == 0) {
            System.out.println("####################### Cliente NO ELIMINADO");
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ Cliente ELIMINADO CORRECTAMENTE");
        }

        String jspClienteEliminado = "/WEB-INF/paginas/propias/clientes/jspClienteEliminadoBORRAR.jsp";
        request.getRequestDispatcher(jspClienteEliminado).forward(request, response);
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "InsertarCliente":
                this.insertarCliente(request, response);
                break;
            case "Guardar":
                this.guardarCambios(request, response);
                break;
            case "Cancelar":
                this.irClientes(request, response);
                break;
            default:
                this.irClientes(request, response);
                break;
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Parámetros obtenidos desde el formulario
        String nombre = request.getParameter("inputNombre");
        String apellidos = request.getParameter("inputApellidos");
        String dni = request.getParameter("inputDni");
        String pasaporte = request.getParameter("inputPasaporte");
        String nacionalidad = request.getParameter("inputNacionalidad");
        String telefono = request.getParameter("inputTelefono");
        String email = request.getParameter("inputEmail");
        int idUsuario = Integer.parseInt(request.getParameter("inputUsuario"));

        cliente = new Cliente(nombre, apellidos, dni, pasaporte, nacionalidad, telefono, email, idUsuario);
        int clienteInsertado = clienteDAO.insertar(cliente);

        if (clienteInsertado == 0) {
            System.out.println("########################### ERROR. EL CLIENTE NO SE HA INSERTADO");
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ CLIENTE AGREGADO CORRECTAMENTE");
        }

        String jspClienteAnadido = "/WEB-INF/paginas/propias/clientes/clienteAnadido.jsp";
        request.getRequestDispatcher(jspClienteAnadido).forward(request, response);
    }
    
     private void guardarCambios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        //Parámetros obtenidos desde el formulario
        String nombre = request.getParameter("inputNombre");
        String apellidos = request.getParameter("inputApellidos");
        String dni = request.getParameter("inputDni");
        String pasaporte = request.getParameter("inputPasaporte");
        String nacionalidad = request.getParameter("inputNacionalidad");
        String telefono = request.getParameter("inputTelefono");
        String email = request.getParameter("inputEmail");
        int idUsuario = Integer.parseInt(request.getParameter("inputUsuario"));

        cliente = new Cliente(id, nombre, apellidos, dni, pasaporte, nacionalidad, telefono, email, idUsuario);
        int clienteActualizado = clienteDAO.actualizar(cliente);

        if (clienteActualizado == 0) {
            System.out.println("########################### ERROR. EL CLIENTE NO SE HA ACTUALIZADO");
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ CLIENTE ACTUALIZADO CORRECTAMENTE");
        }

        String jspClienteCambiosGuardados = "/WEB-INF/paginas/propias/clientes/clienteCambiosGuardados.jsp";
        request.getRequestDispatcher(jspClienteCambiosGuardados).forward(request, response);
    }

}
