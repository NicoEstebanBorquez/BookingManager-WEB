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

public class PropietarioDAO {

    private static final String SQL_SELECT = "SELECT id_propietario, nombre, apellidos,dni, pasaporte, nacionalidad, telefono, domicilio, email, id_usuario FROM propietario";
    private static final String SQL_SELECT_ID = "SELECT id_propietario, nombre, apellidos, dni, pasaporte, nacionalidad, telefono, domicilio, email, id_usuario FROM propietario WHERE id_propietario=?";
    private static final String SQL_INSERT = "INSERT INTO propietario (nombre, apellidos, dni, pasaporte, nacionalidad, telefono, domicilio, email, id_usuario) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM propietario WHERE id_propietario=?";

    public List listar() {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Propietario> lista = new ArrayList<>();
        Propietario propietario = null;

        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idPropietario = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String dni = rs.getString(4);
                String pasaporte = rs.getString(5);
                String nacionalidad = rs.getString(6);
                String telefono = rs.getString(7);
                String domicilio = rs.getString(8);
                String email = rs.getString(9);
                int id_usuario = rs.getInt(10);

                propietario = new Propietario(idPropietario, nombre, apellidos, dni, pasaporte, nacionalidad, telefono, domicilio, email, id_usuario);
                lista.add(propietario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return lista;
    }

    public Propietario encontrarPorId(int id) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Propietario propietario = null;

        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idPropietario = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String dni = rs.getString(4);
                String pasaporte = rs.getString(5);
                String nacionalidad = rs.getString(6);
                String telefono = rs.getString(7);
                String domicilio = rs.getString(8);
                String email = rs.getString(9);
                int id_usuario = rs.getInt(10);

                propietario = new Propietario(idPropietario, nombre, apellidos, dni, pasaporte, nacionalidad, telefono, domicilio, email, id_usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return propietario;
    }

    public int insertar(Propietario propietario) {
        Connection cn = null;
        PreparedStatement ps = null;
        int elementosInsertados = 0;

        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(SQL_INSERT);
            ps.setString(1, propietario.getNombre());
            ps.setString(2, propietario.getApellidos());
            ps.setString(3, propietario.getDni());
            ps.setString(4, propietario.getPasaporte());
            ps.setString(5, propietario.getNacionalidad());
            ps.setString(6, propietario.getTelefono());
            ps.setString(7, propietario.getDomicilio());
            ps.setString(8, propietario.getEmail());
            ps.setInt(9, propietario.getIdUsuario());

            elementosInsertados = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return elementosInsertados;
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
            Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(cn);
        }
        return eliminado;
    }

}
