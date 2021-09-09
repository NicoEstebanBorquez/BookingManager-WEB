package dominio;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellidos, dni, pasaporte, nacionalidad, telefono, email, id_usuario FROM cliente";
    private static final String SQL_SELECT_ID = "SELECT id_cliente, nombre, apellidos, dni, pasaporte, nacionalidad, telefono, email, id_usuario FROM cliente WHERE id_cliente=?";
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellidos, dni, pasaporte, nacionalidad, telefono, email, id_usuario) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellidos=?, dni=?, pasaporte=?, nacionalidad=?, telefono=?, email=?, id_usuario=? WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";

    public List listar() {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList<>();
        Cliente cliente = null;

        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String dni = rs.getString(4);
                String pasaporte = rs.getString(5);
                String nacionalidad = rs.getString(6);
                String telefono = rs.getString(7);
                String email = rs.getString(8);
                int id_usuario = rs.getInt(9);

                cliente = new Cliente(idCliente, nombre, apellidos, dni, pasaporte, nacionalidad, telefono, email, id_usuario);
                lista.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return lista;
    }

    public Cliente encontrarPorId(int id) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String dni = rs.getString(4);
                String pasaporte = rs.getString(5);
                String nacionalidad = rs.getString(6);
                String telefono = rs.getString(7);
                String email = rs.getString(8);
                int id_usuario = rs.getInt(9);

                cliente = new Cliente(idCliente, nombre, apellidos, dni, pasaporte, nacionalidad, telefono, email, id_usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection cn = null;
        PreparedStatement ps = null;
        int elementosInsertados = 0;

        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(SQL_INSERT);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getDni());
            ps.setString(4, cliente.getPasaporte());
            ps.setString(5, cliente.getNacionalidad());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getEmail());
            ps.setInt(8, cliente.getIdUsuario());

            elementosInsertados = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return elementosInsertados;
    }

    public int actualizar(Cliente cliente) {
        Connection cn = null;
        PreparedStatement ps = null;
        int elementosActualizados = 0;

        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(SQL_UPDATE);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getDni());
            ps.setString(4, cliente.getPasaporte());
            ps.setString(5, cliente.getNacionalidad());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getEmail());
            ps.setInt(8, cliente.getIdUsuario());
            ps.setInt(9, cliente.getIdCliente());

            elementosActualizados = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return elementosActualizados;
    }
    
    public int eliminar(int id) {
        Connection cn = null;
        PreparedStatement ps = null;
        int eliminado = 0;

        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);

            eliminado = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return eliminado;
    }
     
}
