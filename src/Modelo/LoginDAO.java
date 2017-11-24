package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @RolandoEscobar
 */
public class LoginDAO {

    Conexion conexion;
    
    public LoginDAO() {
        conexion = new Conexion();
    }
    
    public boolean validar_login(String username,String password) {
    try{           
       Connection accesoDB = conexion.getConexion();   
       PreparedStatement pst = accesoDB.prepareStatement("Select * from usuario where login=? and contrasena=?");
       pst.setString(1, username);
       pst.setString(2, password);
       ResultSet rs = pst.executeQuery();
       if(rs.next())
           return true;
       else
           return false;
    }
    catch(Exception e){
       e.printStackTrace();
       return false;
    }
    }
    
    public String loginSegunUsuario(String username) {
        String nivel = "";
        try{
            Connection accesoDB = conexion.getConexion();
            PreparedStatement pst = accesoDB.prepareStatement("Select acceso from usuario where login=?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
            //JOptionPane.showMessageDialog(null, rs.getString("acceso"));
            nivel = rs.getString("acceso");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return nivel;
    }
    
}