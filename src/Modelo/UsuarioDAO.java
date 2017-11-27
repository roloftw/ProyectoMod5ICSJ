package Modelo;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @RolandoEscobar
 */
public class UsuarioDAO {

    Conexion conexion;

    public UsuarioDAO() {
        conexion = new Conexion();
    }
    
    public String InsertUsuario(String rut_usuario, String login, String password, String acceso) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            //llamar a la rutina creada en phpMyAdmin
            CallableStatement cs = accesoDB.prepareCall("{call insertar_usuario(?,?,?,?)}");
            //cs.setString(1, codUsuario);
            cs.setString(1, rut_usuario);
            cs.setString(2, login);
            cs.setString(3, password);
            //cs.setString(5, estado);
            cs.setString(4, acceso);           
        
        int numFAfectadas = cs.executeUpdate();
        if(numFAfectadas > 0) {
            rptaRegistro = "Registro exitoso";
        }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rptaRegistro;
    }
    
    public ArrayList<Usuario> ListUsuario() {
        ArrayList listaUsuarios = new ArrayList();
        Usuario user;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM `usuario`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                user = new Usuario();
                user.setCod_usuario(rs.getInt(1));
                user.setRut_usuario(rs.getString(2));
                user.setLogin(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setEstado(rs.getString(5));
                user.setAcceso(rs.getString(6));
                listaUsuarios.add(user);
            }
        } catch (Exception e) {
        }
        return listaUsuarios;
    }
    
    public int editarUsuario(String rut_usuario, String login, String password, String acceso) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call editar_usuario(?,?,?,?)}");
            //cs.setInt(1, codUsuario);
            cs.setString(1, rut_usuario);
            cs.setString(2, login);
            cs.setString(3, password);
            cs.setString(4, acceso);
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
    
    public int eliminarUsuario(String rut) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call desactivar_usuario(?)}");
            cs.setString(1, rut);
            
            numFA = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
}
