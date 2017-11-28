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
public class ProductoDAO {

    Conexion conexion;
    
    public ProductoDAO() {
        conexion = new Conexion();
    }
    
    public String InsertProducto(int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
            int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            //llamar a la rutina creada en phpMyAdmin
            CallableStatement cs = accesoDB.prepareCall("{call insertar_producto(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, cod_producto);
            cs.setString(2, nombre_producto);
            cs.setString(3, descripcion_producto);
            cs.setString(4, unidad_producto);
            cs.setInt(5, precio_producto);
            cs.setInt(6, precio_compra);
            cs.setInt(7, stock_producto);
            cs.setString(8, ubicacion_bodega);
            cs.setInt(9, cod_categoria);           
        
        int numFAfectadas = cs.executeUpdate();
        if(numFAfectadas > 0) {
            rptaRegistro = "Registro exitoso";
        }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rptaRegistro;
    }
    
    public ArrayList<Producto> ListProducto() {
        ArrayList listaProductos = new ArrayList();
        Producto product;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM `producto`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                /*int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
                int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria*/
                product = new Producto();
                product.setCod_producto(rs.getInt(1));
                product.setNombre_producto(rs.getString(2));
                product.setDescripcion_producto(rs.getString(3));
                product.setUnidad_producto(rs.getString(4));
                product.setPrecio_producto(rs.getInt(5));
                product.setPrecio_compra(rs.getInt(6));
                product.setStock_producto(rs.getInt(7));
                product.setUbicacion_bodega(rs.getString(8));                
                product.setCod_categoriaFK(rs.getInt(9));
                listaProductos.add(product);
            }
        } catch (Exception e) {
        }
        return listaProductos;
    }
    public ArrayList<Producto> ListProductoRanking() {
        ArrayList listaProductos = new ArrayList();
        Producto product;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM `producto`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                /*int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
                int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria*/
                product = new Producto();
                product.setCod_producto(rs.getInt(1));
                product.setNombre_producto(rs.getString(2));
                product.setDescripcion_producto(rs.getString(3));
                product.setUnidad_producto(rs.getString(4));
                product.setPrecio_producto(rs.getInt(5));
                product.setPrecio_compra(rs.getInt(6));
                product.setStock_producto(rs.getInt(7));
                product.setUbicacion_bodega(rs.getString(8));                
                product.setCod_categoriaFK(rs.getInt(9));
                listaProductos.add(product);
            }
        } catch (Exception e) {
        }
        return listaProductos;
    }
    
    public int editarProducto(int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
            int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call editar_producto(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, cod_producto);
            cs.setString(2, nombre_producto);
            cs.setString(3, descripcion_producto);
            cs.setString(4, unidad_producto);
            cs.setInt(5, precio_producto);
            cs.setInt(6, precio_compra);
            cs.setInt(7, stock_producto);
            cs.setString(8, ubicacion_bodega);
            cs.setInt(9, cod_categoria);
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
    
    public int eliminarProducto(int cod_producto) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call eliminar_producto(?)}");
            cs.setInt(1, cod_producto);
            
            numFA = cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
    
    public int updateProductoStock(int cod_producto, int stock_producto) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call update_stockProducto(?,?)}");
            cs.setInt(1, cod_producto);
            cs.setInt(2, stock_producto);
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return numFA;
    }
}
