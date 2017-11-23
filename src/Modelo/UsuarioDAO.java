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
    
    public String InsertUsuario(String codUsuario, String rut_usuario, String login, String password, String estado, String acceso) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            //llamar a la rutina creada en phpMyAdmin
            CallableStatement cs = accesoDB.prepareCall("{call insertar_usuario(?,?,?,?,?,?)}");
            /*cs.setString(1, Integer.toString(codUsuario));
            cs.setString(2, rut_usuario);
            cs.setString(3, login);
            cs.setString(4, password);
            cs.setString(5, "1");
            cs.setString(6, acceso);
            cs.setString(7, "");*/
            
            
        
        int numFAfectadas = cs.executeUpdate();
        if(numFAfectadas > 0) {
            rptaRegistro = "Registro exitoso";
        }
        } catch (SQLException e) {
        
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
    
    public int editarUsuario(int codUsuario, String rut_usuario, String login, String password, String estado, String acceso) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call editar_usuario(?,?,?,?)}");
            cs.setInt(1, codUsuario);
            cs.setString(2, rut_usuario);
            cs.setString(3, login);
            cs.setString(4, password);
            cs.setString(5, estado);
            cs.setString(6, acceso);
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            
        }
        return numFA;
    }
    
    public int eliminarUsuario(String rut) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call eliminar_usuario(?)}");
            cs.setString(1, rut);
            
            numFA = cs.executeUpdate();
        } catch (SQLException e) {
            
        }
        return numFA;
    }
}
