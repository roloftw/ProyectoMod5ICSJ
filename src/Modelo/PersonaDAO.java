package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @RolandoEscobar
 */
public class PersonaDAO {

    Conexion conexion;

    public PersonaDAO() {
        conexion = new Conexion();
    }
    
    public String InsertPersona(int cod_persona, String nombre_persona, String direccion, String telefono, String email, String contacto, String cel_contacto, String correo_contacto) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            //llamar a la rutina creada en phpMyAdmin
            CallableStatement cs = accesoDB.prepareCall("{call insertar_persona(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, cod_persona);
            cs.setString(2, nombre_persona);
            cs.setString(3, direccion);
            cs.setString(4, telefono);
            cs.setString(5, email);
            cs.setString(6, contacto);
            cs.setString(7, cel_contacto);
            cs.setString(8, correo_contacto);
        
        int numFAfectadas = cs.executeUpdate();
        if(numFAfectadas > 0) {
            rptaRegistro = "Registro exitoso";
        }
        } catch (SQLException e) {
        
        }
        return rptaRegistro;
    }
    
    public ArrayList<Persona> ListPersona() {
        ArrayList listaPersona = new ArrayList();
        Persona persona;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM `persona`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                persona = new Persona();
                persona.setCod_persona(rs.getInt(1));
                persona.setNombre_persona(rs.getString(2));
                persona.setDireccion(rs.getString(3));
                persona.setTelefono(rs.getString(4));
                persona.setEmail(rs.getString(5));
                persona.setContacto(rs.getString(6));
                persona.setCel_contacto(rs.getString(7));
                persona.setCorreo_contacto(rs.getString(8));
                listaPersona.add(persona);
            }
        } catch (Exception e) {
        }
        return listaPersona;
    }
    
    public int editarPersona(int cod_persona, String nombre_persona, String direccion, String telefono, String email, String contacto, String cel_contacto, String correo_contacto) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call editar_persona(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, cod_persona);
            cs.setString(2, nombre_persona);
            cs.setString(3, direccion);
            cs.setString(4, telefono);
            cs.setString(5, email);
            cs.setString(6, contacto);
            cs.setString(7, cel_contacto);
            cs.setString(8, correo_contacto);
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            
        }
        return numFA;
    }
    
    public int eliminarPersona(int cod_persona) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call eliminar_persona(?)}");
            cs.setInt(1, cod_persona);
            
            numFA = cs.executeUpdate();
        } catch (SQLException e) {
            
        }
        return numFA;
    }
}
