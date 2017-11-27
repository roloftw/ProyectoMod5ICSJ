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
public class ClienteDAO {
    
    Conexion conexion;
    
    public ClienteDAO() {
        conexion  = new Conexion();
    }
    
    public String insertarCliente(int cod_cliente, String rut) {
        String rptaReg = null;
        try {
            Connection accesoDB = conexion.getConexion();
            //llamar a la rutina creada en phpMyAdmin
            CallableStatement cs = accesoDB.prepareCall("{call insertar_cliente(?,?)}");
            //cs.setString(1, codUsuario);
            cs.setInt(1, cod_cliente);
            cs.setString(2, rut);
            
            int numFAfectadas = cs.executeUpdate();
        if(numFAfectadas > 0) {
            rptaReg = "Registro exitoso";
        }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rptaReg;
    }
    
    public ArrayList<Cliente> ListCliente() {
        ArrayList listaClientes = new ArrayList();
        Cliente client;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM `cliente`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                client = new Cliente();
                client.setCod_cliente(rs.getInt(1));
                client.setRut_cliente(rs.getString(2));
                
                listaClientes.add(client);
            }
        } catch (Exception e) {
        }
        return listaClientes;
    }
    
    public int editarCliente(int cod_cliente, String rut) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call editar_cliente(?,?)}");
            cs.setInt(1, cod_cliente);
            cs.setString(2, rut);
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
    
    public int eliminarCliente(int cod) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call eliminar_cliente(?)}");
            cs.setInt(1, cod);
            
            numFA = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
}
