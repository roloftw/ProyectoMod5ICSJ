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
public class VentaDAO {

    Conexion conexion;

    public VentaDAO() {
        conexion = new Conexion();
    }
    
    //int cod_venta, int cod_productoFK, String fecha_venta, int total_venta, int cod_usuarioFK, int cod_clienteFK, String tipo_comprobante, int num_factura, int pago, int descuento;
    
    public String InsertVenta(int cod_venta, int cod_productoFK, String fecha_venta, int total_venta, int cod_usuarioFK, int cod_clienteFK, String tipo_comprobante, int num_factura, int pago, int descuento) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            //llamar a la rutina creada en phpMyAdmin
            CallableStatement cs = accesoDB.prepareCall("{call insertar_venta(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, cod_venta);            
            cs.setInt(2, cod_productoFK);
            cs.setString(3, fecha_venta);
            cs.setInt(4, total_venta);       
            cs.setInt(5, cod_usuarioFK);   
            cs.setInt(6, cod_clienteFK);
            cs.setString(7, tipo_comprobante);
            cs.setInt(8, num_factura); 
            cs.setInt(9, pago); 
            cs.setInt(10, descuento); 
        
        int numFAfectadas = cs.executeUpdate();
        if(numFAfectadas > 0) {
            rptaRegistro = "Registro exitoso";
        }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rptaRegistro;
    }
    
    public ArrayList<Venta> ListVenta() {
        //int cod_venta, int cod_productoFK, String fecha_venta, int total_venta, int cod_usuarioFK, int cod_clienteFK, String tipo_comprobante, int num_factura, int pago, int descuento
        ArrayList listaVentas = new ArrayList();
        Venta sale;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM `categoria`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                sale = new Venta();
                sale.setCod_venta(rs.getInt(1));
                sale.setCod_venta(rs.getInt(2));
                sale.setFecha_venta(rs.getString(3));
                sale.setTotal_venta(rs.getInt(4));
                sale.setCod_usuarioFK(rs.getInt(5));
                sale.setCod_clienteFK(rs.getInt(6));
                sale.setTipo_comprobante(rs.getString(7));
                sale.setNum_factura(rs.getInt(8));
                sale.setPago(rs.getInt(9));
                sale.setDescuento(rs.getInt(10));
                listaVentas.add(sale);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaVentas;
    }
    
    public int editarVenta(int cod_venta, int cod_productoFK, String fecha_venta, int total_venta, int cod_usuarioFK, int cod_clienteFK, String tipo_comprobante, int num_factura, int pago, int descuento) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call editar_venta(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, cod_venta);            
            cs.setInt(2, cod_productoFK);
            cs.setString(3, fecha_venta);
            cs.setInt(4, total_venta);       
            cs.setInt(5, cod_usuarioFK);   
            cs.setInt(6, cod_clienteFK);
            cs.setString(7, tipo_comprobante);
            cs.setInt(8, num_factura); 
            cs.setInt(9, pago); 
            cs.setInt(10, descuento);
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
    
    public int eliminarVenta(int cod_venta) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call elimina_venta(?)}");
            cs.setInt(1, cod_venta);
            
            numFA = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
}
