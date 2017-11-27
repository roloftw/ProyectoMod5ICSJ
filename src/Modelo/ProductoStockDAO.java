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
public class ProductoStockDAO {

    //int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, int precio_producto, int precio_compra, int stock_producto, String fecha_stock
    
    Conexion conexion;
    
    public ProductoStockDAO() {
        conexion = new Conexion();
    }
    
    public String InsertProductoStock(int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
            int precio_producto, int precio_compra, int stock_producto, String fecha_stock) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            //llamar a la rutina creada en phpMyAdmin
            CallableStatement cs = accesoDB.prepareCall("{call insertar_productoStock(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, cod_producto);
            cs.setString(2, nombre_producto);
            cs.setString(3, descripcion_producto);
            cs.setString(4, unidad_producto);
            cs.setInt(5, precio_producto);
            cs.setInt(6, precio_compra);
            cs.setInt(7, stock_producto);
            cs.setString(8, fecha_stock);           
        
        int numFAfectadas = cs.executeUpdate();
        if(numFAfectadas > 0) {
            rptaRegistro = "Registro exitoso";
        }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rptaRegistro;
    }
    
    public ArrayList<ProductoStock> ListProductoStock() {
        ArrayList listaProductoStock = new ArrayList();
        ProductoStock product;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM `productostock`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                /*int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
                int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria*/
                product = new ProductoStock();
                product.setCod_producto(rs.getInt(1));
                product.setNombre_prod(rs.getString(2));
                product.setDescripcion_prod(rs.getString(3));
                product.setUnid_prod(rs.getString(4));
                product.setPrecio_producto(rs.getInt(5));
                product.setPrecio_compra(rs.getInt(6));
                product.setStock_producto(rs.getInt(7));
                product.setFecha_prod(rs.getString(8));
                listaProductoStock.add(product);
            }
        } catch (Exception e) {
        }
        return listaProductoStock;
    }
    
    public int editarProductoStock(int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
            int precio_producto, int precio_compra, int stock_producto, String fecha_stock) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call editar_productoStock(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, cod_producto);
            cs.setString(2, nombre_producto);
            cs.setString(3, descripcion_producto);
            cs.setString(4, unidad_producto);
            cs.setInt(5, precio_producto);
            cs.setInt(6, precio_compra);
            cs.setInt(7, stock_producto);
            cs.setString(8, fecha_stock);
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
    
    public int eliminarProductoStock(int cod_producto) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call eliminar_productoStock(?)}");
            cs.setInt(1, cod_producto);
            
            numFA = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
    
    public int updateStock(int cod_producto, int stock_producto) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call update_productoStock(?,?)}");
            cs.setInt(1, cod_producto);
            cs.setInt(2, stock_producto);
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
}
