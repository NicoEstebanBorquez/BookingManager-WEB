package dominio;

import datos.Conexion;
import dominio.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT id_usuario, nombre, apellidos, email FROM usuario";
    private static final String SQL_SELECT_BY_ID = "SELECT id_usuario, nombre, apellidos, email FROM usuario WHERE id_usuario=?";
    private static final String SQL_INSERT = "INSERT INTO usuario (nombre, apellidos, email, password) VALUES (?,?,?,?)";
    private static final String SQL_SELECT_BY_EMAIL_AND_PASSWORD = "SELECT id_usuario, nombre, apellidos, email FROM usuario WHERE email=? and password=?";

    public Usuario selectInicioSesion(String email, String password) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //int usuarioEncontrado = 0;
        Usuario usuario = new Usuario();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_EMAIL_AND_PASSWORD);
            stmt.setString(1, email);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                //usuarioEncontrado++;

                usuario.setIdUsuario(idUsuario);
                usuario.setNombre(nombre);
                usuario.setApellidos(apellidos);
                usuario.setEmail(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    }

    public List<Usuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");

                usuario = new Usuario(idUsuario, nombre, apellidos, email);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }

    public Usuario encontrarPorId(int id) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                int idUsuario = rs.getInt(1);
                String nombre= rs.getString(2);
                String apellidos= rs.getString(3);
                String email = rs.getString(4);
   
                usuario = new Usuario(idUsuario, nombre, apellidos, email);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return usuario;
    }

    public int insert(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int elementosInsertados = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getPassword());
            elementosInsertados = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return elementosInsertados;
    }
}
