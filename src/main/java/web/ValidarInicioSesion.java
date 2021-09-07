package web;

import dominio.Usuario;
import dominio.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ValidarInicioSesion", urlPatterns = {"/ValidarInicioSesion"})
public class ValidarInicioSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("inicioSesion")) {
            switch (accion) {
                case "inicioSesion":
                    this.inicioSesion(request, response);
                    break;
                default:
                    this.volverInicio(request, response);
            }
        } else {
            this.volverInicio(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    private void inicioSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        Usuario usuario = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuario = usuarioDAO.selectInicioSesion(email, password);
        try {
            if (usuario.getIdUsuario() != 0) {
                System.out.println("################################ ENCONTRADO");
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuarioValidado", usuario);

                String jspPanelControl = "/WEB-INF/paginas/propias/panelControl.jsp";
                request.getRequestDispatcher(jspPanelControl).forward(request, response);
            } else {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ NO ENCONTRADO!!!!");
                request.getRequestDispatcher("bookingManager.jsp").forward(request, response);
            }
        } catch (Exception e) {

        }
    }

    private void volverInicio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("bookingManager.jsp");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
